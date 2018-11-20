/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import studentsystem.view.AssignGradeWindow;
import studentsystem.view.AssignedGradeWindow;
import studentsystem.view.LoginWindow;

/**
 *
 * @author Omar
 */
public class CurrentGradeStudentTableModel extends AbstractTableModel {
    
    private final String[] columnNames = new String[]{
        "No", "Curso", "Catedratico", "Laboratorio",  "Creditos"
    };
    
    private final Class[] columnClass = new Class[] {
        Integer.class, String.class, String.class, String.class, Integer.class
    };
    
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
    @Override
    public int getRowCount()
    {
        if(AssignedGradeWindow.currentSemester!=null){
             return LoginWindow.currentStudent.getSemester().getCurrentGradeList(AssignedGradeWindow.currentSemester).listSize();
        }
      return 0;  
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        CurrentGrade row = null;
        try {
            if((rowIndex+1)!=getRowCount()){
                row = LoginWindow.currentStudent.getSemester().getCurrentGradeList(AssignedGradeWindow.currentSemester).getCurrentGradeAt(rowIndex+1);
            } 
        } catch (Exception ex) {
            Logger.getLogger(ProfessorTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }if(row!=null){
            if(0 == columnIndex) {
            return row.getGrade().getNoGrade();
            }
            else if(1 == columnIndex) {
                return row.getGrade().getName();
            }
            else if(2 == columnIndex) {
                return row.getGrade().getProfessor().getCarnet();
            }
            else if(3 == columnIndex) {
                return row.getGrade().getLaboratory();
            }
            else if(4 == columnIndex) {
                return row.getGrade().getCredits();
            }
        }
        
        return null;
    }
    @Override
   public void setValueAt(Object aValue, int rowIndex, int columnIndex)
   {    
       CurrentGrade instance = (CurrentGrade)aValue;
       CurrentGrade row = null;
        try {
            row = LoginWindow.currentStudent.getSemester().getCurrentGradeList(AssignedGradeWindow.currentSemester).getCurrentGradeAt(rowIndex-1);
        } catch (Exception ex) {
            Logger.getLogger(ProfessorTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
       if(0 == columnIndex) {
           row.getGrade().setNoGrade((Integer)instance.getGrade().getNoGrade());
       }
       else if(1 == columnIndex) {
           row.getGrade().setName((String) instance.getGrade().getName());
       }
       else if(2 == columnIndex) {
           row.getGrade().getProfessor().setCarnet((String) instance.getGrade().getProfessor().getCarnet());
       }
       else if(3 == columnIndex) {
            row.getGrade().setLaboratory((String)instance.getGrade().getLaboratory());
        }
       else if(4 == columnIndex) {
            row.getGrade().setCredits((Integer)instance.getGrade().getCredits());
        }
   }
   
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }
    
}
