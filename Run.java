
/**
 * An individual run that stores info: time, distance
 * @author skgigliotti
 *
 */
class Run{
    private int tMin;
    private int tSec;
    private double distance;
    private String year;

    public Run(double dist, int mins, int secs){

       tMin = mins;
       tSec = secs;
       distance = dist;
       
       
    }
    /**
     * 
     * @return the number of minutes
     */
    		
    public int getMin(){
    	return tMin;
    }
    
    /**
     * 
     * @return the seconds run
     */
    public int getSec(){
    	return tSec;
    }
    
    /**
     * 
     * @return the distance run
     */
    public double getDistance(){
    	return distance;
    }
    
    /**
     * 
     * @return the date run
     */
    
    public String getDate(){
    	//TODO:set using the method in Window?
    	return year;
    }
    
    
}
