# Solusi Tutorial APAP 2020/2021
Solusi setiap tutorial mata kuliah APAP 2020/2021 untuk topik Traveloke dan Haidokter.

---

## Jawaban Pertanyaan Tutorial 
1. Cobalah untuk menambahkan sebuah resep dengan mengakses link berikut:
   http://localhost:8080/resep/add?noResep=1&namaDokter=Papa%20APAP&namaPasien=Quanta%20Fasilkom&catatan=Semangat Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi

   Akan terjadi whitelabel error, dikarenakan belum ada template "add-resep.html", sehingga hasil return pada controller terjadi error.

2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat?

   Konsep Inversion of Control, lebih tepatnya Dependency Injection. Class controller nantinya akan menerima injection pada keseluruhan isi pada class service.
   
3. Cobalah untuk menambahkan sebuah resep dengan mengakses link berikut: http://localhost:8080/resep/add?noResep=1&namaDokter=Papa%20APAP&namaPasien=Quanta%20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi?

   Terjadi error, dikarenakan kekurangan parameter "catatan", yang sudah di state bahwa parameter tersebut bersifat required.

4. Jika Papa APAP ingin melihat resep untuk pasien yang bernama Quanta, link apa yang harus diakses?

   http://localhost:8080/resep/view/?noResep=1
   
5. Tambahkan 1 contoh resep lainnya sesukamu. Lalu cobalah untuk mengakses
    
    Add Resep ![Add resep](https://i.ibb.co/jV3nwmB/tutorial-apap.png)
    
    View All![View All](https://i.ibb.co/X7BsVyj/tutorial-apap-2.png")