/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import library.model.Author;
import library.model.AuthorDAO;
import library.model.Book;
import library.model.BookDAO;
import library.model.Genre;
import library.model.GenreDAO;

/**
 *
 * @author Nebojsa
 */
public class EditBookPanel extends javax.swing.JPanel {
    Book b;
    /**
     * Creates new form EditBookPanel
     */
    public EditBookPanel(int id) {
        initComponents();
        cbAuthors2.setVisible(false);
        cbAuthors3.setVisible(false); 
        jbAddAuthor1.setVisible(false);
        jbAddAuthor2.setVisible(false);
        jbRemoveAuthor2.setVisible(false);
        jbRemoveAuthor3.setVisible(false);
        
        try {
            AuthorDAO authorDao = AuthorDAO.getInstance();
            List<Author> authors = authorDao.getAllAuthors();
            for (Author a : authors) {
                cbAuthors1.addItem(a);
                cbAuthors2.addItem(a);
                cbAuthors3.addItem(a);
            }
            GenreDAO genreDao = GenreDAO.getInstance();
            List<Genre> genres = genreDao.getAllGenres();
            for (Genre g : genres) {
                cbGenres.addItem(g);
            }

            BookDAO bookDao = BookDAO.getInstance();
            this.b=bookDao.getBook(id);
            tfTitle.setText(b.title);
            switch(b.authors.size()) {
                case 1:
                    jbAddAuthor1.setVisible(true);
                    for(int i=0; i<authors.size(); i++) {
                        if(authors.get(i).name.equals(b.authors.get(0).name)) {
                            cbAuthors1.setSelectedItem(authors.get(i));
                        }                    
                    }
                break;
                case 2:
                    cbAuthors2.setVisible(true);
                    jbRemoveAuthor2.setVisible(true);
                    for(int i=0; i<authors.size(); i++) {
                        if(authors.get(i).name.equals(b.authors.get(0).name)) {
                            cbAuthors1.setSelectedItem(authors.get(i));
                        }
                        if(authors.get(i).name.equals(b.authors.get(1).name)) {
                            cbAuthors2.setSelectedItem(authors.get(i));
                        }            
                    }
                break;
                case 3:
                    cbAuthors2.setVisible(true);
                    jbRemoveAuthor2.setVisible(true);
                    cbAuthors3.setVisible(true);
                    jbRemoveAuthor3.setVisible(true);
                    for(int i=0; i<authors.size(); i++) {
                        if(authors.get(i).name.equals(b.authors.get(0).name)) {
                            cbAuthors1.setSelectedItem(authors.get(i));
                        }
                        if(authors.get(i).name.equals(b.authors.get(1).name)) {
                            cbAuthors2.setSelectedItem(authors.get(i));
                        }
                        if(authors.get(i).name.equals(b.authors.get(2).name)) {
                            cbAuthors3.setSelectedItem(authors.get(i));
                        }                    
                    }
                break;
            }
            for(int i=0; i<genres.size(); i++) {
                if(genres.get(i).name.equals(b.genre.name)) {
                    cbGenres.setSelectedItem(genres.get(i));
                }
            }     
            jsStock.setValue(b.stock);       
        } catch (SQLException ex) {
            Logger.getLogger(AddBookPanel.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel2 = new javax.swing.JLabel();
        tfTitle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jsStock = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jbEdit = new javax.swing.JButton();
        cbGenres = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cbAuthors1 = new javax.swing.JComboBox<>();
        jbAddAuthor1 = new javax.swing.JButton();
        cbAuthors2 = new javax.swing.JComboBox<>();
        jbRemoveAuthor2 = new javax.swing.JButton();
        jbAddAuthor2 = new javax.swing.JButton();
        cbAuthors3 = new javax.swing.JComboBox<>();
        jbRemoveAuthor3 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Naslov knjige:");

        tfTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Žanr:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Količina:");

        jsStock.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("IZMENI KNJIGU");

        jbEdit.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jbEdit.setText("IZMENI");
        jbEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditActionPerformed(evt);
            }
        });

        cbGenres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Autor(i):");

        cbAuthors1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbAuthors1.setToolTipText("");

        jbAddAuthor1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbAddAuthor1.setText("JOŠ AUTORA");
        jbAddAuthor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddAuthor1ActionPerformed(evt);
            }
        });

        cbAuthors2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbAuthors2.setToolTipText("");

        jbRemoveAuthor2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbRemoveAuthor2.setText("SKLONI AUTORA");
        jbRemoveAuthor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoveAuthor2ActionPerformed(evt);
            }
        });

        jbAddAuthor2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbAddAuthor2.setText("JOŠ AUTORA");
        jbAddAuthor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddAuthor2ActionPerformed(evt);
            }
        });

        cbAuthors3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbAuthors3.setToolTipText("");

        jbRemoveAuthor3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbRemoveAuthor3.setText("SKLONI AUTORA");
        jbRemoveAuthor3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoveAuthor3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(290, 695, Short.MAX_VALUE))
                            .addComponent(tfTitle)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(cbAuthors1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbAddAuthor1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbAddAuthor2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(cbAuthors3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbRemoveAuthor3))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(cbAuthors2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(33, 33, 33)
                                            .addComponent(jbRemoveAuthor2))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jsStock, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(cbGenres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbAuthors1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbAddAuthor1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbRemoveAuthor2)
                    .addComponent(cbAuthors2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbAddAuthor2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAuthors3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbRemoveAuthor3))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbGenres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jbEdit)
                .addGap(118, 118, 118))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditActionPerformed
        try {
            BookDAO bookDao = BookDAO.getInstance();            
            b.title=tfTitle.getText();
            List<Author> authors = new ArrayList<>();            
            authors.add((Author)cbAuthors1.getSelectedItem());
                if(cbAuthors2.isVisible()) {
                    authors.add((Author)cbAuthors2.getSelectedItem());
                } 
                if(cbAuthors3.isVisible()) {
                    authors.add((Author)cbAuthors3.getSelectedItem());
                }
            b.authors = authors;
            b.genre = (Genre)cbGenres.getSelectedItem();
            b.stock = Integer.parseInt(jsStock.getValue().toString());
            
            bookDao.deleteBooksAuthors(b.id);
            
            bookDao.editBook(b);            
            for(int i=0; i<b.authors.size();i++) {
                bookDao.addBooksAuthors(b.id, b.authors.get(i).id);
            }
            JOptionPane.showMessageDialog(this, "Uspešne izmene");
            MainForm.mainForm.changeContent(new AllBooksPanel());
            
        } catch (SQLException ex) {
            Logger.getLogger(EditBookPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbEditActionPerformed

    private void jbAddAuthor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddAuthor1ActionPerformed
        jbAddAuthor1.setVisible(false);
        cbAuthors2.setVisible(true);
        jbRemoveAuthor2.setVisible(true);
        jbAddAuthor2.setVisible(true);
    }//GEN-LAST:event_jbAddAuthor1ActionPerformed

    private void jbRemoveAuthor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoveAuthor2ActionPerformed
        jbRemoveAuthor2.setVisible(false);
        cbAuthors2.setVisible(false);
        jbAddAuthor1.setVisible(true);
        jbAddAuthor2.setVisible(false);
        cbAuthors3.setVisible(false);
        jbRemoveAuthor3.setVisible(false);
    }//GEN-LAST:event_jbRemoveAuthor2ActionPerformed

    private void jbAddAuthor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddAuthor2ActionPerformed
        jbAddAuthor2.setVisible(false);
        cbAuthors3.setVisible(true);
        jbRemoveAuthor3.setVisible(true);

    }//GEN-LAST:event_jbAddAuthor2ActionPerformed

    private void jbRemoveAuthor3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoveAuthor3ActionPerformed
        jbRemoveAuthor3.setVisible(false);
        cbAuthors3.setVisible(false);
        jbAddAuthor2.setVisible(true);
    }//GEN-LAST:event_jbRemoveAuthor3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> cbAuthors1;
    private javax.swing.JComboBox<Object> cbAuthors2;
    private javax.swing.JComboBox<Object> cbAuthors3;
    private javax.swing.JComboBox cbGenres;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbAddAuthor1;
    private javax.swing.JButton jbAddAuthor2;
    private javax.swing.JButton jbEdit;
    private javax.swing.JButton jbRemoveAuthor2;
    private javax.swing.JButton jbRemoveAuthor3;
    private javax.swing.JSpinner jsStock;
    private javax.swing.JTextField tfTitle;
    // End of variables declaration//GEN-END:variables
}