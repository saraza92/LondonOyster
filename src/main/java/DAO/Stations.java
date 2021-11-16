package DAO;

public enum Stations {
    HOLBORN(new int[] {1}),
    EARLS_COURT(new int[] {1,2}),
    WIMBLEDON(new int[]{3}),
    HAMMERSMITH(new int[]{2});

    private int[] zones;

    private Stations(int[] zones){
        this.zones=zones;
    }

    public int[] getZones(){
        return this.zones;
    }
}
