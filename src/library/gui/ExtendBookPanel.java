/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.gui;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import library.model.Member;
import library.model.RentBook;
import library.model.RentBookDAO;

/**
 *
 * @author Nebojsa
 */
public class ExtendBookPanel extends javax.swing.JPanel {

    Member m;
    RentBook rb;
    /**
     * Creates new form ReturnBookPanel
     */
    public ExtendBookPanel(Member m, RentBook rb) {
        initComponents();
        this.m = m;
        this.rb = rb;
        jlMemberID.setText("Broj članske karte: " + m.id);
        jlName.setText("Ime i prezime člana: " + m.name);
        jlJMBG.setText("JMBG: " + m.jmbg);
        jlBookID.setText("ID knjige: " + rb.book.id);
        jlTitle.setText("Naslov knjige: " + rb.book.title);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
        jlRent.setText("Iznajmljeno: " + rb.rentDate.format(dtf));
        jlOldDeadline.setText("Stari rok: " + rb.returnDate.format(dtf));
        jlNewDeadline.setText("Novi rok: " + rb.returnDate.plusWeeks(2).format(dtf));        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jlMemberID = new javax.swing.JLabel();
        jlName = new javax.swing.JLabel();
        jlBookID = new javax.swing.JLabel();
        jlTitle = new javax.swing.JLabel();
        jbExtend = new javax.swing.JButton();
        jlRent = new javax.swing.JLabel();
        jlOldDeadline = new javax.swing.JLabel();
        jlNewDeadline = new javax.swing.JLabel();
        jlJMBG = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(720, 480));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRODUŽIVANJE ROKA ZA VRAĆANJE KNJIGE");

        jlMemberID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlMemberID.setText("ID člana");

        jlName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlName.setText("Ime člana");

        jlBookID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlBookID.setText("ID knjige");

        jlTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlTitle.setText("Naslov");

        jbExtend.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jbExtend.setText("PRODUŽI ROK");
        jbExtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExtendActionPerformed(evt);
            }
        });

        jlRent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlRent.setText("Iznajmljena");

        jlOldDeadline.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlOldDeadline.setText("Stari rok");

        jlNewDeadline.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlNewDeadline.setText("Novi rok");

        jlJMBG.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlJMBG.setText("JMBG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbExtend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlMemberID)
                            .addComponent(jlName)
                            .addComponent(jlBookID)
                            .addComponent(jlTitle)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlRent)
                                .addGap(30, 30, 30)
                                .addComponent(jlOldDeadline)
                                .addGap(41, 41, 41)
                                .addComponent(jlNewDeadline))
                            .addComponent(jlJMBG))
                        .addGap(0, 458, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jlMemberID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlJMBG)
                .addGap(22, 22, 22)
                .addComponent(jlBookID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlRent)
                    .addComponent(jlOldDeadline)
                    .addComponent(jlNewDeadline))
                .addGap(55, 55, 55)
                .addComponent(jbExtend)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbExtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExtendActionPerformed
        try {
            RentBookDAO rbDao = RentBookDAO.getInstance();            
            rb.returnDate = rb.returnDate.plusWeeks(2);
            rbDao.extendBook(m, rb);
            JOptionPane.showMessageDialog(this, "Uspešno produžen rok");
            MainForm.mainForm.changeContent(new AllBooksPanel());
        } catch (SQLException ex) {
            Logger.getLogger(ExtendBookPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbExtendActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbExtend;
    private javax.swing.JLabel jlBookID;
    private javax.swing.JLabel jlJMBG;
    private javax.swing.JLabel jlMemberID;
    private javax.swing.JLabel jlName;
    private javax.swing.JLabel jlNewDeadline;
    private javax.swing.JLabel jlOldDeadline;
    private javax.swing.JLabel jlRent;
    private javax.swing.JLabel jlTitle;
    // End of variables declaration//GEN-END:variables
}
