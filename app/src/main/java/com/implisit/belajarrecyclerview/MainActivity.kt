package com.implisit.belajarrecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        _rvWayang = findViewById<RecyclerView>(R.id.rv_wayang)


        fun SiapakanData() {
            _nama = resources.getStringArray(R.array.namaWayang)
            _karakter = resources.getStringArray(R.array.deskripsiWayang)
            _deskripsi = resources.getStringArray(R.array.karakterUtamaWayang)
            _gambar = resources.getStringArray(R.array.gambarWayang)

        }

        fun tambahData() {
            for (position in _nama.indices) {
                val wayang = wayang(
                    _gambar[position],
                    _nama[position],
                    _karakter[position],
                    _deskripsi[position]
                )
                arwayang.add(wayang)
            }
        }

        fun tampilkanData() {
            _rvWayang.layoutManager = GridLayoutManager(this,2)
            _rvWayang.adapter = adapterRevView(arwayang)
        }

        _rvWayang = findViewById<RecyclerView>(R.id.rv_wayang)
        SiapakanData()
        tambahData()
        tampilkanData()
    }

    private lateinit var _nama: Array<String>
    private lateinit var _karakter: Array<String>
    private lateinit var _deskripsi: Array<String>
    private lateinit var _gambar: Array<String>

    private lateinit var _rvWayang: RecyclerView

    private var arwayang = arrayListOf<wayang>()
}