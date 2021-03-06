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
import library.model.MemberDAO;

/**
 *
 * @author Nebojsa
 */
public class ExtendMembershipPanel extends javax.swing.JPanel {

    
    /**
     * Creates new form ExtendMembershipPanel
     */
    public ExtendMembershipPanel() {
        initComponents();
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
        jLabel7 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        jbShow = new javax.swing.JButton();
        jlName = new javax.swing.JLabel();
        jlJMBG = new javax.swing.JLabel();
        jlAdress = new javax.swing.JLabel();
        jlNewExpiring = new javax.swing.JLabel();
        jlOldExpiring = new javax.swing.JLabel();
        jlStarted = new javax.swing.JLabel();
        jbExtend = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(720, 480));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRODUŽI ČLANSTVO");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Broj članske karte:");

        tfID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jbShow.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jbShow.setText("PRIKAŽI");
        jbShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbShowActionPerformed(evt);
            }
        });

        jlName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlName.setText("Ime i prezime");

        jlJMBG.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlJMBG.setText("JMBG");

        jlAdress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlAdress.setText("Adresa");

        jlNewExpiring.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlNewExpiring.setText("Ističe");

        jlOldExpiring.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlOldExpiring.setText("Isticala");

        jlStarted.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlStarted.setText("Upisan");

        jbExtend.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jbExtend.setText("PRODUŽI");
        jbExtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExtendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfID, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jlName)
                            .addComponent(jlJMBG)
                            .addComponent(jlAdress)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlStarted)
                                .addGap(30, 30, 30)
                                .addComponent(jlOldExpiring)
                                .addGap(41, 41, 41)
                                .addComponent(jlNewExpiring)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jbExtend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbShow)
                .addGap(36, 36, 36)
                .addComponent(jlName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlJMBG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlAdress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlStarted)
                    .addComponent(jlOldExpiring)
                    .addComponent(jlNewExpiring))
                .addGap(31, 31, 31)
                .addComponent(jbExtend)
                .addGap(0, 128, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbShowActionPerformed
        try {
            MemberDAO memberDao = MemberDAO.getInstance();
            Member m = memberDao.getMember(Integer.parseInt(tfID.getText()));
            if(m==null) {
                JOptionPane.showMessageDialog(this, "Član ne postoji!", "Greška!!!", JOptionPane.ERROR_MESSAGE);             
            } else {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
                jlName.setText(m.name);
                jlJMBG.setText(m.jmbg);
                jlAdress.setText(m.adress);
                jlStarted.setText("Učlanjen: " + m.started.format(dtf));
                jlOldExpiring.setText("Isticala: " + m.expiring.format(dtf));
                jlNewExpiring.setText("Ističe: " + m.expiring.plusYears(1).format(dtf));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditMemberPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbShowActionPerformed

    private void jbExtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExtendActionPerformed
        try {
            MemberDAO memberDao = MemberDAO.getInstance();
            Member m = memberDao.getMember(Integer.parseInt(tfID.getText()));
            m.expiring=m.expiring.plusYears(1);
            memberDao.extendMembership(m);
            JOptionPane.showMessageDialog(this, "Uspešno produžena članska karta");
            MainForm.mainForm.changeContent(new AllMembersPanel());
        } catch (SQLException ex) {
            Logger.getLogger(ExtendMembershipPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbExtendActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jbExtend;
    private javax.swing.JButton jbShow;
    private javax.swing.JLabel jlAdress;
    private javax.swing.JLabel jlJMBG;
    private javax.swing.JLabel jlName;
    private javax.swing.JLabel jlNewExpiring;
    private javax.swing.JLabel jlOldExpiring;
    private javax.swing.JLabel jlStarted;
    private javax.swing.JTextField tfID;
    // End of variables declaration//GEN-END:variables
}
