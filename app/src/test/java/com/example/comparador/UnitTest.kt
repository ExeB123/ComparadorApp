import com.example.comparador.view.MainViewModel
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    @Test
    fun testCompararTextos_StringsIguales() {
        val result = viewModel.compararTextos("mensaje de prueba", "mensaje de prueba")
        assertTrue(result.comparison)
    }
}