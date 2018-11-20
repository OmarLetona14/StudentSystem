/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.nodo;

import studentsystem.model.Professor;

/**
 *
 * @author Omar
 */
public class ProfessorNodo {
    
    public Professor info;
    public ProfessorNodo sig;
    
    public ProfessorNodo(Professor informacion){
        info = informacion;
        sig = null;
    }
}
