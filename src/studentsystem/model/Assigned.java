/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.model;

/**
 *
 * @author Omar
 */
public class Assigned {
    
    private int idAssigned;
    private Student student;
    private int note;
    private String state;

    public Assigned(int idAssigned, Student student, int note, String state) {
        this.idAssigned = idAssigned;
        this.student = student;
        this.note = note;
        this.state = state;
    }

    public int getIdAssigned() {
        return idAssigned;
    }

    public void setIdAssigned(int idAssigned) {
        this.idAssigned = idAssigned;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
    
    
    
}
