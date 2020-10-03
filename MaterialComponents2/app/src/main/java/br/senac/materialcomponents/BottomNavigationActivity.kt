package br.senac.materialcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_botton_navigation.*

class BottomNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_botton_navigation)

        val fragRecents = RecentsFrag.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.container, fragRecents).commit()

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {

                R.id.recents -> {
                    val fragRecents = RecentsFrag.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.container, fragRecents).commit()
                }

                R.id.albuns -> {
                    val fragAlbuns = AlbumFrag.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.albuns, fragAlbuns).commit()
                }
                R.id.artists -> {
                    val fragArtists = ArtistFrag.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.artists, fragArtists).commit()
                }

            }

            true
        }
    }
}