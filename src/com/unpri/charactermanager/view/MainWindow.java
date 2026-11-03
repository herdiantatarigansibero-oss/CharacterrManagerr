package com.unpri.charactermanager.view; // package untuk komponen View aplikasi

import java.awt.Cursor; // menyediakan bentuk kursor
import java.awt.Dimension; // menentukan ukuran minimum jendela
import java.awt.GridLayout; // menyusun komponen dalam grid
import java.util.ArrayList; // tipe daftar karakter
import javax.swing.JFrame; // kelas jendela Swing
import javax.swing.JLabel; // komponen label Swing
import javax.swing.JPanel; // container komponen Swing
import javax.swing.SwingConstants; // konstanta perataan komponen Swing
import com.unpri.charactermanager.model.Character; // data karakter dari Model

public class MainWindow extends JFrame { // jendela utama aplikasi

    private JPanel mainPanel; // container utama
    private final ArrayList<Character> characterList; // data Model yang diterima dari Main.java

    public MainWindow(ArrayList<Character> characterList) {
        super("Character Manager v0.4"); // judul jendela untuk sprint #4
        this.characterList = characterList; // simpan data karakter yang diterima

        initComponents(); // susun semua komponen terlebih dahulu

        pack(); // sesuaikan ukuran jendela dengan isi
        setMinimumSize(new Dimension(420, 300)); // cegah jendela terlalu kecil
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // keluar aplikasi saat jendela ditutup
        setLocationRelativeTo(null); // pusatkan jendela setelah ukuran ditentukan
    }

    private void initComponents() {
        // GridLayout(0, 1, 0, 8): satu kolom dengan jarak vertikal 8 piksel.
        mainPanel = new JPanel(new GridLayout(0, 1, 0, 8));
        mainPanel.setBackground(AppTheme.BG_MAIN); // atur warna latar panel
        mainPanel.setBorder(AppTheme.MAIN_PANEL_BORDER); // beri padding luar

        mainPanel.add(createTitleLabel()); // tambahkan judul di bagian atas

        for (Character c : characterList) { // buat satu kartu untuk setiap karakter
            mainPanel.add(createCharacterLabel(c)); // tambahkan kartu karakter
        }

        add(mainPanel); // pasang panel utama ke JFrame
    }

    /** Membuat label judul layar. */
    private JLabel createTitleLabel() {
        JLabel lbl = new JLabel(
                "Daftar Karakter (" + characterList.size() + ")",
                SwingConstants.CENTER); // ratakan teks judul ke tengah
        lbl.setFont(AppTheme.FONT_TITLE); // gunakan font judul dari tema
        lbl.setForeground(AppTheme.TEXT_MAIN); // gunakan warna teks utama dari tema
        return lbl; // kembalikan label yang sudah ditata
    }

    /** Membuat satu kartu karakter dengan warna sesuai role. */
    private JLabel createCharacterLabel(Character c) {
        String info = c.getName() + " | " + c.getType()
                + " | Lv." + c.getLevel()
                + " | HP:" + c.getHitPoints()
                + " | ATK:" + c.getAttackPower(); // baca data karakter melalui getter

        JLabel lbl = new JLabel(info); // buat label berisi informasi karakter
        boolean highLevel = c.getLevel() >= AppTheme.GOLD_LEVEL_THRESHOLD;
        lbl.setFont(highLevel ? AppTheme.FONT_HIGH_LEVEL : AppTheme.FONT_BODY);
        lbl.setForeground(highLevel ? AppTheme.GOLD : AppTheme.TEXT_LIGHT);
        lbl.setBackground(AppTheme.colorFor(c.getType())); // pilih warna kartu berdasarkan role
        lbl.setOpaque(true); // tampilkan warna latar label
        lbl.setBorder(highLevel ? AppTheme.HIGH_LEVEL_BORDER : AppTheme.CARD_BORDER);
        lbl.setToolTipText(AppTheme.describe(c.getType())
                + " | HP: " + c.getHitPoints()
                + " | ATK: " + c.getAttackPower());
        lbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // gunakan kursor tangan
        return lbl; // kembalikan label kartu yang sudah ditata
    }
}
