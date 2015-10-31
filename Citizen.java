import java.util.*;
import java.util.ArrayList;
import gof.*;
/**
 * Write a description of class Citizen here.
 * 
 * @GMR Apps 
 * @beta v 2.00
 */

public class Citizen extends Person implements Comparable
{
    public enum MortalStatus{alive,dead,newlyBorn} 
    protected ArrayList<Citizen> friends = new ArrayList<Citizen>();
    protected ArrayList<String> friendList = new ArrayList<String>();
    protected MortalStatus mortalStatus;
    protected String id;
    protected double friendValue;
    protected String location,firstName,lastName;

    /**
     * Constructor for objects of class Citizen
     */
    public Citizen(String lastName, String firstName, char s, String location, double friendValue)
    {
        super(lastName,firstName,s);
        this.location=location;
        this.friendValue=friendValue;
        this.mortalStatus=MortalStatus.alive;
        this.id="1000";
    }

    /**
     * addPrefference method
     * @param Preference,int
     * @return none
     */ 
    public void addPreference(Preference preference, int rating)
    {
        // Determine if the rating is valid (-1 or 1)
        boolean valid = (rating == -1 || rating == 1);
        // Determine if preference exists in either states
        boolean exists = (this.likes.contains(preference) || this.dislikes.contains(preference));
        // Mutate relevant list if preference is valid and does not exist
        if  (likes.size()<5 || dislikes.size()<5){
            if (valid && !exists) {
                // Effective use of the Ternary Operator
                Object mutate = (rating == 1) ? this.likes.add(preference) : this.dislikes.add(preference);
            }
        }
    }

    /**
     *This is a setter method which assigns a new friend value
     *@param int
     *@return none
     */
    public void setMood(int fv)
    {

        if (fv>1)
        {
            this.friendValue=(this.friendValue*0.90);
        }
        else if(fv<1)
        {
            this.friendValue=(this.friendValue*1.10);
        }
        else
        {
            this.friendValue=this.friendValue;  
        }
    }

    /**
     * This is the compareTo method
     * @param citi
     * @return int
     */
    public int compareTo(Object citi)
    {
        Citizen citizen = (Citizen)citi;
        if (this.getLastName().compareTo(citizen.getLastName())==0)
        {
            return this.getFirstName().compareTo(citizen.getFirstName());
        }else{
            return this.getLastName().compareTo(citizen.getLastName());
        }

    }

    /**
     * 
     * 
     */
    public ArrayList<Citizen> getFriends()
    {
        return friends;
    }

    /**
     *This is a method which 
     *@param
     *@return none
     */
    public void meet(Object citi)
    {
        Citizen citizen= (Citizen)citi;
        if(!friends.contains(citi))
        {
            if (this.compatibility(citizen)>=friendValue)
            {
                friends.add(citizen);
            }

        }else{
            if (this.compatibility(citizen)<friendValue)
            {
                friends.remove(citizen);
            }
        }

    }

    /**
     * Method to set Mortal status
     * @param String
     * @return none
     */
    public void setMortalStatus(MortalStatus mortal)
    {
        this.mortalStatus=mortal;
    }

    /**
     * Method to set location
     * @param String
     * @return none
     */
    public void setLocation(String loc)
    {
        this.location=loc;
    }

    /**
     *Method to get location
     *@param none
     *@return location
     */
    public String getLocation()
    {
        return this.location;
    }

    /**
     * Method to get Mortal Status
     * @param none
     * @return mortalStatus
     */
    public MortalStatus getMortalStatus()
    {
        return this.mortalStatus;
    }

    /**
     *This is a toString method
     * @param none
     * @return String
     */
    public String toString()
    {
        String citizen_data ="\n";
        citizen_data+="First Name: "+this.getFirstName()+"\n";
        citizen_data+="Last Name: "+this.getLastName()+"\n";
        citizen_data+="Location: "+this.getLocation()+"\n";
        citizen_data+= "Friends List: ";
        for(Citizen friend:friends)
        {
            citizen_data+= friend.getFirstName()+" "+friend.getLastName()+",";
        }

        citizen_data+= "\n";
        return citizen_data;
    }

}

