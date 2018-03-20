package yal;


public class RegionFactory {
    private static RegionFactory ourInstance = new RegionFactory();

    public static RegionFactory getInstance() {
        return ourInstance;
    }

    private int noCurrent, noMax ;

    private RegionFactory() {
        noCurrent = 0 ;
        noMax = 0 ;
    }
}
