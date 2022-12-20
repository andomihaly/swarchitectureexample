package eu.misi.initproject;

import eu.misi.exception.SWArchitectureException;

public class InitProjectException extends SWArchitectureException {
    private final String firstProperty;
    public InitProjectException(String property) {
        this.firstProperty= property;
    }

    public String getFirstProperty() {
        return firstProperty;
    }
}
