package com.unpri.charactermanager.model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Mengelola koleksi Character: tambah, cari, hapus, dan statistik dasar.
 * Menerapkan Composition: CharacterManager "has-a" ArrayList<Character>.
 */
public class CharacterManager {

    private final ArrayList<Character> characterList;

    public CharacterManager() {
        this.characterList = new ArrayList<>();
    }

    /**
     * Menambahkan karakter baru ke dalam list.
     * Menolak jika sudah ada karakter dengan nama yang sama (case-sensitive).
     *
     * @return true jika berhasil ditambahkan, false jika ditolak karena duplikat
     */
    public boolean addCharacter(Character character) {
        Objects.requireNonNull(character, "Karakter tidak boleh null");

        for (Character existing : characterList) {
            if (existing.equals(character)) {
                System.out.println("Gagal: karakter dengan nama '" + character.getName() + "' sudah ada!");
                return false;
            }
        }

        characterList.add(character);
        System.out.println("Karakter '" + character.getName() + "' berhasil ditambahkan.");
        return true;
    }

    /**
     * Mencari karakter berdasarkan nama.
     * @return object Character jika ditemukan, null jika tidak ada
     */
    public Character findByName(String name) {
        for (Character c : characterList) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Menghapus karakter dari list berdasarkan nama.
     * @return true jika berhasil dihapus, false jika tidak ditemukan
     */
    public boolean removeCharacter(String name) {
        Character target = findByName(name);
        if (target == null) {
            System.out.println("Gagal hapus: karakter '" + name + "' tidak ditemukan.");
            return false;
        }
        characterList.remove(target);
        System.out.println("Karakter '" + name + "' berhasil dihapus.");
        return true;
    }

    public int getCharacterCount() {
        return characterList.size();
    }

    public int getTotalCharacters() {
        return characterList.size();
    }

    /**
     * Mengembalikan salinan list agar pemanggil tidak dapat mengubah koleksi internal.
     */
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characterList);
    }

    /**
     * Mencari semua karakter dengan tipe tertentu.
     *
     * @return salinan list berisi karakter dengan tipe yang cocok
     */
    public ArrayList<Character> findByType(CharacterType type) {
        Objects.requireNonNull(type, "Tipe karakter tidak boleh null");

        ArrayList<Character> matchingCharacters = new ArrayList<>();
        for (Character character : characterList) {
            if (character.getType() == type) {
                matchingCharacters.add(character);
            }
        }
        return matchingCharacters;
    }

    /**
     * Menghitung rata-rata level semua karakter.
     *
     * @return rata-rata level, atau 0.0 jika belum ada karakter
     */
    public double getAverageLevel() {
        if (characterList.isEmpty()) {
            return 0.0;
        }

        int totalLevel = 0;
        for (Character character : characterList) {
            totalLevel += character.getLevel();
        }
        return (double) totalLevel / characterList.size();
    }

    /**
     * Mencari karakter dengan attack power tertinggi.
     *
     * @return karakter terkuat, atau null jika koleksi kosong; jika seri, mengembalikan yang pertama
     */
    public Character findStrongest() {
        if (characterList.isEmpty()) {
            return null;
        }

        Character strongest = characterList.get(0);
        for (int i = 1; i < characterList.size(); i++) {
            Character candidate = characterList.get(i);
            if (candidate.getAttackPower() > strongest.getAttackPower()) {
                strongest = candidate;
            }
        }
        return strongest;
    }
}
