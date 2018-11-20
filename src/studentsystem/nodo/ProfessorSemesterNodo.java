/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.nodo;

import studentsystem.model.ProfessorSemester;

/**
 *
 * @author Omar
 */
public class ProfessorSemesterNodo {
    
    public ProfessorSemester info;
    public ProfessorSemesterNodo sig;
    
    public ProfessorSemesterNodo(ProfessorSemester informacion){
        info = informacion;
        sig = null;
    }
    
}
