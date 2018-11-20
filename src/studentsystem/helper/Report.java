/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.helper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import studentsystem.model.Grade;
import studentsystem.model.Professor;
import studentsystem.model.ProfessorTableModel;
import studentsystem.model.Semester;
import studentsystem.model.Student;
import studentsystem.view.LoginWindow;

/**
 *
 * @author Omar
 */
public class Report {
    
    FileWriter filewriter = null;
    PrintWriter printw = null;
    
    
    
    public void report1(Grade grade) throws IOException, Exception{
        filewriter = new FileWriter("C:\\Users\\Omar\\Desktop\\StudentSystem\\reports\\" +"Listado de "+grade.getName()+".html");
        printw = new PrintWriter(filewriter);
        
        printw.println("<html>");
        printw.println("<head><title>Listado de "+grade.getName()+"</title></head>");
        printw.println("<body>");
        
        for(int i=0;i<grade.getProfessor().getSemester().getListaCursos(grade.getSemester()).getClass(
                    grade.getProfessor().getCarnet()).listSize();i++){
            try {
                 printw.println("<center><h1><font color=\"navy\">"+grade.getProfessor().getSemester().getListaCursos(grade.getSemester()).getClass(
                        grade.getProfessor().getCarnet()).getAssignedAt(i).getStudent().getName()+"</font></h1></center>");
            } catch (Exception ex) {
                Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        printw.println("</body>");
        printw.println("</html>");
        printw.close();
    }
    
    
    public void report2(Student student, Semester semester) throws IOException{
        filewriter = new FileWriter("C:\\Users\\Omar\\Desktop\\StudentSystem\\reports\\" +"Listado de cursos de "+student.getName()+" en el semestre "
                +semester.getSemesterName()+".html");
        printw = new PrintWriter(filewriter);
        
        printw.println("<html>");
        printw.println("<head><title>Listado de cursos de "+student.getName()+"</title></head>");
        printw.println("<body>");
        
        for(int i=0;i<student.getSemester().getCurrentGradeList(semester).listSize();i++){
            try {
                 printw.println("<center><h4><font color=\"navy\">"+student.getSemester().getCurrentGradeList(semester).getCurrentGradeAt(i).getGrade().getName()
                         +"</font></h4></center>");
            } catch (Exception ex) {
                Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        printw.println("</body>");
        printw.println("</html>");
        printw.close();
    
    }
    
    public void report3(Student student) throws Exception{
        try {
            filewriter = new FileWriter("C:\\Users\\Omar\\Desktop\\StudentSystem\\reports\\" +"Listado de cursos aprobados de "
                    +student.getName()+".html");
            printw = new PrintWriter(filewriter);
            
            printw.println("<html>");
            printw.println("<head><title>Listado de cursos aprobados de  de "+student.getName()+"</title></head>");
            printw.println("<body>");
            for(int y=1; y<student.getSemester().listSize();y++){
                for(int i=1;i<student.getSemester().getCurrentGradeList(student.getSemester().getStudentSemesterAt(y).getSemester()).listSize();i++){
                try {
                     printw.println("<center><h4><font color=\"navy\">"+student.getSemester().getCurrentGradeList(student.getSemester().getStudentSemesterAt(y).getSemester()).getGradeApproved(
                            student.getCarnet(), i).getName() +"</font></h4></center>");
                    } catch (Exception ex) {
                        Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            printw.println("</body>");
            printw.println("</html>");
            printw.close();
        } catch (IOException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void report4(Grade grade, Semester semester) throws IOException, Exception{
        int[] notas = new int[100];
         filewriter = new FileWriter("C:\\Users\\Omar\\Desktop\\StudentSystem\\reports\\" +"Top 3 mejores estudiantes del curso"+grade.getName()+" en el "+
                semester.getSemesterName()+".html");
        printw = new PrintWriter(filewriter);
        
        printw.println("<html>");
        printw.println("<head><title>Top 3 mejores estudiantes del curso"+grade.getName()+" en el "+
                semester.getSemesterName()+"</title></head>");
        printw.println("<body>");
        
        for(int i=1;i<grade.getProfessor().getSemester().getListaCursos(semester).getClassByGrade(grade.getNoGrade()).listSize();i++){
            notas[i-1]=grade.getProfessor().getSemester().getListaCursos(semester).getClassByGrade(grade.getNoGrade()).getAssignedAt(i).getNote();
        }
        try {
            int[] ordenado =burbuja(notas);
            for(int p=0;p<3;p++){
                for(int i=1;i<grade.getProfessor().getSemester().getListaCursos(semester).getClassByGrade(grade.getNoGrade()).listSize();i++){
                    if(ordenado[p]==grade.getProfessor().getSemester().getListaCursos(semester).getClassByGrade(grade.getNoGrade()).getAssignedAt(i).getNote()){
                        String nombre =grade.getProfessor().getSemester().getListaCursos(semester).getClassByGrade(
                            grade.getNoGrade()).getAssignedAt(i).getStudent().getName();
                        int nota =grade.getProfessor().getSemester().getListaCursos(semester).getClassByGrade(grade.getNoGrade()).getAssignedAt(i).getNote();
                        printw.println("<center><h4><font color=\"navy\">Estudiante: "+nombre +" Nota: "+nota+"</font></h4></center>");
                        }
                    }
                }   
            } catch (Exception ex) {
                Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
            } 
          
        printw.println("</body>");
        printw.println("</html>");
        printw.close();
    }
    
    public void report5(Semester semester) throws Exception{
        try {
            filewriter = new FileWriter("C:\\Users\\Omar\\Desktop\\StudentSystem\\reports\\" +"Listado de cursos del semestre "+semester.getSemesterName()+".html");
            printw = new PrintWriter(filewriter);
            printw.println("<html>");
            printw.println("<head><title>Listado de cursos del "+semester.getSemesterName()+"</title></head>");
            printw.println("<body>");
            for(int i =0 ;i<ProfessorTableModel.professorsList.listSize();i++){
                if(ProfessorTableModel.professorsList.getProfessorAt(i)!=null){
                    if(ProfessorTableModel.professorsList.getProfessorAt(i).getSemester().getListaCursos(semester)!=null){
                        for(int y = 1; y<ProfessorTableModel.professorsList.getProfessorAt(i).getSemester().getListaCursos(semester).getClass(
                        ProfessorTableModel.professorsList.getProfessorAt(i).getCarnet()).listSize();y++){
                            if(y==1){
                            printw.println("<center><h1><font color=\"navy\">"+ProfessorTableModel.professorsList.getProfessorAt(i).getSemester().getListaCursos(semester).getGradeAt(y).getName()
                                +"</fprintw.ont></h1></center>");
                            }                           
                            String lineOne = ProfessorTableModel.professorsList.getProfessorAt(i).getSemester().getListaCursos(semester).getClass(
                            ProfessorTableModel.professorsList.getProfessorAt(i).getCarnet()).getAssignedAt(y).getStudent().getName();
                            int lineTwo = ProfessorTableModel.professorsList.getProfessorAt(i).getSemester().getListaCursos(semester).getClass(
                            ProfessorTableModel.professorsList.getProfessorAt(i).getCarnet()).getAssignedAt(y).getNote();
                            printw.println("<center><h4><font color=\"navy\">"+ lineOne+" "+lineTwo+"</font></h4></center>");
                        } 
                    }  
                }
            }
            printw.println("</body>");
            printw.println("</html>");
            printw.close();
        } catch (IOException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void report6() throws Exception{
        try {
            int[] numeroAlumnos = new int[100];
            filewriter = new FileWriter("C:\\Users\\Omar\\Desktop\\StudentSystem\\reports\\" +"Top 5 de los cursos con más alumnos.html");
            printw = new PrintWriter(filewriter);
            printw.println("<html>");
            printw.println("<head><title>Top 5 de los cursos con más alumnos</title></head>");
            printw.println("<body>");
            for(int i = 1;i<ProfessorTableModel.professorsList.listSize();i++){
                if(ProfessorTableModel.professorsList.getProfessorAt(i)!=null){
                    if(ProfessorTableModel.professorsList.getProfessorAt(i).getSemester().getListaCursos(ProfessorTableModel.professorsList.getProfessorAt(i).getSemester().getProfessorSemesterAt(i).getSemester())!=null){
                        numeroAlumnos[i-1]= ProfessorTableModel.professorsList.getProfessorAt(i).getSemester().getListaCursos(ProfessorTableModel.professorsList.getProfessorAt(i).getSemester().getProfessorSemesterAt(i).getSemester()).getClass(
                        ProfessorTableModel.professorsList.getProfessorAt(i).getCarnet()).listSize();
                    }  
                }
            }
            int [] ordenado = burbuja(numeroAlumnos);
                for(int y =0; y<5;y++){
                    for(int i = 1;i<ProfessorTableModel.professorsList.listSize();i++){
                    if(ProfessorTableModel.professorsList.getProfessorAt(i)!=null){
                        if(ProfessorTableModel.professorsList.getProfessorAt(i).getSemester().getListaCursos(ProfessorTableModel.professorsList.getProfessorAt(i).getSemester().getProfessorSemesterAt(i).getSemester())!=null){
                             if(ProfessorTableModel.professorsList.getProfessorAt(i).getSemester().getListaCursos(ProfessorTableModel.professorsList.getProfessorAt(i).getSemester().getProfessorSemesterAt(i).getSemester()).getClass(
                                ProfessorTableModel.professorsList.getProfessorAt(i).getCarnet()).listSize()==ordenado[y]){
                                 String curso=ProfessorTableModel.professorsList.getProfessorAt(i).getSemester().getListaCursos(ProfessorTableModel.professorsList.getProfessorAt(i).getSemester().getProfessorSemesterAt(i).getSemester()).getGradeAt(i).getName();
                                 printw.println("<center><h1><font color=\"navy\">"+curso+"</fprintw.ont></h1></center>");
                            }   
                        }  
                    }
                }
            }
            printw.println("</body>");
            printw.println("</html>");
            printw.close();
        } catch (IOException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void report7(Semester semester) throws Exception{
        try {
            int count = 0;
            filewriter = new FileWriter("C:\\Users\\Omar\\Desktop\\StudentSystem\\reports\\" +"Cantidad de alumnos asignados al "+semester.getSemesterName()+".html");
            printw = new PrintWriter(filewriter);
            printw.println("<html>");
            printw.println("<head><title>Listado de cursos del "+semester.getSemesterName()+"</title></head>");
            printw.println("<body>");
            for(int i =0 ;i<ProfessorTableModel.professorsList.listSize();i++){
                if(ProfessorTableModel.professorsList.getProfessorAt(i)!=null){
                    if(ProfessorTableModel.professorsList.getProfessorAt(i).getSemester().getListaCursos(semester)!=null){                        
                        count += (ProfessorTableModel.professorsList.getProfessorAt(i).getSemester().getListaCursos(semester).getClass(
                        ProfessorTableModel.professorsList.getProfessorAt(i).getCarnet()).listSize())-1;
                    }
                }
            }
            printw.println("<center><h4><font color=\"navy\">Cantidad de alumnos asignados "+count+"</font></h4></center>"); 
            printw.println("</body>");
            printw.println("</html>");
            printw.close();
        } catch (IOException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void reporte8(Professor professor) throws Exception{
        try {
            int count = 0;
            filewriter = new FileWriter("C:\\Users\\Omar\\Desktop\\StudentSystem\\reports\\" +"Cursos que imparte "+professor.getName()+".html");
            printw = new PrintWriter(filewriter);
            printw.println("<html>");
            printw.println("<head><title>Cursos que imparte el professor "+professor.getName()+"</title></head>");
            printw.println("<body>");
            printw.println("<center><h1><font color=\"navy\">Catedratico: "+professor.getName()+"</font></h1></center>");
            for(int i=1;i<professor.getSemester().listSize();i++){
                for(int y=1;y<professor.getSemester().getListaCursos(professor.getSemester().getProfessorSemesterAt(i).getSemester()).listSize();y++){
                    printw.println("<center><h4><font color=\"navy\">"+professor.getSemester().getListaCursos(professor.getSemester().getProfessorSemesterAt(i).getSemester()).getGradeAt(y).getName()
                       +"</font></h4></center>");
                }
            } 
            printw.println("</body>");
            printw.println("</html>");
            printw.close();
        } catch (IOException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void reporte9(Student student, Semester semester) throws IOException{
        double promedio = 0;
        filewriter = new FileWriter("C:\\Users\\Omar\\Desktop\\StudentSystem\\reports\\" +"Promedio del estudiante "+student.getName()+" en el semestre "
                +semester.getSemesterName()+".html");
        printw = new PrintWriter(filewriter);
        int count = 0;
        printw.println("<html>");
        printw.println("<head><title>Promedio del estudiante "+student.getName()+"</title></head>");
        printw.println("<body>");
        
        for(int i=1;i<student.getSemester().getCurrentGradeList(semester).listSize();i++){
            try {
                for(int y=1;y<student.getSemester().getCurrentGradeList(semester).getCurrentGradeAt(i).getAssignedList().listSize();y++){
                    promedio +=student.getSemester().getCurrentGradeList(semester).getCurrentGradeAt(i).getAssignedList().getAssignedAt(y).getNote();
                    count++;
                }     
            } catch (Exception ex) {
                Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        printw.println("<center><h4><font color=\"navy\"> Promedio: "+(promedio/count)+"</font></h4></center>");
        printw.println("</body>");
        printw.println("</html>");
        printw.close();
    }
    public void reporte10(Student student) throws IOException, Exception{
        double promedio = 0;
        filewriter = new FileWriter("C:\\Users\\Omar\\Desktop\\StudentSystem\\reports\\" +"Promedio del estudiante "+student.getName()+".html");
        printw = new PrintWriter(filewriter);
        int count = 0;
        printw.println("<html>");
        printw.println("<head><title>Promedio del estudiante "+student.getName()+"</title></head>");
        printw.println("<body>");
        
        for(int i=1;i<student.getSemester().getCurrentGradeList(student.getSemester().getStudentSemesterAt(i).getSemester()).listSize();i++){
            try {
                for(int y=1;y<student.getSemester().getCurrentGradeList(student.getSemester().getStudentSemesterAt(i).getSemester()).getCurrentGradeAt(i).getAssignedList().listSize();y++){
                    promedio +=student.getSemester().getCurrentGradeList(student.getSemester().getStudentSemesterAt(i).getSemester()).getCurrentGradeAt(i).getAssignedList().getAssignedAt(y).getNote();
                    count++;
                }     
            } catch (Exception ex) {
                Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        printw.println("<center><h4><font color=\"navy\"> Promedio: "+(promedio/count)+"</font></h4></center>");
        printw.println("</body>");
        printw.println("</html>");
        printw.close();
    }
    
     public static int[] burbuja(int arreglo[]){
        for(int i = 0; i < arreglo.length - 1; i++){
            for(int j = 0; j < arreglo.length - 1; j++){
                if (arreglo[j] < arreglo[j + 1]){
                    int tmp = arreglo[j+1];
                    arreglo[j+1] = arreglo[j];
                    arreglo[j] = tmp;
                }
            }
        }
        return arreglo;
    }
    
}
