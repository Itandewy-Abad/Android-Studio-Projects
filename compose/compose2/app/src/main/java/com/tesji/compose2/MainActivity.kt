package import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TablaMultiplicar(tabla = 5)
        }
    }
}
@Composable
fun TablaMultiplicar(tabla:Int) {
    Column {
        for(x in 1..10) {
            Text(text="$tabla * $x = ${tabla*x}")
        }
    }
}