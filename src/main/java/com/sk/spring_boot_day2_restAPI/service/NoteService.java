package com.sk.spring_boot_day2_restAPI.service;

import com.sk.spring_boot_day2_restAPI.dao.Notes;
import com.sk.spring_boot_day2_restAPI.exception.NotesNotFoundException;
import com.sk.spring_boot_day2_restAPI.repo.NotesRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private NotesRepo notesRepo;

    public NoteService(NotesRepo notesRepo) {
        this.notesRepo = notesRepo;
    }


    public List<Notes> getallNotes() {
            return notesRepo.findAll();
    }

    public void addNote(Notes note) {
            notesRepo.save(note);
    }

    public Notes getNoteById(int id) {
        return notesRepo.findById(id).orElseThrow(()->new NotesNotFoundException("Note not found for given id" +id));
    }

    public String deleteById(int id) {
        notesRepo.deleteById(id);
        return "Note with id :"+id+" deleted";
    }
}
