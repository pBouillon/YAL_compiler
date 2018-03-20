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

    public int getNewNum() {
        return ++noMax ;
    }

    public void incrCurr() {
        ++noCurrent ;
    }

    public void decrCurr() {
        --noCurrent ;
    }

    public int getNoCurrent() {
        return noCurrent ;
    }

}
