/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import studentsystem.helper.Achive;
import studentsystem.helper.RandomNumber;
import studentsystem.list.SimpleLinkedListCurrentGrade;
import studentsystem.list.SimplyLinkedListProfessor;
import studentsystem.model.Professor;
import studentsystem.model.ProfessorTableModel;
import studentsystem.model.Semester;

/**
 *
 * @author Omar
 */
public class ProfessorAdministrationWindow extends javax.swing.JFrame {
    
    ProfessorTableModel model = new ProfessorTableModel();
    SimpleLinkedListCurrentGrade assignedGradesList = new SimpleLinkedListCurrentGrade();
    boolean notSelected = true;
    int selected;
    Achive archive = new Achive();
    RandomNumber numeroRandom = new RandomNumber();
    /**
     * Creates new form StudentAdministrationWindow
     */
    public ProfessorAdministrationWindow() {
        initComponents();
        editBtn.setEnabled(false);
        this.setLocationRelativeTo(null);
        ProfessorTable.setModel(model);
        this.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
               carneTxt.setText("");;
                nameTxt.setText("");
                cuiTxt.setText("");
                emailTxt.setText("");
                addressTxt.setText("");
                addBtn.setEnabled(true);
                editBtn.setEnabled(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
               
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        ProfessorTable.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                editBtn.setEnabled(true);
                Professor editp = null;
                notSelected = false;
                int fila = ProfessorTable.rowAtPoint(e.getPoint());
                selected = fila;
                try {
                    editp = ProfessorTableModel.professorsList.getProfessorAt(fila+1);
                } catch (Exception ex) {
                    Logger.getLogger(ProfessorAdministrationWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                addBtn.setEnabled(false);
                carneTxt.setText(editp.getCarnet());
                nameTxt.setText(editp.getName());
                cuiTxt.setText(String.valueOf(editp.getCUI()));
                emailTxt.setText(editp.getEmail());
                addressTxt.setText(editp.getAddress());
                
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ProfessorTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        carneTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        cuiTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        addressTxt = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deletedBtn = new javax.swing.JButton();
        massiveDataLoadBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administracion de Profesores");

        ProfessorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(ProfessorTable);

        jLabel1.setText("Carnet");

        jLabel4.setText("Nombre");

        jLabel5.setText("CUI");

        jLabel6.setText("Email");

        jLabel7.setText("Direccion");

        emailTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTxtActionPerformed(evt);
            }
        });

        addBtn.setText("Agregar");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        editBtn.setText("Editar");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deletedBtn.setText("Eliminar");
        deletedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletedBtnActionPerformed(evt);
            }
        });

        massiveDataLoadBtn.setText("Carga masiva de datos");
        massiveDataLoadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                massiveDataLoadBtnActionPerformed(evt);
            }
        });

        backBtn.setText("Atrás");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(emailTxt)
                        .addComponent(addressTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                        .addComponent(cuiTxt)
                        .addComponent(carneTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(massiveDataLoadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deletedBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(284, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(carneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(addBtn)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editBtn)
                    .addComponent(jLabel4)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deletedBtn)
                    .addComponent(jLabel5)
                    .addComponent(cuiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(massiveDataLoadBtn)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(addressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(backBtn))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTxtActionPerformed
    
    
    
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        try{
            ProfessorTableModel.professorsList.addToFinal(carneTxt.getText(), numeroRandom.getPassword(carneTxt.getText()), "Catedratico",
       nameTxt.getText(), cuiTxt.getText(), emailTxt.getText(), addressTxt.getText());
            JOptionPane.showMessageDialog(this, "Catedrático agregado correctamente", "Agregado",
                    JOptionPane.INFORMATION_MESSAGE);
            ProfessorTableModel.semester.addToFinal(LoginWindow.listaSemestres.getSemesterByName("Segundo Semestre 2018"), assignedGradesList);
            this.dispose();
            ProfessorAdministrationWindow n = new ProfessorAdministrationWindow();
            n.setVisible(true);
        }catch(Exception ex){
        JOptionPane.showMessageDialog(this, "Hubo un error al agregar el catedrático, por favor inténtelo de nuevo", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
       
    }//GEN-LAST:event_addBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        try{
            ProfessorTableModel.professorsList.edit(selected+1, carneTxt.getText(), numeroRandom.getPassword(carneTxt.getText()), "Catedratico",
       nameTxt.getText(), cuiTxt.getText(), emailTxt.getText(), addressTxt.getText());
            JOptionPane.showMessageDialog(this, "Catedrático editado correctamente", "Editado",
                    JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            ProfessorAdministrationWindow n = new ProfessorAdministrationWindow();
            n.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Hubo un error al editar el catedrático, por favor inténtelo de nuevo", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deletedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletedBtnActionPerformed
       try{
           ProfessorTableModel.professorsList.delete(selected+1);
           JOptionPane.showMessageDialog(this, "Catedrático eliminado correctamente", "Editado",
                    JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            ProfessorAdministrationWindow n = new ProfessorAdministrationWindow();
            n.setVisible(true);
       }catch(Exception e){
           JOptionPane.showMessageDialog(this, "Hubo un error al eliminar el catedrático, por favor inténtelo de nuevo", "Error",
                    JOptionPane.ERROR_MESSAGE);
       }
        
    }//GEN-LAST:event_deletedBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        AdministratorWindow admin = new AdministratorWindow();
        admin.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void massiveDataLoadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_massiveDataLoadBtnActionPerformed
        try {
            archive.read("C:\\Users\\Omar\\Desktop\\StudentSystem\\src\\archive\\catedraticos.ipcb", "Catedratico");
            JOptionPane.showMessageDialog(this, "Archivos cargados correctamente", "Archivos",
                    JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            ProfessorAdministrationWindow n = new ProfessorAdministrationWindow();
            n.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(ProfessorAdministrationWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Hubo un error al cargar los datos, por favor inténtelo de nuevo", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_massiveDataLoadBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProfessorAdministrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfessorAdministrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfessorAdministrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfessorAdministrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfessorAdministrationWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ProfessorTable;
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField addressTxt;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField carneTxt;
    private javax.swing.JTextField cuiTxt;
    private javax.swing.JButton deletedBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton massiveDataLoadBtn;
    private javax.swing.JTextField nameTxt;
    // End of variables declaration//GEN-END:variables
}
