package com.sk.spring_boot_day2_restAPI.controller;

import com.sk.spring_boot_day2_restAPI.service.NoteService;
import com.sk.spring_boot_day2_restAPI.dao.Notes;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/notes/{id}")
    public Notes getNotebyId(@PathVariable int id){
        Notes note= service.getNoteById(id);
        if(!note.equals(null)){
            return note;
        }
        return null;
    }

    @DeleteMapping("/api/notes/{id}")
    public String deleteById(@PathVariable int id){
         return service.deleteById(id);
    }
}
