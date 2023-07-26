import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import android.content.Intent
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TopcashbackTest {

    @Test
    fun testLaunchTopcashbackApp() {
        // Start the intents recording.
        Intents.init()

        val packageName = "uk.co.topcashback.topcashback" // Package name of the Topcashback app.
        val activityName = ".splash.SplashActivity" // New Activity name

        // Create an explicit intent
        val launchIntent = Intent()
        launchIntent.setClassName(packageName, packageName + activityName)

        // Add the FLAG_ACTIVITY_NEW_TASK flag. This is required if you're starting the Activity from outside of an Activity context.
        launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        // Start Activity
        getInstrumentation().targetContext.startActivity(launchIntent)

        // Verify that the Topcashback app was started.
        Intents.intended(IntentMatchers.hasComponent(packageName + activityName))

        // End the intents recording.
        Intents.release()

        // Get UiDevice instance
        val uiDevice = UiDevice.getInstance(getInstrumentation())

        // Find the "Member sign-in" button and click it
        val signInButton: UiObject = uiDevice.findObject(UiSelector().text("Member sign-in"))
        if (signInButton.waitForExists(5000)) {
            signInButton.click()
        }
    }
}
