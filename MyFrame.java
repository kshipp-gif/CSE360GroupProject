package group_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JButton aboutButton;
    JButton loadButton;
    JButton addButton;
    JButton saveButton;
    JButton visualizeButton;

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
        JPanel buttonPanel = new JPanel();
        BoxLayout layout0 = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        buttonPanel.setLayout(layout0);
        buttonPanel.setBackground(new Color(0xFAFAFA)); //ASU design standard bg color
        buttonPanel.setBounds(0, 0, 130, 600);
        this.add(buttonPanel);

        //right-side panel
        JPanel textPanel = new JPanel();
        BoxLayout layout1 = new BoxLayout(textPanel, BoxLayout.X_AXIS);
        textPanel.setLayout(layout1);
        textPanel.setBackground(new Color(0xE8E8E8));
        textPanel.setBounds(130, 0, 500, 600);
        this.add(textPanel);
        //**************************************************************************************************************


        //JButton = a button that performs an action when clicked on
        //__________________________________________________________

        aboutButton = new JButton("About");
        aboutButton.setMinimumSize(new Dimension(130, 30));
        aboutButton.setMaximumSize(new Dimension(130, 30));
        //aboutButton.setFocusable(false); //gets rid of highlight box when clicked
        aboutButton.addActionListener(this);
        //aboutButton.addActionListener(e -> lambda expression)
        aboutButton.setFont(new Font("Arial Regular",Font.BOLD,14));
        aboutButton.setForeground(Color.white);
        aboutButton.setBackground(new Color(0x8E0C3A));
        buttonPanel.add(aboutButton);

        loadButton = new JButton("Load Data");
        loadButton.setMinimumSize(new Dimension(130, 30));
        loadButton.setMaximumSize(new Dimension(130, 30));
        loadButton.setFont(new Font("Arial Regular",Font.BOLD,14));
        loadButton.setForeground(Color.white);
        loadButton.setBackground(new Color(0x8E0C3A));
        loadButton.addActionListener(this);
        buttonPanel.add(loadButton);

        addButton = new JButton("Add Data");
        addButton.setMinimumSize(new Dimension(130, 30));
        addButton.setMaximumSize(new Dimension(130, 30));
        addButton.setFont(new Font("Arial Regular",Font.BOLD,14));
        addButton.setForeground(Color.white);
        addButton.setBackground(new Color(0x8E0C3A));
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        saveButton = new JButton("Save Data");
        saveButton.setMinimumSize(new Dimension(130, 30));
        saveButton.setMaximumSize(new Dimension(130, 30));
        saveButton.setFont(new Font("Arial Regular",Font.BOLD,14));
        saveButton.setForeground(Color.white);
        saveButton.setBackground(new Color(0x8E0C3A));
        saveButton.addActionListener(this);
        buttonPanel.add(saveButton);

        visualizeButton = new JButton("Visualize Data");
        visualizeButton.setFont(new Font("Arial Regular",Font.BOLD,14));
        visualizeButton.setForeground(Color.black);
        visualizeButton.setBackground(new Color(0xFFC72C));
        visualizeButton.addActionListener(this);
        buttonPanel.add(visualizeButton);


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
    }
}
