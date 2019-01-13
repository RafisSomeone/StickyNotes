package Kernel;

import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Loader {


    public void loadNotes(NoteAdder noteAdder, File noteHomeDir, Stage stage) throws IOException {

        LinkedList<PreNote> preNotes = new LinkedList<>();
        LinkedList<Note> notes = new LinkedList<>();
        for (File file : noteHomeDir.listFiles()) {
            if (file.getName().equals("config.txt")) continue;
            String name =file.getName();
            name = name.substring(0,name.lastIndexOf('.'));
            int id =  Integer.parseInt(name);
            Note note = new Note();
            note.setNoteID(id);
            PreNote preNote = new PreNote(id);
            preNotes.add(preNote);
            preNote.setOpenAction(note);
            preNote.setDeleteAction(noteAdder,preNote,stage,note);
            notes.add(note);
            }
        if(!notes.isEmpty())noteAdder.setNotes(notes,preNotes);


    }

}
