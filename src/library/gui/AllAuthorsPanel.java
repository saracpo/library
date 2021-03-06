/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.gui;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import library.model.Author;
import library.model.AuthorDAO;

/**
 *
 * @author Nebojsa
 */
public class AllAuthorsPanel extends javax.swing.JPanel {

    /**
     * Creates new form AllAuthorsPanel
     */
    public AllAuthorsPanel() {
        SwingWorker sw = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                AuthorDAO authorDao = AuthorDAO.getInstance();
                List<Author> allAuthors = authorDao.getAllAuthors();
                return allAuthors;
            }

            @Override
            protected void done() {
                try {
                    List<Author> res = (List<Author>)get();
                    DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
                    for (Author a : res) {
                        dtm.addRow(new Object[]{
                            a.id, a.name
                        });
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(AllAuthorsPanel.class.getName()).log(Level.SEVERE, null, ex);
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
        jbEditAuthor = new javax.swing.JButton();
        jbDeleteAuthor = new javax.swing.JButton();
        jbAddAuthor = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SVI PISCI");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Pisac"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        jbEditAuthor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbEditAuthor.setText("IZMENI");
        jbEditAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditAuthorActionPerformed(evt);
            }
        });

        jbDeleteAuthor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbDeleteAuthor.setText("OBRIŠI");
        jbDeleteAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteAuthorActionPerformed(evt);
            }
        });

        jbAddAuthor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbAddAuthor.setText("DODAJ");
        jbAddAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddAuthorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbAddAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(jbEditAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28)
                        .addComponent(jbDeleteAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEditAuthor)
                    .addComponent(jbDeleteAuthor)
                    .addComponent(jbAddAuthor))
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbEditAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditAuthorActionPerformed
        if(jTable1.getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(this, "Nije ništa obeleženo!", "Greška!!!", JOptionPane.ERROR_MESSAGE);
        } else {
            int row = jTable1.getSelectedRow();
            DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
            int id = Integer.parseInt(dtm.getValueAt(row, 0).toString());
            try {
                MainForm.mainForm.changeContent(new EditAuthorPanel(id));
            } catch (SQLException ex) {
                Logger.getLogger(AllAuthorsPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jbEditAuthorActionPerformed

    private void jbDeleteAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteAuthorActionPerformed
        if(jTable1.getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(this, "Nije ništa obeleženo!", "Greška!!!", JOptionPane.ERROR_MESSAGE);
        } else {
            int row = jTable1.getSelectedRow();
            DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
            int id = Integer.parseInt(dtm.getValueAt(row, 0).toString());
            int res = JOptionPane.showConfirmDialog(this, "Da li ste sigurni?", "Brisanje", JOptionPane.YES_NO_OPTION);
            
            if(res==JOptionPane.YES_OPTION) {
                try {
                    AuthorDAO authorDao = AuthorDAO.getInstance();
                    authorDao.deleteAutor(id);
                    dtm.removeRow(row);
                } catch (SQLException ex) {
                    Logger.getLogger(AllAuthorsPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jbDeleteAuthorActionPerformed

    private void jbAddAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddAuthorActionPerformed
        MainForm.mainForm.changeContent(new AddAuthorPanel());
    }//GEN-LAST:event_jbAddAuthorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbAddAuthor;
    private javax.swing.JButton jbDeleteAuthor;
    private javax.swing.JButton jbEditAuthor;
    // End of variables declaration//GEN-END:variables
}
