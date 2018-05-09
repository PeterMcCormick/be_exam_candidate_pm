import domain.Name;
import domain.UserStory;

import java.io.*;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CsvReader {

    public UserStory readCSV(File file) throws IOException{
        Pattern pattern = Pattern.compile(",");
        List<UserStory> userStories;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
           userStories = in.lines().skip(1).map(line -> {
               String[] sa = pattern.split(line);
               Name name = new Name(sa[1], sa[2], sa[3]);
               return new UserStory(Integer.parseInt(sa[0]), name, sa[4]); }) .collect(Collectors.toList());
           return userStories.iterator().next();
        }catch (IOException e) {
            System.out.println("Mistakes were made...");
            return null;
        }
    }

    public String getFileName(File file) {
        return file.getName();
    }
}
