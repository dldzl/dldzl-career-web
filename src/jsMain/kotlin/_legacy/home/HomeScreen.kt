package _legacy.home

import androidx.compose.runtime.Composable
import _legacy.ChartRepositoryImpl
import _legacy.compose.Body

@Composable
fun HomeScreen() {
    val chartRepositoryImpl = ChartRepositoryImpl()

    Body {
        HomeHeader()
        HomeSidebar()
        HomeMain(chartRepositoryImpl)
    }
}