package DAO;

public enum Fare {
    BUS_FARE(1.8d),
    MAX_FARE(3.2d);

    private double fare;

    private Fare(double fare){
        this.fare=fare;
    }

    public double getFare(){
        return this.fare;
    }
}
