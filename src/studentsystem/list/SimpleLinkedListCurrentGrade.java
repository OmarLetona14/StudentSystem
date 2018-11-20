/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.list;

import studentsystem.model.Assigned;
import studentsystem.model.CurrentGrade;
import studentsystem.model.Grade;
import studentsystem.nodo.CurrentGradeNodo;

/**
 *
 * @author Omar
 */
public class SimpleLinkedListCurrentGrade {
    
    private CurrentGradeNodo first;
    int size=1;
    boolean foundEmpty =false,assigned = false, passed = false;
    
    public SimpleLinkedListCurrentGrade(){
        first = null;
    }
    
    public int listSize(){
        return size;
    }
    
    public boolean empty(){
        return(first==null);
    }
    
    public void addToFinal(Grade grade, SimplyLinkedListAssigned assignedStudentsList){
        CurrentGrade currentClass = new CurrentGrade(size,grade, assignedStudentsList);
        CurrentGradeNodo currentNodo = new CurrentGradeNodo(currentClass);
        if(empty()){   
            first = currentNodo;
        }else{
            CurrentGradeNodo aux = first;
            while(aux.sig!=null){
                aux = aux.sig;
            }
            aux.sig = currentNodo;           
        }
       size++;
     
    }
    
    public CurrentGrade getCurrentGradeAt(int idRef) throws Exception{
        if(idRef>=1 && !empty()){
            if(idRef==1){
            return first.info;
            }else{
                CurrentGradeNodo aux = first;
                for(int i=1; i<idRef; i++){
                    aux = aux.sig;
                }
                return aux.info;
            }
        }
        return null;
    }
    
    public Grade getGradeAt(int idRef){
        CurrentGradeNodo aux = first;
        while(aux != null ){
            if(idRef==aux.info.getIdCurrentGrade()){
                return aux.info.getGrade();
            }else{
                aux = aux.sig;
            }
        }
        return null;
    }
    
    public boolean serch(int idRef){
        CurrentGradeNodo aux = first;
        boolean found = false;
        while(aux != null && found!=true){
            if(idRef==aux.info.getIdCurrentGrade()){
                found = true;
            }else{
                aux = aux.sig;
            }
        }
        return found;
    }
    public boolean emptyClass(int noGrade){
        CurrentGradeNodo aux = first;
        
        while(aux != null && !foundEmpty==true){
            if(noGrade==aux.info.getGrade().getNoGrade()){
                if(aux.info.getAssignedList().size==1){
                    return true;
                }else{
                    return false;
                }
            }else{
                aux = aux.sig;
            }
         }
        return foundEmpty;
    }
    
    public boolean assigned(int noGrade, int idStudent) throws Exception{
        CurrentGradeNodo aux = first;
        
        while(aux != null && !assigned==true){
            if(noGrade==aux.info.getGrade().getNoGrade() && 
                    idStudent == aux.info.getAssignedList().getAssignedAt(idStudent).getStudent().getIdStudent()){
                assigned = true;
            }else{
                aux = aux.sig;
            }
        }
        return assigned;
    }
    
    public SimplyLinkedListAssigned getClassStudents(String carnet, int idRef){
        CurrentGradeNodo aux = first;
        while(aux != null){
            if(carnet.equals(aux.info.getGrade().getProfessor().getCarnet()) && idRef == aux.info.getGrade().getIdGrade()){
                return aux.info.getAssignedList();
            }else{
                aux = aux.sig;
            }
        }
        return null;
    }
    
    public SimplyLinkedListAssigned getClass(String carnet){
        CurrentGradeNodo aux = first;
        while(aux != null){
            if(carnet.equals(aux.info.getGrade().getProfessor().getCarnet())){
                return aux.info.getAssignedList();
            }else{
                aux = aux.sig;
            }
        }
        return null;
    }
    public SimplyLinkedListAssigned getClassByGrade(int noGrade){
        CurrentGradeNodo aux = first;
        while(aux != null){
            if(noGrade == aux.info.getGrade().getNoGrade()){
                return aux.info.getAssignedList();
            }else{
                aux = aux.sig;
            }
        }
        return null;
    }
    
     public Grade getGradesByProfessor(String carnet, int idRef){
        CurrentGradeNodo aux = first;
        while(aux != null){
            if(carnet.equals(aux.info.getGrade().getProfessor().getCarnet()) && idRef == aux.info.getGrade().getIdGrade()){
                return aux.info.getGrade();
            }else{
                aux = aux.sig;
            }
        }
        return null;
    }
     

     
     public Grade getGradeApproved(String carnet, int idRef) throws Exception{
        CurrentGradeNodo aux = first;
        
        while(aux != null && !passed){
            if(carnet.equals(aux.info.getAssignedList().getByCarnet(carnet).getCarnet())){
                if(idRef == aux.info.getAssignedList().getAssignedAt(idRef).getIdAssigned()){
                    if(aux.info.getAssignedList().getAssignedAt(idRef).getState().equals("APROBADO")){
                        return aux.info.getGrade();
                    }else{
                        if(aux.sig==first){
                            passed = true;
                        }
                        aux = aux.sig;
                    }
                }
            }
        }
        passed = false;
        return null;
    }
    
    public Assigned getAssignedByGradeProfessor(int idRef, String carnet, int noGrade) throws Exception{
        CurrentGradeNodo aux = first;
        while(aux != null){
            if(carnet.equals(aux.info.getGrade().getProfessor().getCarnet()) && noGrade == aux.info.getGrade().getNoGrade()){
                return aux.info.getAssignedList().getAssignedAt(idRef);
            }else{
                aux = aux.sig;
            }
        }
        return null;
    }
    public Grade getGradeByProfessor(int i, String carnet){
        CurrentGradeNodo aux = first;
        while(aux != null){
            if(carnet.equals(aux.info.getGrade().getProfessor().getCarnet())){
                return aux.info.getGrade();
            }else{
                aux = aux.sig;
            }
        }
        return null;
    }
    public void unassingGrade(int noGrade){
            if(first.info.getGrade().getNoGrade()==noGrade){
                first = first.sig;
            }else{
                CurrentGradeNodo aux = first;
                while(first.info.getGrade().getNoGrade()==noGrade){
                    aux = aux.sig;
                }
                CurrentGradeNodo next = aux.sig.sig;
               
                aux.sig = next;
            }
            size--;
    }
  
    
}
