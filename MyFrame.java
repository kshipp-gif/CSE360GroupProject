package group_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JPanel buttonPanel;             // left panel with buttons
    JPanel textPanel;               // right panel that displays data stuff

    JLabel aboutLabel;
    JLabel loadLabel;
    JLabel addLabel;
    JLabel saveLabel;
    JLabel visualLabel;

    JButton aboutButton;
    JButton loadButton;
    JButton addButton;
    JButton saveButton;
    JButton visualizeButton;
    JButton darkButton;

    MyFrame() {

        //JFrame =  a GUI window to add components to
        //___________________________________________

        setDefaultLookAndFeelDecorated(true);       // sets the look and feel to local OS
        this.setTitle("COVID Vaccines");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of app
        this.setResizable(false); //prevent frame from being resized
        this.setLayout(new BorderLayout());
        this.setSize(600, 600); //sets x and y dimensions of frame

        ImageIcon image = new ImageIcon("logo.png"); //create an image icon for taskbar and app window
        this.setIconImage(image.getImage()); //change icon of frame
        this.getContentPane().setBackground(new Color(0xE8E8E8)); //ASU design standard bg color
        //**************************************************************************************************************


        //JPanel = a GUI component that functions as a container to hold other components
        //_______________________________________________________________________________

        //left-side panel
        buttonPanel = new JPanel();
        //BoxLayout layout0 = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        //buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 1));
        buttonPanel.setLayout(null); //no layout manager so buttons can be manually placed
        buttonPanel.setBackground(new Color(0xFAFAFA)); //ASU design standard bg color
        buttonPanel.setBounds(0, 0, 142, 600);
        this.getContentPane().add(buttonPanel);

        //right-side panel
        textPanel = new JPanel();
        //BoxLayout layout1 = new BoxLayout(textPanel, BoxLayout.X_AXIS);
        textPanel.setLayout(null);
        textPanel.setBackground(new Color(0xE8E8E8));
        textPanel.setBounds(142, 0, 500, 600);
        this.getContentPane().add(textPanel);
        //**************************************************************************************************************


        //JLabel = a GUI display area for a string of text, an image, or both
        //___________________________________________________________________

        //**** about section ****
        aboutLabel = new JLabel("<html>Team #13<br>Fonz Hamilton<br>James Evans" +
                "<br>James Thomas<br>Karson Shipp</html>");
        aboutLabel.setBounds(150,0,200,150);
        aboutLabel.setFont(new Font("Arial Regular",Font.BOLD,20));
        aboutLabel.setForeground(Color.black);
        aboutLabel.setVisible(false);
        textPanel.add(aboutLabel);

        /**
         * TODO make load functional
         */
        //**** load label ****
        loadLabel = new JLabel("<html>This is a placeholder for load</html>");
        loadLabel.setBounds(150, 0, 200, 150);
        loadLabel.setFont(new Font("Arial Regular", Font.BOLD, 20));
        loadLabel.setForeground(Color.black);
        loadLabel.setVisible(false);
        textPanel.add(loadLabel);

        /**
         * TODO make Add functional
         */
        // **** Add label ****
        addLabel = new JLabel("<html>This is a placeholder for add</html>");
        addLabel.setBounds(150, 0, 200, 150);
        addLabel.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addLabel.setForeground(Color.black);
        addLabel.setVisible(false);
        textPanel.add(addLabel);

        /**
         * TODO make Save functional
         */
        //**** Save Label ****
        saveLabel = new JLabel("<html>This is a placeholder for save</html>");
        saveLabel.setBounds(150, 0, 200, 150);
        saveLabel.setFont(new Font("Arial Regular", Font.BOLD, 20));
        saveLabel.setForeground(Color.black);
        saveLabel.setVisible(false);
        textPanel.add(saveLabel);

        /**
         *  TODO make Visualize functional
         */
        //**** Visual Label ****
        visualLabel = new JLabel("<html>This is a placeholder for Visualize</html>");
        visualLabel.setBounds(150, 0, 200, 150);
        visualLabel.setFont(new Font("Arial Regular", Font.BOLD, 20));
        visualLabel.setForeground(Color.black);
        visualLabel.setVisible(false);
        textPanel.add(visualLabel);

        //JButton = a button that performs an action when clicked on
        //__________________________________________________________

        aboutButton = new JButton("About");
        aboutButton.setSize(new Dimension(142, 30));
        //aboutButton.setFocusable(false); //gets rid of highlight box when clicked
        aboutButton.addActionListener(this);
        //aboutButton.addActionListener(e -> lambda expression)
        aboutButton.setFont(new Font("Arial Regular",Font.BOLD,16));
        aboutButton.setForeground(Color.white);
        aboutButton.setBackground(new Color(0x8E0C3A));
        aboutButton.setOpaque(true);
        aboutButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        buttonPanel.add(aboutButton);

        loadButton = new JButton("Load Data");
        loadButton.setBounds(0,30,142,30);
        loadButton.setFont(new Font("Arial Regular",Font.BOLD,16));
        loadButton.setForeground(Color.white);
        loadButton.setBackground(new Color(0x8E0C3A));
        loadButton.setOpaque(true);
        loadButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        loadButton.addActionListener(this);
        buttonPanel.add(loadButton);

        addButton = new JButton("Add Data");
        addButton.setBounds(0,60,142,30);
        addButton.setFont(new Font("Arial Regular",Font.BOLD,16));
        addButton.setForeground(Color.white);
        addButton.setBackground(new Color(0x8E0C3A));
        addButton.setOpaque(true);
        addButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        saveButton = new JButton("Save Data");
        saveButton.setBounds(0,90,142,30);
        saveButton.setFont(new Font("Arial Regular",Font.BOLD,16));
        saveButton.setForeground(Color.white);
        saveButton.setBackground(new Color(0x8E0C3A));
        saveButton.setOpaque(true);
        saveButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        saveButton.addActionListener(this);
        buttonPanel.add(saveButton);

        visualizeButton = new JButton("Visualize Data");
        visualizeButton.setBounds(0,120,142,30);
        visualizeButton.setFont(new Font("Arial Regular",Font.BOLD,16));
        visualizeButton.setForeground(Color.black);
        visualizeButton.setBackground(new Color(0xFFC72C));
        visualizeButton.setOpaque(true);
        visualizeButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        visualizeButton.addActionListener(this);
        buttonPanel.add(visualizeButton);

        /*Dimension min = new Dimension(130, 350);
        Dimension max = new Dimension(130, 350);
        Dimension pref = new Dimension(130, 350);
        buttonPanel.add(new Box.Filler(min, pref, max));*/

        darkButton = new JButton("Dark Mode");
        darkButton.setBounds(0,531,142,30);
        darkButton.setFont(new Font("Arial Regular",Font.BOLD,16));
        darkButton.setForeground(Color.white);
        darkButton.setBackground(new Color(0x8E0C3A));
        darkButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        darkButton.setOpaque(true);
        darkButton.addActionListener(this);
        buttonPanel.add(darkButton);



        setVisible(true); //make frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==aboutButton) {
            resetVisibility();
            aboutLabel.setVisible(true);
        }
        if(e.getSource()==loadButton) {
            resetVisibility();
            loadLabel.setVisible(true);

        }
        if(e.getSource()==addButton) {
            resetVisibility();
            addLabel.setVisible(true);

        }
        if(e.getSource()==saveButton) {
            resetVisibility();
            saveLabel.setVisible(true);

        }
        if(e.getSource()==visualizeButton) {
            resetVisibility();
            visualLabel.setVisible(true);

        }
        if(e.getSource()==darkButton) {
            ChangeColorMode(); //changes to dark or light mode
        }
    }

    /**
     * Method to change the frame coloring from light mode to dark mode
     * Takes no input
     */
    private void ChangeColorMode() {

        if (textPanel.getBackground().equals(Color.black)) {// if dark grey
            buttonPanel.setBackground(new Color(0xFAFAFA));         // set button panel to white-ish
            textPanel.setBackground(new Color(0xE8E8E8));           // set data panel to white-ish-ish
            aboutLabel.setForeground(Color.black);                      // set aboutLabel font to black
            loadLabel.setForeground(Color.black);                       // set loadLabel font to black
            addLabel.setForeground(Color.black);                        // set addLabel font to black
            saveLabel.setForeground(Color.black);                       // set saveLabel font to black
            visualLabel.setForeground(Color.black);                     // set visualLabel font to black
        }

        else {
            buttonPanel.setBackground(new Color(0x484848)); // else set button panel to light grey
            textPanel.setBackground(Color.black);               //  set data panel to dark grey
            aboutLabel.setForeground(Color.white);              // set aboutLabel font to white
            loadLabel.setForeground(Color.white);               // set the loadLabel font to white
            addLabel.setForeground(Color.white);                // set the addLabel font to white
            saveLabel.setForeground(Color.white);               // set visual label font to white
            visualLabel.setForeground(Color.white);             // set visualLabel font to white

        }
        // changes the text on the button itself
        if(darkButton.getText().equals("Dark Mode"))
            darkButton.setText("Light Mode");
        else
            darkButton.setText("Dark Mode");

        repaint();      // repaints the frame to update colors

    }

    /**
     * Method to set all labels to false. Call this method before setting a label to true
     */
    private void resetVisibility() {
        aboutLabel.setVisible(false);
        loadLabel.setVisible(false);
        addLabel.setVisible(false);
        saveLabel.setVisible(false);
        visualLabel.setVisible(false);
    }
}
