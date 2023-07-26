import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launchTopcashbackApp()
    }

    private fun launchTopcashbackApp() {
        val packageName = "uk.co.topcashback.topcashback" // Package name of the Topcashback app.
        val mainActivity = ".main.activity.MainActivity" // Main activity of the Topcashback app.

        // Try to start the Topcashback app.
        val launchIntent: Intent? = packageManager.getLaunchIntentForPackage(packageName)

        // Here, we are setting the exact component (Activity) to be launched.
        val componentName = ComponentName(packageName, packageName + mainActivity)
        launchIntent?.component = componentName

        startActivity(launchIntent)
        finish() // Optional: Finish the MainActivity to remove it from the back stack
    }
}
