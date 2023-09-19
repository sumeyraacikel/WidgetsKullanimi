package com.example.widgetskullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import com.example.widgetskullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var kontrol = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonMutlu.setOnClickListener {
            binding.imageView.setImageResource(R.drawable.mutlu_resim)
        }
        binding.buttonOnay.setOnClickListener {
            binding.imageView.setImageResource(resources.getIdentifier("onay_resim","drawable",packageName))

        }
        binding.toogleButton.addOnButtonCheckedListener{group,checkId, isChecked ->
            kontrol = isChecked
            if (kontrol){
                val secilenButton = findViewById<Button>(checkId)
                val buttonYazi = secilenButton.text.toString()
                Log.e("Sonuc", buttonYazi)
            }
        }

        val ulkeler = ArrayList<String>()
        ulkeler.add("Türkiye")
        ulkeler.add("İtalya")
        ulkeler.add("Japonya")

        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, ulkeler)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        binding.buttonGoster.setOnClickListener {
            if (kontrol){
                    val secilenButton = findViewById<Button>(binding.toogleButton.checkedButtonId)
                    val buttonYazi = secilenButton.text.toString()
                    Log.e("Sonuc son durum", buttonYazi)
                }
            Log.e("Sonuc ülke", binding.autoCompleteTextView.text.toString())
            }
        }
    }
