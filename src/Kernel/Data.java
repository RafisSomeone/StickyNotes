package Kernel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Data {


    public void run() throws IOException {

        File noteHomedir = new File(System.getProperty("user.home"), "StickyNotes");
        if(!noteHomedir.exists()){
            Files.createDirectories(Paths.get(noteHomedir.getPath()));

        }

        File noteData = new File(noteHomedir,"config.txt");
        if(noteData.exists()) {
            new Loader().load(noteData.getPath());
        }
        else {
            noteData.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(noteData.getPath()));
            bufferedWriter.write("0");
            bufferedWriter.close();
        }

        NodeID id = new NodeID();
        id.getID();
        id.increaseID();


    }

    public void deleteData(int id)
    {
        Path path = Paths.get(System.getProperty("user.home")+ File.separator+"StickyNotes"+File.separator+id+".txt");
        File toDelet = new File (String.valueOf(path));
        toDelet.delete();

    }


}