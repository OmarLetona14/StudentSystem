/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import studentsystem.list.SimplyLinkedListGrade;

/**
 *
 * @author Omar
 */
public class GradeTableModel extends AbstractTableModel {
    public static SimplyLinkedListGrade gradesList = new SimplyLinkedListGrade();
    private final String[] columnNames = new String[]{
        "ID","Numero de curso", "Nombre", "Profesor", "Seccion", "Creditos", "Laboratorio", "Pre Requisito", "Post Requisito"
    };
    
    private final Class[] columnClass = new Class[] {
        Integer.class, Integer.class, String.class, String.class, String.class, Integer.class, String.class, String.class,
        String.class
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
        return gradesList.listSize();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Grade row = null;
        try {
            if((rowIndex+1)!=getRowCount()){
                row = gradesList.getGradeAt(rowIndex+1);
            } 
        } catch (Exception ex) {
            Logger.getLogger(ProfessorTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }if(row!=null){
            if(0 == columnIndex) {
            return row.getIdGrade();
            }
            else if(1 == columnIndex) {
                return row.getNoGrade();
            }
            else if(2 == columnIndex) {
                return row.getName();
            }
            else if(3 == columnIndex) {
                return row.getProfessor().getName();
            }
            else if(4 == columnIndex) {
                return row.getSection();
            }
            else if(5 == columnIndex) {
                return row.getCredits();
            }
            else if(6 == columnIndex) {
                return row.getLaboratory();
            }
            else if(7 == columnIndex) {
                if(row.getPreRequisite()!=null){
                    try {
                        return row.getPreRequisite().getGradeAt(rowIndex);
                    } catch (Exception ex) {
                        Logger.getLogger(GradeTableModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    return "Sin Pre Requisito";
                }
            }
            else if(8 == columnIndex) {
                if(row.getPostRequisite()!= null){
                    return row.getPostRequisite().getName();
                }else{
                    return "Sin Post Requisito";
                }
            } 
        }
        
        return null;
    }
    @Override
   public void setValueAt(Object aValue, int rowIndex, int columnIndex)
   {    
       Grade instance = (Grade)aValue;
       Grade row = null;
        try {
            row = gradesList.getGradeAt(rowIndex-1);
        } catch (Exception ex) {
            Logger.getLogger(ProfessorTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
       if(0 == columnIndex) {
           row.setIdGrade((Integer) instance.getIdGrade());
       }
       else if(1 == columnIndex) {
           row.setNoGrade((Integer) instance.getIdGrade());
       }
       else if(2 == columnIndex) {
           row.setName((String) instance.getName());
       }
       else if(3 == columnIndex) {
           row.getProfessor().setName((String) instance.getProfessor().getName());
       }
       else if(4 == columnIndex) {
           row.setSection((String) instance.getSection());
       }
       else if(5 == columnIndex) {
           row.setCredits((Integer) instance.getCredits());
       }
       else if(6 == columnIndex) {
           row.setLaboratory((String) instance.getLaboratory());
       }
       else if(7 == columnIndex) {
           try {
               row.getPreRequisite().getGradeAt(rowIndex).setName((String) instance.getName());
           } catch (Exception ex) {
               Logger.getLogger(GradeTableModel.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       else if(8 == columnIndex) {
           row.getPostRequisite().setName((String) instance.getPostRequisite().getName());
       }
   }
   
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }
    
    
}
