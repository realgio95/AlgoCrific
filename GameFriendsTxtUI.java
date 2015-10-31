import java.util.Scanner;
/**
 * Write a description of class GameFriendsTxtUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameFriendsTxtUI
{
    // instance variables - replace the example below with your own
    Society soci;
    Scanner scan =new Scanner(System.in);
    /**
     * Constructor for objects of class GameFriendsTxtUI
     */

    public GameFriendsTxtUI(Society soci)
    {
        // initialise instance variables
        this.soci=soci;
    }

    /**
     * This is the start method - this method is invoked to start the user interface
     * 
     * @param 
     * @return     none
     */
    public void start()
    {
        String choice="";
        while(!choice.equals("END"))
        {
            System.out.println("A:Simulate Period");
            System.out.println("B:View Society");

            choice=scan.nextLine();

            if(choice.equals("A"))
            {
                soci.tick(1,1);
                System.out.println("Simulating...");
                try
                {
                    Thread.sleep(2000);
                }catch(Exception e)
                {

                }

                System.out.println("Simulation complete");
                System.out.println(soci);

            }
            if(choice.equals("B"))
            {
                System.out.println(soci);
            }

        }
    }
}
