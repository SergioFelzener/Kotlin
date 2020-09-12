package br.senac.exintents

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_photo.*

class PhotoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        btnPhoto.setOnClickListener {
            val i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if (i.resolveActivity(packageManager) != null) {
                startActivityForResult(i, 1)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val img: Bitmap? = data?.getParcelableExtra("data")

            imgPhoto.setImageBitmap(img)
        }
    }
}