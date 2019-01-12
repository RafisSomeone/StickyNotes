package Kernel;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NodeID {


    public NodeID()
    {

    }

    public void  increaseID() throws IOException {
        int id =  getID();
        id++;
        String idString =""+id;
        Path path = Paths.get(System.getProperty("user.home")+ File.separator+"StickyNotes"+File.separator+"config.txt");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        lines.set(0,idString);
        Files.write(path, lines, StandardCharsets.UTF_8);

    }
    public int getID() throws IOException {
        Path path = Paths.get(System.getProperty("user.home")+ File.separator+"StickyNotes"+File.separator+"config.txt");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        int id = Integer.parseInt(lines.get(0));
        return id;

    }


}
