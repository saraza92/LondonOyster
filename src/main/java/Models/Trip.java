package Models;

import DAO.Fare;
import DAO.Stations;
import DAO.Transport;
import Exceptions.FareException;
import Service.CalculateFare;

public class Trip {

    private Stations inStation;
    private Stations outStation;
    private Transport transport;
    private Oyster oyster;

    public void SwipeIn(Stations station, Transport transport, Oyster oyster) throws FareException {
        this.inStation = station;
        this.oyster = oyster;
        this.transport=transport;
        if(transport==Transport.BUS)
            oyster.deductFare(Fare.BUS_FARE);
        else
            oyster.deductMax();

    }

    public void swipeOut(Stations station){
        this.outStation = station;
        oyster.returnBalanceFare(Fare.MAX_FARE.getFare()-CalculateFare.fare(this));

    }

    public Trip(){}

    public Stations getInStation() {
        return inStation;
    }

    public Stations getOutStation() {
        return outStation;
    }

}
