package com.sk.spring_boot_day2_restAPI;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    public static List<Notes> notes=new ArrayList<>();

    // used to initialize data in the arrayList
    static {
        notes.add(new Notes("Santhosh","Maths"));
        notes.add((new Notes("mani","Physics")));
    }
    public List<Notes> getallNotes() {
        return notes;
    }

    public void addNote(Notes note) {
        notes.add(note);
    }
}
