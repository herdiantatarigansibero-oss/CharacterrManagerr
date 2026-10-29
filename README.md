# Character Manager — Java Visual TP5

Aplikasi Java sederhana untuk mengelola karakter game. TP5 menambahkan pengelolaan koleksi karakter dengan operasi CRUD, pencarian, statistik, dan eksperimen object reference.

## Identitas

- **Nama:** Herdianta Yuventus Tarigan
- **NIM:** 253303621206
- **Kelas:** SI pagi3A
- **Tanggal:** 29 Oktober 2026

## TP5

### Fitur baru

- Menambahkan karakter ke koleksi dan menolak nama duplikat (case-sensitive).
- Mencari karakter berdasarkan nama dan menghapus karakter berdasarkan nama.
- Menampilkan jumlah karakter, daftar karakter, dan karakter berdasarkan tipe.
- Menghitung rata-rata level serta mencari karakter dengan attack power tertinggi.
- Mengembalikan salinan list melalui `getAllCharacters()` agar pemanggil tidak dapat mengubah koleksi internal manager secara langsung.

### Output CRUD dan eksperimen reference

Screenshot asli output CRUD dari eksekusi program:

![Screenshot output CRUD Character Manager TP5](screenshots/tp5-crud.png)

Screenshot asli eksperimen object reference:

![Screenshot eksperimen object reference TP5](screenshots/tp5-reference.png)

Eksperimen reference menunjukkan bahwa `asli` dan `duplikatReferensi` menunjuk ke object `Character` yang sama. Perubahan level melalui `duplikatReferensi` terlihat saat object dibaca lewat `asli`, dan perbandingan `asli == duplikatReferensi` bernilai `true`. Sebaliknya, `getAllCharacters()` menghasilkan salinan list: menambahkan karakter ke list salinan tidak menambah jumlah karakter di manager.

Ilustrasi output gabungan tersedia di [screenshots/tp5-output.svg](screenshots/tp5-output.svg).

### Penjelasan fitur Bagian C

`CharacterManager` menerapkan **composition**: manager memiliki `ArrayList<Character>` sebagai koleksi internal. Method `addCharacter`, `findByName`, dan `removeCharacter` menyediakan operasi pengelolaan dasar. Nama karakter diperiksa saat penambahan supaya tidak ada duplikat; pencocokan nama bersifat case-sensitive. `findByType`, `getAverageLevel`, dan `findStrongest` menyediakan pencarian serta statistik tanpa membuka list internal. Untuk melindungi struktur koleksi, `getAllCharacters()` mengembalikan salinan list, bukan list internal.

### Dokumen Bagian D

[Buka Google Docs — JavaVisual TP05 (Anyone with the link — Viewer)](https://docs.google.com/document/d/1wZ7kO6NrQ3Zode-1_h-my-PM2DDP8riFH3ErMOzqL-g/edit)

## Riwayat TP3

Class `Character` merepresentasikan karakter dengan tipe, level, HP, attack, dan mana. Atributnya bersifat private dan diakses melalui getter/setter tervalidasi. Class ini memiliki constructor untuk karakter baru dan untuk memuat data yang sudah ada, serta method `isAlive()` untuk memeriksa HP.

## Menjalankan program

Dengan JDK terpasang, dari direktori repository jalankan:

```powershell
javac -encoding UTF-8 -d out src\Main.java src\com\unpri\charactermanager\model\Character.java src\com\unpri\charactermanager\model\CharacterType.java src\com\unpri\charactermanager\model\CharacterManager.java
java -cp out Main
```

## Struktur project

```text
.
├── README.md
├── screenshots/
│   ├── tp5-crud.png
│   ├── tp5-reference.png
│   └── tp5-output.svg
└── src/
    ├── Main.java
    └── com/
        └── unpri/
            └── charactermanager/
                └── model/
                    ├── Character.java
                    ├── CharacterManager.java
                    └── CharacterType.java
```
