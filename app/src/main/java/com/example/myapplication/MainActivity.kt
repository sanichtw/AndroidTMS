package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        setSupportActionBar(binding.toolbar)
//
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }

        // Find the button by id
        val button = findViewById<Button>(R.id.button)

        // Set the listener to the button
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // Log the homework
        Homework().main()
    }
}

class Homework {
    fun main() {
        logMutableList()
        logMutableSet()
        logReadOnlyMap()
    }

    private fun logMutableList() {
        // creating mutable list collection and output each element to the logs
        val mutableListCollection = mutableListOf("mutable", "list", null, "collection")
        Log.d("TEST ANDROID", "Mutable List Collection:")

        for (el in mutableListCollection) el?.let { Log.d("TEST ANDROID", "\t${el}") }
        Log.d("TEST ANDROID", "\n")
    }

    private fun logMutableSet() {
        // creating mutable set collection and output each element to the logs
        val mutableSetCollection = setOf("mutable", "set", "collection", null)
        Log.d("TEST ANDROID", "Mutable Set Collection:")

        for (el in mutableSetCollection) el?.let { Log.d("TEST ANDROID", "\t${el}") }
        Log.d("TEST ANDROID", "\n")
    }

    private fun logReadOnlyMap() {
        // creating read-only map collection and output each element to the logs
        val readOnlyMapCollection = mapOf("read-only" to 1, "map" to 2 ,"collection" to 4)
        Log.d("TEST ANDROID", "Read-only Map Collection:")

        for (el in readOnlyMapCollection) el?.let { Log.d("TEST ANDROID", "\t${el}") }
    }
}