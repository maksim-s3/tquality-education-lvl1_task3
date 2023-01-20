package enums;

public enum WebTables {
    FIRST_NAME ("First Name"),
    LAST_NAME ("Last Name"),
    EMAIL ("Email"),
    AGE ("Age"),
    SALARY ("Salary"),
    DEPARTMENT ("Department"),
    ACTION ("Action");

    private String title;

    WebTables(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
