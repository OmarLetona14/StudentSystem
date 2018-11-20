/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.nodo;

import studentsystem.model.Grade;
    
/**
 *
 * @author Omar
 */
public class GradeNodo {
    
    public Grade grade;
    public GradeNodo sig;
    
    public GradeNodo(Grade grade){
        this.grade = grade;
        sig = null;
    }
    
}
