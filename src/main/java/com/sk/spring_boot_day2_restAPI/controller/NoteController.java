package com.sk.spring_boot_day2_restAPI.controller;

import com.sk.spring_boot_day2_restAPI.dto.NotesDTO;
import com.sk.spring_boot_day2_restAPI.repsonseAPI.APIResponse;
import com.sk.spring_boot_day2_restAPI.service.NoteService;
import com.sk.spring_boot_day2_restAPI.entity.Notes;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class NoteController {

    private NoteService service;

    public NoteController(NoteService service){
        this.service=service;
    }

    @GetMapping("/api/notes")
    public ResponseEntity<APIResponse<List<NotesDTO>>> getNotes(){

        return ResponseEntity.ok(APIResponse.success(service.getallNotes()));
    }

    @PostMapping("/api/notes")
    public ResponseEntity<Object> saveNotes(@RequestBody @Valid Notes note){
        service.addNote(note);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(note.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/api/notes/{id}")
    public ResponseEntity<APIResponse<NotesDTO>> getNotebyId(@PathVariable int id){
        return ResponseEntity.ok(APIResponse.success(service.getNoteById(id)));
    }

    @DeleteMapping("/api/notes/{id}")
    public String deleteById(@PathVariable int id){
        return service.deleteById(id);
    }

    @PutMapping("/api/notes/{id}")
    public ResponseEntity<APIResponse<NotesDTO>> updateNote(@PathVariable int id, @RequestBody @Valid Notes note){
        return ResponseEntity.ok(APIResponse.success(service.updateNote(id,note)));

    }
}
