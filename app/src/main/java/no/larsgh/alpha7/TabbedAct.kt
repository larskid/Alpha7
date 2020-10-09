package no.larsgh.alpha7

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_tabbed.*

class TabbedAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabbed)
        tab_layout.setSelectedTabIndicatorColor(Color.WHITE)
        tab_layout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
        tab_layout.tabTextColors = ContextCompat.getColorStateList(this, android.R.color.white)

        val numberOfTabs = 3

        tab_layout.tabMode = TabLayout.MODE_FIXED

        tab_layout.isInlineLabel = true

        val adapter = TabsPagerAdapter(supportFragmentManager, lifecycle, numberOfTabs)
        tabs_viewpager.adapter = adapter

        tabs_viewpager.isUserInputEnabled = true

        TabLayoutMediator(tab_layout, tabs_viewpager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Kinoprogram"
                    tab.setIcon(R.drawable.baseline_date_range_white_18dp)
                }
                1 -> {
                    tab.text = "Kommende filmer"
                    tab.setIcon(R.drawable.ic_movie)

                }
                2 -> {
                    tab.text = "Filmsøk"
                    tab.setIcon(R.drawable.quantum_ic_search_grey600_24)
                }

            }

            tab.icon?.colorFilter =
                BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                    Color.WHITE,
                    BlendModeCompat.SRC_ATOP
                )
        }.attach()

    }
}
