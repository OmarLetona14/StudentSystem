/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.nodo;

import studentsystem.model.CurrentGrade;

/**
 *
 * @author Omar
 */
public class CurrentGradeNodo {
    public CurrentGrade info;
    public CurrentGradeNodo sig;
    
    public CurrentGradeNodo(CurrentGrade info){
        this.info = info;
        sig = null;
    }
    
}
