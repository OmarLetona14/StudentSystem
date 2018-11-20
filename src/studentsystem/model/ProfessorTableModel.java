/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import studentsystem.list.SimplyLinkedListProfessor;
import studentsystem.list.SimplyLinkedListProfessorSemester;

/**
 *
 * @author Omar
 */
public class ProfessorTableModel extends AbstractTableModel {
    public static SimplyLinkedListProfessor professorsList = new SimplyLinkedListProfessor();
    public static SimplyLinkedListProfessorSemester semester = new SimplyLinkedListProfessorSemester();
    private final String[] columnNames = new String[]{
        "ID","Carnet", "Contraseña", "Rol", "Nombre", "CUI", "Email", "Direccion"
    };
    
    private final Class[] columnClass = new Class[] {
        Integer.class, String.class, String.class, String.class, String.class, Integer.class,
        String.class, String.class
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
        return professorsList.listSize();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Professor row = null;
        try {
            if((rowIndex+1)!=getRowCount()){
                row = professorsList.getProfessorAt(rowIndex+1);
            } 
        } catch (Exception ex) {
            Logger.getLogger(ProfessorTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }if(row!=null){
            if(0 == columnIndex) {
            return row.getIdProfessor();
            }
            else if(1 == columnIndex) {
                return row.getCarnet();
            }
            else if(2 == columnIndex) {
                return row.getPassword();
            }
            else if(3 == columnIndex) {
                return row.getRole();
            }
            else if(4 == columnIndex) {
                return row.getName();
            }
            else if(5 == columnIndex) {
                return row.getCUI();
            }
            else if(6 == columnIndex) {
                return row.getAddress();
            }
            else if(7 == columnIndex) {
                return row.getEmail();
            }
        }
        
        return null;
    }
    @Override
   public void setValueAt(Object aValue, int rowIndex, int columnIndex)
   {    
       Professor instance = (Professor)aValue;
       Professor row = null;
        try {
            row = professorsList.getProfessorAt(rowIndex-1);
        } catch (Exception ex) {
            Logger.getLogger(ProfessorTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
       if(0 == columnIndex) {
           row.setIdProfessor((Integer) instance.getIdProfessor());
       }
       else if(1 == columnIndex) {
           row.setCarnet((String) instance.getCarnet());
       }
       else if(2 == columnIndex) {
           row.setPassword((String) instance.getPassword());
       }
       else if(3 == columnIndex) {
           row.setRole((String) instance.getRole());
       }
       else if(4 == columnIndex) {
           row.setName((String) instance.getName());
       }
       else if(5 == columnIndex) {
           row.setCUI((String) instance.getCUI());
       }
       else if(6 == columnIndex) {
           row.setEmail((String) instance.getEmail());
       }
       else if(7 == columnIndex) {
           row.setAddress((String) instance.getAddress());
       }
   }
   
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }
    
}
