
/**
 * Write a description of class GofPanel2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GofPanel extends JPanel
{
    private JTextArea  msgtxt;
    private JTextField textFieldPeriod;
    private JComboBox combobox;
    private ButtonGroup buttonGrp;
    private Society society;
    String options[] = {"Same Location","Different Location","Random"};

    /**
     * Constructor for objects of class GofPanel2
     */
    public GofPanel(Society society)
    {
        this.setPreferredSize(new Dimension(1080,600));
        this.setBackground(new Color(0,255,0));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        this.society = society;

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel1.setBackground(new Color(200,255,247));

        JLabel label = new JLabel("Mood:");
        JRadioButton radiobutton1 = new JRadioButton("Good");
        radiobutton1.setActionCommand("Good");
        JRadioButton radiobutton2 = new JRadioButton("Bad");
        radiobutton2.setActionCommand("Bad");
        JRadioButton radiobutton3 = new JRadioButton("Neutral");
        radiobutton3.setActionCommand("Neutral");
        JRadioButton radiobutton4 = new JRadioButton("Random");
        radiobutton4.setActionCommand("Random");
        //action commands set for all radio buttons

        buttonGrp = new ButtonGroup();
        buttonGrp.add(radiobutton1);
        buttonGrp.add(radiobutton2);
        buttonGrp.add(radiobutton3);
        buttonGrp.add(radiobutton4);
        //radio buttons added to the button group so we can only select

        JLabel modelabel = new JLabel("Mode:");

        combobox = new JComboBox(options);

        JLabel periodlabel = new JLabel("Period:");

        textFieldPeriod = new JTextField();
        textFieldPeriod.setPreferredSize(new Dimension(50,30));

        JButton go = new JButton("Go");
        go.addActionListener(new ButtonClickListener());
      

        //action listener added for the go button which will be added to pannel

        panel1.add(label);
        panel1.add(radiobutton1);
        panel1.add(radiobutton2);
        panel1.add(radiobutton3);
        panel1.add(radiobutton4);
        panel1.add(modelabel);
        panel1.add(combobox);
        panel1.add(periodlabel);
        panel1.add(textFieldPeriod); 
        panel1.add(go);
        //all the component added to panel1

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(500,400));
        panel2.setBackground(new Color(228,255,250));
        //panel2 declared and initialized

        msgtxt = new JTextArea();
        msgtxt.setEditable(false);
        //stopping you from edditing the text in msgTxt textArea

        JScrollPane scrlPane = new JScrollPane(msgtxt);
        scrlPane.setPreferredSize(new Dimension(655,375));
        panel2.add(scrlPane);
        this.add(panel1);
        this.add(panel2);
        //two panels added to this GofPanel.

    }
    
    private class ButtonClickListener implements ActionListener {
        
        
        public void actionPerformed(ActionEvent e)
        {
             if(buttonGrp.getSelection() == null || textFieldPeriod.getText().equals(""))
            {
                msgtxt.setText("Error: Not all values were entered.");

            }else{

                String strmd;//string mood
                strmd = buttonGrp.getSelection().getActionCommand();
                //from the radio buttons abve which action commands were set, they are now received.
                int mood;
                if (strmd.equals("Bad"))
                {
                    mood = -1;
                }else if (strmd.equals("Good"))
                {
                    mood = 1;
                }else if (strmd.equals("Neutral"))
                {
                    mood=0;
                }else if (strmd.equals("Random"))
                {
                    Random rand = new Random();
                    mood = rand.nextInt(3)-1;
                    //used Random class to set the mood
                }else
                {
                    mood=0;
                }
                //mood of the mingling set from the action commands when buttons selected

                int mode = combobox.getSelectedIndex()+1;
                if(mode == 3)
                {
                    Random rand2 = new Random();
                    mode = rand2.nextInt(2)+1;
                    //used Random class to set the mode
                }
                int period =1;
                try{
                    period = Integer.parseInt(textFieldPeriod.getText());
                    //converted string literals to integer values using parseInt()
                    for(int i=0;i<period;i++)
                    {
                        society.tick(mood,mode);
                    }
                    String societyInfo = society.toString();

                    msgtxt.setText(societyInfo);

                }catch(NumberFormatException n)
                {
                    msgtxt.setText("Enter Integer Values Only Please");
                }
                //try catch for exception handling to catch NumberFormatException instead.
            }
        }

       
    }
}
