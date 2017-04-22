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
import library.model.RentBook;
import library.model.RentBookDAO;

/**
 *
 * @author Nebojsa
 */
public class HistoryByMemberPanel extends javax.swing.JPanel {

    /**
     * Creates new form BooksByMemberPanel
     */
    public HistoryByMemberPanel() {
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
        jLabel2 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        jbShow = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jlName = new javax.swing.JLabel();
        jlJMBG = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(720, 480));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ISTORIJAT ČLANA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Broj članske karte:");

        tfId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jbShow.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jbShow.setText("PRIKAŽI");
        jbShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbShowActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Naslov", "Autor", "Žanr", "Uzeto", "Rok", "Vraćeno", "Kazna"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(80);
        }

        jlName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlName.setText("Ime i prezime člana");

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
                    .addComponent(jbShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfId))
                            .addComponent(jlName)
                            .addComponent(jlJMBG))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbShow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlName)
                .addGap(10, 10, 10)
                .addComponent(jlJMBG)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbShowActionPerformed
        try {
            MemberDAO memberDAO = MemberDAO.getInstance();
            Member m = memberDAO.getMember(Integer.parseInt(tfId.getText())); 
            if(m==null) {
                JOptionPane.showMessageDialog(this, "Član ne postoji!", "Greška!!!", JOptionPane.ERROR_MESSAGE);
            } else {
                jlName.setText("Ime i prezime: " + m.name);
                jlJMBG.setText("JMBG: " + m.jmbg);
                SwingWorker sw = new SwingWorker() {
                    @Override
                    protected Object doInBackground() throws Exception {
                        RentBookDAO rbDao = RentBookDAO.getInstance();
                        List<RentBook> books = rbDao.getReturnedBooksByMember(Integer.parseInt(tfId.getText()));
                        return books;
                    }
                    @Override
                    protected void done() {
                        try {
                            List<RentBook> res = (List<RentBook>)get();
                            DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
                            dtm.setRowCount(0);
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
                            if(res.isEmpty()) {
                                JOptionPane.showMessageDialog(jTable1, "Ovaj član nije uzimao nijednu knjigu");
                                MainForm.mainForm.changeContent(new AllBooksPanel());
                            } else {
                                for (RentBook rb : res) {
                                    dtm.addRow(new Object[]{
                                        rb.book.id, rb.book.title, rb.book.authors, rb.book.genre.name, rb.rentDate.format(dtf), rb.returnDate.format(dtf), rb.dateOfReturn.format(dtf), rb.finePerBook
                                    });
                                }
                            }
                        } catch (InterruptedException | ExecutionException ex) {
                            Logger.getLogger(HistoryByMemberPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                };
                sw.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(HistoryByMemberPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbShowActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbShow;
    private javax.swing.JLabel jlJMBG;
    private javax.swing.JLabel jlName;
    private javax.swing.JTextField tfId;
    // End of variables declaration//GEN-END:variables
}
