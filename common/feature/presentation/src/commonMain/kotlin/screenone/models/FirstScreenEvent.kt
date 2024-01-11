package screenone.models

sealed class FirstScreenEvent {
    data object ButtonClick : FirstScreenEvent()
}