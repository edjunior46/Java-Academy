package br.com.academy.enums;

public enum Status {
    
    STUDYING("Studying"),
    COMPLETED("Completed"),
    INTERRUPTED("Interrupted"),
    CANCELLED("Cancelled");

    private String status;

    private Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

}
