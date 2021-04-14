package group_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.util.Scanner;
import java.io.*;
import java.swing.JTable;


public class MyFrame extends JFrame implements ActionListener {

    private int ID, rows;
    private String lastName, firstName, vaccineType, vaccinationDate, vaccineLocation;
    
    private JPanel buttonPanel;             // left panel with buttons
    private JPanel textPanel;               // right panel that displays data stuff

    private JLabel aboutLabel;
    private JLabel loadLabel;
    private JLabel addLabel;
    private JLabel saveLabel;
    private JLabel visualLabel;

    private JButton aboutButton;
    private JButton loadButton;
    private JButton addButton;
    private JButton saveButton;
    private JButton visualizeButton;
    private JButton darkButton;
    
    private Scanner scnr;
    private Iterator blah = new Iterator();
    private Object[][] data;

    private JFileChooser fc;                // handles the file chooser dialog box
    private JScrollPane scrollPane;          // handles the scroll bars
    //ScrollPane scrollPane;


    MyFrame() {

        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);


        //JFrame =  a GUI window to add components to
        //___________________________________________

        setDefaultLookAndFeelDecorated(true);       // sets the look and feel to local OS
        this.setTitle("COVID Vaccines");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of app
        this.setResizable(false); //prevent frame from being resized
        this.setLayout(null);
        this.setSize(600, 600); //sets x and y dimensions of frame


        ImageIcon image = new ImageIcon("logo.png"); //create an image icon for taskbar and app window
        this.setIconImage(image.getImage()); //change icon of frame
        this.getContentPane().setBackground(new Color(0xE8E8E8)); //ASU design standard bg color
        //**************************************************************************************************************


        //JPanel = a GUI component that functions as a container to hold other components
        //_______________________________________________________________________________

        //left-side button panel
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
        //textPanel.setLayout(new BorderLayout());
        textPanel.setLayout(null);
        textPanel.setBackground(new Color(0xE8E8E8));
        textPanel.setBounds(142, 0, 500, 600);
        this.getContentPane().add(textPanel);
        //textPanel.add(scrollPane);
        //**************************************************************************************************************


        //JLabel = a GUI display area for a string of text, an image, or both
        //___________________________________________________________________

        //**** about section ****
        aboutLabel = new JLabel("<html>Team #13<br>Fonz Hamilton<br>James Evans" +
                "<br>James Thomas<br>Karson Shipp</html>");
        aboutLabel.setBounds(150,0,200,150);
        aboutLabel.setFont(new Font("Arial Regular",Font.BOLD,20));
        aboutLabel.setForeground(Color.black);
        aboutLabel.setHorizontalAlignment(2);        // sets the text horizontal alignment. 2 = LEFT
        aboutLabel.setVerticalAlignment(1);          // sets the text vertical alignment. 1 = TOP
        aboutLabel.setVisible(false);
        textPanel.add(aboutLabel);

        /**
         * TODO make load functional
         */
        //**** load label ****
        //loadLabel = new JLabel("<html>This is a placeholder for load</html>");
        loadLabel = new JLabel();
        loadLabel.setBounds(150, 0, 500, 150);
        loadLabel.setFont(new Font("Arial Regular", Font.BOLD, 20));
        loadLabel.setForeground(Color.black);
        loadLabel.setHorizontalAlignment(2);        // sets the horizontal text alignment. 2 = LEFT
        loadLabel.setVerticalAlignment(1);          // sets the vertical text alignment. 1 = TOP
        loadLabel.setVisible(false);
        textPanel.add(loadLabel);

        /**
         * TODO make Add functional
         */
        // **** Add label ****
        // ***** the 'f' are for testing scroll *** Delete later ******
        addLabel = new JLabel("<html>This is a placeholder for addfff fffffffffffffffffff ffffffffffffffffffffffffff fffffffffffffffffffffffffffffff f</html>");
        addLabel.setBounds(150, 0, 700, 150);
        addLabel.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addLabel.setForeground(Color.black);
        addLabel.setHorizontalAlignment(2);        // sets the horizontal text alignment. 2 = LEFT
        addLabel.setVerticalAlignment(1);          // sets the vertical text alignment. 1 = TOP
        addLabel.setVisible(false);
        textPanel.add(addLabel);

        /**
         * TODO make Save functional
         */
        //**** Save Label ****
        saveLabel = new JLabel("<html>This is a placeholder for save</html>");
        saveLabel.setBounds(150, 0, 600, 150);
        saveLabel.setFont(new Font("Arial Regular", Font.BOLD, 20));
        saveLabel.setForeground(Color.black);
        saveLabel.setHorizontalAlignment(2);        // sets the horizontal text alignment. 2 = LEFT
        saveLabel.setVerticalAlignment(1);          // sets the vertical text alignment. 1 = TOP
        saveLabel.setVisible(false);
        textPanel.add(saveLabel);

        /**
         *  TODO make Visualize functional
         */
        //**** Visual Label ****
        visualLabel = new JLabel("<html>This is a placeholder for Visualize</html>");
        visualLabel.setBounds(150, 0, 200, 150);
        visualLabel.setHorizontalAlignment(2);      // sets the horizontal text alignment. 2 = LEFT
        visualLabel.setVerticalAlignment(1);        // sets the vertical text alignment. 1 = TOP
        visualLabel.setFont(new Font("Arial Regular", Font.BOLD, 20));
        visualLabel.setForeground(Color.black);
        visualLabel.setVisible(false);
        textPanel.add(visualLabel);

        //**** ScrollPane *****************************************************************************
        scrollPane = new JScrollPane(textPanel);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(142, 0, 452, 561);

        scrollPane.getViewport().setBackground(new Color(0xE8E8E8));

        scrollPane.setVisible(true);
        //add(scrollPane, BorderLayout.PAGE_START);
        add(scrollPane);

        //JButton = a button that performs an action when clicked on
        //__________________________________________________________

        aboutButton = new JButton("About");
        aboutButton.setSize(new Dimension(142, 30));
        aboutButton.setFocusable(false); //gets rid of highlight box when clicked
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
            resetVisibility();                          // reset visibility 
            scrollPane.setViewportView(aboutLabel);     // set the viewport for the scrollpane to addLabel

            //scrollPane.setPreferredSize(new Dimension(150,0));
            scrollPane.setVisible(true);                // make the scrollPane visible
            aboutLabel.setVisible(true);                // make the label visible
        }
        else if(e.getSource()==loadButton) {

            int returnVal = fc.showOpenDialog(MyFrame.this);        // opens dialog box for opening file
            
            // if function for choosing file
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                resetVisibility();
                File file = fc.getSelectedFile();
                loadLabel.setText("Opening: " + file.getName());
                loadLabel.setVisible(true);
                
                String line = "";
                String delim = ","; // delimiter to parse csv files
                int count = 0;
                rows = 0;

                try {
                    Scanner scnr = new Scanner(file);
                    while(scnr.hasNextLine()) {
                        scnr.nextLine();
                        rows++;
                    }
                    scnr.close();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }

                data = new Object[rows-1][6];
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    while ((line = br.readLine()) != null) {    // while there is a line to read (i.e., not EOF)
                        if (count > 0) {                        // count is just to skip the first line holding irrelevant data
                            String[] arr = line.split(delim);   // fills arr with the delimited strings from the each line
                            data[count - 1] = arr;              // fills the 2d data array for the JTable below
                            ID = Integer.parseInt(arr[0]);      // convert ID string to int
                            lastName = arr[1];
                            firstName = arr[2];
                            vaccineType = arr[3];
                            vaccinationDate = arr[4];
                            vaccineLocation = arr[5];
                            blah.addNewPatient(ID, lastName, firstName, vaccineType, vaccinationDate, vaccineLocation);
                        }
                        count++;
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                String[] columnNames = {
                        "ID",
                        "Last Name",
                        "First Name",
                        "Vaccine Type",
                        "Vaccination Date",
                        "Vaccine Location"  };

                JTable table = new JTable(data, columnNames);
                table.setVisible(true);
                table.setPreferredScrollableViewportSize(new Dimension(100,50));
                table.setFillsViewportHeight(true);
                JScrollPane scrollPane1 = new JScrollPane(table);
                scrollPane1.setBounds(142, 0, 500, 600);
                textPanel.add(scrollPane1);
            }
        }
        else if(e.getSource()==addButton) {
            resetVisibility();
            scrollPane.setViewportView(addLabel);
            scrollPane.setVisible(true);
            addLabel.setVisible(true);

        }
        else if(e.getSource()==saveButton) {
            int returnVal = fc.showSaveDialog(MyFrame.this);        // opens dialog box for saving
            // if statement for saving file
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                resetVisibility();
                File file = fc.getSelectedFile();
                saveLabel.setText("Saving: " + file.getName());
                saveLabel.setVisible(true);
            }

        }
        else if(e.getSource()==visualizeButton) {
            resetVisibility();
            scrollPane.setViewportView(visualLabel);
            scrollPane.setVisible(true);
            visualLabel.setVisible(true);

        }
        else if(e.getSource()==darkButton) {
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
            scrollPane.getViewport().setBackground(new Color(0xE8E8E8));

        }

        else {
            buttonPanel.setBackground(new Color(0x484848)); // else set button panel to light grey
            textPanel.setBackground(Color.black);               //  set data panel to dark grey
            aboutLabel.setForeground(Color.white);              // set aboutLabel font to white
            loadLabel.setForeground(Color.white);               // set the loadLabel font to white
            addLabel.setForeground(Color.white);                // set the addLabel font to white
            saveLabel.setForeground(Color.white);               // set visual label font to white
            visualLabel.setForeground(Color.white);             // set visualLabel font to white
            scrollPane.getViewport().setBackground(Color.black);
            scrollPane.getHorizontalScrollBar().setBackground(new Color(0x484848));


        }
        // changes the text on the button itself
        if(darkButton.getText().equals("Dark Mode"))
            darkButton.setText("Light Mode");
        else
            darkButton.setText("Dark Mode");

        repaint();      // repaints the frame to update colors

    }

    /**
     * Method to set all labels to false. Also sets resets scrollPane. Call this method before setting a label to true
     */
    private void resetVisibility() {
        aboutLabel.setVisible(false);
        loadLabel.setVisible(false);
        addLabel.setVisible(false);
        saveLabel.setVisible(false);
        visualLabel.setVisible(false);

        scrollPane.setVisible(false);
    }

}
