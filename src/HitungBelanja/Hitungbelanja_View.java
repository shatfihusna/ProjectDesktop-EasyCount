/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HitungBelanja;

import DAO.Menu_Dao;
import Input_Menu.Form_Inputmenu;
import MenuUtama1.FromUtama;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raven
 */
public class Hitungbelanja_View extends javax.swing.JFrame {
    Hitungbelanja_Controller controller;
    DefaultTableModel model;
    Menu_Dao dao;
    /**
     * Creates new form Stock2_View
     */
   
    public Hitungbelanja_View() throws SQLException {
        initComponents();
         dispose();
        controller = new Hitungbelanja_Controller(this);
        controller.isiTabelpesan();
        controller.isiTabelDaftarMenu();
        controller.Tanggal(this);
        controller.AutoIsiKodeTransaksi(this);
        controller.AutoIsiIdPemesanan(this);
        model = (DefaultTableModel)tblDaftarMenu.getModel();
        
    }

      public void setUsername(String username){
        lbl_username.setText(username);
    }
    public JTextField getTxt_bayar() {
        return txt_bayar;
    }

    public JTextField getTxt_kodetransaksi() {
        return txt_kodetransaksi;
    }

    public JTextField getTxt_kembali() {
        return txt_kembali;
    }

    public JTextField getTxt_total() {
        return txt_total;
    }

    public static JLabel getLbl_tot() {
        return lbl_tot;
    }

    
    public JTable getTbl_pesan() {
        return tbl_pesan;
    }

    public JSpinner getSpn_jum() {
        return spn_jum;
    }

    public javax.swing.JTable gettblDaftarMenu(){
        return tblDaftarMenu;
    }
    
    public java.awt.TextField gettxtId_pemesanan(){
        return txtId_pemesanan;
    }
    public java.awt.TextField gettxtKodemenu(){
        return txtKodemenu;
    }
    public java.awt.TextField gettxtNamamenu(){
        return txtNamamenu;
    }
    public java.awt.TextField gettxtTgl(){
        return txtTgl;
    }

    public JTextField getTxt_harga() {
        return txt_harga;
    }

    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btn_keluar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDaftarMenu = new javax.swing.JTable();
        label2 = new java.awt.Label();
        label1 = new java.awt.Label();
        txt_total = new javax.swing.JTextField();
        txt_bayar = new javax.swing.JTextField();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        txtId_pemesanan = new java.awt.TextField();
        txtTgl = new java.awt.TextField();
        label6 = new java.awt.Label();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        label9 = new java.awt.Label();
        txtKodemenu = new java.awt.TextField();
        txtNamamenu = new java.awt.TextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_pesan = new javax.swing.JTable();
        btnInsert = new java.awt.Button();
        btn_Simpan = new java.awt.Button();
        txt_kembali = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        spn_jum = new javax.swing.JSpinner();
        txt_harga = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_kodetransaksi = new javax.swing.JTextField();
        btnlaporan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        btn_keluar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_keluar.setText("KELUAR");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Selamat Datang");

        lbl_username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jPanel1.setBackground(new java.awt.Color(204, 153, 255));

        jLabel1.setFont(new java.awt.Font("Coolvetica Condensed Rg", 1, 36)); // NOI18N
        jLabel1.setText("HITUNG BELANJA");

        tblDaftarMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Kode Menu", "Nama Menu"
            }
        ));
        jScrollPane1.setViewportView(tblDaftarMenu);

        label2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label2.setText("Uang Bayar");

        label1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label1.setText("Total");

        txt_total.setEditable(false);
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });

        txt_bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_bayarKeyPressed(evt);
            }
        });

        label4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label4.setText("Id Pemesanan");

        label5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label5.setText("Tanggal");

        txtId_pemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtId_pemesananActionPerformed(evt);
            }
        });
        txtId_pemesanan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtId_pemesananKeyPressed(evt);
            }
        });

        label6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label6.setText("Kode Menu");

        label7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label7.setText("Nama Menu");

        label8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label8.setText("Jumlah");

        label9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label9.setText("Harga");

        txtKodemenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKodemenuKeyPressed(evt);
            }
        });

        tbl_pesan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Menu", "Nama Menu", "Harga", "Jumlah"
            }
        ));
        jScrollPane2.setViewportView(tbl_pesan);

        btnInsert.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnInsert.setLabel("Tambah");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btn_Simpan.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_Simpan.setLabel("Simpan");
        btn_Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SimpanActionPerformed(evt);
            }
        });

        txt_kembali.setEditable(false);
        txt_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kembaliActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Uang Kembali");

        txt_harga.setEditable(false);
        txt_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargaActionPerformed(evt);
            }
        });

        lbl_tot.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Kode Transaksi");

        txt_kodetransaksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_kodetransaksiKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(110, 110, 110)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtId_pemesanan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_kodetransaksi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTgl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(120, 120, 120)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(142, 142, 142)
                                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNamamenu, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtKodemenu, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spn_jum, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txt_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(104, 104, 104)
                                                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(67, 67, 67)
                                        .addComponent(btn_Simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(157, 157, 157)
                                        .addComponent(txt_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(lbl_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(512, 512, 512)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtId_pemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_kodetransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtKodemenu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(txtNamamenu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtTgl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spn_jum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl_username, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lbl_username, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnlaporan.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnlaporan.setText("LAPORAN");
        btnlaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlaporanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnlaporan, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(btn_keluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btn_keluar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnlaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txtId_pemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtId_pemesananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtId_pemesananActionPerformed

    private void txtKodemenuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodemenuKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            controller.getKodemenu();
        }
    }//GEN-LAST:event_txtKodemenuKeyPressed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        try {
            // TODO add your handling code here:
            controller.inputPesanan();
            controller.isiTabelpesan();
            controller.AutoIsiIdPemesanan(this);
            controller.TetapIsiKodeTransaksi(this);
        } catch (SQLException ex) {
            Logger.getLogger(Hitungbelanja_View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void txtId_pemesananKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtId_pemesananKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            controller.getTotalbelanja();
        }
    }//GEN-LAST:event_txtId_pemesananKeyPressed

    private void txt_bayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bayarKeyPressed
        // TODO add your handling code here:
        controller.Kembalian(this);
    }//GEN-LAST:event_txt_bayarKeyPressed

    private void btn_SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SimpanActionPerformed
        // TODO add your handling code here:
        controller.inputTransaksi();
    }//GEN-LAST:event_btn_SimpanActionPerformed

    private void txt_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargaActionPerformed

    private void txt_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kembaliActionPerformed

    private void txt_kodetransaksiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_kodetransaksiKeyPressed
        try {
            // TODO add your handling code here:
            controller.isiTabelpesan();
        } catch (SQLException ex) {
            Logger.getLogger(Hitungbelanja_View.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_txt_kodetransaksiKeyPressed

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        // TODO add your handling code here:
        FromUtama f = new FromUtama();
        f.setVisible(true);
        f.toFront();
        dispose();
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void btnlaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlaporanActionPerformed
        // TODO add your handling code here:
        controller.previewTransaksi();
    }//GEN-LAST:event_btnlaporanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Hitungbelanja_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hitungbelanja_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hitungbelanja_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hitungbelanja_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Hitungbelanja_View().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Hitungbelanja_View.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnInsert;
    private java.awt.Button btn_Simpan;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btnlaporan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    public static final javax.swing.JLabel lbl_tot = new javax.swing.JLabel();
    public static final javax.swing.JLabel lbl_username = new javax.swing.JLabel();
    private javax.swing.JSpinner spn_jum;
    private javax.swing.JTable tblDaftarMenu;
    private javax.swing.JTable tbl_pesan;
    private java.awt.TextField txtId_pemesanan;
    private java.awt.TextField txtKodemenu;
    private java.awt.TextField txtNamamenu;
    private java.awt.TextField txtTgl;
    private javax.swing.JTextField txt_bayar;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_kembali;
    private javax.swing.JTextField txt_kodetransaksi;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
