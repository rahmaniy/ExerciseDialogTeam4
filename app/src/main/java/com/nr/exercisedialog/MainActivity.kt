package com.nr.exercisedialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
    }
}