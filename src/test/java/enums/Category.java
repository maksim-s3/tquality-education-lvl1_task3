package enums;

public enum Category {
    ELEMENTS ("Elements"),
    FORMS ("Forms"),
    ALERTS_FRAME_AND_WINDOWS("Alerts, Frame & Windows"),
    WIDGETS ("Widgets"),
    INTERACTIONS ("Interactions"),
    BOOKSTORE ("Book Store Application");

    private String title;

    Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
