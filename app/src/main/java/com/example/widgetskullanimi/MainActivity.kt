package com.example.widgetskullanimi

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import com.example.widgetskullanimi.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

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

        binding.buttonToast.setOnClickListener {
            Toast.makeText(this,"Merhaba", Toast.LENGTH_SHORT).show()
        }
        binding.buttonSnackbar.setOnClickListener {
            Snackbar.make(it, "Silmek istiyor musunuz?", Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                    Snackbar.make(it, "Silindi", Snackbar.LENGTH_SHORT).show()

                }
                .setBackgroundTint(Color.WHITE)
                .setTextColor(Color.BLUE)
                .setActionTextColor(Color.RED)
                    .show()
        }
        binding.buttonDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle( "Başlık")
                .setMessage("Mesaj")
                .setPositiveButton("Tamam"){d, i ->
                    Toast.makeText(this,"Tamam seçildi", Toast.LENGTH_SHORT).show()

                }
                .setNegativeButton("iptal"){d, i ->
                    Toast.makeText(this,"iptal seçildi", Toast.LENGTH_SHORT).show()

                }
                .show()
        }

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
