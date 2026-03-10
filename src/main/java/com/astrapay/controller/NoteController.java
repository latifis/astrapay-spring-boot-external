package com.astrapay.controller;

import com.astrapay.dto.CreateNoteRequestDto;
import com.astrapay.dto.NoteDto;
import com.astrapay.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<List<NoteDto>> getNotes() {
        return ResponseEntity.ok(noteService.getAll());
    }

    @PostMapping
    public ResponseEntity<NoteDto> createNote(@Valid @RequestBody CreateNoteRequestDto request) {
        NoteDto created = noteService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable String id) {
        noteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
