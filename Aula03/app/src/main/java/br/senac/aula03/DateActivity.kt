package br.senac.aula03

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_date.*
import java.util.*

class DateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        val calendar = Calendar.getInstance()

        val calendarYear = calendar.get(Calendar.YEAR)
        val calendarMonth = calendar.get(Calendar.MONTH)
        val calendarDay = calendar.get(Calendar.DAY_OF_MONTH)

        etDate.setOnClickListener {
            val datePicker = DatePickerDialog(this, { view, year, month, day ->
                etDate.setText("$day/$month/$year")

            }, calendarYear, calendarMonth, calendarDay)

            datePicker.show()
        }


    }
}