/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.model;

import studentsystem.list.DoubleLinkedListStudentSemester;

/**
 *
 * @author Omar
 */
public class Student extends SystemUser {
    
    private int idStudent;
    private int credits;
    private DoubleLinkedListStudentSemester semester;

    public Student(int idStudent, int credits, DoubleLinkedListStudentSemester semester, String carnet, String password, String role, String name, String CUI, String email, String address) {
        super(carnet, password, role, name, CUI, email, address);
        this.idStudent = idStudent;
        this.credits = credits;
        this.semester = semester;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public DoubleLinkedListStudentSemester getSemester() {
        return semester;
    }

    public void setSemester(DoubleLinkedListStudentSemester semester) {
        this.semester = semester;
    }

    public static SystemUser[] getSystemusers() {
        return systemusers;
    }

    public static void setSystemusers(SystemUser[] systemusers) {
        SystemUser.systemusers = systemusers;
    }

    
}
