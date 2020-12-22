package iloveus.wetterek.iloveus

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.view.animation.AnimationUtils.loadAnimation as loadAnimation1

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)

    fun openYoutubeLink(youtubeID: String) {
        val intentApp = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + youtubeID))
        val intentBrowser = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + youtubeID))
        try {
            this.startActivity(intentApp)
        } catch (ex: ActivityNotFoundException) {
            this.startActivity(intentBrowser)
        }
    }
    fun openSpotifyPlaylist() {
        val intentSpotify = Intent(Intent.ACTION_VIEW, Uri.parse("https://open.spotify.com/playlist/2TcS2BOdubkUBZFZPLtuUk?si=9ABHABTpQdGKZhqesjAljw&utm_source=copy-link"))
        this.startActivity(intentSpotify)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Random youtube links
        val memes = arrayOf(
                "1JOS0GHFmBk",
                "SovdH0uaWVY",
                "hdWe-yoh978",
                "ggB33d0BLcY",
                "mvz3LRK263E",
                "tUXdcrSbIho",
                "NIJ5RiMAmNs",
                "5WBSoYIWQKo",
                "wv95zQcAXF0",
                "6nE8ifrCB2U",
                "ez_2fRRjWtc",
                "BZlag-kbN4k",
                "neKqlZujsx8",
                "Wc_JMRe3ECQ",
                "NWJPxE4Rzz4",
                "Ue8BvTZtUeA",
                "RFWZGbjAhjo",
                "Mn8cH13dR4I",
                "PAkuxOoHZCg",
                "hyD2Qu1lzdQ",
                "rqtr_RvR3sY",
                "gNnOz9vtEcg"
        )

        //Jokes
        val jokes = arrayOf(
                //Swedish dad jokes
                "När kocken hade begått ett brott hamnade han i rätten.",
                "Kan man kalla hästskor för gångjärn?",
                "- Har du smakat McDonalds nya fiskburgare?\n" +
                        "- Nä, vad heter den?\n" +
                        "- Mac rill!",
                "Från vilken stad kommer fågelinfluensan ifrån? Här-nös-and!",
                "- Orientering är en ofri sport!\n" +
                        "- Vad pratar du om?\n" +
                        "- Det är ju kontroller överallt!",
                "- Blev du glad då du kom in på elprogrammet?\n" +
                        "- Ja, jag blev så till mig att jag slog en volt.",
                "- Det var inte kul för kannibalen som kom för sent till middagen, han fick kalla handen",
                "- Folk har börjat reta mig för min vikt.\n" +
                        "- Äh, upp med hakorna!",
                "- Hur gick det med pokerspelandet igår?\n" +
                        "- Dåligt, fick spader och nu är jag helt knekt!",
                "- Hur hade du råd att köpa en ny griffeltavla?\n" +
                        "- Jag köpte den på krita!",
                "- Hänger du med och snor äpplen?\n" +
                        "- Nej, jag pallar inte.",
                "- I vilket land gör man värnplikten flera gånger?\n" +
                        "- Armenien",
                "- Vad äter en kinesisk matematiker?\n" +
                        "- Matris.",
                "- Är det sant att din hund kan räkna?\n" +
                        "- Ja, han är väldigt förtjust i matte.",
                "- Vad talar änglarna för språk egentligen?\n" +
                        "- Ängelska så klart!",
                "- Var lär sig hajarna skriva och läsa?\n" +
                        "- I High-school.",
                "- Vad snackar brandmännen om?\n" +
                        "- Gamla flammor.",
                "- Vad är det för likhet mellan en brandman och en tandläkare?\n" +
                        "- Båda rycker ut!",
                "I Indien arbetar bara folk av de lägre kasten, medan överkasten ligger på sängarna.",
                "- Varför är apelsiner bra för ögonen?\n" +
                        "- De innehåller sevitaminer.",
                "- Vad krävs för att bli brandman?\n" +
                        "- Ett brinnande intresse!",
                "Tror ni att apelsiner vill bli juice eller blir de pressade till det?",
                "Hårsalongen gick dåligt, hade svårt att locka kunder.",
                "Om man skjuter insekter med ett gevär, är man krypskytt då?",
                "Publiken, är det dom som har supit ihjäl sig?",
                "Jag kan inte se Paradise hotel eftersom jag har en smart-tv.",
                "Han slängde ett öga åt vardera håll och rusade blint vidare.",
                "Begravningsentreprenörer är aldrig likgiltiga. ",
                "Jag hade tänkt hyra båt till sommaren men alla var upptagna.",
                "Vad heter världsmästaren i svampplockning? Champion.",
                "- Har ni hört om styckmorden i Afrika?\n" +
                        "- Det var Nelson Man dela.",
                "Kalle Anka, Bamse och Fantomen har hittats döda. Polisen tror att en seriemördare går lös.",
                "- Olle vet du var Engelska kanalen ligger?\n" +
                        "- Nej, tyvärr. Vi har bara SVT1 och SVT2.",
                "- Vad gör en arbetslös skådespelare?\n" +
                        "- Spelar ingen roll!",
                //English dad jokes
                "Why don't eggs tell jokes? They'd crack each other up.",
                "I don't trust stairs. They're always up to something.",
                "Did you hear the rumor about butter? Well, I'm not going to spread it!",
                "This graveyard looks overcrowded. People must be dying to get in.",
                "What do you call cheese that isn't yours? Nacho cheese.",
                "What kind of shoes do ninjas wear? Sneakers!",
                "How does a penguin build its house? Igloos it together.",
                "Why did the scarecrow win an award? Because he was outstanding in his field.",
                "I'm reading a book about anti-gravity. It's impossible to put down!",
                "Did you hear about the guy who invented the knock-knock joke? He won the 'no-bell' prize.",
                "I used to hate facial hair...but then it grew on me.",
                "I decided to sell my vacuum cleaner—it was just gathering dust!",
                "What's brown and sticky? A stick.",
                "What do you call an elephant that doesn't matter? An irrelephant.",
                "I could tell a joke about pizza, but it's a little cheesy.",
                "I wouldn't buy anything with velcro. It's a total rip-off.",
                "Don't trust atoms. They make up everything!",
                "What’s an astronaut’s favorite part of a computer? The space bar.",
                "I don't play soccer because I enjoy the sport. I'm just doing it for kicks!",
                "Why are elevator jokes so classic and good? They work on many levels.",
                "What do you call a fake noodle? An impasta.",
                "What rock group has four men that don't sing? Mount Rushmore.",
                "When I was a kid, my mother told me I could be anyone I wanted to be. Turns out, identity theft is a crime.",
                "A guy goes to his doctor because he can see into the future. The doctor asks him, \"How long have you suffered from that condition?\" The guy tells him, \"Since next Monday.\"",
                "What do sprinters eat before a race? Nothing, they fast!",
                "Did you hear about the restaurant on the moon? Great food, no atmosphere!",
                "What happens when you go to the bathroom in France? European.",
                "What's the difference between a poorly dressed man on a tricycle and a well-dressed man on a bicycle? Attire!",
                "Last night I had a dream that I weighed less than a thousandth of a gram. I was like, 0mg.",
                "A cheese factory exploded in France. Da brie is everywhere!",
                "Why did the invisible man turn down the job offer? He couldn't see himself doing it!",
                "I was really angry at my friend Mark for stealing my dictionary. I told him, \"Mark, my words!\"",
                "How does Moses make his coffee? Hebrews it.",
                "I was just reminiscing about the beautiful herb garden I had when I was growing up.\n" +
                        "Good thymes."
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

        //Youtubebutton
        val click_youtube_button = findViewById<Button>(R.id.button_youtube)
        click_youtube_button.setOnClickListener {
            timBounce.startAnimation(bounceAnimation)
            johannaBounce.startAnimation(bounceAnimation)

            var randomMeme = memes.random()
            this.openYoutubeLink(randomMeme)
        }

        //Spotifybutton
        val click_spotify_button = findViewById<Button>(R.id.button_spotify)
        click_spotify_button.setOnClickListener {
            timBounce.startAnimation(bounceAnimation)
            johannaBounce.startAnimation(bounceAnimation)

            this.openSpotifyPlaylist()
        }

        //Jokesbutton
        val click_jokes_button = findViewById<Button>(R.id.button_jokes)
        click_jokes_button.setOnClickListener {
            timBounce.startAnimation(bounceAnimation)
            johannaBounce.startAnimation(bounceAnimation)

            var randomJoke = jokes.random()

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Ordvits")
            builder.setMessage(randomJoke)

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(applicationContext,
                        android.R.string.yes, Toast.LENGTH_SHORT).show()
            }

            builder.show()
        }
    }
}


