package com.utama.a1_mo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BarangAdapter(
    private val listBarang: List<Barang>
) : RecyclerView.Adapter<BarangAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNama: TextView = itemView.findViewById(R.id.tvNama)
        val tvKategori: TextView = itemView.findViewById(R.id.tvKategori)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_barang, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val barang = listBarang[position]

        holder.tvNama.text = barang.nama_barang
        holder.tvKategori.text = barang.kategori

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("nama", barang.nama_barang)
            intent.putExtra("kategori", barang.kategori)
            intent.putExtra("stok", barang.stok)
            intent.putExtra("harga", barang.harga)
            intent.putExtra("deskripsi", barang.deskripsi)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listBarang.size
}