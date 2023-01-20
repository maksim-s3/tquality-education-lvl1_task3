package enums;

public enum AlertsForm {
    SEE_ALERT ("alertButton"),
    TIMER_ALERT ("timerAlertButton"),
    CONFIRM_BOX_ALERT ("confirmButton"),
    PROMPT_BOX_ALERT ("promtButton");

    private String title;

    AlertsForm(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
