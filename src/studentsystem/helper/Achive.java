/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import studentsystem.list.SimpleLinkedListCurrentGrade;
import studentsystem.list.SimplyLinkedListAssigned;
import studentsystem.list.SimplyLinkedListGrade;
import studentsystem.model.CurrentGradeTableModel;
import studentsystem.model.Grade;
import studentsystem.model.GradeTableModel;
import studentsystem.model.Professor;
import studentsystem.model.ProfessorTableModel;
import studentsystem.model.Semester;
import studentsystem.model.StudentTableModel;
import studentsystem.view.LoginWindow;

/**
 *
 * @author Omar
 */
public class Achive {
    
    SimpleLinkedListCurrentGrade assignedGradesList = new SimpleLinkedListCurrentGrade();   
    BufferedReader reader = null;
    FileReader fReader = null;
    RandomNumber random = new RandomNumber();
    
    public void read(String filename, String type) throws FileNotFoundException, IOException{
        fReader = new FileReader(filename);
        reader = new BufferedReader(fReader); 
        String linea;      
        while((linea = reader.readLine()) != null){
            if(!(linea == null)){
                String[] lineaString = linea.split(";");
                   switch(type){
                       case "Catedratico":
                           String nombreP = lineaString[2]+ " " +lineaString[3];
                           ProfessorTableModel.professorsList.addToFinal(lineaString[0], random.getPassword(lineaString[0]), type, nombreP, 
                                   lineaString[1], lineaString[4], lineaString[5]);
                           
                        break;
                       case "Estudiante":
                           String nombreS = lineaString[2]+" "+lineaString[3];
                           StudentTableModel.studentsList.addToFinal(lineaString[0], Integer.valueOf(lineaString[6]), random.getPassword(lineaString[0]), type, nombreS, 
                                   lineaString[1], lineaString[4], lineaString[5]);                
                        break;
                       case "Curso":
                           try{
                               if(ProfessorTableModel.professorsList.serchByCarnet(lineaString[3])){
                                   getGrade(lineaString);
                                   if(!getProfessorByCarnet(lineaString[3]).getSemester().serchSemester(LoginWindow.listaSemestres.getSemesterByName(lineaString[2]))){
                                    SimplyLinkedListAssigned listaCurso = new SimplyLinkedListAssigned();
                                    Grade GradeNe = GradeTableModel.gradesList.getGradeByNumber(Integer.valueOf(lineaString[0]));
                                    SimpleLinkedListCurrentGrade lista = new SimpleLinkedListCurrentGrade();
                                    lista.addToFinal(GradeNe, listaCurso);
                                    getProfessorByCarnet(lineaString[3]).getSemester().addToFinal(LoginWindow.listaSemestres.getSemesterByName(lineaString[2]), lista);
                                    }else{
                                        getProfessorByCarnet(lineaString[3]).getSemester().getListaCursos(LoginWindow.listaSemestres.getSemesterByName(lineaString[2])).addToFinal(
                                                getProfessorByCarnet(lineaString[3]).getSemester().getListaCursos(LoginWindow.listaSemestres.getSemesterByName(lineaString[2])).getGradeAt(getProfessorByCarnet(
                                                        lineaString[3]).getSemester().getListaCursos(LoginWindow.listaSemestres.getSemesterByName(lineaString[2])).listSize()-1),
                                                getProfessorByCarnet(lineaString[3]).getSemester().getListaCursos(LoginWindow.listaSemestres.getSemesterByName(lineaString[2])).getClass(getProfessorByCarnet(lineaString[3]).getCarnet()));
                                     }
                            }
                           
                           }catch(Exception e){ } 
                        break;
                   }       
                }    
            }                 
        fReader.close();
    }
    
    public Professor getProfessorByCarnet(String carnet){
        if(ProfessorTableModel.professorsList.serchByCarnet(carnet)){
            return ProfessorTableModel.professorsList.getProfessorByCarnet(carnet);
        }else{
            return null;
        }
    }
    
    public void getGrade(String[] lista){
        if(LoginWindow.listaSemestres.getSemesterByName(lista[2])==null){
            LoginWindow.listaSemestres.addToFinal(lista[2]);
        }
        SimplyLinkedListGrade listPreRequisite = new SimplyLinkedListGrade();
        for(int x = 8; x<=lista.length-1;x++){
            Grade claseActual = getGradeByNumber(lista[x]);
            listPreRequisite.addToFinal(claseActual.getSemester(),claseActual.getNoGrade(), claseActual.getName(), claseActual.getProfessor(), claseActual.getCredits(), claseActual.getSection()
                    , claseActual.getLaboratory(), claseActual.getPreRequisite(), claseActual.getPostRequisite());
        }
        
        GradeTableModel.gradesList.addToFinal(LoginWindow.listaSemestres.getSemesterByName(lista[2]),Integer.valueOf(lista[0]), lista[1], 
                                           getProfessorByCarnet(lista[3]), Integer.valueOf(lista[4]), getLab(lista[5]), lista[6],
                                   listPreRequisite, getGradeByNumber(lista[lista.length-1])); 
    
    }
    
    public String getLab(String lab){
        switch(lab){
            case "S":
                return "Con Laboratorio";
            case "N":
                return "Sin Laboratorio";
        }
        return null;
    }
    
    public Grade getGradeByNumber(String noGrade){
        try{
            return GradeTableModel.gradesList.getGradeByNumber(Integer.valueOf(noGrade));
        }catch(Exception e){
        
        }
        return null;
    }
    
}
