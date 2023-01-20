package enums;

public enum LeftAccordionListItem {
    WEB_TABLES("Web Tables"),
    LINKS("Links"),
    BROWSER_WINDOWS("Browser Windows"),
    ALERTS ("Alerts"),
    FRAMES ("Frames"),
    NESTED_FRAMES ("Nested Frames"),
    SLIDER ("Slider"),
    PROGRESS_BAR("Progress Bar"),
    DATE_PICKER ("Date Picker"),
    UPLOAD_AND_DOWNLOAD ("Upload and Download");

    private String title;

    LeftAccordionListItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
