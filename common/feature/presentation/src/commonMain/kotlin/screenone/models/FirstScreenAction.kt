package screenone.models

sealed class FirstScreenAction {
    data class OpenSecondScreen(val value: String) : FirstScreenAction()
}