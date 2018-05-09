import domain.UserStory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        File dir = new File("/Users/petermccormick/Dev/SCOIRproject/src/main/resources/input");
        File[] directoryListing = dir.listFiles();
        CsvReader csvReader = new CsvReader();
        JsonWriter jsonWriter = new JsonWriter();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                List<UserStory> userStories= new ArrayList<UserStory>();
                userStories.add(csvReader.readCSV(child));
                jsonWriter.writeJsonToFile(child , userStories);

            }
        }

    }


}
