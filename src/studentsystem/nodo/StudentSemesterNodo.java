/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.nodo;

import studentsystem.model.StudentSemester;

/**
 *
 * @author Omar
 */
public class StudentSemesterNodo {
    public StudentSemester info;
    public StudentSemesterNodo sig;
    public StudentSemesterNodo ant;
    
    public StudentSemesterNodo(StudentSemester informacion){
        info = informacion;
        sig = null;
        ant = null;
    }
}
