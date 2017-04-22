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
import library.model.Book;
import library.model.BookDAO;

/**
 *
 * @author Nebojsa
 */
public class AllBooksPanel extends javax.swing.JPanel {

    /**
     * Creates new form AllBooksPanel
     */
    public AllBooksPanel() {
        SwingWorker sw = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                BookDAO bookDao = BookDAO.getInstance();
                List<Book> allBooks = bookDao.getAllBooks();
                return allBooks;
            }

            @Override
            protected void done() {
                try {
                    List<Book> res = (List<Book>)get();
                    DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
                    for (Book b : res) {
                        dtm.addRow(new Object[] {
                            b.id, b.title, b.authors, b.genre.name, b.stock
                        });
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(AllBooksPanel.class.getName()).log(Level.SEVERE, null, ex);
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
        jbRent = new javax.swing.JButton();
        jbEdit = new javax.swing.JButton();
        jbDelete = new javax.swing.JButton();
        jbAtTheMoment = new javax.swing.JButton();
        jbHistory = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SVE KNJIGE");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Naslov", "Autor", "Žanr", "Količina"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(160);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        jbRent.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jbRent.setText("IZNAJMI");
        jbRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRentActionPerformed(evt);
            }
        });

        jbEdit.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jbEdit.setText("IZMENI");
        jbEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditActionPerformed(evt);
            }
        });

        jbDelete.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jbDelete.setText("OBRIŠI");
        jbDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteActionPerformed(evt);
            }
        });

        jbAtTheMoment.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jbAtTheMoment.setText("TRENUTNO");
        jbAtTheMoment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtTheMomentActionPerformed(evt);
            }
        });

        jbHistory.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jbHistory.setText("ISTORIJAT");
        jbHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHistoryActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbRent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28)
                        .addComponent(jbEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24)
                        .addComponent(jbDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbAtTheMoment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(jbHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEdit)
                    .addComponent(jbRent)
                    .addComponent(jbDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAtTheMoment)
                    .addComponent(jbHistory))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditActionPerformed
        DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
        if(jTable1.getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(this, "Niste ništa obeležili!", "Greška!!!", JOptionPane.ERROR_MESSAGE);
        } else {
            int row = jTable1.getSelectedRow();
            int id = Integer.parseInt(dtm.getValueAt(row, 0).toString());
            MainForm.mainForm.changeContent(new EditBookPanel(id));
        }
    }//GEN-LAST:event_jbEditActionPerformed

    private void jbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        if(jTable1.getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(this, "Niste ništa obeležili!", "Greška!!!", JOptionPane.ERROR_MESSAGE);
        } else {
            int row = jTable1.getSelectedRow();
            int id = Integer.parseInt(dtm.getValueAt(row, 0).toString());
            int res = JOptionPane.showConfirmDialog(this, "Jeste li sigurni?", "Brisanje knjige", JOptionPane.YES_NO_OPTION);
            if(res==JOptionPane.YES_OPTION) {
                try {
                    dtm.removeRow(row);
                    
                    BookDAO bookDao = BookDAO.getInstance();
                    bookDao.deleteBook(id);
                    bookDao.deleteBooksAuthors(id);
                } catch (SQLException ex) {
                    Logger.getLogger(AllBooksPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jbDeleteActionPerformed

    private void jbRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRentActionPerformed
        DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
        if(jTable1.getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(this, "Niste ništa obeležili!", "Greška!!!", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                int row = jTable1.getSelectedRow();
                int id = Integer.parseInt(dtm.getValueAt(row, 0).toString());
                int stock = Integer.parseInt(dtm.getValueAt(row, 4).toString());
                if(stock == 0) {
                    JOptionPane.showMessageDialog(this, "Ponestalo je obeležene knjige!", "Greška!!!", JOptionPane.ERROR_MESSAGE);
                    MainForm.mainForm.changeContent(new MembersByRentBookPanel(id));
                } else {
                    MainForm.mainForm.changeContent(new RentBookPanel(id));
                }
            } catch (SQLException ex) {
                Logger.getLogger(AllBooksPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }//GEN-LAST:event_jbRentActionPerformed

    private void jbAtTheMomentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtTheMomentActionPerformed
        DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
        if(jTable1.getSelectedRowCount()==0) {
            MainForm.mainForm.changeContent(new AllCurrentRentBooksPanel());
        } else {
            int row = jTable1.getSelectedRow();
            int id = Integer.parseInt(dtm.getValueAt(row, 0).toString());
            MainForm.mainForm.changeContent(new MembersByRentBookPanel(id));
        }
    }//GEN-LAST:event_jbAtTheMomentActionPerformed

    private void jbHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHistoryActionPerformed
        DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
        if(jTable1.getSelectedRowCount()==0) {
            MainForm.mainForm.changeContent(new AllReturnedtBooksPanel());
        } else {
            int row = jTable1.getSelectedRow();
            int id = Integer.parseInt(dtm.getValueAt(row, 0).toString());
            MainForm.mainForm.changeContent(new HistoryByBookPanel(id));
        }
    }//GEN-LAST:event_jbHistoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbAtTheMoment;
    private javax.swing.JButton jbDelete;
    private javax.swing.JButton jbEdit;
    private javax.swing.JButton jbHistory;
    private javax.swing.JButton jbRent;
    // End of variables declaration//GEN-END:variables
}