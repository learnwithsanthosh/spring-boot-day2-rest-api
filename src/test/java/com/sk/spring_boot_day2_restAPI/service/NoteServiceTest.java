package com.sk.spring_boot_day2_restAPI.service;

import com.sk.spring_boot_day2_restAPI.controller.NoteController;
import com.sk.spring_boot_day2_restAPI.entity.Notes;
import com.sk.spring_boot_day2_restAPI.repo.NotesRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class NoteServiceTest {

    @Mock
    private NoteController noteController;

    @Mock
    private NotesRepo notesRepo;

    @InjectMocks
    private NoteService noteService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetallNotes(){
        when(notesRepo.findAll()).thenReturn(new ArrayList<>());
        var response=noteService.getallNotes(0,1);
        assertNotNull(response);
    }

    @Test
    public void testGetNoteById(){
        Notes note = new Notes();
        note.setId(52);
        note.setName("Test Note");
        note.setSubject("This is a test note.");
        when(notesRepo.findById(anyInt())).thenReturn(Optional.of(note));
        var response = noteService.getNoteById(52);
        assertNotNull(response);
    }
}