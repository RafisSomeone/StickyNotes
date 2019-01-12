package Kernel;


import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class NoteAdder {
List<PreNote> preNotes= new LinkedList<>();
List<Note> notes= new LinkedList<>();
    public Note noteAdd () throws IOException {

        Note note = new Note();
        PreNote preNote = new PreNote(note.getNodeID());
        preNote.setOpenAction(note);
        preNotes.add(preNote);

        return note;
    }

    public List<PreNote> getPreNotes() {
        return preNotes;
    }

}
