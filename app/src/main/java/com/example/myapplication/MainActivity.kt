package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val boton = findViewById<Button>(R.id.btn_open_activity)
        val miClick = MiOnClick()

        boton.setOnClickListener(miClick)
//        boton.setOnClickListener(View.OnClickListener {
//            Toast.makeText(this@MainActivity, "texto", Toast.LENGTH_SHORT).show()
//            val intent = Intent(this, MainActivity2::class.java)
//            intent.putExtra("key", "value")
//            startActivity(intent)
//        })
    }

    override fun onStart() {
        super.onStart()
        Log.i("Main", "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Main", "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Main", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Main", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Main", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Main", "onDestroy")
    }
}

class MiOnClick : View.OnClickListener {
    override fun onClick(p0: View?) {
        Toast.makeText(p0?.context, "texto", Toast.LENGTH_SHORT).show()
        val intent = Intent(p0?.context, MainActivity2::class.java)
        intent.putExtra("key", "value")
        p0?.context?.startActivity(intent)
    }
}