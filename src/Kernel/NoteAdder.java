package Kernel;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.List;

public class NoteAdder {
List<PreNote> preNotes= new LinkedList<>();
List<Note> notes= new LinkedList<>();
    public void noteAdd (int id){
        PreNote preNote = new PreNote(id);

        preNotes.add(preNote);

    }

    public List<PreNote> getPreNotes() {
        return preNotes;
    }

}
