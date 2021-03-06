package Kernel;

import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Data {


    public void run(NoteAdder noteAdder, Stage stage) throws IOException {

        File noteHomedir = new File(System.getProperty("user.home"), "StickyNotes");
        if (!noteHomedir.exists()) {
            Files.createDirectories(Paths.get(noteHomedir.getPath()));
        }
        Loader load = new Loader();
        File noteData = new File(noteHomedir, "config.txt");
        if (!noteData.exists()) {
            noteData.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(noteData.getPath()));
            bufferedWriter.write("0");
            bufferedWriter.close();
        }
        load.loadNotes(noteAdder, noteHomedir, stage);
        NodeID id = new NodeID();
        id.getID();
        id.increaseID();


    }

    public void deleteData(int id) {

        Path path = Paths.get(System.getProperty("user.home") + File.separator + "StickyNotes" + File.separator + id + ".txt");

        File toDelete = new File(String.valueOf(path));
        toDelete.delete();

    }


}