package iloveus.wetterek.iloveus

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.AnimationUtils.*
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.view.animation.AnimationUtils.loadAnimation as loadAnimation1


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Random youtube links
        val lovesongs = arrayOf(
                "m5N9IHqqGcA",  /*I drove all night*/
                "TYQzIw0zat0",  /*You got it*/
                "YUY9Y9RFiHY",   /*You sexy thing*/
                "Z9QokOsivbU", /*Du är discot i mitt hjärta*/
                "A3uyjKc9LYA", /*Disease*/
                "vyVoE0k1vvs" /*Dina andetag*/
        )

        //Pulse animation
        val heartPulse = findViewById<View>(R.id.imageView_heart) as ImageView
        heartPulse.startAnimation(AnimationUtils.loadAnimation(this, R.anim.pulse_animation))

        //Bounce animation
        val bounceAnimation = loadAnimation1(this, R.anim.bounce_animation)

        bounceAnimation.repeatMode = Animation.REVERSE
        bounceAnimation.duration = (100..200).random().toLong()

        val timBounce = findViewById<ImageView>(R.id.imageView_tim)
        val johannaBounce = findViewById<ImageView>(R.id.imageView_johanna)

        val clickButton = findViewById<Button>(R.id.button)
        clickButton.setOnClickListener {
            timBounce.startAnimation(bounceAnimation)
            johannaBounce.startAnimation(bounceAnimation)
            var randomLovesong = lovesongs.random()
            this.openYoutubeLink(randomLovesong)
        }
    }
    fun openYoutubeLink(youtubeID: String) {
        val intentApp = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + youtubeID))
        val intentBrowser = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + youtubeID))
        try {
            this.startActivity(intentApp)
        } catch (ex: ActivityNotFoundException) {
            this.startActivity(intentBrowser)
        }
    }
}

