
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import domain.UserStory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonWriter {
    CsvReader csvReader = new CsvReader();


    public void writeJsonToFile(File file, List<UserStory> userStories) {
        try {
            String rawFileName = csvReader.getFileName(file);
            String fileName = rawFileName.split("\\.")[0];
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(new File("/Users/petermccormick/Dev/SCOIRproject/src/main/resources/output/" + fileName + ".json"), userStories);
        }
        catch (IOException e) {}
    }
}
