package com.unpri.charactermanager.view;

import java.awt.Color;                       // kelas warna AWT
import java.awt.Font;                        // kelas font AWT
import javax.swing.BorderFactory;            // pabrik border
import javax.swing.border.Border;            // tipe objek border
import com.unpri.charactermanager.model.CharacterType; // enum dari Model (View boleh membaca Model)

/**
 * Pusat gaya tampilan Character Manager.
 * Mengubah tema aplikasi cukup dengan mengedit file ini.
 */
public final class AppTheme {

    // ---------- Palet warna ----------
    public static final Color BG_MAIN    = Color.decode("#13131f"); // latar jendela: hampir hitam
    public static final Color TEXT_MAIN  = Color.decode("#dfe6e9"); // teks utama: abu terang
    public static final Color TEXT_LIGHT = Color.WHITE;             // teks di atas kartu berwarna
    public static final Color GOLD       = Color.decode("#fdcb6e"); // aksen untuk karakter level tinggi
    public static final Color WARRIOR    = Color.decode("#d63031"); // merah
    public static final Color MAGE       = Color.decode("#0984e3"); // biru
    public static final Color ARCHER     = Color.decode("#00b894"); // hijau
    public static final Color HEALER     = Color.decode("#6c5ce7"); // ungu
    public static final int GOLD_LEVEL_THRESHOLD = 5;

    // ---------- Font ----------
    public static final Font FONT_TITLE = new Font("SansSerif", Font.BOLD, 22);   // judul layar
    public static final Font FONT_BODY  = new Font("SansSerif", Font.PLAIN, 14);  // isi kartu
    public static final Font FONT_HIGH_LEVEL = new Font("SansSerif", Font.BOLD, 14);
    public static final Font FONT_MONO  = new Font("Monospaced", Font.PLAIN, 13); // angka sejajar

    // ---------- Border ----------
    // Border bersifat immutable, jadi aman dipakai ulang oleh banyak komponen.
    public static final Border CARD_BORDER =
            BorderFactory.createEmptyBorder(8, 12, 8, 12); // atas, kiri, bawah, kanan
    public static final Border MAIN_PANEL_BORDER =
            BorderFactory.createEmptyBorder(16, 16, 16, 16); // padding panel utama
    public static final Border HIGH_LEVEL_BORDER = BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(GOLD, 2),
            BorderFactory.createEmptyBorder(6, 10, 6, 10));

    private AppTheme() { }  // class utilitas: konstruktor private mencegah new AppTheme()

    /** Menerjemahkan role (data Model) menjadi warna kartu (urusan View). */
    public static Color colorFor(CharacterType type) {
        switch (type) {
            case WARRIOR: return WARRIOR;
            case MAGE:    return MAGE;
            case ARCHER:  return ARCHER;
            case HEALER:  return HEALER;
            default:      return Color.GRAY;              // cadangan bila ada role baru
        }
    }

    /** Teks tooltip per role. */
    public static String describe(CharacterType type) {
        switch (type) {
            case WARRIOR: return "Warrior: jarak dekat, HP tinggi";
            case MAGE:    return "Mage: serangan sihir, HP rendah";
            case ARCHER:  return "Archer: jarak jauh, seimbang";
            case HEALER:  return "Healer: pemulihan, HP tinggi";
            default:      return "Role belum terdaftar";
        }
    }
}