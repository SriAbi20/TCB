import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
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
        val mainActivity = ".main.activity.MainActivity" // Main activity of the Topcashback app.

        // Here, we are setting the exact component (Activity) to be launched.
        val componentName = ComponentName(packageName, packageName + mainActivity)

        // Try to start the Topcashback app.
        val launchIntent = Intent().setComponent(componentName)

        // Start Activity
        getInstrumentation().context.startActivity(launchIntent)

        // Verify that the Topcashback app was started.
        Intents.intended(IntentMatchers.hasComponent(componentName))

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
