package com.example.learnfragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.learnfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentManager = supportFragmentManager

        // Load Fragment1 by default when the app starts
        if (savedInstanceState == null) {
            goToFragment(Fragment1())
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonFragment1.setOnClickListener {
            goToFragment(Fragment1())
        }
        binding.buttonFragment2.setOnClickListener {
            goToFragment(Fragment2())
        }
    }

    private fun goToFragment(fragment: Fragment) {
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
