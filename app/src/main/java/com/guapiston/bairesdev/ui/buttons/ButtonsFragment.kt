package com.guapiston.bairesdev.ui.buttons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.guapiston.bairesdev.R

class ButtonsFragment : Fragment(){
    lateinit var buttonAlert : Button
    lateinit var buttonToast : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_buttons,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonAlert = view.findViewById(R.id.btn_alert)
        buttonAlert.setOnClickListener { showAlert() }
        buttonToast = view.findViewById(R.id.btn_toast)
        buttonToast.setOnClickListener { showToast() }
    }

    private fun showToast(message : String = "This is the toast message"){
        Toast.makeText(context,message , Toast.LENGTH_LONG).show()
    }

    private fun showAlert(){
        context?.let {
            AlertDialog.Builder(it).apply {
                setTitle("Alert dialog title")
                setMessage("This is the alert dialog message")
                show()
            }
        }
    }

    companion object{
        var instance : ButtonsFragment? = null
        fun newInstance() : ButtonsFragment{
            if (instance == null) instance = ButtonsFragment()
            return instance!!
        }
    }
}