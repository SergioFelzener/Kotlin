package br.senac.materialcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pageAdapter = TabPageAdapter(this)

        viewPager.adapter = pageAdapter

        val tabLayMediator = TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position) {
                0 -> {
                    tab.text = "Recents"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.recent)
                }
                1 -> {
                    tab.text = "Albuns"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.album)
                }
                2 -> {
                    tab.text = "Artists"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.music)
                }
            }

        }
        tabLayMediator.attach()

    }
}