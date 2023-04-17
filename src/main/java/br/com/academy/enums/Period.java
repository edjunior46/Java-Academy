package br.com.academy.enums;

public enum Period {
    
    MORNING("Morning"),
    AFTERNOON("Afternoon"),
    EVENING("Evening");

    private String period;

    private Period(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

}
