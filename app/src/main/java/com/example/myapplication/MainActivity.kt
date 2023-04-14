package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val button = findViewById<Button>(R.id.button)

        // Set the listener to the button
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}

// create first class
open class TestA {
    open val name = "Nikita"

    open fun getNameS(): String {
        return name
    }

    open fun greets() {
        println("Hello ${getNameS()}!")
    }

    open fun bye() {
        println("Bye ${getNameS()}!")
    }
}

// create second class
open class TestB: TestA() {
    override val name = "Nikitos"

    override fun getNameS(): String {
        return name
    }

    override fun greets() {
        println("Zdarova, ${getNameS()}!")
    }

    override fun bye() {
        println("Davaj, ydachi ${getNameS()}!")
    }
}

// create third class
open class TestC: TestB() {
    override var name = "Unknown"

    fun setName() {
        name = "Random name"
    }

    override fun getNameS(): String {
        return super.getNameS()
    }

    override fun greets() {
        println("Zdarova kak tebya tam..")
    }
}