/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.view.dialog;

import com.bustomi.bookstorepos.entity.master.Pengarang;
import com.bustomi.bookstorepos.manager.SpringManager;
import com.bustomi.bookstorepos.service.PengarangService;
import com.bustomi.bookstorepos.validator.ValidatorException;
import com.bustomi.bookstorepos.validator.implement.PengarangValidator;
import com.bustomi.bookstorepos.view.tablemodel.HurufListRender;
import java.awt.Color;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author PacuL
 */
public class DialogPengarangRelasi extends javax.swing.JDialog {

    private List<Pengarang> pengarangs;
    private final DefaultListModel<Pengarang> defaultListModel;
    private final DefaultListModel<Pengarang> defaultListModel2;
    
    public DialogPengarangRelasi() {
        setModal(true);
        setModal(true);
        initComponents();
        setLocationRelativeTo(null);
        defaultListModel= new DefaultListModel<>();
        listPengarang.setModel(defaultListModel);
        
        defaultListModel2= new DefaultListModel<>();
        listpengarangpilih.setModel(defaultListModel2);
        
        listPengarang.setCellRenderer(new HurufListRender());
        listpengarangpilih.setCellRenderer(new HurufListRender());
        
        textAreaInfo.setDisabledTextColor(Color.LIGHT_GRAY);        
      
    }
    
    public void loadPengarang() {
        PengarangService service = SpringManager.getInstance().getBean(PengarangService.class);
        List<Pengarang> list = service.findAll();
        defaultListModel.clear();
        
        for (Pengarang object : list) {
            defaultListModel.addElement(object);
            if (defaultListModel2.contains(object)) {
                defaultListModel.removeElement(object);
            }
        }
    }
        
    public List<Pengarang> ubah(List<Pengarang> parameter) {
                
                
        jLabelInfo.setText("Atur Pengarang");
        setTitle("Atur Pengarang");
        
        for (Pengarang object : parameter) {
            defaultListModel2.addElement(object);
        }
        loadPengarang();
        
        pengarangs = parameter;
        
        setVisible(true);
        
        return pengarangs;
    }
    
    public List<Pengarang> ubah() {
        
        loadPengarang();
               
                
        jLabelInfo.setText("Atur Pengarang");
        setTitle("Atur Pengarang");
                       
        setVisible(true);
        
        return pengarangs;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewPortX1 = new com.bustomi.bookstorepos.component.ViewPortX();
        textAreaInfo = new javax.swing.JTextArea();
        viewPortX3 = new com.bustomi.bookstorepos.component.ViewPortX();
        listpengarangpilih = new javax.swing.JList();
        viewPortX2 = new com.bustomi.bookstorepos.component.ViewPortX();
        listPengarang = new javax.swing.JList();
        panelXBack1 = new com.bustomi.bookstorepos.component.PanelXBack();
        panelX1 = new com.bustomi.bookstorepos.component.PanelX();
        jLabel6 = new javax.swing.JLabel();
        jScrollPanePengarang = new javax.swing.JScrollPane();
        jScrollPanePengarangPilih = new javax.swing.JScrollPane();
        jLabel7 = new javax.swing.JLabel();
        buttonMin1 = new com.bustomi.bookstorepos.component.ButtonMin();
        buttonMin2 = new com.bustomi.bookstorepos.component.ButtonMin();
        jLabelInfo = new javax.swing.JLabel();
        panelX2 = new com.bustomi.bookstorepos.component.PanelX();
        buttonGreen1 = new com.bustomi.bookstorepos.component.ButtonGreen();
        buttonRed1 = new com.bustomi.bookstorepos.component.ButtonRed();
        panelX3 = new com.bustomi.bookstorepos.component.PanelX();
        jScrollPaneNama = new javax.swing.JScrollPane();
        textFieldXNama = new com.bustomi.bookstorepos.component.TextFieldX();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonBlue1 = new com.bustomi.bookstorepos.component.ButtonBlue();

        textAreaInfo.setColumns(20);
        textAreaInfo.setForeground(new java.awt.Color(255, 255, 255));
        textAreaInfo.setRows(5);
        textAreaInfo.setOpaque(false);
        viewPortX1.add(textAreaInfo);

        listpengarangpilih.setForeground(new java.awt.Color(255, 255, 255));
        listpengarangpilih.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listpengarangpilih.setOpaque(false);
        viewPortX3.add(listpengarangpilih);

        listPengarang.setForeground(new java.awt.Color(255, 255, 255));
        listPengarang.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listPengarang.setOpaque(false);
        viewPortX2.add(listPengarang);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelX1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Pengarang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        panelX1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Data Pengarang tersimpan:");

        jScrollPanePengarang.setOpaque(false);
        jScrollPanePengarang.setViewport(viewPortX2);

        jScrollPanePengarangPilih.setOpaque(false);
        jScrollPanePengarangPilih.setViewport(viewPortX3);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Data Pengarang dipilih :");

        buttonMin1.setText("< Hapus");
        buttonMin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMin1ActionPerformed(evt);
            }
        });

        buttonMin2.setText("Tambah >");
        buttonMin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMin2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelX1Layout = new javax.swing.GroupLayout(panelX1);
        panelX1.setLayout(panelX1Layout);
        panelX1Layout.setHorizontalGroup(
            panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPanePengarang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonMin2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonMin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPanePengarangPilih, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelX1Layout.setVerticalGroup(
            panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelX1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelX1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPanePengarang)
                            .addComponent(jScrollPanePengarangPilih, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelX1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(buttonMin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonMin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))))
        );

        jLabelInfo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelInfo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfo.setText("Info Dialog");
        jLabelInfo.setName(""); // NOI18N

        buttonGreen1.setText("Simpan");
        buttonGreen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGreen1ActionPerformed(evt);
            }
        });
        panelX2.add(buttonGreen1);

        buttonRed1.setText("Batal");
        buttonRed1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRed1ActionPerformed(evt);
            }
        });
        panelX2.add(buttonRed1);

        panelX3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tambah Pengarang Baru", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255)), "Tambah Pengarang Baru", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        panelX3.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPaneNama.setOpaque(false);
        jScrollPaneNama.setViewport(viewPortX1);

        textFieldXNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldXNamaActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nama :");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Info :");

        buttonBlue1.setText("Tambahkan");
        buttonBlue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBlue1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelX3Layout = new javax.swing.GroupLayout(panelX3);
        panelX3.setLayout(panelX3Layout);
        panelX3Layout.setHorizontalGroup(
            panelX3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelX3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelX3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelX3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldXNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneNama, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonBlue1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelX3Layout.setVerticalGroup(
            panelX3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelX3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelX3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonBlue1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelX3Layout.createSequentialGroup()
                        .addGroup(panelX3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldXNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelX3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneNama, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelXBack1Layout = new javax.swing.GroupLayout(panelXBack1);
        panelXBack1.setLayout(panelXBack1Layout);
        panelXBack1Layout.setHorizontalGroup(
            panelXBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelXBack1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelXBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelX2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelX1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelXBack1Layout.createSequentialGroup()
                        .addComponent(panelX3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelXBack1Layout.setVerticalGroup(
            panelXBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelXBack1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelX3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panelXBack1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGreen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGreen1ActionPerformed
       pengarangs = new ArrayList<>();
        for (int i = 0; i < defaultListModel2.getSize(); i++) {
            pengarangs.add(defaultListModel2.get(i));
        }
        dispose();
        
    }//GEN-LAST:event_buttonGreen1ActionPerformed

    private void buttonRed1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRed1ActionPerformed
        pengarangs=null;
        dispose();
    }//GEN-LAST:event_buttonRed1ActionPerformed

    private void textFieldXNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldXNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldXNamaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        pengarangs = null;
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void buttonBlue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBlue1ActionPerformed
        
        String nama=textFieldXNama.getText();
        String info=textAreaInfo.getText();
        
        Pengarang pengarang=new Pengarang();
        pengarang.setNama(nama);
        pengarang.setInfo(info);
        
        PengarangValidator validator=SpringManager.getInstance().getBean(PengarangValidator.class);
        PengarangService service=SpringManager.getInstance().getBean(PengarangService.class);
        try {
            validator.validate(pengarang);
            service.save(pengarang);            
            loadPengarang();
            textFieldXNama.setText("");
            textAreaInfo.setText("");
        } catch (ValidatorException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }            
        
    
        
    }//GEN-LAST:event_buttonBlue1ActionPerformed

    private void buttonMin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMin2ActionPerformed
        DefaultListModel listModel=(DefaultListModel) listPengarang.getModel();
        if (listPengarang.getSelectedIndices().length > 0) {
            int [] i=listPengarang.getSelectedIndices();
            for (int j = i.length-1; j >= 0; j--) {
                defaultListModel2.addElement((Pengarang) listModel.get(i[j]));
                listModel.removeElementAt(i[j]);
            }
        }
    }//GEN-LAST:event_buttonMin2ActionPerformed

    private void buttonMin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMin1ActionPerformed
        DefaultListModel listModel=(DefaultListModel) listpengarangpilih.getModel();
        if (listpengarangpilih.getSelectedIndices().length > 0) {
            int [] i = listpengarangpilih.getSelectedIndices();
            for (int j = i.length-1 ; j >= 0; j--) {
                defaultListModel.addElement((Pengarang) listModel.get(i[j]));
                listModel.removeElementAt(i[j]);
            }
        }
    }//GEN-LAST:event_buttonMin1ActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.bustomi.bookstorepos.component.ButtonBlue buttonBlue1;
    private com.bustomi.bookstorepos.component.ButtonGreen buttonGreen1;
    private com.bustomi.bookstorepos.component.ButtonMin buttonMin1;
    private com.bustomi.bookstorepos.component.ButtonMin buttonMin2;
    private com.bustomi.bookstorepos.component.ButtonRed buttonRed1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JScrollPane jScrollPaneNama;
    private javax.swing.JScrollPane jScrollPanePengarang;
    private javax.swing.JScrollPane jScrollPanePengarangPilih;
    private javax.swing.JList listPengarang;
    private javax.swing.JList listpengarangpilih;
    private com.bustomi.bookstorepos.component.PanelX panelX1;
    private com.bustomi.bookstorepos.component.PanelX panelX2;
    private com.bustomi.bookstorepos.component.PanelX panelX3;
    private com.bustomi.bookstorepos.component.PanelXBack panelXBack1;
    private javax.swing.JTextArea textAreaInfo;
    private com.bustomi.bookstorepos.component.TextFieldX textFieldXNama;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX1;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX2;
    private com.bustomi.bookstorepos.component.ViewPortX viewPortX3;
    // End of variables declaration//GEN-END:variables
  
}
