class Run{
    private int tMin;
    private int tSec;
    private double distance;

    public Run(double dist, int mins, int secs){

       tMin = mins;
       tSec = secs;
       distance = dist;
       
       
    }
    
    public int getTime(){
    	return tMin;
    }
}
