package com.jonasthuresson.onealarmclock.android.ui.triggeredalarm

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.jonasthuresson.onealarmclock.R
import com.jonasthuresson.onealarmclock.android.services.BaseSoundService
import com.jonasthuresson.onealarmclock.android.services.SoundService
import com.jonasthuresson.onealarmclock.android.ui.BaseFragment
import kotlinx.android.synthetic.main.triggered_alarm_fragment.*

class TriggeredAlarm() : BaseFragment() {

    private val args: TriggeredAlarmArgs by navArgs()

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var viewModel: TriggeredAlarmViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = getViewModel(TriggeredAlarmViewModel::class.java)
        viewModel.triggeredAlarm.observe(viewLifecycleOwner, Observer{alarm ->
            alarm_time_text_view.text = alarm.time.toString()
        })
        setupDismissAlarmButton()
        viewModel.fetchTriggeredAlarm(args.alarmId)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    private fun setupDismissAlarmButton(){
        dismiss_alarm_button.setOnClickListener(){
            val i = Intent(BaseSoundService.ACTION_ALARM_STOP, null, context, SoundService::class.java)
            context?.stopService(i)
            findNavController().popBackStack()
        }
    }
    override fun layout(): Int = R.layout.triggered_alarm_fragment

}