package com.musnadil.chapter4dialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.musnadil.chapter4dialog.databinding.ActivityMainBinding
import com.musnadil.chapter4dialog.databinding.LayoutCustomDialogBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDialog.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Binar")
                .setMessage("Hallo Android 4")
                .setCancelable(false)
                .setPositiveButton("Positive Button", DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this, "Positive Button Clicked", Toast.LENGTH_SHORT).show()
                })
                .setNegativeButton("Negative Button", DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this, "Negative Button Clicked", Toast.LENGTH_SHORT).show()
                })
                .setNeutralButton("Neutral Button", DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this, "Neutral Button Clicked", Toast.LENGTH_SHORT).show()
                })
                .show()
        }
        binding.btnCustomDialog.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
            val dialogBinding = LayoutCustomDialogBinding.inflate(LayoutInflater.from(this))
            alertDialog.setView(dialogBinding.root)
            val dialog = alertDialog.create()

            dialogBinding.btnOk.setOnClickListener { 
                dialog.dismiss()
                Toast.makeText(this, "sudah di klik", Toast.LENGTH_SHORT).show()
            }
            dialog.show()
        }

    }
}