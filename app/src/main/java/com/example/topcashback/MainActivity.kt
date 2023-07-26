import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.topcashback.ui.theme.TopCashBackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Launch the Topcashback app directly
        val intent = packageManager.getLaunchIntentForPackage("uk.co.topcashback.topcashback")
        startActivity(intent)
        finish() // Optional: Finish the MainActivity to remove it from the back stack
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TopCashBackTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // If you had any content to preview, you can add it here
        }
    }
}
