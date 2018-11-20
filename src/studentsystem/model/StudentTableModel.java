/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import studentsystem.list.DoubleLinkedCircularListStudent;

/**
 *
 * @author Omar
 */
public class StudentTableModel extends AbstractTableModel{
    
     public static DoubleLinkedCircularListStudent studentsList = new DoubleLinkedCircularListStudent();
    private final String[] columnNames = new String[]{
        "ID","Creditos","Carnet", "Contraseña", "Rol", "Nombre", "CUI", "Email", "Direccion"
    };
    
    private final Class[] columnClass = new Class[] {
        Integer.class, Integer.class, String.class, String.class, String.class, String.class, Integer.class,
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
        return studentsList.listSize();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Student row = null;
        try {
            if((rowIndex+1)!=getRowCount()){
                row = studentsList.getStudentAt(rowIndex+1);
            } 
        } catch (Exception ex) {
            Logger.getLogger(ProfessorTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }if(row!=null){
            if(0 == columnIndex) {
            return row.getIdStudent();
            }
            else if(1 == columnIndex) {
                return row.getCredits();
            }
            else if(2 == columnIndex) {
                return row.getCarnet();
            }
            else if(3 == columnIndex) {
                return row.getPassword();
            }
            else if(4 == columnIndex) {
                return row.getRole();
            }
            else if(5 == columnIndex) {
                return row.getName();
            }
            else if(6 == columnIndex) {
                return row.getCUI();
            }
            else if(7 == columnIndex) {
                return row.getEmail();
            }
            else if(8 == columnIndex) {
                return row.getAddress();
            }
        }
        
        return null;
    }
    @Override
   public void setValueAt(Object aValue, int rowIndex, int columnIndex)
   {    
       Student instance = (Student)aValue;
       Student row = null;
        try {
            row = studentsList.getStudentAt(rowIndex-1);
        } catch (Exception ex) {
            Logger.getLogger(ProfessorTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
       if(0 == columnIndex) {
           row.setIdStudent((Integer) instance.getIdStudent());
       }
       else if(1 == columnIndex) {
           row.setCredits((Integer) instance.getCredits());
       }
       else if(2 == columnIndex) {
           row.setCarnet((String) instance.getCarnet());
       }
       else if(3 == columnIndex) {
           row.setPassword((String) instance.getPassword());
       }
       else if(4 == columnIndex) {
           row.setRole((String) instance.getRole());
       }
       else if(5 == columnIndex) {
           row.setName((String) instance.getName());
       }
       else if(6 == columnIndex) {
           row.setCUI((String) instance.getCUI());
       }
       else if(7 == columnIndex) {
           row.setEmail((String) instance.getEmail());
       }
       else if(8 == columnIndex) {
           row.setAddress((String) instance.getAddress());
       }
   }
   
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }
    
}
