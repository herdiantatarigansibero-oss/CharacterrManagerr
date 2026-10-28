package com.unpri.charactermanager.model;

import java.util.Objects;

/**
 * Merepresentasikan satu karakter dalam aplikasi Character Manager.
 * Menerapkan prinsip Encapsulation: semua atribut private,
 * akses hanya melalui getter/setter.
 */
public class Character {

    // ===== ATRIBUT (private — tidak bisa diakses langsung dari luar class) =====
    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    // ===== CONSTRUCTOR 1: untuk membuat karakter BARU =====
    // Dipakai saat user membuat karakter dari form (belum punya id dari database)
    public Character(String name, CharacterType type, int level) {
        this.name = validateName(name);
        this.type = Objects.requireNonNull(type, "Tipe karakter tidak boleh null");
        validateLevel(level);
        this.level = level;
        recalculateStats();
    }

    // ===== CONSTRUCTOR 2: untuk MEMUAT karakter dari database =====
    // Dipakai saat data sudah ada (id dan statistik sudah final dari DB)
    public Character(int id, String name, CharacterType type, int level, int hitPoints, int attackPower) {
        this.id = id;
        this.name = validateName(name);
        this.type = Objects.requireNonNull(type, "Tipe karakter tidak boleh null");
        validateLevel(level);
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
    }

    // ===== HELPER PRIVATE: hanya dipakai internal class ini =====
    private int calculateBaseHP() {
        return 100 + (level * 10);   // contoh: level 5 → HP = 150
    }

    private int calculateBaseAttack() {
        return 10 + (level * 5);     // contoh: level 5 → Attack = 35
    }

    private void recalculateStats() {
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
    }

    private static String validateName(String name) {
        String validatedName = Objects.requireNonNull(name, "Nama karakter tidak boleh null");
        if (validatedName.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama karakter tidak boleh kosong");
        }
        return validatedName;
    }

    private static void validateLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level minimal adalah 1");
        }
    }

    // ===== GETTER: cara AMAN membaca nilai atribut private dari luar =====
    public int getId() { return id; }
    public String getName() { return name; }
    public CharacterType getType() { return type; }
    public int getLevel() { return level; }
    public int getHitPoints() { return hitPoints; }
    public int getAttackPower() { return attackPower; }
    public int getMana() { return mana; }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    // ===== SETTER: cara AMAN mengubah atribut, dengan VALIDASI =====
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = validateName(name);
    }

    public void setType(CharacterType type) {
        this.type = Objects.requireNonNull(type, "Tipe karakter tidak boleh null");
    }

    public void setLevel(int level) {
        validateLevel(level);
        this.level = level;
        recalculateStats();
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh negatif");
        }
        this.mana = mana;
    }

    // ===== toString(): representasi teks object, berguna untuk debugging =====
    @Override
    public String toString() {
        return "Character{id=" + id +
               ", name='" + name + '\'' +
               ", type=" + type +
               ", level=" + level +
               ", hp=" + hitPoints +
               ", atk=" + attackPower +
               ", mana=" + mana + '}';
    }

}