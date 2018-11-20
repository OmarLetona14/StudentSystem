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
public class StudentSemester {
    
    private int idStudentSemester;
    private Semester semester;
    private SimpleLinkedListCurrentGrade gradesList;

    public StudentSemester(int idStudentSemester, Semester semester, SimpleLinkedListCurrentGrade gradesList) {
        this.idStudentSemester = idStudentSemester;
        this.semester = semester;
        this.gradesList = gradesList;
    }

    public int getIdStudentSemester() {
        return idStudentSemester;
    }

    public void setIdStudentSemester(int idStudentSemester) {
        this.idStudentSemester = idStudentSemester;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public SimpleLinkedListCurrentGrade getGradesList() {
        return gradesList;
    }

    public void setGradesList(SimpleLinkedListCurrentGrade gradesList) {
        this.gradesList = gradesList;
    }
    
    
    
    
}
