package com.unpri.charactermanager.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.util.ArrayList;
import com.unpri.charactermanager.model.Character;

/**
 * Jendela utama aplikasi Character Manager.
 * Menampilkan daftar karakter yang diterima dari luar (bukan dibuat sendiri).
 */
public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private ArrayList<Character> characterList;   // data yang akan ditampilkan

    public MainWindow(ArrayList<Character> characterList) {
        super("Character Manager v0.3");    // judul title bar
        this.characterList = characterList;  // simpan data yang diterima dari Main.java

        initComponents();

        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("=== Daftar Karakter (" + characterList.size() + ") ===");
        mainPanel.add(titleLabel);

        int totalLevel = 0;

        // Loop setiap Character, buat SATU JLabel baru untuk masing-masing
        for (Character c : characterList) {
            String info = c.getName() + " | " + c.getType() +
                          " | Lv." + c.getLevel() +
                          " | HP:" + c.getHitPoints() +
                          " | ATK:" + c.getAttackPower();
            JLabel characterLabel = new JLabel(info);
            mainPanel.add(characterLabel);   // setiap karakter mendapat JLabel sendiri
            totalLevel += c.getLevel();
        }

        double averageLevel = characterList.isEmpty()
                ? 0.0
                : (double) totalLevel / characterList.size();
        JLabel statisticsLabel = new JLabel("Rata-rata Level: " + averageLevel);
        mainPanel.add(statisticsLabel);

        add(mainPanel);
    }
}
