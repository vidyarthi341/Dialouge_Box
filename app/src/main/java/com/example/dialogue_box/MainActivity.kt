package com.example.dialogue_box

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dialogue_box.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.tvQuestion1.setOnClickListener {


            var builder1 = AlertDialog.Builder(this)
            builder1.setTitle("In which Language you have done mastery?")
            var options = arrayOf("C", "Java", "Kotlin", "Python")
            var ans = "C"
            builder1.setSingleChoiceItems(options, 0,
            ){ dialog, which ->

                 ans = options[which]

            }
            builder1.setPositiveButton("Submit"){ dialog, which ->
                Toast.makeText(this, "You have selected $ans", Toast.LENGTH_SHORT).show()
            }
            builder1.setNegativeButton("cancel",DialogInterface.OnClickListener { dialog, which ->

                Toast.makeText(this, "You have cancelled", Toast.LENGTH_SHORT).show()

            })
            builder1.show()

        }

        binding.tvQuestion2.setOnClickListener {

            var builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Select your Skills")
            var option = arrayOf("Android", "IOS", "Web", "ML")
            val selectedItems = mutableListOf<Int>()
            builder2.setMultiChoiceItems(
                option, null,
            ) { dialog, which, isChecked ->

                if (isChecked) {
                    selectedItems.add(which)
                } else {
                    selectedItems.remove(which)
                }

            }
            builder2.setPositiveButton("Submit") { dialog, which ->
                Toast.makeText(
                    this,
                    "You have selected ${selectedItems.size} skills: ${selectedItems.map { option[it] }}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            builder2.setNegativeButton("Cancel"){ dialog, which ->

                Toast.makeText(this, "You have cancelled", Toast.LENGTH_SHORT).show()

            }

            builder2.show()
        }
        binding.tvQuestion3.setOnClickListener {

        var builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Select your Gender")
            var gender  = arrayOf("Male", "Female", "Other")

            var gnd = "Male"

            builder3.setSingleChoiceItems(gender, 0,
            ){ dialog, which ->
                gnd= gender[which]
            }
            builder3.setPositiveButton("Submit"){ dialog, which ->
                Toast.makeText(this, "You have selected $gnd", Toast.LENGTH_SHORT).show()
            }
            builder3.setNegativeButton("Cancel"){ dialog, which ->
                Toast.makeText(this, "You have cancelled", Toast.LENGTH_SHORT).show()
            }
           builder3.show()


        }

        binding.btnExit.setOnClickListener {

        var builder = AlertDialog.Builder(this)
            builder.setTitle("Are you sure")
            builder.setMessage("Really do you want to exit?")
            builder.setIcon(R.drawable.baseline_exit_to_app_24)


            builder.setPositiveButton("Yes"){dialogInterface, which ->
                finish()
            }
            builder.setNegativeButton("No"){dialogInterface, which ->

            }
            builder.show()

        }

    }
}

