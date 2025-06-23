package com.sk.spring_boot_day2_restAPI.service;

import com.sk.spring_boot_day2_restAPI.controller.NoteController;
import com.sk.spring_boot_day2_restAPI.dao.Notes;
import com.sk.spring_boot_day2_restAPI.exception.NotesNotFoundException;
import com.sk.spring_boot_day2_restAPI.repo.NotesRepo;
import org.aspectj.weaver.ast.Not;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private static final Logger logger = LoggerFactory.getLogger(NoteController.class);

    private NotesRepo notesRepo;

    public NoteService(NotesRepo notesRepo) {
        this.notesRepo = notesRepo;
    }


    public List<Notes> getallNotes() {
        logger.info(" Inside NoteService.getallNotes()");
        return notesRepo.findAll();
    }

    public void addNote(Notes note) {
        logger.info(" Inside NoteService.addNote() :{}",note);
            notesRepo.save(note);
    }

    public Notes getNoteById(int id) {
        logger.info("Inside NoteService.getNoteById() with id : {}",id);
        Notes note= notesRepo.findById(id).get();
        if (note.equals(null)) {
            logger.error("Note not found for given id: "+id);
            throw new NotesNotFoundException("Note not found for given id :"+id);
        }
        return note;
    }

    public String deleteById(int id) {
        logger.info("Inside NoteService.deleteById() with id : {}",id);
        notesRepo.deleteById(id);
        return "Note with id :"+id+" deleted";
    }
}
