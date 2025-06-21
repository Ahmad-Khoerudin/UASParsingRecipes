**ParsingRecipe**

Aplikasi Android sederhana untuk menampilkan daftar resep masakan menggunakan REST API.

**Fitur**

- Menampilkan daftar resep dari API

- Detail resep lengkap dengan bahan dan cara memasak

- Loading gambar dengan Glide

- Interface yang responsif

**Screenshot**

Main Screen - Daftar Resep Detail Screen - Detail Resep

**Teknologi**

- Language: Java

- API: DummyJSON Recipes

- Libraries:

      - Retrofit - HTTP client

      - Glide - Image loading

      - RecyclerView - List display
**Instalasi**

1. Clone repository ini

2. Buka dengan Android Studio

3. Sync Gradle dan jalankan aplikasi

**Dependencies**

      gradle

    // Networking
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.google.code.gson:gson:2.10.1'
    
    // Image Loading
    implementation 'com.github.bumptech.glide:glide:4.16.0'
    
    // UI Components
    implementation 'androidx.recyclerview:recyclerview:1.3.2'
    implementation 'androidx.cardview:cardview:1.0.0'

**Struktur Project**
    
    MainActivity.java - Menampilkan daftar resep 

    DetailActivity.java - Menampilkan detail resep 

    RecipeAdapter.java - Adapter untuk RecyclerView 

    DataRecipes.java - Model data resep 

    APIService.java - Interface Retrofit 

    APIConfig.java - Konfigurasi Retrofit

**API**
Menggunakan API dari DummyJSON:

- URL: https://dummyjson.com/recipes

- Method: GET

- Format: JSON
