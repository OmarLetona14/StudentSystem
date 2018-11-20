/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.nodo;

import studentsystem.model.Semester;

/**
 *
 * @author Omar
 */
public class SemesterNodo {
    public Semester info;
    public SemesterNodo sig;
    
    public SemesterNodo(Semester informacion){
        info = informacion;
        sig = null;
    }
}
