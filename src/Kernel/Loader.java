package Kernel;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Loader {


    public void loadNotes(NoteAdder noteAdder, File noteHomeDir, Stage stage) throws IOException {

        LinkedList<PreNote> preNotes = new LinkedList<>();
        LinkedList<Note> notes = new LinkedList<>();
        File[] files =noteHomeDir.listFiles();
        Arrays.sort(files);
        for (File file : files) {
            if (file.getName().equals("config.txt")) continue;
            String name =file.getName();
            name = name.substring(0,name.lastIndexOf('.'));
            int id =  Integer.parseInt(name);

            List<String> lines = Files.readAllLines(Paths.get(file.getPath()), StandardCharsets.UTF_8);
            NoteSettings noteSettings = new NoteSettings();

                noteSettings.setFont(lines.get(0));
                noteSettings.setFontColor(lines.get(1));
                noteSettings.setBackgroundColor(lines.get(2));


            String text = "";
            for(int i=3; i<lines.size();i++)
            {
                text=text+lines.get(i);
                if(i!=lines.size()-1)text+="\n";

            }
            TextArea textArea = new TextArea();
            textArea.setText(text);
            Note note = new Note(textArea,noteAdder);
            note.setNoteSettings(noteSettings);

            note.setNoteID(id);
            PreNote preNote = new PreNote(id);
            preNotes.add(preNote);
            preNote.refreshPrenote(note);
            preNote.setOpenAction(note);
            preNote.setDeleteAction(noteAdder,preNote,stage,note);
            notes.add(note);
            }
        if(!notes.isEmpty())noteAdder.setNotes(notes,preNotes);


    }

}
