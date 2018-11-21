package message;

public enum ApplicationMessage {
    REQUIRED_PARAMS("Parameters are required\n");

    private final String message;

    ApplicationMessage(final String messasge) {
        this.message = messasge;
    }

    public String getMessage() {
        return this.message;
    }
}
