# Solusi Tutorial APAP 2020/2021
Solusi setiap tutorial mata kuliah APAP 2020/2021 untuk topik Traveloke dan Haidokter.

Solusi setiap tutorial akan dibedakan berdasarkan branch.
=======
---

## Jawaban Pertanyaan Tutorial 
1. Apa itu Postman? Apa kegunaannya?

    Postman adalah aplikasi yang digunakan untuk berinteraksi dengan API menggunakan HTTP request.
    Dengan Postman, kita dapat memastikan fungsionalitas suatu API dengan mudah,
    tanpa harus menulis kodingan yang panjang. Selain itu, Postman juga dapat digunakan untuk
    melakukan automated testing, mensimulasikan endpoint API, melakukan monitoring terhadap kinerja
    API, dan menulis dokumentasi API.
2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
    - `@JsonIgnoreProperties` digunakan untuk mengabaikan suatu atribut dalam serialisasi dan deserialisasi
    JSON. `JsonIgnoreProperties` diletakkan pada class level, bukan pada properti yang ada dalam class
    tersebut.
    - `@JsonProperty` digunakan untuk memetakan nama properti yang diberikan pada JSON terhadap properti
    di class Java yang bersangkutan. Misalnya, suatu atribut `name` memiliki `@JsonProperty` berupa `className`,
    maka saat dikirim JSON dengan parameter `className`, parameter tersebut akan menjadi atribut `name` pada
    class yang bersangkutan.
3. Apa kegunaan atribut WebClient?
    WebClient adalah interface yang dapat digunakan untuk melakukan HTTP request terhadap Rest Service di luar
    aplikasi. WebClient bisa digunakan untuk membuat API Consumer atau Producer, sehingga aplikasi lain
    juga dapat berinteraksi dengan API yang ada pada aplikasi kita.
4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
    - `ResponseEntity` merepresentasikan HTTP response dengan isi berupa status, code, header, dan body.
    Dengan `ResponseEntity`, kita dapat mengatur response apa yang kita harapkan saat melakukan suatu
    HTTP request.
    - `BindingResult` adalah sebuah objek dari Spring yang menyimpan hasil dari validasi dan juga error
    yang terjadi saat dilakukannya validasi tersebut. `BindingResult` biasanya dipanggil dalam suatu
    method di Controller setelah pemanggilan objek Model yang diperlukan validasi. Biasanya BindingResult
    digunakan untuk memastikan form yang sudah disubmit memiliki isi yang sudah sesuai. 
