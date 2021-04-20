package group_project;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.io.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class MyFrame extends JFrame implements ActionListener {

    private int ID;
    private String lastName, firstName, vaccineType, vaccinationDate, vaccineLocation;
    private boolean darkModeBool = false;

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
    private JButton displayButton;

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

    private String[] columnNames = {
            "ID",
            "Last Name",
            "First Name",
            "Vaccine Type",
            "Vaccination Date",
            "Vaccine Location"  };

    private DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
    private JTable table = new JTable(tableModel);


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
        this.setResizable(false); //prevent frame from being resized
        this.setLayout(null);
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
        aboutLabel.setBounds(50,0,200,150);
        aboutLabel.setFont(new Font("Arial Regular",Font.BOLD,20));
        aboutLabel.setForeground(Color.black);
        //aboutLabel.setHorizontalAlignment(2);        // sets the text horizontal alignment. 2 = LEFT
        aboutLabel.setVerticalAlignment(1);          // sets the text vertical alignment. 1 = TOP
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
        //Placeholder Code

        addLabel = new JLabel();
        addLabel.setBounds(0, 0, 200, 150);
        addLabel.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addLabel.setForeground(Color.black);
        //addLabel.setHorizontalAlignment(2);        // sets the horizontal text alignment. 2 = LEFT
        //addLabel.setVerticalAlignment(1);          // sets the vertical text alignment. 1 = TOP
        addLabel.setVisible(false);
        textPanel.add(addLabel);

        //Code edits made by James Thomas

        //Add ID
        addIDL = new JLabel("ID: ");
        addIDL.setBounds(10, 5, 200, 25);
        addIDL.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addIDL.setForeground(Color.black);
        addIDL.setVisible(false);
        addLabel.add(addIDL);

        addIDTA = new JTextArea("");
        addIDTA.setBounds(200, 5, 200, 25);
        addIDTA.setFont(new Font("Arial Regular", Font.BOLD, 20));

        addIDTA.setEditable(true);
        addIDTA.setVisible(false);
        addLabel.add(addIDTA);

        //Add Last Name
        addLastNameL = new JLabel("Last Name: ");
        addLastNameL.setBounds(10, 35, 200, 25);
        addLastNameL.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addLastNameL.setForeground(Color.black);
        addLastNameL.setVisible(false);
        addLabel.add(addLastNameL);

        addLastNameTA = new JTextArea("");
        addLastNameTA.setBounds(200, 35, 200, 25);
        addLastNameTA.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addLastNameTA.setEditable(true);
        addLastNameTA.setVisible(false);
        addLabel.add(addLastNameTA);

        //Add First Name
        addFirstNameL = new JLabel("First Name: ");
        addFirstNameL.setBounds(10, 65, 200, 25);
        addFirstNameL.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addFirstNameL.setForeground(Color.black);
        addFirstNameL.setVisible(false);
        addLabel.add(addFirstNameL);

        addFirstNameTA = new JTextArea("");
        addFirstNameTA.setBounds(200, 65, 200, 25);
        addFirstNameTA.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addFirstNameTA.setEditable(true);
        addFirstNameTA.setVisible(false);
        addLabel.add(addFirstNameTA);

        //Add Vaccine Type
        addVaccineTypeL = new JLabel("Vaccine Type: ");
        addVaccineTypeL.setBounds(10, 95, 200, 25);
        addVaccineTypeL.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addVaccineTypeL.setForeground(Color.black);
        addVaccineTypeL.setVisible(false);
        addLabel.add(addVaccineTypeL);

        addVaccineTypeTA = new JTextArea("");
        addVaccineTypeTA.setBounds(200, 95, 200, 25);
        addVaccineTypeTA.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addVaccineTypeTA.setEditable(true);
        addVaccineTypeTA.setVisible(false);
        addLabel.add(addVaccineTypeTA);

        //Add Vaccination Date
        addVaccinationDateL = new JLabel("Vaccination Date: ");
        addVaccinationDateL.setBounds(10, 125, 200, 25);
        addVaccinationDateL.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addVaccinationDateL.setForeground(Color.black);
        addVaccinationDateL.setVisible(false);
        addLabel.add(addVaccinationDateL);

        addVaccinationDateTA = new JTextArea("");
        addVaccinationDateTA.setBounds(200, 125, 200, 25);
        addVaccinationDateTA.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addVaccinationDateTA.setEditable(true);
        addVaccinationDateTA.setVisible(false);
        addLabel.add(addVaccinationDateTA);

        //Add Vaccine Location
        addVaccineLocationL = new JLabel("Vaccine Location: ");
        addVaccineLocationL.setBounds(10, 155, 200, 25);
        addVaccineLocationL.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addVaccineLocationL.setForeground(Color.black);
        addVaccineLocationL.setVisible(false);
        addLabel.add(addVaccineLocationL);

        addVaccineLocationTA = new JTextArea("");
        addVaccineLocationTA.setBounds(200, 155, 200, 25);
        addVaccineLocationTA.setFont(new Font("Arial Regular", Font.BOLD, 20));
        addVaccineLocationTA.setEditable(true);
        addVaccineLocationTA.setVisible(false);
        addLabel.add(addVaccineLocationTA);

        //Add submit button
        addSubmitButton = new JButton("Submit");
        addSubmitButton.setBounds(150, 185, 75, 30);
        addSubmitButton.setFocusable(false);
        addSubmitButton.setFont(new Font("Arial Regular",Font.BOLD,16));
        addSubmitButton.setForeground(Color.white);
        addSubmitButton.setBackground(new Color(0x8E0C3A));
        addSubmitButton.setOpaque(true);
        addSubmitButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        addSubmitButton.addActionListener(this);
        addSubmitButton.setVisible(false);
        addLabel.add(addSubmitButton);

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
        scrollPane.setBounds(142,0,452,562);
        scrollPane.getViewport().setBackground(new Color(0xE8E8E8));
        //scrollPane.setVisible(true);
        //this.getContentPane().add(scrollPane);
        add(scrollPane);
        scrollPane.add(table);
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

        displayButton = new JButton("Display Table");
        displayButton.setBounds(0,150,142,30);
        displayButton.setFocusable(false);
        displayButton.setFont(new Font("Arial Regular",Font.BOLD,16));
        displayButton.setForeground(Color.white);
        displayButton.setBackground(new Color(0x8E0C3A));
        displayButton.setOpaque(true);
        displayButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        displayButton.addActionListener(this);
        buttonPanel.add(displayButton);

// **********************************************************************************************************************
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
            scrollPane.setVisible(true);
            scrollPane.setViewportView(aboutLabel);
            aboutLabel.setVisible(true);

        }
        else if(e.getSource()==loadButton) {
            int returnVal = fc.showOpenDialog(MyFrame.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                resetVisibility();
                scrollPane.setVisible(true);
                scrollPane.setViewportView(loadLabel);
                tableModel.setRowCount(0);
                File file = fc.getSelectedFile(); // csv file that is opened

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
                database = new Iterator();
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
                table = new JTable(data, columnNames);
                if (darkModeBool == false) {
                    table.setForeground(Color.black);                   // table font color
                    table.setBackground(new Color(0xE8E8E8));       // table bg color
                    table.getTableHeader().setBackground(new Color(0xE8E8E8)); // change the top row bg color
                    table.getTableHeader().setForeground(Color.black);   // change the top row font color

                }
                else {
                    table.setForeground(Color.white);
                    table.setBackground(Color.black);
                    table.getTableHeader().setBackground(Color.black);
                    table.getTableHeader().setForeground(Color.white);
                }

                table.setVisible(true);
                setTableProperties(30,100);     // sets the row height, column width respectively

                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                scrollPane.setViewportView(table);
            }
        }

        else if(e.getSource()==addButton) {
            resetVisibility();
            addLabel.setVisible(true);
            scrollPane.setVisible(true);
            scrollPane.setViewportView(addLabel);
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
        else if(e.getSource()==addSubmitButton) {
            //Add it to the list!
            // if there is any error in textfield/not an integer in ID
            if (addIDTA.getText().equals("") || addLastNameTA.getText().equals("") || addFirstNameTA.getText().equals("")
                    || addVaccineTypeTA.getText().equals("") || addVaccinationDateTA.getText().equals("") ||
                    addVaccineLocationTA.getText().equals("") || !isNumeric(addIDTA.getText())) {
                warningBox("Please make sure ID is entirely numeric and no field is empty", "Error");
            }

            // else check for any duplicates
            else {
                Object[][] idCheck = database.getPatientInfo();
                boolean match = false;
                int rows = database.getRows();

                for (int i = 0; i < rows; i++) {
                    if (idCheck[i][0].equals(Integer.parseInt(addIDTA.getText()))) {
                        match = true;
                    }
                }
                //match if no duplicates
                if (match == false) {
                    database.addNewPatient(Integer.parseInt(addIDTA.getText()), addLastNameTA.getText(),
                            addFirstNameTA.getText(), addVaccineTypeTA.getText(), addVaccinationDateTA.getText(),
                            addVaccineLocationTA.getText());
                }
                else {
                    warningBox("ID already in use. Not added to the list.", "Error");

                }
            }


            addIDTA.setText("");
            addLastNameTA.setText("");
            addFirstNameTA.setText("");
            addVaccineTypeTA.setText("");
            addVaccinationDateTA.setText("");
            addVaccineLocationTA.setText("");
        }

        else if(e.getSource()==saveButton) {
            int returnVal = fc.showSaveDialog(MyFrame.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                resetVisibility();
                File file = fc.getSelectedFile();
                saveLabel.setText("Saving: " + file.getName());
                saveLabel.setVisible(true);
                
                Patient ptr = database.head;
                //Check for IO exception
                try {
                	//Create new file writer (and new file)
                	FileWriter writer = new FileWriter(file + ".csv");
                	System.out.println(file + ".csv");
                	
                	//Writing the Headers
                	writer.append("ID");
                	writer.append(',');
                	writer.append("Last Name");
                	writer.append(',');
                	writer.append("First Name");
                	writer.append(',');
                	writer.append("Vaccine Type");
                	writer.append(',');
                	writer.append("Vaccination Date");
                	writer.append(',');
                	writer.append("Vaccine Location");
                	writer.append('\n');
                	
                	while(ptr != null) {
                		//Read in the patients and parse their data
                    	writer.append("" + ptr.getID());
                    	writer.append(',');
                    	writer.append(ptr.getLastName());
                    	writer.append(',');
                    	writer.append(ptr.getFirstName());
                    	writer.append(',');
                    	writer.append(ptr.getVaccineType());
                    	writer.append(',');
                    	writer.append(ptr.getVaccinationDate());
                    	writer.append(',');
                    	writer.append(ptr.getVaccineLocation());
                    	writer.append('\n');     
                    	
                    	ptr = ptr.getNextPatient();
                	}
                	
                	writer.close();
                	
                }catch(IOException f) {
                	System.out.println("oof.");
                }
                
            }
        }

        else if(e.getSource()==visualizeButton) {
            resetVisibility();
            scrollPane.setVisible(true);
            visualLabel.setVisible(true);
        }

        else if(e.getSource()==displayButton) {
            resetVisibility();
            scrollPane.setVisible(true);
            scrollPane.setViewportView(textPanel);

            if (database.head != null) {
                scrollPane.setVisible(true);
                data = database.getPatientInfo();           // puts the list into data array
                table = new JTable(data, columnNames);      // creates a new table

                // dark mode shenanigans
                if (darkModeBool == false) {
                    table.setForeground(Color.black);                   // table font color
                    table.setBackground(new Color(0xE8E8E8));       // table bg color
                    table.getTableHeader().setBackground(new Color(0xE8E8E8)); // change the top row bg color
                    table.getTableHeader().setForeground(Color.black);   // change the top row font color

                }
                else {
                    table.setForeground(Color.white);
                    table.setBackground(Color.black);
                    table.getTableHeader().setBackground(Color.black);
                    table.getTableHeader().setForeground(Color.white);
                }

                table.setVisible(true);
                setTableProperties(30,100);     // sets the row height, column width respectively

                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                scrollPane.setViewportView(table);
            }
        }

        else if(e.getSource()==darkButton) {
            changeColorMode(); //changes to dark or light mode
        }
    }

    //functionality for dark mode
    private void changeColorMode() {
        if (textPanel.getBackground().equals(Color.black)) {            // if already in darkmode
            darkModeBool = false;
            buttonPanel.setBackground(new Color(0xFAFAFA));         // set button panel
            textPanel.setBackground(new Color(0xE8E8E8));           // set data panel
            aboutLabel.setForeground(Color.black);                      // set aboutLabel font
            loadLabel.setForeground(Color.black);                       // set loadLabel font
            addLabel.setForeground(Color.black);                        // set addLabel font
            saveLabel.setForeground(Color.black);                       // set saveLabel font
            visualLabel.setForeground(Color.black);                     // set visualLabel font

            scrollPane.getViewport().setBackground(new Color(0xE8E8E8));    // scrollpane bg color
            scrollPane.getViewport().setForeground(Color.black);        // set the scroll pane font color
            scrollPane.getHorizontalScrollBar().setBackground(new Color(0xE8E8E8));
            scrollPane.getVerticalScrollBar().setBackground(new Color(0xE8E8E8));

            table.setForeground(Color.black);                           // table font color
            table.setBackground(new Color(0xE8E8E8));               // table bg color
            table.getTableHeader().setBackground(new Color(0xE8E8E8));          // change the top row bg color
            table.getTableHeader().setForeground(Color.black);          // change the top row font color

            addIDL.setForeground(Color.black);                          // change the font of id label
            addIDTA.setBackground(Color.white);                         // change the bg of text area
            addIDTA.setForeground(Color.black);                         // change the font of text area
            addLastNameL.setForeground(Color.black);                    // change the font of lastName
            addLastNameTA.setBackground(Color.white);                   // change the bg of text area
            addLastNameTA.setForeground(Color.black);                   // change the font of text area
            addFirstNameL.setForeground(Color.black);                   // change the font of firstName
            addFirstNameTA.setBackground(Color.white);                  // change the bg of text area
            addFirstNameTA.setForeground(Color.black);                  // change the font of text area
            addVaccineTypeL.setForeground(Color.black);                 // change the font of vaccineType
            addVaccineTypeTA.setBackground(Color.white);                // change the bg of text area
            addVaccineTypeTA.setForeground(Color.black);                // change the font of text area
            addVaccinationDateL.setForeground(Color.black);             // change the font of vaccinationDate
            addVaccinationDateTA.setBackground(Color.white);            // change the bg of text area
            addVaccinationDateTA.setForeground(Color.black);            // change the font of text area
            addVaccineLocationL.setForeground(Color.black);             // change the font of vaccinationLocation
            addVaccineLocationTA.setBackground(Color.white);            // change the bg of text area
            addVaccineLocationTA.setForeground(Color.black);            // change the font of text area

            addIDTA.setCaretColor(Color.black);
            addLastNameTA.setCaretColor(Color.black);
            addFirstNameTA.setCaretColor(Color.black);
            addVaccineTypeTA.setCaretColor(Color.black);
            addVaccinationDateTA.setCaretColor(Color.black);
            addVaccineLocationTA.setCaretColor(Color.black);
        }

        else {                                                          // else change everything to dark mode
            darkModeBool = true;
            buttonPanel.setBackground(new Color(0x484848));         // else set button panel
            textPanel.setBackground(Color.black);                       //  set data panel
            aboutLabel.setForeground(Color.white);                      // set aboutLabel font
            loadLabel.setForeground(Color.white);                       // set the loadLabel font
            addLabel.setForeground(Color.white);                        // set the addLabel font
            saveLabel.setForeground(Color.white);                       // set visual label font
            visualLabel.setForeground(Color.white);                     // set visualLabel font

            scrollPane.getViewport().setBackground(Color.black);
            scrollPane.getViewport().setForeground(Color.white);
            scrollPane.getHorizontalScrollBar().setBackground(new Color(0x484848)); // change the scroll bar bg
            scrollPane.getVerticalScrollBar().setBackground(new Color(0x484848));

            table.setForeground(Color.white);                           // change the table font color
            table.setBackground(Color.black);                           // change the table bg color
            table.getTableHeader().setBackground(Color.black);          // change the top row bg color
            table.getTableHeader().setForeground(Color.white);          // change the top row font color

            addIDL.setForeground(Color.white);                          // change the font of id to white
            addIDTA.setBackground(new Color(0x484848));             // change the bg of text area
            addIDTA.setForeground(Color.white);                         // change th font of text area
            addLastNameL.setForeground(Color.white);                    // change the font of lastName
            addLastNameTA.setBackground(new Color(0x484848));       // change the bg of text area
            addLastNameTA.setForeground(Color.white);                   // change the font of text area
            addFirstNameL.setForeground(Color.white);                   // change the font of firstName
            addFirstNameTA.setBackground(new Color(0x484848));      // change the bg of text area
            addFirstNameTA.setForeground(Color.white);                  // change the font of text area
            addVaccineTypeL.setForeground(Color.white);                 // change the font of vaccineType
            addVaccineTypeTA.setBackground(new Color(0x484848));    // change the bg of text area
            addVaccineTypeTA.setForeground(Color.white);                // change the font of text area
            addVaccinationDateL.setForeground(Color.white);             // change the font of vaccinationDate
            addVaccinationDateTA.setBackground(new Color(0x484848));    // change the bg of text area
            addVaccinationDateTA.setForeground(Color.white);            // change the font of text area
            addVaccineLocationL.setForeground(Color.white);             // change the font of vaccineLocation
            addVaccineLocationTA.setBackground(new Color(0x484848));    // change the bg of text area
            addVaccineLocationTA.setForeground(Color.white);                // change the font of text area

            addIDTA.setCaretColor(Color.white);
            addLastNameTA.setCaretColor(Color.white);
            addFirstNameTA.setCaretColor(Color.white);
            addVaccineTypeTA.setCaretColor(Color.white);
            addVaccinationDateTA.setCaretColor(Color.white);
            addVaccineLocationTA.setCaretColor(Color.white);
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

        loadLabel.setVisible(false);

        scrollPane.setVisible(false);
        addLabel.setVisible(false);
        saveLabel.setVisible(false);
        visualLabel.setVisible(false);
    }

    /**
     * method to change row height and column width
     * @param rowHeight - changes the row height
     * @param columnWidth - changes the column width
     */
    private void setTableProperties(int rowHeight, int columnWidth) {
        table.setRowHeight(rowHeight);
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(columnWidth);
        columnModel.getColumn(1).setPreferredWidth(columnWidth);
        columnModel.getColumn(2).setPreferredWidth(columnWidth);
        columnModel.getColumn(3).setPreferredWidth(columnWidth);
        columnModel.getColumn(4).setPreferredWidth(columnWidth);
        columnModel.getColumn(5).setPreferredWidth(columnWidth);

    }

    /**
     * Method to check if a string is numeric
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    /**
     * Method to throw a pop-up box
     * @param infoMessage
     * @param titleBar
     */
    public static void warningBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar,
                JOptionPane.INFORMATION_MESSAGE);
    }

}
