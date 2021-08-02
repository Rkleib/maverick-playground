package com.rkleib.maverickplayground.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.rkleib.maverickplayground.BaseFragment
import com.rkleib.maverickplayground.databinding.FragmentDashboardBinding
import retrofit2.Response

data class DashboardState(val count: Int = 0) : MavericksState

class DashboardFragment : BaseFragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DashboardViewModel by fragmentViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnCount.setOnClickListener {
            viewModel.count()
        }
    }

    override fun invalidate() = withState(viewModel) { state ->
        binding.textDashboard.text = state.count.toString()
    }


}