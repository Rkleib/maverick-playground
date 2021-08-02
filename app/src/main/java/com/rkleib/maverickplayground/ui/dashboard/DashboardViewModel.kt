package com.rkleib.maverickplayground.ui.dashboard

import com.airbnb.mvrx.MavericksViewModel

class DashboardViewModel(initialState: DashboardState) : MavericksViewModel<DashboardState>(initialState) {
    fun count() = setState { copy(count = count + 1) }
}