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
import library.model.Book;
import library.model.BookDAO;
import library.model.Member;
import library.model.MemberDAO;

/**
 *
 * @author Nebojsa
 */
public class MembersByRentBookPanel extends javax.swing.JPanel {

    /**
     * Creates new form MembersByRentBookPanel
     */
    public MembersByRentBookPanel(int book_id) {
        try {
            initComponents();            
            BookDAO bookDao = BookDAO.getInstance();
            Book b = bookDao.getBook(book_id);
            jlTitle.setText("Naslov: " + b.title);
            jlAuthor.setText("Autor: " + b.authors.toString());
            SwingWorker sw = new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {
                   MemberDAO memberDao = MemberDAO.getInstance();
                   List<Member> members = memberDao.getMembersByRentBook(b.id);
                   return members;
                }

                @Override
                protected void done() {
                    try {
                        List<Member> res = (List<Member>)get();
                        DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
                        if(res.isEmpty()) {
                            JOptionPane.showMessageDialog(jTable1, "Ova knjiga nije ni kod koga trenutno");
                            MainForm.mainForm.changeContent(new AllBooksPanel());
                        } else {
                            for (Member m : res) {
                                dtm.addRow(new Object[] {
                                    m.id, m.name, m.jmbg, m.rentBooks.get(0).rentDate.format(dtf), m.rentBooks.get(0).returnDate.format(dtf)
                                });
                            }
                        }
                    } catch (InterruptedException | ExecutionException ex) {
                        Logger.getLogger(MembersByRentBookPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            };
            sw.execute();           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MembersByRentBookPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jlTitle = new javax.swing.JLabel();
        jlAuthor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KNJIGA KOD ČLANOVA");

        jlTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlTitle.setText("Naslov");

        jlAuthor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlAuthor.setText("Autor");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ime i prezime", "JMBG", "Uzeto", "Rok za vraćanje"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(160);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlTitle)
                            .addComponent(jlAuthor))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jlTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlAuthor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(280, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlAuthor;
    private javax.swing.JLabel jlTitle;
    // End of variables declaration//GEN-END:variables
}
