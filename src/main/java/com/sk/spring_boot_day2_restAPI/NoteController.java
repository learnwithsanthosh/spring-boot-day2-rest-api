package com.sk.spring_boot_day2_restAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteController {

    private NoteService service;

    public NoteController(NoteService service){
        this.service=service;
    }

    @GetMapping("/api/notes")
    public List<Notes> getNotes(){
        return service.getallNotes();
    }

    @PostMapping("/api/notes")
    public void saveNotes(@RequestBody Notes note){
        service.addNote(note);
    }
}
