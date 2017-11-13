class Run{
    private int tMin;
    private int tSec;
    private double distance;
    private String date;

    public Run(double dist, int mins, int secs){

       tMin = mins;
       tSec = secs;
       distance = dist;
       
       
    }
    
    public int getMin(){
    	return tMin;
    }
    
    public double getDistance(){
    	return distance;
    }
    
    public int getSec(){
    	return tSec;
    }
    
    public String getDate(){
    	return date;
    }
    
    
}
