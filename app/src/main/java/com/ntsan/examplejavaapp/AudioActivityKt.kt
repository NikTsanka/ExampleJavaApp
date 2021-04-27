package com.ntsan.examplejavaapp

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.ntsan.examplejavaapp.databinding.ActivityAudioKtBinding
import java.util.*

class AudioActivityKt : AppCompatActivity() {


    private var binding: ActivityAudioKtBinding? = null

    private var mediaPlayer: MediaPlayer? = null
    private var audioManager: AudioManager? = null

    private fun start(view: View?) {
        mediaPlayer!!.start()
    }

    private fun pause(view: View?) {
        mediaPlayer!!.pause()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAudioKtBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)

        binding?.playBtn?.setOnClickListener {
            start(it)
        }

        binding?.pauseBtn?.setOnClickListener {
            pause(it)
        }

        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager

        val maxVolume = audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        val currentVolume = audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC)

        mediaPlayer = MediaPlayer.create(this, R.raw.oldcar)

        val volume: SeekBar = binding!!.seekBar
        volume.max = maxVolume
        volume.progress = currentVolume

        volume.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                audioManager!!.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
                Log.i("Volume:", progress.toString())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        val revFor: SeekBar = binding!!.revForBtn
        revFor.max = mediaPlayer!!.duration

        revFor.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                mediaPlayer?.seekTo(progress)
                Log.i("F.Forward, Rev:", progress.toString())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                revFor.progress = mediaPlayer!!.currentPosition
            }
        }, 0, 100)
    }


}