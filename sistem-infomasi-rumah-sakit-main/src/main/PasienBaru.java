/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.sql.Connection;
import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import main.Koneksi;

/**
 *
 * @author staff
 */
public class PasienBaru extends javax.swing.JFrame {

    /**
     * Creates new form PasienBaru
     */
    public PasienBaru() {

        initComponents();
        kodePasien();
    }

    private void reset() {
        txtid.setEditable(false);
        txtnama.setText(null);
        cbjk.setSelectedIndex(0);
        txtumur.setText(null);
        txthp.setText(null);
        taalamat.setText(null);

        btnsimpan.setEnabled(true);
        kodePasien();
    }

    private void kodePasien() {
        try {
            String sql = "SELECT MAX(right(id_pasien, 1)) AS id_pasien FROM pasien";
            java.sql.Connection conn = (Connection) Koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            if (res.next()) {
                int kode = res.getInt(1);
                String AN = "" + (kode + 1);
                String Nol = "";

                if (AN.length() == 1) {
                    Nol = "00";
                } else if (AN.length() == 2) {
                    Nol = "0";
                } else if (AN.length() == 3) {
                    Nol = "";
                }

                txtid.setText("PSN" + Nol + AN);

            } else {
                txtid.setText("PSN001");
            }
        } catch (Exception e) {
            System.out.print(e);
            JOptionPane.showMessageDialog(null, "Koneksi Gagal");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelFormPasien = new javax.swing.JPanel();
        btncari = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        cbjk = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtumur = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taalamat = new javax.swing.JTextArea();
        jLabel41 = new javax.swing.JLabel();
        txthp = new javax.swing.JTextField();
        btnsimpan = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        btnDataPasien = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelFormPasien.setBackground(new java.awt.Color(255, 255, 255));
        panelFormPasien.setMaximumSize(new java.awt.Dimension(900, 900));
        panelFormPasien.setPreferredSize(new java.awt.Dimension(780, 480));

        btncari.setBackground(new java.awt.Color(255, 255, 255));
        btncari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cari.png"))); // NOI18N
        btncari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btncari.setBorderPainted(false);
        btncari.setContentAreaFilled(false);
        btncari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncari.setFocusable(false);
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 255));
        jLabel29.setText("ID");

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 255));
        jLabel30.setText("Nama");

        cbjk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- - Pilih Jenis Kelamin - -", "Laki Laki", "Perempuan" }));
        cbjk.setBorder(null);

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 255));
        jLabel31.setText("Jenis Kelamin");

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 51, 255));
        jLabel32.setText("Umur");

        txtumur.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtumur.setText(" ");
        txtumur.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 255));
        jLabel33.setText("Tahun");

        txtid.setEditable(false);
        txtid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtid.setText("Otomatis");
        txtid.setToolTipText("");
        txtid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        txtnama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtnama.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));

        jLabel80.setBackground(new java.awt.Color(102, 102, 255));
        jLabel80.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(51, 51, 255));
        jLabel80.setText("Input Data Pasien");

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 255));
        jLabel34.setText("No HP");

        taalamat.setColumns(20);
        taalamat.setRows(5);
        jScrollPane2.setViewportView(taalamat);

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(51, 51, 255));
        jLabel41.setText("Alamat");

        txthp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txthp.setText(" ");
        txthp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));

        btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Vector.png"))); // NOI18N
        btnsimpan.setText(" Simpan");
        btnsimpan.setFocusable(false);
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Group 2803.png"))); // NOI18N
        btnreset.setText(" Reset");
        btnreset.setFocusable(false);
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        btnDataPasien.setText("Tutup");
        btnDataPasien.setFocusable(false);
        btnDataPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataPasienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormPasienLayout = new javax.swing.GroupLayout(panelFormPasien);
        panelFormPasien.setLayout(panelFormPasienLayout);
        panelFormPasienLayout.setHorizontalGroup(
            panelFormPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormPasienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel80)
                .addContainerGap(587, Short.MAX_VALUE))
            .addGroup(panelFormPasienLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(panelFormPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel34)
                    .addComponent(jLabel41))
                .addGap(29, 29, 29)
                .addGroup(panelFormPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelFormPasienLayout.createSequentialGroup()
                            .addComponent(txtumur, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel33))
                        .addComponent(jScrollPane2)
                        .addComponent(txthp)
                        .addComponent(cbjk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelFormPasienLayout.createSequentialGroup()
                        .addGroup(panelFormPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btncari, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88)
                .addGroup(panelFormPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelFormPasienLayout.createSequentialGroup()
                        .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDataPasien, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelFormPasienLayout.setVerticalGroup(
            panelFormPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormPasienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel80)
                .addGap(20, 20, 20)
                .addGroup(panelFormPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormPasienLayout.createSequentialGroup()
                        .addGroup(panelFormPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(btnDataPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(309, Short.MAX_VALUE))
                    .addGroup(panelFormPasienLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panelFormPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFormPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29))
                            .addComponent(btncari, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelFormPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(panelFormPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(cbjk, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelFormPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(txtumur, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(panelFormPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34)
                            .addComponent(txthp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(panelFormPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41))
                        .addGap(49, 49, 49))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelFormPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelFormPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtidActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btncariActionPerformed
        String id = JOptionPane.showInputDialog(null, "Cari Berdasarkan ID Pasien!!!");
        try {
            String sql = "SELECT * FROM pasien WHERE id_pasien='" + id + "'";
            java.sql.Connection conn = (Connection) Koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            if (res.next()) {
                JOptionPane.showMessageDialog(null, "Data ditemukan");
                txtid.setText(res.getString(1));
                txtnama.setText(res.getString(2));
                cbjk.setSelectedItem(res.getString(3));
                txtumur.setText(res.getString(4));
                txthp.setText(res.getString(6));
                taalamat.setText(res.getString(5));

                btnsimpan.setEnabled(false);
                btnupdate.setEnabled(true);
                btndelete.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Data Tidak ditemukan");
                reset();
            }
        } catch (Exception e) {
            System.out.print(e);
            JOptionPane.showMessageDialog(null, "Koneksi Gagal");
        }
    }// GEN-LAST:event_btncariActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnsimpanActionPerformed
        if (txtnama.getText().equals("") || cbjk.getSelectedIndex() == 0 || txtumur.getText().equals("")
                || txthp.getText().equals("") || taalamat.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Form Tidak Boleh Ada Yang Kosong!!!");
        } else {
            try {
                String sql = "INSERT INTO pasien(id_pasien, nama_pasien, jenis_kelamin, umur, alamat, no_hp) "
                        + "VALUES('" + txtid.getText() + "' ,'" + txtnama.getText() + "', '" + cbjk.getSelectedItem()
                        + "', '" + txtumur.getText() + "', '" + taalamat.getText() + "', '" + txthp.getText() + "')";
                java.sql.Connection conn = (Connection) Koneksi.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                JOptionPane.showMessageDialog(null, "Prosess Simpan Data Pasien Berhasil..");
                reset();

            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }// GEN-LAST:event_btnsimpanActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnupdateActionPerformed
        try {
            String sql = "UPDATE pasien SET nama_pasien='" + txtnama.getText() + "', jenis_kelamin='"
                    + cbjk.getSelectedItem() + "', umur='" + txtumur.getText() + "', alamat='" + taalamat.getText()
                    + "', no_hp='" + txthp.getText() + "' WHERE id_pasien = '" + txtid.getText() + "'";
            java.sql.Connection conn = (Connection) Koneksi.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Edit Data Pasien Berhasil...");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        reset();
    }// GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btndeleteActionPerformed
        int tanya = JOptionPane.showConfirmDialog(null, "Yakin untuk menghapus data ini?", "Confirmation",
                JOptionPane.YES_NO_OPTION);

        if (tanya == 0) {
            try {
                String sql = "DELETE FROM pasien WHERE id_pasien='" + txtid.getText() + "'";
                java.sql.Connection conn = (Connection) Koneksi.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                JOptionPane.showMessageDialog(null, "Hapus Data Pasien Berhasil....");
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            reset();
        }
    }// GEN-LAST:event_btndeleteActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnresetActionPerformed
        reset();
    }// GEN-LAST:event_btnresetActionPerformed

    private void btnDataPasienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDataPasienActionPerformed
        dispose();
    }// GEN-LAST:event_btnDataPasienActionPerformed

    private void btnDataPasien1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDataPasien1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnDataPasien1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PasienBaru.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasienBaru.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasienBaru.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasienBaru.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        // java.awt.EventQueue.invokeLater(new Runnable() {
        // public void run() {
        // new PasienBaru().setVisible(true);
        // }
        // });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDataPasien;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JComboBox<String> cbjk;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelFormPasien;
    private javax.swing.JTextArea taalamat;
    private javax.swing.JTextField txthp;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtumur;
    // End of variables declaration//GEN-END:variables
}
