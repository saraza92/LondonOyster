package Service;

import DAO.Stations;
import Models.Trip;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CalculateFareTest {

    @Test
    public void testZoneDifferenceCalculatorSameZone(){
        Trip trip = Mockito.mock(Trip.class);
        Mockito.when(trip.getInStation()).thenReturn(Stations.EARLS_COURT);
        Mockito.when(trip.getOutStation()).thenReturn((Stations.HOLBORN));

        assertArrayEquals(new int[]{0,1,1},CalculateFare.getMinZoneDiff(trip));
    }

    @Test
    public void testZoneDifferenceCalculatorDiffZone(){
        Trip trip = Mockito.mock(Trip.class);
        Mockito.when(trip.getInStation()).thenReturn(Stations.WIMBLEDON);
        Mockito.when(trip.getOutStation()).thenReturn((Stations.HOLBORN));

        assertArrayEquals(new int[]{2,3,1},CalculateFare.getMinZoneDiff(trip));
    }

}