package screentwo.models

sealed class SecondScreenEvent {
    data object BackClick : SecondScreenEvent()
}