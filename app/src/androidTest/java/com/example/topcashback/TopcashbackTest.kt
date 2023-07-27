import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import android.content.Intent
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TopcashbackTest {

    @Test
    fun testLaunchTopcashbackApp() {

        Intents.init()

        val packageName = "uk.co.topcashback.topcashback" // Package name of the Topcashback app.
        val activityName = ".splash.SplashActivity" // Activity name

        val launchIntent = Intent()
        launchIntent.setClassName(packageName, packageName + activityName)
        launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        getInstrumentation().targetContext.startActivity(launchIntent)
        Intents.intended(IntentMatchers.hasComponent(packageName + activityName))
        Intents.release()

        // Added delay to wait for the app to launch
        Thread.sleep(5000)

        // Get UiDevice instance
        val uiDevice = UiDevice.getInstance(getInstrumentation())

        //click Member sign-in to navigate to the login page
        val signInButton = uiDevice.findObject(UiSelector().textContains("Member sign-in"))
        signInButton.click()

        // Login as an existing user
        val emailField = uiDevice.findObject(UiSelector().text("Enter email"))
        emailField.setText("sriabinaya1997@gmail.com")

        val passwordField = uiDevice.findObject(UiSelector().text("Enter password"))
        passwordField.setText("Sriabi@20")

        val loginButton = uiDevice.findObject(UiSelector().text("Login"))
        loginButton.click()

        // To dismiss popups
        val noButton = uiDevice.findObject(UiSelector().text("No"))
        if (noButton.exists()) {
            noButton.click()
        }

        // To Search for a merchant (Nike)
        val searchBar = uiDevice.findObject(UiSelector().text("Search Merchant / Store Name"))
        searchBar.click() // click to focus on the search field
        searchBar.setText("Nike") // input the search term
        uiDevice.pressEnter() // press the enter key to execute the search

        // Assert that the first result shown is the searched merchant
        val firstResult = uiDevice.findObject(UiSelector().text("Nike"))
        assertTrue(firstResult.exists())

        // Click on the first merchant
        firstResult.click()

        // Assert that the correct merchant page is displayed
        val merchantPageText = uiDevice.findObject(UiSelector().textContains("Nike"))
        assertTrue(merchantPageText.exists())

        //Press the back button to navigate back to the list
        uiDevice.pressBack()

        //delay
        Thread.sleep(500)

        //Press the back button  to navigate to home page
        uiDevice.pressBack()

        //click more button to view the logout
        val moreButton = uiDevice.findObject(UiSelector().description("More"))
        moreButton.click()

        // Find and click the "Logout" button
        val logoutButton = uiDevice.findObject(UiSelector().text("Logout"))
        logoutButton.click()

        // Assert logout confirmation dialog is displayed
        val logoutPrompt = uiDevice.findObject(UiSelector().text("Are you sure that you want to logout?"))
        assertTrue(logoutPrompt.exists())

        // Find and click the "LOGOUT" button in the dialog
        val confirmLogoutButton = uiDevice.findObject(UiSelector().text("LOGOUT"))
        confirmLogoutButton.click()

        Thread.sleep(2000)

        while (uiDevice.currentPackageName == packageName) {
            uiDevice.pressBack()
        }


    }
}
