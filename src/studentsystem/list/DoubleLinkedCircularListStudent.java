/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.list;

import studentsystem.model.Semester;
import studentsystem.model.Student;
import studentsystem.nodo.EstudianteNodo;
import studentsystem.view.AssignGradeWindow;

/**
 *
 * @author Omar
 */
public class DoubleLinkedCircularListStudent {
    
    private EstudianteNodo actual;
    private int size = 1;
    private boolean passed=false;
    
    public DoubleLinkedCircularListStudent(){
        actual = null;
    }
    
    public int listSize(){
        return size;
    }
    
    public boolean empty(){
        return(actual==null);
    }
    
    public void addToFinal(String carne, int credits, String password, String role, String name, String CUI, String email, String address){
        DoubleLinkedListStudentSemester semester = new DoubleLinkedListStudentSemester();
        Student newStudent = new Student(size,credits, semester, carne, password,role, name, CUI, email, address);
        EstudianteNodo nuevo = new EstudianteNodo(newStudent);
        if(empty()){
            actual = nuevo;  
        }else{
            EstudianteNodo aux = actual;
            aux.ant = nuevo;
            while(aux.sig!=null && aux.sig!=actual){
               aux = aux.sig; 
            }
            aux.sig = nuevo;
            nuevo.ant = aux;
            nuevo.sig = actual;
        }   
        size++;
    }
    
    public boolean loginSerch(String carneRef, String passwordRef){
        EstudianteNodo aux = actual;
        boolean found = false;
        while(aux != null && found!=true && !passed){
            if(carneRef.equals(aux.student.getCarnet()) && passwordRef.equals(aux.student.getPassword())){
                found = true;
            }else{
                if(aux.sig==actual){
                    passed = true;
                }
                aux = aux.sig; 
            }
        }
        passed = false;
        return found;
    }
    
    public Student getStudentAt(int idRef) throws Exception{
        if(idRef>=1 && !empty()){
            if(idRef==1){   
                
                return actual.student;
            }else{
                EstudianteNodo aux = actual;
                for(int i=1; i<idRef; i++){
                    aux = aux.sig;
                }
                return aux.student;
            }
        }
        passed = false;
        return null;
    }
    
    public Student getStudentByCarnet(String carnet){
        EstudianteNodo aux = actual;
        while(aux != null && !passed){
            if(carnet.equals(aux.student.getCarnet())){
                return aux.student;
            }else{
                if(aux.sig==actual){
                    passed = true;
                }
                aux = aux.sig;
            }
        }
        passed = false;
        return null;
    }
    
    
    public Student getStudentByName(String name){
        EstudianteNodo aux = actual;
        while(aux != null && !passed){
            if(name.equals(aux.student.getName())){
                return aux.student;
            }else{
                if(aux.sig==actual){
                    passed = true;
                }
                aux = aux.sig;
            }
        }
        passed = false;
        return null;
    }
   
     public boolean serch(int idRef){
        EstudianteNodo aux = actual;
        boolean found = false;
        while(aux != null && found!=true){
            if(idRef==aux.student.getIdStudent()){
                found = true;
            }else{
                aux = aux.sig;
            }
        }
        return found;
    }
    
     public void edit(int idRef, String carne, String password, String role, String name, String CUI, String email, String address){
        if(serch(idRef)){
            EstudianteNodo aux = actual;
            while(aux.student.getIdStudent() != idRef && !passed){
                if(aux.sig==actual){
                        passed = true;
                    }
                aux = aux.sig;
            }
            aux.student.setCarnet(carne);
            aux.student.setPassword(password);
            aux.student.setRole(role);
            aux.student.setName(name);
            aux.student.setCUI(CUI);
            aux.student.setEmail(email);
            aux.student.setAddress(address);
            passed = false;
        }
    
    }
   
    public void delete(int idRef){
        if(serch(idRef)){
            if(actual.student.getIdStudent()==idRef){
                actual = actual.sig;
               // first.info.setIdProfessor(idRef);
            }else{
                EstudianteNodo aux = actual;
                while(aux.sig.student.getIdStudent()!=idRef && !passed){
                    if(aux.sig==actual){
                        passed = true;
                    }
                    aux = aux.sig;
                }
                EstudianteNodo next = aux.sig.sig;
                aux.sig = next;
            }
            passed = false;
            size--;
        }
    }
     
    public void print(){
        
        EstudianteNodo temp = actual;
        
        while(temp != null && !passed){
            if(temp.ant != null){
                System.out.println("Anterior: "+temp.ant.student.getIdStudent());
            }
            System.out.println("Actual: "+temp.student.getIdStudent());
            if(temp.sig != null){
                System.out.println("Siguiente: "+temp.sig.student.getIdStudent());
            }
            System.out.println("-----------------------------");
            if(temp.sig==actual){
                passed = true;
            }
            temp = temp.sig;
        }
        passed = false;
        
    }
    
     
    
}
