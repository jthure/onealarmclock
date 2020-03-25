package com.jonasthuresson.onealarmclock.android.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.jonasthuresson.onealarmclock.MainActivity
import com.jonasthuresson.onealarmclock.R
import com.jonasthuresson.onealarmclock.android.helpers.AlarmReceiver
import com.jonasthuresson.onealarmclock.android.helpers.SystemAlarmManager


class SoundService: BaseSoundService() {

    var mediaPlayer: MediaPlayer? = null

    override fun startSound(){
        mediaPlayer = MediaPlayer.create(this, R.raw.good_morning)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()
    }
    override fun stopSound(){
        mediaPlayer?.release()
        mediaPlayer = null
    }
}