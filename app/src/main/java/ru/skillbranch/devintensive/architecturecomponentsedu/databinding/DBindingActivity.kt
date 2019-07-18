package ru.skillbranch.devintensive.architecturecomponentsedu.databinding

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.skillbranch.devintensive.architecturecomponentsedu.R

class DBindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dbinding)

        val binding : ActivityDbindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_dbinding)
        val viewModel = ViewModelProviders.of(this).get(DBindingViewModel::class.java)

        binding.viewmodel = viewModel

        viewModel.editTextContent.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

    }
}
