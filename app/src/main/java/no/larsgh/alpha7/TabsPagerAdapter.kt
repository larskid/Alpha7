package no.larsgh.alpha7

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabsPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle, private var numberOfTabs: Int) : FragmentStateAdapter(fm, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                val bundle = Bundle()
                bundle.putString("fragmentName", "Kinoprogram")
                val kinoprogFrag = YeetusTab()
                kinoprogFrag.arguments = bundle
                return kinoprogFrag
            }
            1 -> {
                val bundle = Bundle()
                bundle.putString("fragmentName", "Kommende filmer")
                val comfilmFrag = YeetusTab()
                comfilmFrag.arguments = bundle
                return comfilmFrag
            }
            2 -> {
                val bundle = Bundle()
                bundle.putString("fragmentName", "Søk film")
                val sookfilmFrag = YeetusTab()
                sookfilmFrag.arguments = bundle
                return sookfilmFrag
            }
            else -> return YeetusTab()
        }
    }

    override fun getItemCount(): Int {
        return numberOfTabs
    }
}