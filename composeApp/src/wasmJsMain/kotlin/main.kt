import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.CanvasBasedWindow
import ui.base.Section
import ui.careerlist.CareerListScreen
import ui.onboarding.OnBoardingScreen

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        val (selectedSession, onChangeSelectedSection) = remember { mutableStateOf(MainSection.ON_BOARDING) }

        Column {
            MainHeader(
                modifier = Modifier.fillMaxWidth(),
                selectedSection = selectedSession,
                onChangeSelectedSection = { newSection -> onChangeSelectedSection(newSection as MainSection) },
            )

            val screenModifier = Modifier.weight(1f)

            when (selectedSession) {
                MainSection.ON_BOARDING -> OnBoardingScreen(modifier = screenModifier)
                MainSection.CAREER_LIST -> CareerListScreen(modifier = screenModifier)
            }
        }
    }
}

@Composable
fun MainHeader(
    modifier: Modifier = Modifier,
    selectedSection: Section,
    onChangeSelectedSection: (newSection: Section) -> Unit,
    sections: List<Section> = MainSection.entries,
) {
    Row(
        modifier = modifier.padding(
            horizontal = 12.dp,
            vertical = 8.dp,
        ),
    ) {
        Image(
            imageVector = Icons.Default.Lock,
            contentDescription = "Inky",
        )
        Spacer(modifier = Modifier.weight(1f))
        sections.forEach { section ->
            val selected = section == selectedSection
            Text(
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                        vertical = 12.dp,
                    ).clickable { onChangeSelectedSection(section) },
                text = section.label,
                color = if (selected) {
                    MaterialTheme.colors.primary
                } else {
                    MaterialTheme.colors.onSurface
                },
            )
        }
    }
}


@Immutable
enum class MainSection(
    override val icon: ImageVector,
    override val label: String,
) : Section {
    ON_BOARDING(
        icon = Icons.Default.Home,
        label = "On Boarding",
    ),
    CAREER_LIST(
        icon = Icons.Default.List,
        label = "Careers",
    ), ;
}
