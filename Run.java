
/**
 * This class contains all the information
 * associated with an individual run
 * 
 * @author skgigliotti
 *
 */
class Run{
    private int tMin;
    private int tSec;
    private double distance;
    private String date;
    private int mood;
    private double pace;
    private int exhaustion;
    
    /**
     * 
     * @param dist double total distance run
     * @param mins int minutes run
     * @param secs int seconds run
     * @param mind int (1-5) higher, better mood
     * @param tiredness (1-5) higher, more tired
     */
    public Run(double dist, int mins, int secs, int mind, int tiredness){

       tMin = mins;
       tSec = secs;
       distance = dist;
       mood = mind;
       exhaustion = tiredness;
       pace = distance/getComboTime();
       
       
    }
    
    /**
     * This method converts the mins and secs (passed in 
     * as integers) into a single doubleand returns the value
     * @return double of comboTime
     */
    public double getComboTime() {
    	double secondsFrac = tSec/60;
    	return tMin + secondsFrac;
    }
    /**
     * This method returns the pace of the run
     * @return double pace of the run
     */
    public double getPace(){
    	return pace;
    }
    
    /**
     * This method returns the number of minutes run
     * @return int minutes run
     */
    public int getMin(){
    	return tMin;
    }
    
    /**
     * This method returns the distance run
     * @return double distance run
     */
    public double getDistance(){
    	return distance;
    }
    
    /**
     * This method returns the number of seconds run
     * @return int seconds run
     */
    public int getSec(){
    	return tSec;
    }
    /**
     * This method returns the overall mood on the day run
     * @return int mood level
     */
    public int getMood(){
    	return mood;
    }
    
    public int getExhaustion(){
    	return exhaustion;
    }
    
    public String getDate(){
    	return date;
    }
    
    
}
