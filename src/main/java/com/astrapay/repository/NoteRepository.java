package com.astrapay.repository;

import com.astrapay.entity.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class NoteRepository {

    private final ConcurrentHashMap<String, Note> store = new ConcurrentHashMap<>();

    public List<Note> findAll() {
        return new ArrayList<>(store.values());
    }

    public Note save(Note note) {
        store.put(note.getId(), note);
        return note;
    }

    public void deleteById(String id) {
        store.remove(id);
    }

    public boolean existsById(String id) {
        return store.containsKey(id);
    }
}
