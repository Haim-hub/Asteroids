package dk.sdu.mmmi.cbse.asteriodsystem;

public enum AsteriodSize {

    LARGE("LARGE"),
    MEDIUM("MEDIUM"),
    SMALL("SMALL");

    private String size;

    private AsteriodSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
