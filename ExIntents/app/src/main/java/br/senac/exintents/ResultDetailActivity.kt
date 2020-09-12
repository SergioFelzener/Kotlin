package br.senac.exintents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result_detail.*

class ResultDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_detail)

        btnVideo.setOnClickListener {
            response("Video Cards")
        }

        btnProcessor.setOnClickListener {
            response("Processor's")
        }

        btnMother.setOnClickListener {
            response("Mother Boards")
        }


    }


    fun response(category: String){
        val returnIntent = Intent()

        returnIntent.putExtra("category", category)

        setResult(Activity.RESULT_OK, returnIntent)

        finish()

    }






}