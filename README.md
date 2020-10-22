# Solusi Tutorial APAP 2020/2021
Solusi setiap tutorial mata kuliah APAP 2020/2021 untuk topik Traveloke dan Haidokter.

---

## Jawaban Pertanyaan Tutorial 
1. Jelaskan perbedaan th:include dan th:replace!

   Jika kita menggunakan `th:include`, maka kontent fragment akan berada didalam tag pemanggil `th:include` tersebut. Contoh : `<div class="cth" th:include="..."> content </div>`. Maka, isi dari fragment yang dipanggil berada di dalam div (class cth). Sedangkan, jika kita menggunakan `th:replace`, fragment yang dipanggil bukan berada di dalam tag yang memanggil. Melainkan, tag pemanggil akan di replace dengan fragmentnya

2. Jelaskan apa fungsi dari th:object!
   
   `th: objek` digunakan untuk menentukan objek yang akan diikat oleh data form untuk nantinya atribut-atribut dari objek tersebut digunakan pada field form di html.
   
3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?

   Ketika menggunakan th:object, form akan dihubungkan dengan sebuah model yang kita kirimkan. Dalam contoh soal adalah ${resep}. Tanda $ berguna untuk mengambil objek model yang kita passing dari controller untuk dihubungkan ke form. Sedangkan tanda * berguna untuk menunjuk atribut dari object yang digunakan pada form dalam kasus ini *{listObat} mengambil daftar obat dari resep saat ini.

4. Bagaimana kamu menyelesaikan latihan nomor 3?

   Terdapat beberapa cara untuk menyelesaikan latihan ini. Cara yang akan digunakan kali ini adalah dengan melakukan passing variable dari HTML ke fragment.

   - Pertama pada fragment tambahkan penggunaan variabel yang ingin digunakan, dalam contoh ini variable bernama 'current'.
      `<a href="#" th:text="${current}"></a>`

   - Kemudian pada file HTML yang menggunakan fragment navbar, kita dapat menambahkan argumen seperti berikut ini ke fragment. Contoh pada home.html.
   `<nav th:replace="fragments/fragment :: navbar (current='Home')"></nav>`