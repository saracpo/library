/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.gui;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import library.model.Member;
import library.model.MemberDAO;

/**
 *
 * @author Nebojsa
 */
public class AllMembersPanel extends javax.swing.JPanel {

    /**
     * Creates new form AllBooksPanel
     */
    public AllMembersPanel() {
        SwingWorker sw = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                MemberDAO memberDao = MemberDAO.getInstance();
                List<Member> allMembers = memberDao.getAllMembers();
                return allMembers;
            }

            @Override
            protected void done() {
                try {
                    List<Member> res = (List<Member>)get();
                    DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
                    for (Member m : res) {
                        dtm.addRow(new Object[] {
                            m.id, m.name, m.jmbg, m.adress, m.started.format(dtf), m.expiring.format(dtf)
                        });
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(AllMembersPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        };
        sw.execute();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbCurrent = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SVI ČLANOVI");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ime i prezime", "JMBG", "Adresa", "Učlanio se", "Ističe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(160);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(70);
        }

        jbCurrent.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jbCurrent.setText("KNJIGE KOD ČLANA");
        jbCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCurrentActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton1.setText("ISTORIJAT ČLANA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCurrent)
                    .addComponent(jButton1))
                .addGap(58, 58, 58))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCurrentActionPerformed
        if(jTable1.getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(this, "Niste odabrali člana!", "Greška!!!", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
                MainForm.mainForm.changeContent(new BooksByMemberPanel1(Integer.parseInt(dtm.getValueAt(jTable1.getSelectedRow(), 0).toString())));
            } catch (SQLException ex) {
                Logger.getLogger(AllMembersPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jbCurrentActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jTable1.getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(this, "Niste odabrali člana!", "Greška!!!", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
                MainForm.mainForm.changeContent(new HistoryByMemberPanel1(Integer.parseInt(dtm.getValueAt(jTable1.getSelectedRow(), 0).toString())));
            } catch (SQLException ex) {
                Logger.getLogger(AllMembersPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbCurrent;
    // End of variables declaration//GEN-END:variables
}