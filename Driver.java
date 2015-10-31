/**
 * Driver Class for the COMP1161 Project
 * 
 * Giovanni HoSang 620076323
 * Mark Ford -620081226
 * Mikhail Rhone - 620075969
 * @version (April 16,2015)
 */
import gof.*;
import java.util.*;
import java.util.ArrayList;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Driver

{
    // A lean main method. The way it should be
    public Driver()
    {
       
        Society game = new Society("GAZA SOCIETY", 2014, "samplesocietyv2.txt");
        GofPanel panel2 = new GofPanel(game);
       
        JFrame jframe = new JFrame("Society");
        jframe.setResizable(false);
        jframe.setBackground(new Color(255,0,0));
        jframe.setPreferredSize(new Dimension(800,500));      
        jframe.getContentPane().add(panel2);
        jframe.setLocationRelativeTo(null);
        jframe.pack();
        jframe.setVisible(true);

    }

    public static void main(String[] args)
    {

        new Driver();   
    }

}
