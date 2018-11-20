/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.list;

import studentsystem.model.Assigned;
import studentsystem.model.Grade;
import studentsystem.model.Student;
import studentsystem.nodo.AssignedNodo;

/**
 *
 * @author Omar
 */
public class SimplyLinkedListAssigned {
    private AssignedNodo first;
    int size=1;
    
    public SimplyLinkedListAssigned(){
        first = null;
    }
    
    public int listSize(){
        return size;
    }
    
    public boolean empty(){
        return(first==null);
    }
    
    public void addToFinal(Student student, int note, String state){
        Assigned assigned = new Assigned(size,student,note, state);
        AssignedNodo assignedNodo = new AssignedNodo(assigned);
        if(empty()){   
            first = assignedNodo;
        }else{
            AssignedNodo aux = first;
            while(aux.sig!=null){
                aux = aux.sig;
            }
            aux.sig = assignedNodo;           
        }
       size++;
     
    }
    
    public Assigned getAssignedAt(int idRef) throws Exception{
        if(idRef>=1 && !empty()){
            if(idRef==1){
            return first.info;
            }else{
                AssignedNodo aux = first;
                for(int i=1; i<idRef; i++){
                    aux = aux.sig;
                }
                return aux.info;
            }
        }
        return null;
    }
    
    
    public boolean serch(int idRef){
        AssignedNodo aux = first;
        boolean found = false;
        while(aux != null && found!=true){
            if(idRef==aux.info.getIdAssigned()){
                found = true;
            }else{
                aux = aux.sig;
            }
        }
        return found;
    }
    public boolean serchByCarnet(String carnet){
        AssignedNodo aux = first;
        boolean found = false;
        while(aux != null && found!=true){
            if(carnet.equals(aux.info.getStudent().getCarnet())){
                found = true;
            }else{
                aux = aux.sig;
            }
        }
        return found;
    }
    
    public Student getByCarnet(String carnet){
        AssignedNodo aux = first;
        while(aux != null){
            if(carnet.equals(aux.info.getStudent().getCarnet())){
                return aux.info.getStudent();
            }else{
                aux = aux.sig;
            }
        }
        return null;
    }
    
    public Assigned getAssignedByCarnet(String carnet){
        AssignedNodo aux = first;
        while(aux != null){
            if(carnet.equals(aux.info.getStudent().getCarnet())){
                return aux.info;
            }else{
                aux = aux.sig;
            }
        }
        return null;
    }
    
    
    public void updateNote(String carnet, Grade grade, int note){
        AssignedNodo aux = first;
        boolean updated = false;
        while(aux != null && !updated){
            if(carnet.equals(aux.info.getStudent().getCarnet())){
                aux.info.setNote(note);
                if(note>=61){
                    int actualCredits = aux.info.getStudent().getCredits();
                    int currentCredits = grade.getCredits();
                    aux.info.getStudent().setCredits(actualCredits+currentCredits);
                    aux.info.setState("APROBADO");
                }
                updated = true;
            }else{
                aux = aux.sig;
            }
        }
    }
    
     
    
   
    public void unassing(String carnet){
        if(serchByCarnet(carnet)){
            if(first.info.getStudent().getCarnet().equals(carnet)){
                first = first.sig;
            }else{
                AssignedNodo aux = first;
                while(aux.sig.info.getStudent().getCarnet().equals(carnet)){
                    aux = aux.sig;
                }
                AssignedNodo next = aux.sig.sig;
               
                aux.sig = next;
            }
            size--;
        }
    }
    
    public void print(){
        
        AssignedNodo temp = first;
        
        while(temp != null){

            System.out.println("Actual: "+temp.info.getIdAssigned());
            if(temp.sig != null){
                System.out.println("Siguiente: "+temp.sig.info.getIdAssigned());
            }
            System.out.println("-----------------------------");
            
            temp = temp.sig;
        }
    }
    
}
