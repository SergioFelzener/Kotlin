package br.senac.materialcomponents

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabPageAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when (position){
            1 -> return AlbumFrag.newInstance()
            2 -> return ArtistFrag.newInstance()
            else -> return RecentsFrag.newInstance()
        }

    }


}