import gof.*;
import java.util.*;
import java.util.ArrayList;
import java.io.*;

/**
 * Society Class for the Project 2.
 * 
 * @GMR apps 
 * @ver 2.001
 */
public class Society extends MetaSociety
{
    protected String textFile,simulation;
    ArrayList<Citizen> citizens=new ArrayList<Citizen>();

    /**
     * Constructor for Society
     */
    public Society(String simulation,int startingPeriod,String textFile)
    {
        super(simulation,startingPeriod);
        this.simulation=simulation;
        this.textFile=textFile;
        Scanner scan;
        int count=0;
        try {
            scan = new Scanner(new File(textFile));
            String s1,s2,s3;
            while (scan.hasNextLine()){

                s1 = scan.nextLine();
                if(s1.startsWith("#"))
                {
                    continue;
                }
                String[] para = s1.split(",");
                s2 = scan.nextLine();
                String[] likes = s2.split(",");
                s3 = scan.nextLine();
                String[] dislikes = s3.split(",");

                Citizen citizen= new Citizen(para[0],para[1],para[2].charAt(0),para[4],Double.parseDouble(para[3]));
                for (String like: likes)
                {
                    citizen.addPreference(Preference.valueOf(like),1);
                }
                for (String dislike: dislikes)
                {
                    citizen.addPreference(Preference.valueOf(dislike),-1);
                }
                citizens.add(citizen);
            }
            persons = new Citizen[citizens.size()];
            for(int i=0;i<citizens.size();i++)
            {
                persons[i] = citizens.get(i);
            }

        }
        catch(FileNotFoundException exception)
        {
            System.out.println("File Not Found!");
        }
    }

    /**
     * Support method Mingle
     * @param
     * @return
     */

    public void mingle(int mood, int mode)
    {  

        if(mode == 1)//Same Location
        {

            for(int i=0;i<persons.length;i++)
            {
                Citizen citizen1 = (Citizen)persons[i];
                citizen1.setMood(mood);
                for(int j =0;j<persons.length;j++)
                {
                    Citizen citizen2 = (Citizen)persons[j];
                    if (citizen2.compareTo(citizen1)!=0)
                    {
                        if(citizen1.getLocation().equals(citizen2.getLocation()))
                        {
                            citizen1.meet(citizen2);
                        }
                    }
                }
            }
        }else if(mode ==2){ //Different Location
            for(int i=0;i<persons.length;i++)
            {

                Citizen citizen1 = (Citizen)persons[i];
                citizen1.setMood(mood);
                for(int j =0;j<persons.length;j++)
                {
                    Citizen citizen2 = (Citizen)persons[j];
                    if (citizen2.compareTo(citizen1)!=0)
                    {
                        if(!(citizen1.getLocation().equals(citizen2.getLocation())))
                        {
                            citizen1.meet(citizen2);
                        }
                    }
                }
            }

        }
    }

    /**
     * Support Method Update (Simulation of a hospital)
     * @param 
     * @return
     */
    public void update()
    {
        int i=0;
        for (Citizen citizen:citizens)
        {
            int size = citizen.getFriends().size();
            if (size==0)
            {
                citizen.setLocation("No FriendZone - Ward 21"); //No friends
            }else if(size>3){
                citizen.setLocation("FriendZone City"); //Too many friends man, wasting time!
            }

        }
    }

}