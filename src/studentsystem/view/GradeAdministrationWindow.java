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
import studentsystem.list.SimpleLinkedListCurrentGrade;
import studentsystem.list.SimplyLinkedListAssigned;
import studentsystem.list.SimplyLinkedListGrade;
import studentsystem.model.CurrentGradeTableModel;
import studentsystem.model.Grade;
import studentsystem.model.GradeTableModel;
import studentsystem.model.Professor;
import studentsystem.model.ProfessorTableModel;
import studentsystem.model.Semester;

/**
 *
 * @author Omar
 */
public class GradeAdministrationWindow extends javax.swing.JFrame {
    
    GradeTableModel model = new GradeTableModel();
    boolean notSelected = true;
    int selected;
    Achive archive = new Achive();
    SimplyLinkedListAssigned listaCurso = new SimplyLinkedListAssigned();
    /**
     * Creates new form GradeAdministrationWindow
     */
    public GradeAdministrationWindow() {
        initComponents();
        editBtn.setEnabled(false);
        this.setLocationRelativeTo(null);
        GradeTable.setModel(model);
        Professor currentProfessor = null;
        Semester currentSemester = null;
        cbPreRequisite.addItem("");
        cbPostRequisite.addItem("");
        for(int i=1; i<ProfessorTableModel.professorsList.listSize();i++){
            try {
                currentProfessor = ProfessorTableModel.professorsList.getProfessorAt(i);
            } catch (Exception ex) {
                Logger.getLogger(GradeAdministrationWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        cbProfessor.addItem(currentProfessor.getName());
        }
        for(int i=1; i<LoginWindow.listaSemestres.listSize();i++){
            try {
                currentSemester = LoginWindow.listaSemestres.getSemesterAt(i);
            } catch (Exception ex) {
                Logger.getLogger(GradeAdministrationWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        cbSemester.addItem(currentSemester.getSemesterName());
        }
        
        for(int i=0; i<GradeTableModel.gradesList.listSize();i++){
            Grade currentGrade = null;
            try {
                currentGrade = GradeTableModel.gradesList.getGradeAt(i);
            } catch (Exception ex) {
                Logger.getLogger(GradeAdministrationWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(currentGrade!=null){
                cbPreRequisite.addItem(currentGrade.getName());
            cbPostRequisite.addItem(currentGrade.getName());
            }
            
        }
        this.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                noGradeTxt.setText("");
                nameTxt.setText("");
                creditsTxt.setText("");
                sectionTxt.setText("");
                chbLaboratory.setSelected(false);
                cbPreRequisite.setSelectedItem("");
                cbPostRequisite.setSelectedItem("");
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
        GradeTable.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                editBtn.setEnabled(true);
                Grade editG = null;
                notSelected = false;
                int fila = GradeTable.rowAtPoint(e.getPoint());
                selected = fila;
                try {
                    editG = GradeTableModel.gradesList.getGradeAt(fila+1);
                } catch (Exception ex) {
                    Logger.getLogger(ProfessorAdministrationWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                addBtn.setEnabled(false);
                noGradeTxt.setText(String.valueOf(editG.getNoGrade()));
                sectionTxt.setText(editG.getSection());
                nameTxt.setText(editG.getName());
                creditsTxt.setText(String.valueOf(editG.getCredits()));
                cbProfessor.setSelectedItem(editG.getProfessor().getName());
                chbLaboratory.setSelected(false);
                
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
        GradeTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbProfessor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbPreRequisite = new javax.swing.JComboBox<>();
        cbPostRequisite = new javax.swing.JComboBox<>();
        noGradeTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        creditsTxt = new javax.swing.JTextField();
        chbLaboratory = new javax.swing.JCheckBox();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        massiveDataLoadBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        sectionTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbSemester = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GradeTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        GradeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(GradeTable);

        jLabel1.setText("Numero de curso");

        jLabel2.setText("Nombre");

        cbProfessor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        jLabel3.setText("Catedratico");

        jLabel4.setText("Creditos");

        jLabel5.setText("Laboratorio");

        jLabel6.setText("Pre Requisito");

        jLabel7.setText("Post Requisito");

        cbPreRequisite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        cbPostRequisite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));

        chbLaboratory.setText("Si/No");

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

        deleteBtn.setText("Eliminar");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        backBtn.setText("Atrás");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        massiveDataLoadBtn.setText("Carga masiva de datos");
        massiveDataLoadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                massiveDataLoadBtnActionPerformed(evt);
            }
        });

        jLabel8.setText("Sección");

        jLabel9.setText("Semestre");

        cbSemester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTxt)
                            .addComponent(noGradeTxt)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(59, 59, 59))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(43, 43, 43)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(44, 44, 44)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chbLaboratory)
                            .addComponent(cbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(creditsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbPreRequisite, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbPostRequisite, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(sectionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(massiveDataLoadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(cbPreRequisite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noGradeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addBtn))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(cbPostRequisite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editBtn))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(deleteBtn)
                                    .addComponent(sectionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))))
                        .addGap(9, 9, 9))
                    .addComponent(creditsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(chbLaboratory)
                            .addComponent(jLabel9)
                            .addComponent(cbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(massiveDataLoadBtn)
                        .addGap(18, 18, 18)))
                .addComponent(backBtn)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        try {
            
            if(idPreRe()!=0 && idPostRe()!=0){
                SimplyLinkedListGrade preRequisite = new SimplyLinkedListGrade();
                        preRequisite.addToFinal(getGrade(idPreRe()).getSemester(),getGrade(idPreRe()).getNoGrade(), getGrade(idPreRe()).getName(), getGrade(idPreRe()).getProfessor(), getGrade(idPreRe()).getCredits()
                           , getGrade(idPreRe()).getSection(), getGrade(idPreRe()).getLaboratory(), getGrade(idPreRe()).getPreRequisite(), getGrade(idPreRe()).getPostRequisite());
                GradeTableModel.gradesList.addToFinal(getSemester(idSemester()),Integer.valueOf(noGradeTxt.getText()), nameTxt.getText(), getProfessor(idProf()), Integer.valueOf(creditsTxt.getText()), getLaboratory(),
                   sectionTxt.getText(),preRequisite  , getGrade(idPostRe()));
                
                if(!getProfessor(idProf()).getSemester().serchSemester(getSemester(idSemester()))){
                    Grade GradeNe = GradeTableModel.gradesList.getGradeByNumber(Integer.valueOf(noGradeTxt.getText()));
                    SimpleLinkedListCurrentGrade lista = new SimpleLinkedListCurrentGrade();
                    lista.addToFinal(GradeNe, listaCurso);
                    getProfessor(idProf()).getSemester().addToFinal(getSemester(idSemester()), lista);
                }else{
                    Grade grade = GradeTableModel.gradesList.getGradeByNumber(Integer.valueOf(noGradeTxt.getText()));
                    getProfessor(idProf()).getSemester().getListaCursos(getSemester(idSemester())).addToFinal(
                            grade, listaCurso);
                }
                
                CurrentGradeTableModel.currentGradeList.addToFinal(GradeTableModel.gradesList.getGradeAt(GradeTableModel.gradesList.listSize()-1), listaCurso);
            }else if(idPreRe()!=0){
                SimplyLinkedListGrade preRequisite = new SimplyLinkedListGrade();
                        preRequisite.addToFinal(getGrade(idPreRe()).getSemester(),getGrade(idPreRe()).getNoGrade(), getGrade(idPreRe()).getName(), getGrade(idPreRe()).getProfessor(), getGrade(idPreRe()).getCredits()
                           , getGrade(idPreRe()).getSection(), getGrade(idPreRe()).getLaboratory(), getGrade(idPreRe()).getPreRequisite(), getGrade(idPreRe()).getPostRequisite());
                GradeTableModel.gradesList.addToFinal(getSemester(idSemester()),Integer.valueOf(noGradeTxt.getText()), nameTxt.getText(), getProfessor(idProf()), Integer.valueOf(creditsTxt.getText()), getLaboratory(),
                    sectionTxt.getText(),preRequisite, null);
                if(!getProfessor(idProf()).getSemester().serchSemester(getSemester(idSemester()))){
                    Grade GradeNe = GradeTableModel.gradesList.getGradeByNumber(Integer.valueOf(noGradeTxt.getText()));
                    SimpleLinkedListCurrentGrade lista = new SimpleLinkedListCurrentGrade();
                    lista.addToFinal(GradeNe, listaCurso);
                    getProfessor(idProf()).getSemester().addToFinal(getSemester(idSemester()), lista);
                }else{
                    Grade grade = GradeTableModel.gradesList.getGradeByNumber(Integer.valueOf(noGradeTxt.getText()));
                    getProfessor(idProf()).getSemester().getListaCursos(getSemester(idSemester())).addToFinal(
                            grade, listaCurso);
                }
            }else if(idPostRe()!=0){
                GradeTableModel.gradesList.addToFinal(getSemester(idSemester()),Integer.valueOf(noGradeTxt.getText()), nameTxt.getText(), getProfessor(idProf()), Integer.valueOf(creditsTxt.getText()), getLaboratory(),
                    sectionTxt.getText(),null, getGrade(idPostRe()));
                if(!getProfessor(idProf()).getSemester().serchSemester(getSemester(idSemester()))){
                    Grade GradeNe = GradeTableModel.gradesList.getGradeByNumber(Integer.valueOf(noGradeTxt.getText()));
                    SimpleLinkedListCurrentGrade lista = new SimpleLinkedListCurrentGrade();
                    lista.addToFinal(GradeNe, listaCurso);
                    getProfessor(idProf()).getSemester().addToFinal(getSemester(idSemester()), lista);
                }else{
                    Grade grade = GradeTableModel.gradesList.getGradeByNumber(Integer.valueOf(noGradeTxt.getText()));
                    getProfessor(idProf()).getSemester().getListaCursos(getSemester(idSemester())).addToFinal(
                            grade, listaCurso);
                }
            }else{
                GradeTableModel.gradesList.addToFinal(getSemester(idSemester()),Integer.valueOf(noGradeTxt.getText()), nameTxt.getText(), getProfessor(idProf()), Integer.valueOf(creditsTxt.getText()), getLaboratory(),
                    sectionTxt.getText(),null, null);
                if(!getProfessor(idProf()).getSemester().serchSemester(getSemester(idSemester()))){
                    Grade GradeNe = GradeTableModel.gradesList.getGradeByNumber(Integer.valueOf(noGradeTxt.getText()));
                    SimpleLinkedListCurrentGrade lista = new SimpleLinkedListCurrentGrade();
                    lista.addToFinal(GradeNe, listaCurso);
                    getProfessor(idProf()).getSemester().addToFinal(getSemester(idSemester()), lista);
                }else{
                    Grade grade = GradeTableModel.gradesList.getGradeByNumber(Integer.valueOf(noGradeTxt.getText()));
                    getProfessor(idProf()).getSemester().getListaCursos(getSemester(idSemester())).addToFinal(
                            grade, listaCurso);
                }
            }
            JOptionPane.showMessageDialog(this, "Curso agregado correctamente", "Agregado",
                    JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            GradeAdministrationWindow n = new GradeAdministrationWindow();
            n.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(GradeAdministrationWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Hubo un error al agregar el curso, por favor inténtelo de nuevo", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        AdministratorWindow adm = new AdministratorWindow();
        adm.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
       addBtn.setEnabled(false);
        try {
            GradeTableModel.gradesList.edit(selected+1,getSemester(idSemester()), Integer.valueOf(noGradeTxt.getText()), nameTxt.getText(), getProfessor(idProf()), Integer.valueOf(creditsTxt.getText()),
            getLaboratory(), new SimplyLinkedListGrade(), getGrade(idPostRe()));
            JOptionPane.showMessageDialog(this, "Curso editado correctamente", "Editado",
                    JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            GradeAdministrationWindow n = new GradeAdministrationWindow();
            n.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(GradeAdministrationWindow.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(this, "Hubo un error al editar el curso, por favor inténtelo de nuevo", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        try{
            GradeTableModel.gradesList.delete(selected+1);
            JOptionPane.showMessageDialog(this, "Curso eliminado correctamente", "Eliminado",
                    JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            GradeAdministrationWindow n = new GradeAdministrationWindow();
            n.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Hubo un error al eliminar el curso, por favor inténtelo de nuevo", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void massiveDataLoadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_massiveDataLoadBtnActionPerformed
         try {
            archive.read("C:\\Users\\Omar\\Desktop\\StudentSystem\\src\\archive\\cursos.ipcb", "Curso");
            JOptionPane.showMessageDialog(this, "Archivos cargados correctamente", "Archivos",
                    JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            GradeAdministrationWindow n = new GradeAdministrationWindow();
            n.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(StudentAdministrationWindow.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(GradeAdministrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GradeAdministrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GradeAdministrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GradeAdministrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GradeAdministrationWindow().setVisible(true);
            }
        });
    }
     public Professor getProfessor(int idRef) throws Exception{
        return ProfessorTableModel.professorsList.getProfessorAt(idRef);
    }
     
    public Semester getSemester(int idRef) throws Exception{
        return LoginWindow.listaSemestres.getSemesterAt(idRef);
    }
    
     public String getLaboratory(){
         if(chbLaboratory.isSelected()){
             return "Con Laboratorio";
         }else{
             return "Sin Laboratorio";
         }
     }
     
    public Grade getGrade(int idRef) throws Exception{
        return GradeTableModel.gradesList.getGradeAt(idRef);
    }
    
    public int idProf(){
        Professor currentP = ProfessorTableModel.professorsList.getProfessorByName(String.valueOf(cbProfessor.getSelectedItem()));
        return currentP.getIdProfessor();
    }
    
    public int idSemester(){
        Semester currentSemester = LoginWindow.listaSemestres.getSemesterByName(String.valueOf(cbSemester.getSelectedItem()));
        return currentSemester.getIdSemester();
    }
    
    public int idPreRe(){
        if(!cbPreRequisite.getSelectedItem().equals("")){
            Grade currentG = GradeTableModel.gradesList.getGradeByName(String.valueOf(cbPreRequisite.getSelectedItem()));
            return currentG.getIdGrade();
        }else{
            return 0;
        }
    }
    
    public int idPostRe(){
        if(!cbPostRequisite.getSelectedItem().equals("")){
            Grade currentG = GradeTableModel.gradesList.getGradeByName(String.valueOf(cbPostRequisite.getSelectedItem()));
            return currentG.getIdGrade();
        }else{
            return 0;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable GradeTable;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> cbPostRequisite;
    private javax.swing.JComboBox<String> cbPreRequisite;
    private javax.swing.JComboBox<String> cbProfessor;
    private javax.swing.JComboBox<String> cbSemester;
    private javax.swing.JCheckBox chbLaboratory;
    private javax.swing.JTextField creditsTxt;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton massiveDataLoadBtn;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTextField noGradeTxt;
    private javax.swing.JTextField sectionTxt;
    // End of variables declaration//GEN-END:variables
}
