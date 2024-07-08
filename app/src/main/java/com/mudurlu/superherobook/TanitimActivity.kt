package com.mudurlu.superherobook

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mudurlu.superherobook.databinding.ActivityMainBinding
import com.mudurlu.superherobook.databinding.ActivityTanitimBinding

class TanitimActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTanitimBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTanitimBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //val adapterdenGelenVeri = intent.getSerializableExtra("veri",SuperHero::class.java)
        val adapterdenGelenVeri = intent.getSerializableExtra("veri")as SuperHero

        binding.imageView.setImageResource(adapterdenGelenVeri.gorsel)
        binding.textKahraman.text = adapterdenGelenVeri.kahraman
        binding.textIsim.text = adapterdenGelenVeri.isim
        binding.textMeslek.text = adapterdenGelenVeri.meslek


    }
}