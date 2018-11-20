/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.model;

import studentsystem.list.SimplyLinkedListGrade;

/**
 *
 * @author Omar
 */
public class Grade {
    
    private int idGrade;
    private Semester semester;
    private int noGrade;
    private String name;
    private Professor professor;
    private int credits;
    private String laboratory;
    private String section;
    private SimplyLinkedListGrade preRequisite;
    private Grade postRequisite;

    public Grade(int idGrade, Semester semester, int noGrade, String name, Professor professor, int credits, String laboratory, String section, SimplyLinkedListGrade preRequisite, Grade postRequisite) {
        this.idGrade = idGrade;
        this.semester = semester;
        this.noGrade = noGrade;
        this.name = name;
        this.professor = professor;
        this.credits = credits;
        this.laboratory = laboratory;
        this.section = section;
        this.preRequisite = preRequisite;
        this.postRequisite = postRequisite;
    }

    public int getIdGrade() {
        return idGrade;
    }

    public void setIdGrade(int idGrade) {
        this.idGrade = idGrade;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public int getNoGrade() {
        return noGrade;
    }

    public void setNoGrade(int noGrade) {
        this.noGrade = noGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public SimplyLinkedListGrade getPreRequisite() {
        return preRequisite;
    }

    public void setPreRequisite(SimplyLinkedListGrade preRequisite) {
        this.preRequisite = preRequisite;
    }

    public Grade getPostRequisite() {
        return postRequisite;
    }

    public void setPostRequisite(Grade postRequisite) {
        this.postRequisite = postRequisite;
    }

    
   
}
