package com.nr.exercisedialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.nr.exercisedialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val btnAlertDialogStandard = findViewById<Button>(R.id.btn_alert_dialog_standard)
        val btnAlertDialogFragment = findViewById<Button>(R.id.btn_alert_dialog_fragment)

        btnAlertDialogStandard.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Dialog Cancelable")
            dialog.setMessage("Dialog cancelable bisa ditutup dengan klik bagian luar dialog")
            dialog.setCancelable(true)
            dialog.show()
        }

        btnAlertDialogFragment.setOnClickListener {
            val dialogFragment = ExampleDialogFragment("Noverina")
            dialogFragment.show(supportFragmentManager,null)
        }

        binding.btnAlertWithButton.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Dialog Button")
            dialog.setMessage("Dialog with button")
            dialog.setIcon(R.drawable.ic_baseline_account_circle_24)

            dialog.setCancelable(false)
            dialog.setPositiveButton("Ini Button") { dialogInterface, p1 ->
                Toast.makeText(this, "You click the button", Toast.LENGTH_LONG).show()
            }
            dialog.show()
        }

        binding.btnAlertCostume.setOnClickListener {
            val view = LayoutInflater.from(this).inflate(R.layout.dialog_costume, null, false)
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setView(view)

            val dialog = dialogBuilder.create()

            view.findViewById<Button>(R.id.btn_login).setOnClickListener {
                Toast.makeText(this, "Berhasil Login", Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }
            dialog.show()
        }
    }
}