import admin.CommandExecute;
import admin.UserDataBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import input.Input;
public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Input inputData = objectMapper.readValue(new File(args[0]), Input.class);

        CommandExecute command = new CommandExecute(inputData);

        ArrayNode output = objectMapper.createArrayNode();
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();

        objectWriter.writeValue(new File(args[1]), output);
    }
}
