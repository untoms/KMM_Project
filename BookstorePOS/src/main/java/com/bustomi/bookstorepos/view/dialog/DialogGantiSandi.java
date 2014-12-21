/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.dialog;

import com.bustomi.bookstorepos.manager.LoginManager;
import javax.swing.JOptionPane;

/**
 *
 * @author PacuL
 */
public class DialogGantiSandi extends javax.swing.JDialog {
    private String sandi;
    public DialogGantiSandi() {
        setModal(true);
        initComponents();        
        
    } 
    
    public String ganti(){
        return sandi;        
    }
        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelXBack1 = new com.bustomi.bookstorepos.component.PanelXBack();
        panelX1 = new com.bustomi.bookstorepos.component.PanelX();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textPassX1 = new com.bustomi.bookstorepos.component.TextPassX();
        textPassX2 = new com.bustomi.bookstorepos.component.TextPassX();
        textPassX3 = new com.bustomi.bookstorepos.component.TextPassX();
        jLabelInfo = new javax.swing.JLabel();
        panelX2 = new com.bustomi.bookstorepos.component.PanelX();
        buttonYellow1 = new com.bustomi.bookstorepos.component.ButtonYellow();
        buttonRed1 = new com.bustomi.bookstorepos.component.ButtonRed();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelX1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        panelX1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Sandi Sekarang :");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Sandi Baru :");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Konfirmasi Sandi Baru :");

        javax.swing.GroupLayout panelX1Layout = new javax.swing.GroupLayout(panelX1);
        panelX1.setLayout(panelX1Layout);
        panelX1Layout.setHorizontalGroup(
            panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX1Layout.createSequentialGroup()
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textPassX1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textPassX2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textPassX3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelX1Layout.setVerticalGroup(
            panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textPassX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textPassX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textPassX3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelInfo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelInfo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfo.setText("Ganti Sandi");
        jLabelInfo.setName(""); // NOI18N

        panelX2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        buttonYellow1.setText("UPDATE");
        buttonYellow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonYellow1ActionPerformed(evt);
            }
        });
        panelX2.add(buttonYellow1);

        buttonRed1.setText("CANCEL");
        buttonRed1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRed1ActionPerformed(evt);
            }
        });
        panelX2.add(buttonRed1);

        javax.swing.GroupLayout panelXBack1Layout = new javax.swing.GroupLayout(panelXBack1);
        panelXBack1.setLayout(panelXBack1Layout);
        panelXBack1Layout.setHorizontalGroup(
            panelXBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelXBack1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelXBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelX1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelX2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelXBack1Layout.setVerticalGroup(
            panelXBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelXBack1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelX1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panelXBack1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        sandi=null;
    }//GEN-LAST:event_formWindowClosing

    private void buttonRed1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRed1ActionPerformed
        sandi=null;
        dispose();
    }//GEN-LAST:event_buttonRed1ActionPerformed

    private void buttonYellow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonYellow1ActionPerformed
        String pass=new String(textPassX1.getPassword());
        String pass1=new String(textPassX2.getPassword());
        String pass2=new String(textPassX3.getPassword());
        
        if (!LoginManager.getInstance().getUser().getPassword().equals(
                LoginManager.getInstance().sandi(pass))) {
            JOptionPane.showMessageDialog(this, "Sandi sekarang SALAH!");
        }else if(!pass1.equals(pass2)){
            JOptionPane.showMessageDialog(this, "Sandi baru dengan konfirmasi sandi baru harus sama");
        }else{
            sandi=LoginManager.getInstance().sandi(pass2);
            dispose();
        }
    }//GEN-LAST:event_buttonYellow1ActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bustomi.bookstorepos.component.ButtonRed buttonRed1;
    private com.bustomi.bookstorepos.component.ButtonYellow buttonYellow1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelInfo;
    private com.bustomi.bookstorepos.component.PanelX panelX1;
    private com.bustomi.bookstorepos.component.PanelX panelX2;
    private com.bustomi.bookstorepos.component.PanelXBack panelXBack1;
    private com.bustomi.bookstorepos.component.TextPassX textPassX1;
    private com.bustomi.bookstorepos.component.TextPassX textPassX2;
    private com.bustomi.bookstorepos.component.TextPassX textPassX3;
    // End of variables declaration//GEN-END:variables
   
    
}