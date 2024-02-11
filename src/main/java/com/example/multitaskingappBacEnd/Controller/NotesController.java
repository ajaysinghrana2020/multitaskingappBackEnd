package com.example.multitaskingappBacEnd.Controller;

import com.example.multitaskingappBacEnd.Pom.Notes;
import com.example.multitaskingappBacEnd.Repo.NotesRepository;
import com.example.multitaskingappBacEnd.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/notes")
public class NotesController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotesRepository notesRepository;

//    @PostMapping(value = "/add/{id}")
//    public ResponseEntity<Notes> addNewNote(@PathVariable(value = "id")int userid, @RequestBody Notes notes){
//        Notes notes1= userRepository.findById(userid).map(note->{
//            notes.setUsers(note);
//            return notesRepository.save(notes);
//        }).orElseThrow(()->new ResourceAccessException("not accable "));
//        return new ResponseEntity<>(notes, HttpStatus.CREATED);
//    }

    @GetMapping(value = "/all")
    public ResponseEntity<Iterable> getAllNotes(){
        return ResponseEntity.ok(notesRepository.findAll());
    }


}
