/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.nodo;

import studentsystem.model.Assigned;

/**
 *
 * @author Omar
 */
public class AssignedNodo {
    public Assigned info;
    public AssignedNodo sig;
    
    public AssignedNodo(Assigned info){
        this.info = info;
        sig = null;
    }
    
}
