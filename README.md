# Character Manager — Java Visual TP8

Aplikasi Java sederhana untuk mengelola data karakter dan menampilkannya melalui GUI Swing. Program menyiapkan data di `CharacterManager`, lalu menampilkan daftar karakter pada jendela `MainWindow`. Gaya tampilan terpusat di `AppTheme`.

## Identitas

- **Nama:** Herdianta Yuventus Tarigan
- **NIM:** 253303621206
- **Kelas:** SI pagi3A
- **Tanggal:** 3 November 2026

## TP8 — GUI dan MVC

### Fitur

- Membuat enam karakter dengan empat role dan level bervariasi: Arjuna, Merlin, Athena, Gatotkaca, Morgana, dan Saraswati.
- Menampilkan jumlah karakter serta nama, tipe, level, HP, dan attack power setiap karakter pada GUI Swing.
- Membedakan warna kartu dan tooltip berdasarkan tipe karakter.
- Menampilkan teks level 5 ke atas dengan warna emas dan huruf tebal; ambang level dikelola oleh `AppTheme.GOLD_LEVEL_THRESHOLD`.
- Menampilkan border emas pada kartu level tinggi dan detail HP/ATK di tooltip. Border menonjolkan karakter level tinggi, sementara tooltip memberi akses cepat ke statistik tanpa memanjangkan teks kartu.
- Menjalankan inisialisasi GUI melalui `SwingUtilities.invokeLater()` pada Event Dispatch Thread (EDT).

### Tema tampilan

`AppTheme` menyimpan warna latar, warna teks, font, dan border yang digunakan oleh `MainWindow`. Warna kartu dan tooltip ditentukan oleh tipe karakter:

| Tipe | Warna kartu | Tooltip |
|---|---|---|
| `WARRIOR` | Merah | Jarak dekat, HP tinggi |
| `MAGE` | Biru | Serangan sihir, HP rendah |
| `ARCHER` | Hijau | Jarak jauh, seimbang |
| `HEALER` | Ungu | Pemulihan, HP tinggi |

Untuk mengubah gaya tampilan atau deskripsi tipe, edit konstanta dan metode `colorFor()` atau `describe()` di `src/com/unpri/charactermanager/view/AppTheme.java`.

### Bukti screenshot

Screenshot TP8 [tP8.png](screenshots/tP8.png) mendokumentasikan proses eksekusi sebelumnya. Screenshot GUI sebelum dan sesudah TP10 tersedia pada bagian TP10 di bawah.

## TP10 — Tema, Perluasan, dan Mini-Challenge

### Screenshot sebelum dan sesudah

| Sebelum | Sesudah TP10 |
|---|---|
| ![Tampilan GUI sebelum TP10](<screenshots/tp10 sebelum.png>) | ![Tampilan GUI sesudah TP10](<screenshots/tp10 sesudah.png>) |

### Pemisahan warna dari Model

Warna adalah bagian dari presentasi antarmuka, bukan data atau aturan domain karakter, sehingga tidak disimpan di `Character`. `AppTheme` menjadi satu tempat untuk mengatur palet dan pemetaan warna role agar tampilan konsisten. Dengan pemisahan ini, perubahan tema tidak memerlukan perubahan pada Model. `MainWindow` menggunakan tema tersebut untuk menampilkan karakter tanpa mencampur logika tampilan ke dalam data karakter.

### Properti tambahan kartu

- **Border emas untuk karakter level tinggi:** membantu menonjolkan karakter yang mencapai level ambang.
- **Tooltip berisi HP dan ATK:** memberikan akses cepat ke statistik tanpa membuat teks setiap kartu lebih panjang.

### Analisis GUI & MVC — Bagian D

[Buka Google Docs — Bagian D: Analisis GUI & MVC](https://docs.google.com/document/d/1JDPi8U_Az4XEmBgMA7m4c6W6u-jlbwaB7kSiREIT3rQ/edit)

Dokumen disetel ke **Siapa saja yang memiliki link — Pelihat (Viewer)**.

### Aliran data

`Main` membuat `CharacterManager`, menambahkan data karakter, lalu mengirim hasil `getAllCharacters()` kepada constructor `MainWindow`. `CharacterManager` mengelola koleksi karakter menggunakan `ArrayList<Character>` dan menyediakan operasi CRUD serta statistik, termasuk rata-rata level. `MainWindow` menerima daftar tersebut dan membuat `JLabel` untuk judul serta setiap karakter. Perhitungan rata-rata tersedia pada Model, tetapi belum ditampilkan di jendela. `Main` menjadi titik awal yang menghubungkan data Model dengan View. Controller terpisah belum dibuat; alur aplikasi saat ini berfokus pada penampilan data.

`MainWindow` mewarisi `JFrame` (relasi **is-a**) karena merupakan jenis jendela Swing. Sebaliknya, `CharacterManager` menyimpan `ArrayList<Character>` (relasi **has-a**) sebagai koleksi internal.

## TP5 — CRUD dan object reference

TP5 menambahkan pengelolaan koleksi karakter, termasuk:

- Menambah karakter dan menolak nama duplikat (case-sensitive).
- Mencari serta menghapus karakter berdasarkan nama.
- Menampilkan karakter berdasarkan tipe, jumlah karakter, rata-rata level, dan karakter dengan attack power tertinggi.
- Mengembalikan salinan list melalui `getAllCharacters()` agar pemanggil tidak mengubah koleksi internal secara langsung.

![Screenshot output CRUD Character Manager TP5](screenshots/tp5-crud.png)

![Screenshot eksperimen object reference TP5](screenshots/tp5-reference.png)

Eksperimen reference menunjukkan bahwa dua variabel dapat menunjuk ke objek `Character` yang sama, sehingga perubahan lewat salah satunya terlihat melalui variabel lain. Sebaliknya, `getAllCharacters()` mengembalikan salinan list; menambahkan elemen ke salinan tidak menambah koleksi internal manager.

## Menjalankan program

Dengan JDK terpasang, jalankan perintah berikut dari direktori repository:

```powershell
javac -encoding UTF-8 -d out src\Main.java src\com\unpri\charactermanager\model\Character.java src\com\unpri\charactermanager\model\CharacterType.java src\com\unpri\charactermanager\model\CharacterManager.java src\com\unpri\charactermanager\view\AppTheme.java src\com\unpri\charactermanager\view\MainWindow.java
java -cp out Main
```

## Struktur project

```text
.
├── README.md
├── screenshots/
│   ├── tp10 sebelum.png
│   ├── tp10 sesudah.png
│   ├── tP8.png
│   ├── tp5-crud.png
│   └── tp5-reference.png
└── src/
    ├── Main.java
    └── com/
        └── unpri/
            └── charactermanager/
                ├── model/
                │   ├── Character.java
                │   ├── CharacterManager.java
                │   └── CharacterType.java
                └── view/
                    ├── AppTheme.java
                    └── MainWindow.java
```
