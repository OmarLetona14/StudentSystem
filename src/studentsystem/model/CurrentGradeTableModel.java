/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import studentsystem.list.SimpleLinkedListCurrentGrade;
import studentsystem.view.LoginWindow;
import studentsystem.view.ProfessorWindow;

/**
 *
 * @author Omar
 */
public class CurrentGradeTableModel extends AbstractTableModel {
    
    public static SimpleLinkedListCurrentGrade currentGradeList = new SimpleLinkedListCurrentGrade();
    private final String[] columnNames = new String[]{
        "Carnet", "Nombre", "Nota"
    };
    
    private final Class[] columnClass = new Class[] {
        String.class, String.class, Integer.class
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
        if(ProfessorWindow.currSemester!=null){
            return LoginWindow.currentProfessor.getSemester().getListaCursos(ProfessorWindow.currSemester).getClass(
                        LoginWindow.currentProfessor.getCarnet()).listSize();
        }
        return 0;  
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Assigned row = null;
        try {
            if(ProfessorWindow.currentGrade!=null){
                row =   LoginWindow.currentProfessor.getSemester().getListaCursos(ProfessorWindow.currSemester).getClass(
                        LoginWindow.currentProfessor.getCarnet()).getAssignedAt(rowIndex+1);
            } 
        } catch (Exception ex) {
            Logger.getLogger(ProfessorTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }if(row!=null){
            if(0 == columnIndex) {
            return row.getStudent().getCarnet();
            }
            else if(1 == columnIndex) {
                return row.getStudent().getName();
            }
            else if(2 == columnIndex) {
                return row.getNote();
            }
            
        }
        return null;
    }
    @Override
   public void setValueAt(Object aValue, int rowIndex, int columnIndex)
   {    
       Assigned instance = (Assigned)aValue;
       Assigned row = null;
        try {
            row = currentGradeList.getAssignedByGradeProfessor(rowIndex-1, LoginWindow.currentProfessor.getCarnet(),
                        ProfessorWindow.currentGrade.getNoGrade());
        } catch (Exception ex) {
            Logger.getLogger(ProfessorTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
       if(0 == columnIndex) {
           row.getStudent().setCarnet((String) instance.getStudent().getCarnet());
       }
       else if(1 == columnIndex) {
           row.getStudent().setName((String) instance.getStudent().getName());
       }
       else if(2 == columnIndex) {
           row.setNote((Integer) instance.getNote());
       }
   }
   
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }
    
    
}
