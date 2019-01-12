package Kernel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Data {


    public void run() throws IOException {

        File noteHomedir = new File(System.getProperty("user.home"), "StickyNotes");
        if(!noteHomedir.exists()){
            Files.createDirectories(Paths.get(noteHomedir.getPath()));

        }

        File noteData = new File(noteHomedir,"plik.txt");
        if(noteData.exists()) {
            new Loader().load(noteData.getPath());
        }
        else {
            noteData.createNewFile();
        }


    }


}