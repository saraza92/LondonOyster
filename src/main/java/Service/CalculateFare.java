package Service;

import DAO.Fare;
import DAO.Stations;
import DAO.Transport;
import Models.Trip;

public class CalculateFare {


    public static double fare(Trip trip){
        double finalFare=Fare.MAX_FARE.getFare();
        int[] zoneTravel = getMinZoneDiff(trip);

        if(zoneTravel[0]==2)
            return finalFare;
        if(zoneTravel[0]==1&&(zoneTravel[1]==1||zoneTravel[2]==1))
            finalFare=3d;
        else if(zoneTravel[0]==1)
            finalFare=2.25d;
        if(zoneTravel[0]==0 && zoneTravel[1]==1)
            finalFare=2.5d;
        else
            finalFare=2d;
        return finalFare;
    }

    public static int[] getMinZoneDiff(Trip trip){
        Integer min= Integer.MAX_VALUE;
        int[] inStationZones, outStationZones, zoneTravel;
        zoneTravel= new int[3];
        inStationZones = trip.getInStation().getZones();
        outStationZones = trip.getOutStation().getZones();
        for(int i : inStationZones){
            for(int j:outStationZones)
                if(Math.abs(i-j)<min){
                    min=Math.abs(i-j);
                    zoneTravel[0]=min;
                    zoneTravel[1]=i;
                    zoneTravel[2]=j;
                }
        }
        return zoneTravel;
    }


}
