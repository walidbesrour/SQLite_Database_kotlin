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
        var db = DataBaseHandler(this)

        binding.btnInsert.setOnClickListener {
            if (binding.name.text.toString().length > 0 && binding.age.text.toString().length > 0){
            var user = User(binding.name.text.toString(),binding.age.text.toString().toInt())

                db.insertData(user)
            }else{
                Toast.makeText(this,"Please Fill all Data's", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnRead.setOnClickListener {
            var data = db.readList()
            binding.tvResult.text = ""
            for (i in 0..(data.size - 1)){
                binding.tvResult.append(data.get(i).id.toString() +
                "  " + data.get(i).name +"  "+ data.get(i).age + "\n")

            }
        }

        binding.btnDelete.setOnClickListener {
            db.deleteData()
            binding.btnRead.performClick()
        }

        binding.btnUpdate.setOnClickListener {
            db.updateData()
            binding.btnRead.performClick()
        }
    }
}
