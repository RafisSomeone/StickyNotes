package Kernel;


import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sun.awt.image.ImageWatched;

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
    public void deleteNote(PreNote preNote)
    {
        for(PreNote preNoteTmp : preNotes)
        {
            if(preNoteTmp.equals(preNote)) {preNotes.remove(preNoteTmp);new Data().deleteData(preNote.getNodeID());break;}

        }


    }

    public LinkedList<PreNote> getPreNotes() {
        return (LinkedList<PreNote>) preNotes;
    }

}
