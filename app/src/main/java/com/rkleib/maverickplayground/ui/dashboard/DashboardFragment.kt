package com.rkleib.maverickplayground.ui.dashboard

import android.os.Bundle
import android.view.View
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.rkleib.maverickplayground.BaseFragment
import com.rkleib.maverickplayground.R
import com.rkleib.maverickplayground.databinding.FragmentDashboardBinding
import com.rkleib.maverickplayground.viewBinding

data class DashboardState(val count: Int = 0) : MavericksState

class DashboardFragment : BaseFragment(R.layout.fragment_dashboard), MavericksView {
    private val binding: FragmentDashboardBinding by viewBinding()
    private val viewModel: DashboardViewModel by fragmentViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnCount.setOnClickListener {
            viewModel.count()
        }
    }

    override fun invalidate() = withState(viewModel) { state ->
        binding.textDashboard.text = state.count.toString()
    }
}