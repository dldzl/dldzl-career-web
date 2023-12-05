import org.jetbrains.compose.web.renderComposable
import _legacy.home.HomeScreen

fun main() {
    renderComposable(rootElementId = "root") {
        HomeScreen()
    }
}