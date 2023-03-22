package dk.sdu.mmmi.cbse.asteroidsystem;

public enum AsteroidSize {

    LARGE("LARGE"),
    MEDIUM("MEDIUM"),
    SMALL("SMALL");

    private String size;

    private AsteroidSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
