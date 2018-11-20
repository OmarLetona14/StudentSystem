/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.nodo;

import studentsystem.model.Student;

/**
 *
 * @author Omar
 */
public class EstudianteNodo {
    
    public Student student;
    public EstudianteNodo sig;
    public EstudianteNodo ant;
    
    public EstudianteNodo(Student student){
        this.student = student;
        sig = null;
        ant = null;
    }
    
}
