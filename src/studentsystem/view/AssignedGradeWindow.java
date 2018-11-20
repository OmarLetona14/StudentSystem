/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsystem.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import studentsystem.model.CurrentGradeStudentTableModel;
import studentsystem.model.CurrentGradeTableModel;
import studentsystem.model.Grade;
import studentsystem.model.GradeTableModel;
import studentsystem.model.Semester;
import static studentsystem.view.AssignGradeWindow.currentGrade;

/**
 *
 * @author Omar
 */
public class AssignedGradeWindow extends javax.swing.JFrame {
    
    public static Grade currentGrade;
    public static Semester currentSemester;
    Semester semester=null;
    Grade editG = null;
    boolean notSelected = true;
    int selected;
    
    /**
     * Creates new form AssignGradeWindow
     */
    public AssignedGradeWindow() {
        try {
            initComponents();
            this.setLocationRelativeTo(null);
            this.setResizable(false);
           

            CurrentGradeStudentTableModel model = new CurrentGradeStudentTableModel();
            AssignedTable.setModel(model);
            for(int i=1; i<LoginWindow.listaSemestres.listSize();i++){
                try {
                    semester = LoginWindow.currentStudent.getSemester().getStudentSemesterAt(i).getSemester();
                } catch (Exception ex) {
                    Logger.getLogger(GradeAdministrationWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                semesterCb.addItem(String.valueOf(semester.getSemesterName()));
            }
            userLabel.setText(LoginWindow.currentStudent.getName());
            
            ImageIcon backgroundLogoimg = new ImageIcon(getClass().getResource("../systemimages/logo.png"));
            Icon backgroundLogoicn = new ImageIcon(backgroundLogoimg.getImage().getScaledInstance(LogoImageLbl.getWidth(),
                    LogoImageLbl.getHeight(), Image.SCALE_DEFAULT));
            LogoImageLbl.setIcon(backgroundLogoicn);
            ImageIcon backgroundUserimg = new ImageIcon(getClass().getResource("../systemimages/login.jpeg"));
            Icon backgroundUsericn = new ImageIcon(backgroundUserimg.getImage().getScaledInstance(userImageLbl.getWidth(),
                    userImageLbl.getHeight(), Image.SCALE_DEFAULT));
            userImageLbl.setIcon(backgroundUsericn);
            this.repaint();
            
            semesterCb.addActionListener((ActionEvent e) -> {
                try {
                    currentSemester = getSemester();
                    
                } catch (Exception ex) {
                    Logger.getLogger(AssignedGradeWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
                AssignedGradeWindow c = new AssignedGradeWindow();
                c.setVisible(true);
            });
        } catch (Exception ex) {
            Logger.getLogger(AssignedGradeWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        AssignedTable.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                
                notSelected = false;
                int fila = AssignedTable.rowAtPoint(e.getPoint());
                selected = fila;
                try {
                    editG = LoginWindow.currentStudent.getSemester().getCurrentGradeList(currentSemester).getGradeAt(fila+1);
                    
                } catch (Exception ex) {
                    Logger.getLogger(ProfessorAdministrationWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
    
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
    
    
    public Semester getSemester() throws Exception{
        return LoginWindow.listaSemestres.getSemesterByName((String)semesterCb.getSelectedItem());
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogoImageLbl = new javax.swing.JLabel();
        userImageLbl = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        semesterCb = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AssignedTable = new javax.swing.JTable();
        desassignBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LogoImageLbl.setBackground(new java.awt.Color(0, 0, 0));
        LogoImageLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentsystem/systemimages/logo.png"))); // NOI18N

        backButton.setText("Atrás");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        semesterCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        jLabel3.setText("Semestre");

        AssignedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(AssignedTable);

        desassignBtn.setText("Desasignar");
        desassignBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desassignBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LogoImageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userImageLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(userLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(semesterCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(desassignBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 65, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LogoImageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userImageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(semesterCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(desassignBtn)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
       this.dispose();
       StudentWindow s = new StudentWindow();
       s.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void desassignBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desassignBtnActionPerformed
       try{
           if(LoginWindow.currentStudent.getSemester().getCurrentGradeList(editG.getSemester()).getClassByGrade(editG.getNoGrade()).getAssignedByCarnet(
           LoginWindow.currentStudent.getCarnet()).getNote()==0){
               LoginWindow.currentStudent.getSemester().getCurrentGradeList(editG.getSemester()).getClassByGrade(editG.getNoGrade()).unassing(LoginWindow.currentStudent.getCarnet());
               LoginWindow.currentStudent.getSemester().getCurrentGradeList(editG.getSemester()).unassingGrade(editG.getNoGrade()); 
                editG.getProfessor().getSemester().getListaCursos(editG.getSemester()).getClassByGrade(editG.getNoGrade()).unassing(LoginWindow.currentStudent.getCarnet());
            JOptionPane.showMessageDialog(this, "Curso desasignado correctamente", "Notas",
                JOptionPane.INFORMATION_MESSAGE);
           }else{
               JOptionPane.showMessageDialog(this, "No se puede desasignar por que ya se subio su nota", "Error",
                    JOptionPane.ERROR_MESSAGE);
           }
           
       }catch(Exception e){
           JOptionPane.showMessageDialog(this, "Ocurrio un error en la desasignacion", "Error",
                    JOptionPane.ERROR_MESSAGE);
       }
        
    }//GEN-LAST:event_desassignBtnActionPerformed

    
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
            java.util.logging.Logger.getLogger(AssignedGradeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssignedGradeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssignedGradeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssignedGradeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AssignedGradeWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AssignedTable;
    private javax.swing.JLabel LogoImageLbl;
    private javax.swing.JButton backButton;
    private javax.swing.JButton desassignBtn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> semesterCb;
    private javax.swing.JLabel userImageLbl;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}