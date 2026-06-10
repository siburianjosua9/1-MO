package com.utama.a1_mo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BarangAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        loadData()
    }

    private fun loadData() {
        RetrofitClient.instance.getBarang()
            .enqueue(object : Callback<List<Barang>> {

                override fun onResponse(
                    call: Call<List<Barang>>,
                    response: Response<List<Barang>>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body() ?: emptyList()
                        adapter = BarangAdapter(data)
                        recyclerView.adapter = adapter
                    }
                }

                override fun onFailure(
                    call: Call<List<Barang>>,
                    t: Throwable
                ) {
                    Toast.makeText(
                        this@MainActivity,
                        "Error: ${t.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }
}