 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.model;

import studentsystem.list.SimplyLinkedListAssigned;

/**
 *
 * @author Omar
 */
public class CurrentGrade {
    
    private int idCurrentGrade;
    private Grade grade;
    private SimplyLinkedListAssigned assignedList;

    public CurrentGrade(int idCurrentGrade, Grade grade, SimplyLinkedListAssigned assignedList) {
        this.idCurrentGrade = idCurrentGrade;
        this.grade = grade;
        this.assignedList = assignedList;
    }

    public int getIdCurrentGrade() {
        return idCurrentGrade;
    }

    public void setIdCurrentGrade(int idCurrentGrade) {
        this.idCurrentGrade = idCurrentGrade;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public SimplyLinkedListAssigned getAssignedList() {
        return assignedList;
    }

    public void setAssignedList(SimplyLinkedListAssigned assignedList) {
        this.assignedList = assignedList;
    }
    
    
    

}
