package com.utama.a1_mo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val nama = intent.getStringExtra("nama") ?: ""
        val kategori = intent.getStringExtra("kategori") ?: ""
        val stok = intent.getStringExtra("stok") ?: ""
        val harga = intent.getStringExtra("harga") ?: ""
        val deskripsi = intent.getStringExtra("deskripsi") ?: ""

        findViewById<TextView>(R.id.tvNama).text = "Nama: $nama"
        findViewById<TextView>(R.id.tvKategori).text = "Kategori: $kategori"
        findViewById<TextView>(R.id.tvStok).text = "Stok: $stok"
        findViewById<TextView>(R.id.tvHarga).text = "Harga: Rp $harga"
        findViewById<TextView>(R.id.tvDeskripsi).text = "Deskripsi: $deskripsi"
    }
}