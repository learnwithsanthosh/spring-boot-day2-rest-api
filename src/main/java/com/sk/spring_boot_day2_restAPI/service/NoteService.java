package com.sk.spring_boot_day2_restAPI.service;

import com.sk.spring_boot_day2_restAPI.controller.NoteController;
import com.sk.spring_boot_day2_restAPI.dto.NotesDTO;
import com.sk.spring_boot_day2_restAPI.entity.Notes;
import com.sk.spring_boot_day2_restAPI.exception.NotesNotFoundException;
import com.sk.spring_boot_day2_restAPI.repo.NotesRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {
    private static final Logger logger = LoggerFactory.getLogger(NoteController.class);

    private NotesRepo notesRepo;

    public NoteService(NotesRepo notesRepo) {
        this.notesRepo = notesRepo;
    }


    public List<NotesDTO> getallNotes() {
        logger.info(" Inside NoteService.getallNotes()");
        List<Notes> response= notesRepo.findAll();
        List<NotesDTO> notesDTOS = response
                .stream()
                .map(data->new NotesDTO(data.getId(),data.getName(), data.getSubject()))
                .collect(Collectors.toList());
        return notesDTOS;
    }

    public void addNote(Notes note) {
        logger.info(" Inside NoteService.addNote() :{}",note);
            notesRepo.save(note);
    }

    public NotesDTO getNoteById(int id) {
        logger.info("Inside NoteService.getNoteById() with id : {}",id);
        Notes note= notesRepo.findById(id).get();
        if (note.equals(null)) {
            logger.error("Note not found for given id: "+id);
            throw new NotesNotFoundException("Note not found for given id :"+id);
        }
        NotesDTO notesDTO= new NotesDTO(note.getId(), note.getName(),note.getSubject());
        return notesDTO;
    }
    public Notes getNoteByIdNoDTO(int id) {
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

    public NotesDTO updateNote(int id,Notes note) {
        Notes noteByIdNoDTO = getNoteByIdNoDTO(id);
        noteByIdNoDTO.setName(note.getName());
        noteByIdNoDTO.setSubject(note.getSubject());
        addNote(noteByIdNoDTO);
        return new NotesDTO(noteByIdNoDTO.getId(), noteByIdNoDTO.getName(), noteByIdNoDTO.getSubject());
    }
}
