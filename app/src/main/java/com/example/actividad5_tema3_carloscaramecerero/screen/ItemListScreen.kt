import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.actividad5_tema3_carloscaramecerero.viewmodel.ItemViewModel

@Composable
fun ItemListScreen(viewModel: ItemViewModel = hiltViewModel()) {
    val items = viewModel.items.collectAsState() // Ahora StateFlow funciona directo

    LazyColumn {
        items(items.value) { item ->
            Row {
                Text(item.nombre)
                Button(onClick = { /* editar */ }) { Text("Editar") }
                Button(onClick = { viewModel.deleteItem(item.id) }) { Text("Eliminar") }
            }
        }
    }
}
