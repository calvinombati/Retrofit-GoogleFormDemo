package com.sheecodes.retrofit_googleformdemo

import android.R
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sheecodes.retrofit_googleformdemo.databinding.ActivityMainBinding
import com.sheecodes.retrofit_googleformdemo.network.FormApi
import retrofit2.Callback
import retrofit2.Response


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSubmit.setOnClickListener {
/*
            val radioGroup = binding.radioSex
            val radioButtonID = radioGroup.checkedRadioButtonId
            val radioButton = radioGroup.findViewById<View>(radioButtonID) as RadioButton

            val selectedText = radioButton.text as String*/

            // get selected radio button from radioGroup
            val selectedId: Int = binding.radioSex.checkedRadioButtonId

            // find the radiobutton by returned id
            val gender = (findViewById<RadioButton>(selectedId)).text.toString()

            //CheckBoxes
            val kotlin = binding.kotlinCheckBox.isChecked
            val java = binding.javaCheckBox.isChecked
            val dart = binding.dartCheckBox.isChecked
            val swift = binding.swiftCheckbox.isChecked

            FormApi.api.submitResponse(
                binding.edtEmail.text.toString(),
                binding.edtFullName.text.toString(),
                binding.edtGithub.text.toString(),
                gender,
                if (kotlin) {
                    "Kotlin"
                } else null,
                if (java) {
                    "Java"
                } else null,
                if (dart) {
                    "Dart"
                } else null,
                if (swift) {
                    "Swift"
                } else null,
            ).enqueue(object : Callback<Void> {

                override fun onResponse(call: retrofit2.Call<Void>, response: Response<Void>) {
                    Toast.makeText(
                        applicationContext,
                        "Form data submitted successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onFailure(call: retrofit2.Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }
}