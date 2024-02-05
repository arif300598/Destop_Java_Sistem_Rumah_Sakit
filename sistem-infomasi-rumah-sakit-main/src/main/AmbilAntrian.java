/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author staff
 */
public class AmbilAntrian extends javax.swing.JFrame {
    
    ArrayList idSpesialis = new ArrayList();
    ArrayList idDokter = new ArrayList();
    String tanggal;
    
    private void reset(){
       txtid.setEditable(false);
        txtidpasien.setText(null);
        txtnamapasien.setText(null);
        cbspesialis.setSelectedIndex(0);
        cbdokter.setSelectedIndex(0);
        tadiagnosa.setText(null);
        dttanggal.setDate(null);
        cbtindakan.setSelectedIndex(0);
        
        btnsimpan.setEnabled(true);
        btncaripasien.setEnabled(true);

        kodePemeriksaan();

    }
    
    private void tampilSpesialis(){
        try{
            String sql = "SELECT * FROM spesialis";
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                cbspesialis.addItem(res.getString(2));
                idSpesialis.add(res.getString(1));
            }
            
        }catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    private void tampilDokter(){
        try{
            String id_spesialis = (String) idSpesialis.get((int)cbspesialis.getSelectedIndex());
            String sql = "SELECT * FROM dokter WHERE id_spesialis='"+id_spesialis+"'";
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                cbdokter.addItem(res.getString(2));
                idDokter.add(res.getString(1));
            }
            
        }catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    private void kodePemeriksaan(){
        try{
            String sql = "SELECT MAX(right(kode_periksa, 1)) AS kode_periksa FROM pemeriksaan";
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            if(res.next()){
                int kode = res.getInt(1);
                String AN = "" + (kode + 1);
                String Nol = "";
                
                if(AN.length() == 1){
                    Nol = "00";
                }else if(AN.length() == 2){
                    Nol = "0";
                }else if(AN.length() == 3){
                    Nol = "";
                }
                
                txtid.setText("PRS" + Nol + AN);
                
            } else {
                txtid.setText("PRS001");
            }
        } catch (Exception e){
            System.out.print(e);
            JOptionPane.showMessageDialog(null, "Koneksi Gagal");
        }
    }

    /**
     * Creates new form AmbilAntrian
     */
    public AmbilAntrian() {
       initComponents();
        //((javax.swing.plaf.basic.BasicInternalFrameUI)getUI()).setNorthPane(null);
        idSpesialis.add("0");
        idDokter.add("0");
        tampilSpesialis();
        kodePemeriksaan();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFormPemeriksaan = new javax.swing.JPanel();
        btncari = new javax.swing.JButton();
        btncaripasien = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtidpasien = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtnamapasien = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cbspesialis = new javax.swing.JComboBox<>();
        cbdokter = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tadiagnosa = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        btnsimpan = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        cbtindakan = new javax.swing.JComboBox<>();
        btnDataPemeriksaan = new javax.swing.JButton();
        dttanggal = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFormPemeriksaan.setBackground(new java.awt.Color(255, 255, 255));
        panelFormPemeriksaan.setMaximumSize(new java.awt.Dimension(900, 900));
        panelFormPemeriksaan.setPreferredSize(new java.awt.Dimension(780, 480));

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

        btncaripasien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cari.png"))); // NOI18N
        btncaripasien.setBorderPainted(false);
        btncaripasien.setContentAreaFilled(false);
        btncaripasien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncaripasien.setFocusable(false);
        btncaripasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncaripasienActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 255));
        jLabel15.setText("Kode Pemeriksaan");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 255));
        jLabel16.setText("ID Pasien");

        txtid.setEditable(false);
        txtid.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtid.setText("Otomatis");
        txtid.setToolTipText("");
        txtid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));

        txtidpasien.setEditable(false);
        txtidpasien.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtidpasien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));

        jLabel67.setBackground(new java.awt.Color(102, 102, 255));
        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(51, 51, 255));
        jLabel67.setText("Ambil Antrian");

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 255));
        jLabel24.setText("Nama Pasien");

        txtnamapasien.setEditable(false);
        txtnamapasien.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtnamapasien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 255));
        jLabel18.setText("Spesialis");

        cbspesialis.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbspesialis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- - Pilih Spesialis - -" }));
        cbspesialis.setBorder(null);
        cbspesialis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbspesialisActionPerformed(evt);
            }
        });

        cbdokter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbdokter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- - Pilih Dokter - -" }));
        cbdokter.setBorder(null);
        cbdokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbdokterActionPerformed(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 255));
        jLabel21.setText("Dokter");

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 255));
        jLabel25.setText("Keluhan");

        tadiagnosa.setColumns(20);
        tadiagnosa.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        tadiagnosa.setRows(5);
        tadiagnosa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(0, 255, 0)));
        jScrollPane1.setViewportView(tadiagnosa);

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 255));
        jLabel26.setText("Tanggal Periksa");

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

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 255));
        jLabel27.setText("Tindakan");

        cbtindakan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbtindakan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- - Pilih Tindakan - -", "Rawat Inap", "Rawat Jalan" }));
        cbtindakan.setBorder(null);
        cbtindakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtindakanActionPerformed(evt);
            }
        });

        btnDataPemeriksaan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clipboard-square-symbol.png"))); // NOI18N
        btnDataPemeriksaan.setText(" Data Pemeriksaan");
        btnDataPemeriksaan.setFocusable(false);
        btnDataPemeriksaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataPemeriksaanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormPemeriksaanLayout = new javax.swing.GroupLayout(panelFormPemeriksaan);
        panelFormPemeriksaan.setLayout(panelFormPemeriksaanLayout);
        panelFormPemeriksaanLayout.setHorizontalGroup(
            panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel67))
                    .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtnamapasien)
                                    .addComponent(cbdokter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbspesialis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(cbtindakan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dttanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))
                                .addGap(29, 29, 29)
                                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtidpasien, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btncari, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btncaripasien, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(82, 82, 82)
                                .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormPemeriksaanLayout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(btnDataPemeriksaan, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        panelFormPemeriksaanLayout.setVerticalGroup(
            panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel67)
                .addGap(20, 20, 20)
                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                        .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtidpasien, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtnamapasien, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbspesialis, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(9, 9, 9))
                    .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                        .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btncari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btncaripasien, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDataPemeriksaan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)))
                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cbdokter, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel25)))
                .addGap(21, 21, 21)
                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbtindakan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)))
                    .addComponent(dttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelFormPemeriksaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelFormPemeriksaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        String kode = JOptionPane.showInputDialog(null, "Cari Berdasarkan Kode Pemeriksaan!!!");
        try{
            String sql = "SELECT * FROM pemeriksaan "
            + "INNER JOIN pasien ON pasien.id_pasien=pemeriksaan.id_pasien "
            + "INNER JOIN dokter ON dokter.id_dokter=pemeriksaan.id_dokter "
            + "INNER JOIN spesialis ON spesialis.id_spesialis=dokter.id_spesialis "
            + "WHERE kode_periksa='"+kode+"'";
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            if(res.next()){
                int id_spesialis = idSpesialis.indexOf(res.getString(18));
                JOptionPane.showMessageDialog(null, "Data ditemukan");
                txtid.setText(res.getString(1));
                txtidpasien.setText(res.getString(7));
                txtnamapasien.setText(res.getString(8));
                cbspesialis.setSelectedIndex(id_spesialis);

                int id_dokter = idDokter.indexOf(res.getString(13));
                cbdokter.setSelectedIndex(id_dokter);

                tadiagnosa.setText(res.getString(4));

                java.util.Date date = new SimpleDateFormat("yyy-MM-dd").parse((String)res.getString(5));
                dttanggal.setDate(date);

                cbtindakan.setSelectedItem(res.getString(6));

                btnsimpan.setEnabled(false);
                btnupdate.setEnabled(true);
                btndelete.setEnabled(true);
                btncaripasien.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Data Tidak ditemukan");
                reset();
            }
        } catch (Exception e){
            System.out.print(e);
            JOptionPane.showMessageDialog(null, "Koneksi Gagal");
        }
    }//GEN-LAST:event_btncariActionPerformed

    private void btncaripasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncaripasienActionPerformed
        String id = JOptionPane.showInputDialog(null, "Cari Berdasarkan ID Pasien!!!");
        try{
            String sql = "SELECT * FROM pasien WHERE id_pasien='"+id+"'";
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            if(res.next()){
                JOptionPane.showMessageDialog(null, "Data ditemukan");
                txtidpasien.setText(res.getString(1));
                txtnamapasien.setText(res.getString(2));
            } else {
                JOptionPane.showMessageDialog(null, "Data Tidak ditemukan");
                reset();
            }
        } catch (Exception e){
            System.out.print(e);
            JOptionPane.showMessageDialog(null, "Koneksi Gagal");
        }
    }//GEN-LAST:event_btncaripasienActionPerformed

    private void cbspesialisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbspesialisActionPerformed
        cbdokter.removeAllItems();
        cbdokter.addItem("- - Pilih Dokter - -");
        idDokter.clear();
        idDokter.add("0");
        tampilDokter();
    }//GEN-LAST:event_cbspesialisActionPerformed

    private void cbdokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbdokterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbdokterActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        if(dttanggal.getDate() != null){
            SimpleDateFormat tgl = new SimpleDateFormat("yyyy-mm-dd");
            tanggal = tgl.format(dttanggal.getDate());
        }
        if(txtidpasien.getText().equals("") || txtnamapasien.getText().equals("") || cbspesialis.getSelectedIndex() ==  0 || cbdokter.getSelectedIndex() ==  0 || tadiagnosa.getText().equals("") || dttanggal.getDate().equals("") || cbtindakan.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Form Tidak Boleh Ada Yang Kosong!!!");
        }else{
            try {
                String id_dokter = (String) idDokter.get((int)cbdokter.getSelectedIndex());

                String sql = "INSERT INTO pemeriksaan(kode_periksa, id_pasien, id_dokter, diagnosa, tgl_periksa, tindakan) "
                    + "VALUES('"+txtid.getText()+"', '"+txtidpasien.getText()+"', '"+id_dokter+"','"+tadiagnosa.getText()+"','"+tanggal+"', '"+cbtindakan.getSelectedItem()+"')";
                java.sql.Connection conn = (Connection)Koneksi.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                JOptionPane.showMessageDialog(null, "Prosess Simpan Data Pemeriksaan Berhasil..");
                reset();
                kodePemeriksaan();

            }catch (HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        reset();
    }//GEN-LAST:event_btnresetActionPerformed

    private void cbtindakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtindakanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbtindakanActionPerformed

    private void btnDataPemeriksaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataPemeriksaanActionPerformed
        CetakAntrian antrian = new CetakAntrian();
        antrian.setVisible(true);
    }//GEN-LAST:event_btnDataPemeriksaanActionPerformed
       
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AmbilAntrian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AmbilAntrian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AmbilAntrian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AmbilAntrian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AmbilAntrian().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDataPemeriksaan;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btncaripasien;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JComboBox<String> cbdokter;
    private javax.swing.JComboBox<String> cbspesialis;
    private javax.swing.JComboBox<String> cbtindakan;
    private com.toedter.calendar.JDateChooser dttanggal;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelFormPemeriksaan;
    private javax.swing.JTextArea tadiagnosa;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidpasien;
    private javax.swing.JTextField txtnamapasien;
    // End of variables declaration//GEN-END:variables
}