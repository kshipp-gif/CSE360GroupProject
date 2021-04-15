package group_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.io.*;
import javax.swing.JTable;

public class MyFrame extends JFrame implements ActionListener {

    private int ID;
    private String lastName, firstName, vaccineType, vaccinationDate, vaccineLocation;

    private JPanel buttonPanel;
    private JPanel textPanel;

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

    private JTextField addDateField;
    private JTextField IDField;

    private JFileChooser fc;
    private JScrollPane scrollPane;
    private JScrollPane tableScrollPane;

    private Iterator database = new Iterator();
    private int rows;
    private Object[][] data;

    private JLabel addIDL;
    private JLabel addFirstNameL;
    private JLabel addLastNameL;
    private JLabel addVaccineTypeL;
    private JLabel addVaccinationDateL;
    private JLabel addVaccineLocationL;

    private JTextArea addIDTA;
    private JTextArea addLastNameTA;
    private JTextArea addFirstNameTA;
    private JTextArea addVaccineTypeTA;
    private JTextArea addVaccinationDateTA;
    private JTextArea addVaccineLocationTA;

    private JButton addSubmitButton;
//**********************************************************************************************************************
//**********************************************************************************************************************
//**********************************************************************************************************************

    MyFrame() {

        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        //JFrame =  a GUI window to add components to
        //___________________________________________

        setDefaultLookAndFeelDecorated(true);
        this.setTitle("COVID Vaccines");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of app
        this.setResizable(true); //prevent frame from being resized
        this.setLayout(new BorderLayout());
        this.setSize(600, 600); //sets x and y dimensions of frame

        ImageIcon image = new ImageIcon("logo.png"); //create an image icon
        this.setIconImage(image.getImage()); //change icon of frame
        this.getContentPane().setBackground(new Color(0xE8E8E8)); //ASU design standard bg color
//**********************************************************************************************************************
//**********************************************************************************************************************
//**********************************************************************************************************************


        //JPanel = a GUI component that functions as a container to hold other components
        //_______________________________________________________________________________

        //left-side panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null); //no layout manager so buttons can be manually placed
        buttonPanel.setBackground(new Color(0xFAFAFA)); //ASU design standard bg color
        buttonPanel.setBounds(0, 0, 142, 600);
        this.getContentPane().add(buttonPanel);

        //right-side panel
        textPanel = new JPanel();
        textPanel.setLayout(null);
        textPanel.setBackground(new Color(0xE8E8E8));
        textPanel.setBounds(142, 0, 500, 600);
        this.getContentPane().add(textPanel);
//**********************************************************************************************************************
//**********************************************************************************************************************
//**********************************************************************************************************************


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
        /* Placeholder Code

        addLabel = new JLabel("<html>This is a placeholder for add</html>");
        addLabel.setBounds(150, 0, 200, 150);
        addLabel.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addLabel.setForeground(Color.black);
        addLabel.setVisible(false);
        textPanel.add(addLabel);

        Code edits made by James Thomas */

        //Add ID
        addIDL = new JLabel("ID: ");
        addIDL.setBounds(150, 5, 200, 25);
        addIDL.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addIDL.setForeground(Color.black);
        addIDL.setVisible(false);
        textPanel.add(addIDL);

        addIDTA = new JTextArea("");
        addIDTA.setBounds(350, 5, 200, 25);
        addIDTA.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addIDTA.setEditable(true);
        addIDTA.setVisible(false);
        textPanel.add(addIDTA);

        //Add Last Name
        addLastNameL = new JLabel("Last Name: ");
        addLastNameL.setBounds(150, 35, 200, 25);
        addLastNameL.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addLastNameL.setForeground(Color.black);
        addLastNameL.setVisible(false);
        textPanel.add(addLastNameL);

        addLastNameTA = new JTextArea("");
        addLastNameTA.setBounds(350, 35, 200, 25);
        addLastNameTA.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addLastNameTA.setEditable(true);
        addLastNameTA.setVisible(false);
        textPanel.add(addLastNameTA);

        //Add First Name
        addFirstNameL = new JLabel("First Name: ");
        addFirstNameL.setBounds(150, 65, 200, 25);
        addFirstNameL.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addFirstNameL.setForeground(Color.black);
        addFirstNameL.setVisible(false);
        textPanel.add(addFirstNameL);

        addFirstNameTA = new JTextArea("");
        addFirstNameTA.setBounds(350, 65, 200, 25);
        addFirstNameTA.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addFirstNameTA.setEditable(true);
        addFirstNameTA.setVisible(false);
        textPanel.add(addFirstNameTA);

        //Add Vaccine Type
        addVaccineTypeL = new JLabel("Vaccine Type: ");
        addVaccineTypeL.setBounds(150, 95, 200, 25);
        addVaccineTypeL.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addVaccineTypeL.setForeground(Color.black);
        addVaccineTypeL.setVisible(false);
        textPanel.add(addVaccineTypeL);

        addVaccineTypeTA = new JTextArea("");
        addVaccineTypeTA.setBounds(350, 95, 200, 25);
        addVaccineTypeTA.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addVaccineTypeTA.setEditable(true);
        addVaccineTypeTA.setVisible(false);
        textPanel.add(addVaccineTypeTA);

        //Add Vaccination Date
        addVaccinationDateL = new JLabel("Vaccination Date: ");
        addVaccinationDateL.setBounds(150, 125, 200, 25);
        addVaccinationDateL.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addVaccinationDateL.setForeground(Color.black);
        addVaccinationDateL.setVisible(false);
        textPanel.add(addVaccinationDateL);

        addVaccinationDateTA = new JTextArea("");
        addVaccinationDateTA.setBounds(350, 125, 200, 25);
        addVaccinationDateTA.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addVaccinationDateTA.setEditable(true);
        addVaccinationDateTA.setVisible(false);
        textPanel.add(addVaccinationDateTA);

        //Add Vaccine Location
        addVaccineLocationL = new JLabel("Vaccine Location: ");
        addVaccineLocationL.setBounds(150, 155, 200, 25);
        addVaccineLocationL.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addVaccineLocationL.setForeground(Color.black);
        addVaccineLocationL.setVisible(false);
        textPanel.add(addVaccineLocationL);

        addVaccineLocationTA = new JTextArea("");
        addVaccineLocationTA.setBounds(350, 155, 200, 25);
        addVaccineLocationTA.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addVaccineLocationTA.setEditable(true);
        addVaccineLocationTA.setVisible(false);
        textPanel.add(addVaccineLocationTA);

        //Add submit button
        addSubmitButton = new JButton("Submit");
        addSubmitButton.setBounds(250, 185, 75, 30);
        addSubmitButton.setFocusable(false);
        addSubmitButton.setFont(new Font("Arial Regular",Font.BOLD,16));
        addSubmitButton.setForeground(Color.white);
        addSubmitButton.setBackground(new Color(0x8E0C3A));
        addSubmitButton.setOpaque(true);
        addSubmitButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        addSubmitButton.addActionListener(this);
        addSubmitButton.setVisible(false);
        textPanel.add(addSubmitButton);

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

        scrollPane = new JScrollPane(textPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(142,0,500,562);
        this.getContentPane().add(scrollPane);
//**********************************************************************************************************************
//**********************************************************************************************************************
//**********************************************************************************************************************


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
        loadButton.setFocusable(false);
        loadButton.setFont(new Font("Arial Regular",Font.BOLD,16));
        loadButton.setForeground(Color.white);
        loadButton.setBackground(new Color(0x8E0C3A));
        loadButton.setOpaque(true);
        loadButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        loadButton.addActionListener(this);
        buttonPanel.add(loadButton);

        addButton = new JButton("Add Data");
        addButton.setBounds(0,60,142,30);
        addButton.setFocusable(false);
        addButton.setFont(new Font("Arial Regular",Font.BOLD,16));
        addButton.setForeground(Color.white);
        addButton.setBackground(new Color(0x8E0C3A));
        addButton.setOpaque(true);
        addButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        saveButton = new JButton("Save Data");
        saveButton.setBounds(0,90,142,30);
        saveButton.setFocusable(false);
        saveButton.setFont(new Font("Arial Regular",Font.BOLD,16));
        saveButton.setForeground(Color.white);
        saveButton.setBackground(new Color(0x8E0C3A));
        saveButton.setOpaque(true);
        saveButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        saveButton.addActionListener(this);
        buttonPanel.add(saveButton);

        visualizeButton = new JButton("Visualize Data");
        visualizeButton.setBounds(0,120,142,30);
        visualizeButton.setFocusable(false);
        visualizeButton.setFont(new Font("Arial Regular",Font.BOLD,16));
        visualizeButton.setForeground(Color.black);
        visualizeButton.setBackground(new Color(0xFFC72C));
        visualizeButton.setOpaque(true);
        visualizeButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        visualizeButton.addActionListener(this);
        buttonPanel.add(visualizeButton);

        darkButton = new JButton("Dark Mode");
        darkButton.setBounds(0,531,142,30);
        darkButton.setFocusable(false);
        darkButton.setFont(new Font("Arial Regular",Font.BOLD,16));
        darkButton.setForeground(Color.white);
        darkButton.setBackground(new Color(0x8E0C3A));
        darkButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        darkButton.setOpaque(true);
        darkButton.addActionListener(this);
        buttonPanel.add(darkButton);
//**********************************************************************************************************************
//**********************************************************************************************************************
//**********************************************************************************************************************


        // MAKE ENTIRE FRAME VISIBLE
        this.setVisible(true);
    }
//**********************************************************************************************************************
//**********************************************************************************************************************
//**********************************************************************************************************************


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==aboutButton) {
            resetVisibility();
            aboutLabel.setVisible(true);
            database.printList();
        }
        if(e.getSource()==loadButton) {
            int returnVal = fc.showOpenDialog(MyFrame.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                resetVisibility();
                File file = fc.getSelectedFile(); // csv file that is opened
                /*loadLabel.setText("Opening: " + file.getName());
                loadLabel.setVisible(true);*/

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
                            database.addNewPatient(ID, lastName, firstName, vaccineType, vaccinationDate, vaccineLocation);
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
                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                tableScrollPane = new JScrollPane(table);
                tableScrollPane.setBounds(142, 0, 500, 600);
                textPanel.add(tableScrollPane);
            }
        }

        if(e.getSource()==addButton) {
            resetVisibility();
            addIDL.setVisible(true);
            addIDTA.setVisible(true);
            addLastNameL.setVisible(true);
            addLastNameTA.setVisible(true);
            addFirstNameL.setVisible(true);
            addFirstNameTA.setVisible(true);
            addVaccineTypeL.setVisible(true);
            addVaccineTypeTA.setVisible(true);
            addVaccinationDateL.setVisible(true);
            addVaccinationDateTA.setVisible(true);
            addVaccineLocationL.setVisible(true);
            addVaccineLocationTA.setVisible(true);
            addSubmitButton.setVisible(true);

        }
        if(e.getSource()==addSubmitButton) {
            //Add it to the list!
            database.addNewPatient(Integer.parseInt(addIDTA.getText()), addLastNameTA.getText(), addFirstNameTA.getText(),
                    addVaccineTypeTA.getText(), addVaccinationDateTA.getText(), addVaccineLocationTA.getText());
            addIDTA.setText("");
            addLastNameTA.setText("");
            addFirstNameTA.setText("");
            addVaccineTypeTA.setText("");
            addVaccinationDateTA.setText("");
            addVaccineLocationTA.setText("");
        }

        if(e.getSource()==saveButton) {
            int returnVal = fc.showSaveDialog(MyFrame.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                resetVisibility();
                File file = fc.getSelectedFile();
                saveLabel.setText("Saving: " + file.getName());
                saveLabel.setVisible(true);
            }
        }

        if(e.getSource()==visualizeButton) {
            resetVisibility();
            visualLabel.setVisible(true);
        }

        if(e.getSource()==darkButton) {
            changeColorMode(); //changes to dark or light mode
        }
    }

    //functionality for dark mode
    private void changeColorMode() {
        if (textPanel.getBackground().equals(Color.black)) {            // if dark gray
            buttonPanel.setBackground(new Color(0xFAFAFA));         // set button panel to white-ish
            textPanel.setBackground(new Color(0xE8E8E8));           // set data panel to white-ish-ish
            aboutLabel.setForeground(Color.black);                      // set aboutLabel font to black
            loadLabel.setForeground(Color.black);                       // set loadLabel font to black
            addLabel.setForeground(Color.black);                        // set addLabel font to black
            saveLabel.setForeground(Color.black);                       // set saveLabel font to black
            visualLabel.setForeground(Color.black);                     // set visualLabel font to black
        }

        else {
            buttonPanel.setBackground(new Color(0x484848));         // else set button panel to light grey
            textPanel.setBackground(Color.black);                       //  set data panel to dark grey
            aboutLabel.setForeground(Color.white);                      // set aboutLabel font to white
            loadLabel.setForeground(Color.white);                       // set the loadLabel font to white
            addLabel.setForeground(Color.white);                        // set the addLabel font to white
            saveLabel.setForeground(Color.white);                       // set visual label font to white
            visualLabel.setForeground(Color.white);                     // set visualLabel font to white

        }
        // changes the text on the button itself
        if(darkButton.getText().equals("Dark Mode"))
            darkButton.setText("Light Mode");
        else
            darkButton.setText("Dark Mode");

        repaint();      // repaints the frame to update colors

    }

    private void resetVisibility() {
        aboutLabel.setVisible(false);

        /* Load Button Stuff */
        loadLabel.setVisible(false);
        for(int i = 0; i < textPanel.getComponentCount(); i ++) {
            if(textPanel.getComponent(i) == tableScrollPane) {
                tableScrollPane.setVisible(false);
            }
        }

        /* Add Text Areas and Button */
        addIDL.setVisible(false);
        addIDTA.setVisible(false);
        addLastNameL.setVisible(false);
        addLastNameTA.setVisible(false);
        addFirstNameL.setVisible(false);
        addFirstNameTA.setVisible(false);
        addVaccineTypeL.setVisible(false);
        addVaccineTypeTA.setVisible(false);
        addVaccinationDateL.setVisible(false);
        addVaccinationDateTA.setVisible(false);
        addVaccineLocationL.setVisible(false);
        addVaccineLocationTA.setVisible(false);
        addSubmitButton.setVisible(false);


        saveLabel.setVisible(false);
        visualLabel.setVisible(false);
    }

}
