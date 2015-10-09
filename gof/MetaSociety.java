package gof;


/**
 * Abstract class MetaSociety - A society of persons 
 * @author COMP1161
 * @version 1.0
 */
public abstract class MetaSociety
{
    /** The persons in the society */
    protected Person persons[];
    
    /** Counter, that is incremented on every tick can be used for day, or year, etc.*/
    private int period;
    
    /** A name by which the society is known */
    private String nameOfSociety;
    
    /**
     * Sample Null constructor. Creates the Garden of Eden with two citizens
     */
    public MetaSociety()
    {
        nameOfSociety = "Garden of Eden";
        this.persons = new Person[2];
        persons[0] = new Person("Gardner","Adam",'M');  // Adam
        persons[1] = new Person("Gardener","Eve",'F');  // Eve

        persons[0].addPreference(Preference.CHURCH,1);
        persons[0].addPreference(Preference.CHILDREN,1);
        persons[0].addPreference(Preference.ANIMALS,-1);
        
        //Eve likes children and snakes
        persons[1].addPreference(Preference.CHILDREN,1);
        persons[1].addPreference(Preference.ANIMALS,1);

        period = 1;   // The garden was really created in year 1
    }
    
    /** 
     * Constructor that loads citizen data from a text file
     * @param name a name that is given to the society
     * @param startPeriod the start of the society. Can be a year (e.g. 2014) or a number of your own choosing
     * @param fileName name of a text file from which citizen data is to be loaded

     abstract public MetaSociety(String name, int startPeriod, String fileName)
     {
     }
*/     
    /**
     *  Method that is called to simulate one tick (e.g. a year) of simulation
     * 
     * @param  mood   mood of mingling (-ve, 0, or +ve)
     * @param  mode   can be used to control type of mingling
     */
    final public void tick(int mood, int mode) 
    {
        //
        mingle(mood, mode);
        update();
        period++;
        
    }
    
    
    /**
     * Defines the rules for how a mingling happens
     * @param mood  mood of the mingling, good=+ve;neutral=0;bad=-ve
     * @param mode  can be used to define different types of mingling (use as you wish)
     */
    abstract protected void mingle(int mood, int mode);
    
    
    /**
     * Defines the rules for how the society is to change after a mingling
     */
    abstract protected void update();
    
    
    /**
     * Formatted list of persons in the society
     */
    final public String toString()
    {
        String result = "nameOfSociety";
        for (Person p : persons)
        {
                result += "\n   "+p;
        }
        
        return result;
    }
    
}
