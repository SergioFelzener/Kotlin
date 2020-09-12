package br.senac.exintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import kotlinx.android.synthetic.main.activity_alarm.*

class AlarmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        btnSetAlarm.setOnClickListener {
            val i = Intent(AlarmClock.ACTION_SET_ALARM)

            i.putExtra(AlarmClock.EXTRA_HOUR, etHour.text.toString().toInt())
            i.putExtra(AlarmClock.EXTRA_MINUTES, etMin.text.toString().toInt())
            i.putExtra(AlarmClock.EXTRA_MESSAGE, etMsg.text.toString())



            if (i.resolveActivity(packageManager) != null) {
                startActivity(i)
            }
        }
    }
}