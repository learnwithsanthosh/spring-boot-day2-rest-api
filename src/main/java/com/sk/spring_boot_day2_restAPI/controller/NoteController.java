package com.sk.spring_boot_day2_restAPI.controller;

import com.sk.spring_boot_day2_restAPI.exception.NotesNotFoundException;
import com.sk.spring_boot_day2_restAPI.service.NoteService;
import com.sk.spring_boot_day2_restAPI.dao.Notes;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {

    private NoteService service;

    public NoteController(NoteService service){
        this.service=service;
    }

    @GetMapping("/api/notes")
    public ResponseEntity<List<Notes>> getNotes(){

        return ResponseEntity.ok(service.getallNotes());
    }

    @PostMapping("/api/notes")
    public ResponseEntity<Object> saveNotes(@RequestBody @Valid Notes note){
        service.addNote(note);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(note.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/api/notes/{id}")
    public ResponseEntity<Notes> getNotebyId(@PathVariable int id){
        Notes note= service.getNoteById(id);
        return ResponseEntity.ok(note);
    }

    @DeleteMapping("/api/notes/{id}")
    public String deleteById(@PathVariable int id){
        return service.deleteById(id);
    }

    @PutMapping("/api/notes/{id}")
    public ResponseEntity<Notes> updateNote(@PathVariable int id, @RequestBody @Valid Notes note){
        Notes noteForId=service.getNoteById(id);

        noteForId.setName(note.getName());
        noteForId.setSubject(note.getSubject());
        service.addNote(noteForId);
        return ResponseEntity.ok(noteForId);

    }
}
