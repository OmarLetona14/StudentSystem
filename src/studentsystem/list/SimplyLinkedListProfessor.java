/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.list;

import studentsystem.model.Professor;
import studentsystem.nodo.ProfessorNodo;

/**
 *
 * @author Omar
 */
public class SimplyLinkedListProfessor {
    private ProfessorNodo first;
    int size=1;
    
    public SimplyLinkedListProfessor(){
        first = null;
    }
    
    public int listSize(){
        return size;
    }
    
    public boolean empty(){
        return(first==null);
    }
    
    public void addToFinal(String carne, String password, String role, String name, String CUI, String email, String address){
        SimplyLinkedListProfessorSemester listaSemestres = new SimplyLinkedListProfessorSemester();
        Professor professor = new Professor(size,listaSemestres,carne, password,role, name, CUI, email, address);
        ProfessorNodo newNodo = new ProfessorNodo(professor);
        if(empty()){   
            first = newNodo;
        }else{
            ProfessorNodo aux = first;
            while(aux.sig!=null){
                aux = aux.sig;
            }
            aux.sig = newNodo;           
        }
       size++;
     
    }
    
    public boolean loginSerch(String carneRef, String passwordRef){
        ProfessorNodo aux = first;
        boolean found = false;
        while(aux != null && found!=true){
            if(carneRef.equals(aux.info.getCarnet()) && passwordRef.equals(aux.info.getPassword())){
                found = true;
            }else{
                aux = aux.sig;
            }
        }
        return found;
    }
    
    public Professor getProfessorAt(int idRef) throws Exception{
        if(idRef>=1 && !empty()){
            if(idRef==1){
            return first.info;
            }else{
                ProfessorNodo aux = first;
                for(int i=1; i<idRef; i++){
                    aux = aux.sig;
                }
                return aux.info;
            }
        }
        return null;
    }
    public Professor getProfessorByName(String name){
        ProfessorNodo aux = first;
        while(aux != null){
            if(name.equals(aux.info.getName())){
                return aux.info;
            }else{
                aux = aux.sig;
            }
        }
        return null;
    }
    
    public Professor getProfessorByCarnet(String carnet){
        ProfessorNodo aux = first;
        while(aux != null){
            if(carnet.equals(aux.info.getCarnet())){
                return aux.info;
            }else{
                aux = aux.sig;
            }
        }
        return null;
    }
    
    public boolean serch(int idRef){
        ProfessorNodo aux = first;
        boolean found = false;
        while(aux != null && found!=true){
            if(idRef==aux.info.getIdProfessor()){
                found = true;
            }else{
                aux = aux.sig;
            }
        }
        return found;
    }
    
    public boolean serchByCarnet(String carnet){
        String spCarnet=carnet;
        ProfessorNodo aux = first;
        boolean found = false;
        while(aux != null && found!=true){
            String strCarnet =aux.info.getCarnet().trim();
            if(!(spCarnet.equalsIgnoreCase(strCarnet))){
                aux = aux.sig;
            }else{
                found = true;
            }
        }
        return found;
    
    }
    
    public void edit(int idRef, String carne, String password, String role, String name, String CUI, String email, String address){
        if(serch(idRef)){
            ProfessorNodo aux = first;
            while(aux.info.getIdProfessor() != idRef){
                aux = aux.sig;
            }
            aux.info.setCarnet(carne);
            aux.info.setPassword(password);
            aux.info.setRole(role);
            aux.info.setName(name);
            aux.info.setCUI(CUI);
            aux.info.setEmail(email);
            aux.info.setAddress(address);
        }
    
    }
   
    public void delete(int idRef){
        if(serch(idRef)){
            if(first.info.getIdProfessor()==idRef){
                first = first.sig;
                //first.info.setIdProfessor(idRef);
            }else{
                ProfessorNodo aux = first;
                while(aux.sig.info.getIdProfessor()!=idRef){
                    aux = aux.sig;
                }
                ProfessorNodo next = aux.sig.sig;
               
                aux.sig = next;
            }
            size--;
        }
    }
    
    public void print(){
        
        ProfessorNodo temp = first;
        
        while(temp != null){

            System.out.println("Actual: "+temp.info.getIdProfessor());
            if(temp.sig != null){
                System.out.println("Siguiente: "+temp.sig.info.getIdProfessor());
            }
            System.out.println("-----------------------------");
            
            temp = temp.sig;
        }
    }
}
