/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.model;

import studentsystem.list.SimpleLinkedListCurrentGrade;

/**
 *
 * @author Omar
 */
public class ProfessorSemester {
    
    private int idProfessorSemester;
    private Semester semester;
    private SimpleLinkedListCurrentGrade coursesList;

    public ProfessorSemester(int idProfessorSemester, Semester semester, SimpleLinkedListCurrentGrade coursesList) {
        this.idProfessorSemester = idProfessorSemester;
        this.semester = semester;
        this.coursesList = coursesList;
    }

    public int getIdProfessorSemester() {
        return idProfessorSemester;
    }

    public void setIdProfessorSemester(int idProfessorSemester) {
        this.idProfessorSemester = idProfessorSemester;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public SimpleLinkedListCurrentGrade getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(SimpleLinkedListCurrentGrade coursesList) {
        this.coursesList = coursesList;
    }
    
    
    
}
