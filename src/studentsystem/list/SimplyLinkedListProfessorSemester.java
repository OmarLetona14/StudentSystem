/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.list;

import studentsystem.model.CurrentGrade;
import studentsystem.model.ProfessorSemester;
import studentsystem.model.Semester;
import studentsystem.nodo.ProfessorSemesterNodo;

/**
 *
 * @author Omar
 */
public class SimplyLinkedListProfessorSemester {
    
    private ProfessorSemesterNodo first;
    int size=1;
    
    public SimplyLinkedListProfessorSemester(){
        first = null;
    }
    
    public int listSize(){
        return size;
    }
    
    public boolean empty(){
        return(first==null);
    }
    
    public void addToFinal(Semester semester, SimpleLinkedListCurrentGrade assignedGradesList){
        ProfessorSemester professorSemester = new ProfessorSemester(size,semester, assignedGradesList);
        ProfessorSemesterNodo currentNodo = new ProfessorSemesterNodo(professorSemester);
        if(empty()){   
            first = currentNodo;
        }else{
            ProfessorSemesterNodo aux = first;
            while(aux.sig!=null){
                aux = aux.sig;
            }
            aux.sig = currentNodo;           
        }
       size++;
     
    }
    
    public ProfessorSemester getProfessorSemesterAt(int idRef) throws Exception{
        if(idRef>=1 && !empty()){
            if(idRef==1){
            return first.info;
            }else{
                ProfessorSemesterNodo aux = first;
                for(int i=1; i<idRef; i++){
                    aux = aux.sig;
                }
                return aux.info;
            }
        }
        return null;
    }
    
    public boolean serch(int idRef){
        ProfessorSemesterNodo aux = first;
        boolean found = false;
        while(aux != null && found!=true){
            if(idRef==aux.info.getIdProfessorSemester()){
                found = true;
            }else{
                aux = aux.sig;
            }
        }
        return found;
    }
    public boolean serchSemesterByProfessor(int idRef){
        ProfessorSemesterNodo aux = first;
        boolean found = false;
        while(aux != null && found!=true){
            if(idRef==aux.info.getIdProfessorSemester()){
                found = true;
            }else{
                aux = aux.sig;
            }
        }
        return found;
    }
    
    public boolean serchSemester(Semester semester){
        ProfessorSemesterNodo aux = first;
        boolean found = false;
        while(aux != null && found!=true){
            if(semester.getSemesterName().equals(aux.info.getSemester().getSemesterName())){
                found = true;
            }else{
                aux = aux.sig;
            }
        }
        return found;
    }
    public SimpleLinkedListCurrentGrade getListaCursos(Semester semester){
        ProfessorSemesterNodo aux = first;
        while(aux != null){
            if(semester.getSemesterName().equals(aux.info.getSemester().getSemesterName())){
                return aux.info.getCoursesList();
            }else{
                aux = aux.sig;
            }
        }
        return null;
    }
}
