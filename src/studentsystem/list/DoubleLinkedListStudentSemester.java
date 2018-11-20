/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.list;

import studentsystem.model.Semester;
import studentsystem.model.StudentSemester;
import studentsystem.nodo.StudentSemesterNodo;

/**
 *
 * @author Omar
 */
public class DoubleLinkedListStudentSemester {
    
    private StudentSemesterNodo actual;
    int size=1;
    
    public DoubleLinkedListStudentSemester(){
        actual = null;
    }
    
    public int listSize(){
        return size;
    }
    
    public boolean empty(){
        return(actual==null);
    }
    
    public void addToFinal(Semester semester, SimpleLinkedListCurrentGrade assignedGradesList){
        StudentSemester studentSemester = new StudentSemester(size,semester, assignedGradesList);
        StudentSemesterNodo currentNodo = new StudentSemesterNodo(studentSemester);
        if(empty()){   
            actual = currentNodo;
        }else{
            StudentSemesterNodo aux = actual;
            while(aux.sig!=null){
                aux = aux.sig;
            }
            aux.sig = currentNodo; 
            currentNodo.ant = aux;
        }
       size++;
     
    }
    
    public boolean serch(int idRef){
        StudentSemesterNodo aux = actual;
        boolean found = false;
        while(aux != null && found!=true){
            if(idRef==aux.info.getIdStudentSemester()){
                found = true;
            }else{
                aux = aux.sig;
            }
        }
        return found;
    }
    
    public StudentSemester getStudentSemesterAt(int idRef) throws Exception{
        if(idRef>=1 && !empty()){
            if(idRef==1){
            return actual.info;
            }else{
                StudentSemesterNodo aux = actual;
                for(int i=1; i<idRef; i++){
                    aux = aux.sig;
                }
                return aux.info;
            }
        }
        return null;
    }
    
    public SimpleLinkedListCurrentGrade getCurrentGradeList(Semester semester){
        if(semester!=null){
            StudentSemesterNodo aux = actual;
            while(aux != null){

                if(semester.getSemesterName().equals(aux.info.getSemester().getSemesterName())){
                    return aux.info.getGradesList();
                }else{
                    aux = aux.sig;
                }
            }
        }  
        return null;
    }
    
}
