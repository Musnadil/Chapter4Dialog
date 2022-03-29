package com.musnadil.chapter4dialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.musnadil.chapter4dialog.databinding.FragmentCustomDialogBinding

class CustomDialogFragment() : DialogFragment() {
    lateinit var binding:FragmentCustomDialogBinding
    lateinit var name :String
    constructor(name:String):this(){
        this.name = name
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCustomDialogBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (this::name.isInitialized){
            binding.tvNama.text = name
        }
        binding.btnFragDial.setOnClickListener {
            Toast.makeText(activity, "clicked", Toast.LENGTH_SHORT).show()
            dialog?.dismiss()
        }
    }


}