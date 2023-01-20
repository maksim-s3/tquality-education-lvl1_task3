package enums;

public enum LinksForm {
    HOME ("simpleLink"),
    HOME_EDTl5 ("dynamicLink");

    private String title;

    LinksForm(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
