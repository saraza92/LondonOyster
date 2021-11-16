package Service;

import DAO.Stations;
import DAO.Transport;
import Exceptions.FareException;
import Models.Oyster;
import Models.Trip;

public class Service {
    public static void main(String[] args){

        Oyster user1 = new Oyster(0);
        user1.reload(30);

        Trip trip = new Trip();

        try {
            trip.SwipeIn(Stations.HOLBORN, Transport.TUBE, user1);
        }catch (FareException e){
            e.printStackTrace();
        }

        System.out.printf("Balance after swipe in on Trip 1:%.2f \n", user1.getBalance());
        trip.swipeOut(Stations.EARLS_COURT);
        System.out.printf("Balance after swipe out on Trip 1:%.2f \n", user1.getBalance());

        Trip secondTrip = new Trip();
        try {
            secondTrip.SwipeIn(Stations.EARLS_COURT, Transport.BUS, user1);
        }catch (FareException e){
            e.printStackTrace();
        }

        System.out.printf("Balance after swipe in on Trip 2:%.2f \n", user1.getBalance());

        Trip thirdTrip = new Trip();
        try {
            thirdTrip.SwipeIn(Stations.EARLS_COURT, Transport.TUBE, user1);
        }catch (FareException e){
            e.printStackTrace();
        }

        System.out.printf("Balance after swipe in on Trip 3: %.2f \n", user1.getBalance());
        thirdTrip.swipeOut(Stations.HAMMERSMITH);
        System.out.printf("Balance after swipe out on Trip 3: %.2f", user1.getBalance());

    }

}
