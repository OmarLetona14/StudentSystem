/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.model;

import studentsystem.list.SimplyLinkedListProfessorSemester;

/**
 *
 * @author Omar
 */
public class Professor extends SystemUser {
    
    private int idProfessor;
    private SimplyLinkedListProfessorSemester semester;

    public Professor(int idProfessor, SimplyLinkedListProfessorSemester semester, String carnet, String password, String role, String name, String CUI, String email, String address) {
        super(carnet, password, role, name, CUI, email, address);
        this.idProfessor = idProfessor;
        this.semester = semester;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public SimplyLinkedListProfessorSemester getSemester() {
        return semester;
    }

    public void setSemester(SimplyLinkedListProfessorSemester semester) {
        this.semester = semester;
    }
    
    
   
}
