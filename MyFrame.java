package group_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JPanel buttonPanel;
    JPanel textPanel;

    JButton aboutButton;
    JButton loadButton;
    JButton addButton;
    JButton saveButton;
    JButton visualizeButton;
    JButton darkButton;

    MyFrame() {

        //JFrame =  a GUI window to add components to
        //___________________________________________

        setDefaultLookAndFeelDecorated(true);
        this.setTitle("COVID Vaccines");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of app
        this.setResizable(false); //prevent frame from being resized
        this.setLayout(new BorderLayout());
        this.setSize(600, 600); //sets x and y dimensions of frame

        ImageIcon image = new ImageIcon("logo.png"); //create an image icon
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
        this.add(buttonPanel);

        //right-side panel
        textPanel = new JPanel();
        BoxLayout layout1 = new BoxLayout(textPanel, BoxLayout.X_AXIS);
        textPanel.setLayout(layout1);
        textPanel.setBackground(new Color(0xE8E8E8));
        textPanel.setBounds(142, 0, 500, 600);
        this.add(textPanel);
        //**************************************************************************************************************


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
        darkButton.setOpaque(true);
        darkButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        darkButton.addActionListener(this);
        buttonPanel.add(darkButton);



        this.setVisible(true); //make frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==aboutButton) {

        }
        if(e.getSource()==loadButton) {

        }
        if(e.getSource()==addButton) {

        }
        if(e.getSource()==saveButton) {

        }
        if(e.getSource()==visualizeButton) {

        }
        if(e.getSource()==darkButton) {
            ChangeColorMode(); //changes to dark or light mode
            this.repaint();

        }
    }

    public void ChangeColorMode() {

        if (textPanel.getBackground() == Color.black) {
            buttonPanel.setBackground(new Color(0xFAFAFA));
            textPanel.setBackground(new Color(0xE8E8E8));
        }
        else {
            buttonPanel.setBackground(new Color(0x484848));
            textPanel.setBackground(Color.black);
        }
        if(darkButton.getText().equals("Dark Mode"))
            darkButton.setText("Light Mode");
        else
            darkButton.setText("Dark Mode");
    }

}
