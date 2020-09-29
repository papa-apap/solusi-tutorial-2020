# Solusi Tutorial APAP 2020/2021
Solusi setiap tutorial mata kuliah APAP 2020/2021 untuk topik Traveloke dan Haidokter.

Solusi kedua topik akan dibedakan berdasarkan branch.

---

## Jawaban Catatan Tutorial 1
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?

   Issue Tracker adalah sebuah fitur yang dapat membantu *developer* untuk melakukan *tracking* terhadap masalah-masalah yang ada dalam suatu *repository*. Issue Tracker dapat digunakan untuk mendapatkan *feedback* dari pengguna atau *collaborator*, melaporkan *bug* yang ada dalam kode, serta membantu *developer* mencatat dan memprioritaskan masalah-masalah yang ada. Secara umum, Issue Tracker dapat digunakan sebagai *to-do list* agar *developer* dapat mendiskusikan dan melakukan perbaikan terhadap kode.

2. Apa perbedaan dari git merge dan git merge --squash?

   Saat kita melakukan `git merge` terhadap suatu *branch* ke *branch* lainnya, misalnya dalam suatu kasus sebuah *branch* Feature ke *branch* Master, maka semua commit yang ada pada branch Feature akan masuk ke dalam *history commit* yang ada pada *branch* Master. Saat kita melakukan `git merge --squash`, maka hanya akan ada satu commit dari *branch* Feature yang akan masuk ke dalam *branch* Master, sehingga akan menghasilkan *history commit* yang lebih rapi.

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?

   Version Control System membantu merekam perubahan yang terjadi pada kode aplikasi. Dengan bantuan Version Control System, kolaborasi dalam membuat aplikasi juga akan lebih mudah, karena setiap *developer* dapat memiliki versi aplikasinya tersendiri dalam *local environment*-nya, yang pada nantinya dapat digabungkan menjadi satu dengan **merging**. Selain itu, apabila suatu versi terdapat masalah, maka Version Control System memberikan kemampuan bagi *developer* untuk membandingkan versi tersebut dengan versi sebelum-sebelumnya, sehingga masalah yang muncul dapat teratasi dengan cepat.

### Spring
4. Apa itu library & dependency?

   Library adalah suatu kumpulan kode yang dikompilasikan dan disimpan dalam suatu *file*. *File* tersebut dapat digunakan oleh *developer* untuk membuat suatu aplikasi. Pada umumnya, library berisi kumpulan-kumpulan *function* dan *method* yang dapat dipanggil sesuai dengan kebutuhan. Fungsi-fungsi tersebut juga dapat di-*override* agar dapat disesuaikan dengan kebutuhan. Dengan bantuan library, beban kerja seorang *developer* dapat berkurang karena tidak perlu fokus terhadap pembuatan *method* tertentu. Dependency adalah suatu istilah dimana suatu perangkat lunak bergantung pada perangkat lunak lainnya untuk berjalan. Jika dependency dari suatu perangkat lunak belum ada atau belum di-*install*, maka perangkat lunak tersebut tidak bisa berjalan dengan semestinya.

5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?


6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?
