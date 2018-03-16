/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic.buttons2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author sire_marcos
 */
class Window extends JFrame implements ActionListener
{
    //Fields
    private final int X = 500;
    private final int Y = 150;
    private final int NBUTTONS = 5;
    private JButton[] arrayButtons;
    
    //Allocations
    Container content;
    
    //Constructor
    public Window() throws HeadlessException
    {
        setTitle("Actication/Desactivation");
        setSize(X, Y);
        content = getContentPane();
        content.setLayout(new FlowLayout());
        arrayButtons = new JButton[NBUTTONS];
        //
        for (int i = 0; i < NBUTTONS; i++)
        {
            //Each button is created dynamicaly
            arrayButtons[i] = new JButton("Button " + i);
            //The new button is added to the content
            content.add(arrayButtons[i]);
            //And add the action from a listener that is the window itself
            arrayButtons[i].addActionListener(this);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ev)
    {
        //Show the button state
        System.out.println("Button state = ");
        //Loop to activate buttons
        for (int i = 0; i < NBUTTONS; i++)
        {
            System.out.print(arrayButtons[i].isEnabled() + " ");
        }
        System.out.println();
        //Button instanciation from ActionEvent
        JButton source = (JButton) ev.getSource();
        //Desactivate button
        System.out.println("We desactivate the button: " + 
                source.getActionCommand());
        source.setEnabled(false);
    }
    
}
