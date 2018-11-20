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
public class Semester {
    
    public int idSemester;
    public String semesterName;

    public Semester(int idSemester, String semesterName) {
        this.idSemester = idSemester;
        this.semesterName = semesterName;
    }

    public int getIdSemester() {
        return idSemester;
    }

    public void setIdSemester(int idSemester) {
        this.idSemester = idSemester;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    } 
    
}
