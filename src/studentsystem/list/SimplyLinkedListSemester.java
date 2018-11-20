/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.list;

import studentsystem.model.Semester;
import studentsystem.nodo.SemesterNodo;

/**
 *
 * @author Omar
 */
public class SimplyLinkedListSemester {
    
     private SemesterNodo first;
    int size=1;
    
    public SimplyLinkedListSemester(){
        first = null;
    }
    
    public int listSize(){
        return size;
    }
    
    public boolean empty(){
        return(first==null);
    }
    
    public void addToFinal(String semester){
        Semester grade = new Semester(size, semester);
        SemesterNodo newNodo = new SemesterNodo(grade);
        if(empty()){   
            first = newNodo;
        }else{
            SemesterNodo aux = first;
            while(aux.sig!=null){
                aux = aux.sig;
            }
            aux.sig = newNodo;           
        }
       size++;
     
    }
    
    public Semester getSemesterAt(int idRef) throws Exception{
       
        if(idRef>=1 && !empty()){
            if(idRef==1){
            return first.info;
            }else{
                SemesterNodo aux = first;
                for(int i=1; i<idRef; i++){
                    aux = aux.sig;
                }
                return aux.info;
            }
        }
        return null;
    }
    
    public Semester getSemesterByName(String name){
        SemesterNodo aux = first;
        while(aux != null){
            if(name.equals(aux.info.getSemesterName())){
                return aux.info;
            }else{
                aux = aux.sig;
            }
        }
        return null;
    }
    
    
    public boolean serch(String semester){
        SemesterNodo aux = first;
        boolean found = false;
        while(aux != null && found!=true){
            if(semester==aux.info.getSemesterName()){
                found = true;
            }else{
                aux = aux.sig;
            }
        }
        return found;
    }
    
    
}
