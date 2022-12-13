import admin.CommandExecute;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;
import input.Input;
public class Main {
    //static int i = 0;

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(final String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Input inputData = objectMapper.readValue(new File(args[0]), Input.class);

        CommandExecute command = new CommandExecute(inputData);

        ArrayNode output = command.doCommand(objectMapper);
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();

        objectWriter.writeValue(new File(args[1]), output);
        //i++;
        //objectWriter.writeValue(new File("out" + i + ".txt"), output);
        // va rog sa avem un mod mai usor de a ne testa output-ul
    }
}
