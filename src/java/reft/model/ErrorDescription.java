package reft.model;

public class ErrorDescription {

    private String errorMessages;
    private Location errorLocation;

    public ErrorDescription(String errorMessages, Location errorLocation) {
        this.errorLocation = errorLocation;
        this.errorMessages = errorMessages;
    }

    public Location getErrorLocation() {
        return errorLocation;
    }

    public void setErrorLocation(Location errorLocation) {
        this.errorLocation = errorLocation;
    }

    public String getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(String errorMessages) {
        this.errorMessages = errorMessages;
    }

}
