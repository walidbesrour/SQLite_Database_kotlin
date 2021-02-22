package com.example.sqlite_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sqlite_database.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInsert.setOnClickListener {
            if (binding.name.text.toString().length > 0 && binding.age.text.toString().length > 0){
            var user = User(binding.name.text.toString(),binding.age.text.toString().toInt())
            var db = DataBaseHandler(this)
                db.insertData(user)
            }else{
                Toast.makeText(this,"Please Fill all Data's", Toast.LENGTH_LONG).show()
            }
        }
    }
}
