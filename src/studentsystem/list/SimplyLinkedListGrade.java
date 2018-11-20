/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.list;

import studentsystem.model.Grade;
import studentsystem.model.Professor;
import studentsystem.model.Semester;
import studentsystem.nodo.GradeNodo;

/**
 *
 * @author Omar
 */
public class SimplyLinkedListGrade {
    private GradeNodo first;
    int size=1;
    
    public SimplyLinkedListGrade(){
        first = null;
    }
    
    public int listSize(){
        return size;
    }
    
    public boolean empty(){
        return(first==null);
    }
    
    public void addToFinal(Semester semester, int noGrade, String name, Professor professor, int credits, String section, String laboratory, SimplyLinkedListGrade preRequisite, Grade postRequisite){
        Grade grade = new Grade(size, semester, noGrade, name, professor, credits, section, laboratory, preRequisite, postRequisite);
        GradeNodo newNodo = new GradeNodo(grade);
        if(empty()){   
            first = newNodo;
        }else{
            GradeNodo aux = first;
            while(aux.sig!=null){
                aux = aux.sig;
            }
            aux.sig = newNodo;           
        }
       size++;
     
    }
    
    public Grade getGradeAt(int idRef) throws Exception{
       
        if(idRef>=1 && !empty()){
            if(idRef==1){
            return first.grade;
            }else{
                GradeNodo aux = first;
                for(int i=1; i<idRef; i++){
                    aux = aux.sig;
                }
                return aux.grade;
            }
        }
        return null;
    }
    
    public Grade getGradeByName(String name){
        GradeNodo aux = first;
        while(aux != null){
            if(name.equals(aux.grade.getName())){
                return aux.grade;
            }else{
                aux = aux.sig;
            }
        }
        return null;
    }
    public Grade getGradeByNumber(int noGrade){
        GradeNodo aux = first;
        while(aux != null){
            if(noGrade==aux.grade.getNoGrade()){
                return aux.grade;
            }else{
                aux = aux.sig;
            }
        }
        return null;
    }
    
    public boolean serch(int idRef){
        GradeNodo aux = first;
        boolean found = false;
        while(aux != null && found!=true){
            if(idRef==aux.grade.getIdGrade()){
                found = true;
            }else{
                aux = aux.sig;
            }
        }
        return found;
    }
    
    public void edit(int idRef, Semester semester, int noGrade, String name, Professor professor, int credits, String laboratory, SimplyLinkedListGrade preRequisite, Grade postRequisite){
        if(serch(idRef)){
            GradeNodo aux = first;
            while(aux.grade.getIdGrade() != idRef){
                aux = aux.sig;
            }
            aux.grade.setSemester(semester);
            aux.grade.setNoGrade(noGrade);
            aux.grade.setName(name);
            aux.grade.setProfessor(professor);
            aux.grade.setCredits(credits);
            aux.grade.setLaboratory(laboratory);
            aux.grade.setPreRequisite(preRequisite);
            aux.grade.setPostRequisite(postRequisite);
        }
    
    }
    
    public void delete(int idRef){
        if(serch(idRef)){
            if(first.grade.getIdGrade()==idRef){
                first = first.sig;
               // first.grade.setIdGrade(idRef);
            }else{
                GradeNodo aux = first;
                while(aux.sig.grade.getIdGrade()!=idRef){
                    aux = aux.sig;
                }
                GradeNodo next = aux.sig.sig;
               
                aux.sig = next;
            }
            size--;
        }
    }
    
    public void print(){
        
        GradeNodo temp = first;
        
        while(temp != null){

            System.out.println("Actual: "+temp.grade.getIdGrade());
            if(temp.sig != null){
                System.out.println("Siguiente: "+temp.sig.grade.getIdGrade());
            }
            System.out.println("-----------------------------");
            
            temp = temp.sig;
        }
    }
    
    
}
