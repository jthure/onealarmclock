package com.jonasthuresson.onealarmclock.ui.alarms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.jonasthuresson.onealarmclock.R

class AlarmsMainFragment : Fragment() {

    companion object {
        fun newInstance() = AlarmsMainFragment()
    }

    private val viewModel by viewModels<AlarmsViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.alarms
    }

}