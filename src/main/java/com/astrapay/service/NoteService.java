package com.astrapay.service;

import com.astrapay.dto.CreateNoteRequestDto;
import com.astrapay.dto.NoteDto;
import com.astrapay.entity.Note;
import com.astrapay.exception.NotFoundException;
import com.astrapay.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<NoteDto> getAll() {
        return noteRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public NoteDto create(CreateNoteRequestDto request) {
        Note note = Note.builder()
                .id(UUID.randomUUID().toString())
                .content(request.getContent().trim())
                .build();

        Note saved = noteRepository.save(note);
        return toDto(saved);
    }

    public void deleteById(String id) {
        if (!noteRepository.existsById(id)) {
            throw new NotFoundException(id);
        }
        noteRepository.deleteById(id);
    }

    private NoteDto toDto(Note note) {
        return NoteDto.builder()
                .id(note.getId())
                .content(note.getContent())
                .build();
    }
}