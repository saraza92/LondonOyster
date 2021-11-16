package Models;

import DAO.Fare;
import Exceptions.FareException;

public class Oyster {

    private float balance;

    public Oyster(float balance) {
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

    public void reload (float amount){
        if(amount > 0)
        this.balance+=amount;
    }

    public void deductMax() throws FareException{
        if(this.balance< Fare.MAX_FARE.getFare())
            throw new FareException("Balance is too less to travel!");
        this.balance-=3.20;
    }

    public void deductFare(Fare fare) throws FareException{
        if(this.balance< fare.getFare())
            throw new FareException("Balance is too less to travel!");
        this.balance-=fare.getFare();
    }

    public void returnBalanceFare(Double reversal){
        this.balance+=reversal;
    }


}
