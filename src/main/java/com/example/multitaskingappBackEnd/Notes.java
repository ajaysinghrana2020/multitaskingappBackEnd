package com.example.multitaskingappBackEnd;

import jakarta.persistence.*;

@Table(name = "notes")
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int notes_id;
    int time;
    String note;
    Boolean status;
    
    @ManyToOne
    private Users users;


    public int getNotes_id() {
        return notes_id;
    }

    public void setNotes_id(int notes_id) {
        this.notes_id = notes_id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Notes(int notes_id, int time, String note, Boolean status) {
        this.notes_id = notes_id;
        this.time = time;
        this.note = note;
        this.status = status;
    }
}
