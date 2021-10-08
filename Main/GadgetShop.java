package Main; /**
 * Programming Coursework
 *
 * @author Ricardo
 * @version 1.0
 */

//database class to store mobile and mp3

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;

public class GadgetShop implements ActionListener
{

    private ArrayList<Gadget> gadgets;

    private JFrame window; //define gui window
    private JFrame resultsFrame;
    private JTextArea resultsArea;
    private JScrollPane scrollBar;

    //defining buttons
    private JButton addMobile, addMP3, clearAll, displayAll, displayDevice, numberOfDevices, makecall, download, resetDetails;

    //defining text inputs
    private JLabel modelLabel, priceLabel, weightLabel, sizeLabel, brandLabel, creditLabel, memoryLabel, displayNumberLabel, phoneNumberLabel, durationLabel, downloadLabel, songNameLabel;
    private JTextField modelField, priceField, weightField, sizeField, brandField, creditField, memoryField, displayNumberField, phoneNumberField, durationField, downloadField, songNameField;
    
    private String brand_, model_, size_, phoneNumber_;
    private double price_;
    private int weight_;
    private int credit_;
    private double memory_;
    private int listSize_;
    private int displayNumber;

    public GadgetShop(){

        gadgets = new ArrayList<Gadget>();
        
        //window frame start
        window = new JFrame("Main.Gadget Shop"); //set frame title

        Container contentPane = window.getContentPane();
        contentPane.setLayout(new GridLayout(0,5,10,10));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        resultsFrame = new JFrame("Device Details");
        resultsFrame.setSize(300,300);
        resultsFrame.setLocation(100,200);
        resultsArea = new JTextArea(10,20);
        scrollBar = new JScrollPane(resultsArea);
        resultsArea.setEditable(false);
        resultsFrame.add(scrollBar);

        //window.getContentPane().setBackground(Color.black); //set a background color

        makeMenuBar(window);

        //buttons / inputs start
        brandLabel = new JLabel("Brand:");
        modelLabel = new JLabel("Model:");
        priceLabel = new JLabel("Price:");
        weightLabel = new JLabel("Weight:");
        sizeLabel = new JLabel("Size:");
        creditLabel = new JLabel("Credit:");
        memoryLabel = new JLabel("Memory:");
        displayNumberLabel = new JLabel("Device Number:");
        phoneNumberLabel = new JLabel("Phone Number:");
        downloadLabel = new JLabel("Song Size:");
        durationLabel = new JLabel("Call Duration:");
        songNameLabel = new JLabel("Song Name:");

        brandField = new JTextField();
        modelField = new JTextField();
        priceField = new JTextField();
        weightField = new JTextField();
        sizeField = new JTextField();
        creditField = new JTextField("only for mobile");
        memoryField = new JTextField("only for mp3");
        displayNumberField = new JTextField();
        phoneNumberField = new JTextField();
        downloadField = new JTextField();
        durationField = new JTextField();
        songNameField = new JTextField();

        addMobile = new JButton("Add Main.Mobile");
        addMP3 = new JButton("Add Main.MP3");
        clearAll = new JButton("Clear All");
        displayAll = new JButton("Display All");
        displayDevice = new JButton("Display Device");
        numberOfDevices = new JButton("# of Devices");
        makecall = new JButton("Make Call");
        download = new JButton("Download");
        resetDetails = new JButton("Reset Details");

        //row 1
        contentPane.add(brandLabel);
        contentPane.add(modelLabel);
        contentPane.add(priceLabel);
        contentPane.add(weightLabel);
        contentPane.add(sizeLabel);

        //row 2
        contentPane.add(brandField);
        contentPane.add(modelField);
        contentPane.add(priceField);
        contentPane.add(weightField);
        contentPane.add(sizeField);

        //row 3
        contentPane.add(creditLabel);
        contentPane.add(memoryLabel);
        
        contentPane.add(Box.createHorizontalGlue());
        contentPane.add(Box.createHorizontalGlue());
        contentPane.add(Box.createHorizontalGlue());

        //row 4
        contentPane.add(creditField);
        contentPane.add(memoryField);

        contentPane.add(addMobile);
        addMobile.addActionListener(this);

        contentPane.add(addMP3);
        addMP3.addActionListener(this);

        contentPane.add(clearAll);
        clearAll.addActionListener(this);

        //row 5
        contentPane.add(displayNumberLabel);
        contentPane.add(durationLabel);
        contentPane.add(phoneNumberLabel);
        contentPane.add(downloadLabel);
        contentPane.add(songNameLabel);
        
        //row 6
        contentPane.add(displayNumberField);
        contentPane.add(durationField);
        contentPane.add(phoneNumberField);
        contentPane.add(downloadField);
        contentPane.add(songNameField);
        
        //row7
        contentPane.add(numberOfDevices);
        numberOfDevices.addActionListener(this);

        contentPane.add(displayAll);
        displayAll.addActionListener(this);
        
        //contentPane.add(Box.createHorizontalGlue());
        contentPane.add(resetDetails);
        resetDetails.addActionListener(this);
        
        //contentPane.add(displayDevice);
        //displayDevice.addActionListener(this);
        
        contentPane.add(makecall);
        makecall.addActionListener(this);
        
        contentPane.add(download);
        download.addActionListener(this);
        
        //buttons / inputs end

        window.setSize(700,300);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        //window frame end
    }

    //this allows the program to run without bluej
    public static void main(String[] args){
        new GadgetShop();
    }

    public void makeMenuBar(JFrame window){
        JMenuBar menubar = new JMenuBar();
        window.setJMenuBar(menubar);

        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);

        JMenuItem clearAll = new JMenuItem("Clear All");
        clearAll.addActionListener(this);
        fileMenu.add(clearAll);
        
        JMenuItem testTerminal = new JMenuItem("Test Terminal");
        testTerminal.addActionListener(this);
        fileMenu.add(testTerminal);

        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(this);
        fileMenu.add(quitItem);
        
        JMenu mobileMenu = new JMenu("Main.Mobile");
        menubar.add(mobileMenu);
        
        JMenuItem addCredit = new JMenuItem("Add Credit");
        addCredit.addActionListener(this);
        mobileMenu.add(addCredit);
        
        JMenuItem callHistory = new JMenuItem("Call History");
        callHistory.addActionListener(this);
        mobileMenu.add(callHistory);
        
        JMenu mp3Menu = new JMenu("Main.MP3");
        menubar.add(mp3Menu);
        
        JMenuItem songsList = new JMenuItem("Songs List");
        songsList.addActionListener(this);
        mp3Menu.add(songsList);

    }

    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand();
        if(command.equals("Add Main.Mobile")){
            addMobile();
        }

        if(command.equals("Add Main.MP3")){
            addMP3();
        }

        if(command.equals("Display Device")){
            displayDevice();
        }

        if(command.equals("# of Devices")){
            getNumOfDevices();
        }

        if(command.equals("Display All")){
            getList();
        }
        
        if(command.equals("Make Call")){
            makePhoneCall();
        }
        
        if(command.equals("Download")){
            download();
        }
        
        if(command.equals("Call History")){
            getHistory();
        }
        
        if(command.equals("Songs List")){
            getSongsList();
        }
        
        if(command.equals("Add Credit")){
            addCredit();
        }

        if(command.equals("Clear All")){
            clearAll();
        }
        
        if(command.equals("Reset Details")){
            resetDetails();
        }
        
        if(command.equals("Test Terminal")){
            testTerminal();
        }

        if(command.equals("Quit")){
            quit();
        }
    }

    public void addMobile(){
        try{
            if(getBrand().equals("")){
                JOptionPane.showMessageDialog(window, "Please enter a brand.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }else if(getModel().equals("")){
                JOptionPane.showMessageDialog(window, "Please enter a model.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }else if(getPrice() <= 0){
                JOptionPane.showMessageDialog(window, "Please enter positive value for price.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }else if(getWeight() <= 0){
                JOptionPane.showMessageDialog(window, "Please enter positive value for weight.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }else if(getSize().equals("")){
                JOptionPane.showMessageDialog(window, "Please enter a size.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }else if(getCredit() <= 0){
                JOptionPane.showMessageDialog(window, "Please enter positive value for credit.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }else{
                Mobile mobile = new Mobile(getBrand(), getModel(), getPrice(), getWeight(), getSize(), getCredit());
                gadgets.add(mobile);
                JOptionPane.showMessageDialog(window, "Main.Mobile was added successfully.", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                clearAll();
                
                //display the mobile gadget details just after adding it.
                resultsArea.append("***** New mobile device added *****\n\n");
                resultsArea.append("Main.Gadget: " + brand_ + " " + model_ + "\n");
                resultsArea.append("Price: £" + price_ + "\n");
                resultsArea.append("The gadget weights: " + weight_ + " grams\n");
                resultsArea.append("The gadget measures: " + size_ + "\n");
                resultsArea.append("Initial credit: " + credit_ + "\n");
                resultsArea.append("***************\n\n");
                resultsFrame.setVisible(true);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(window,
            "Please fill in all the required boxes.\nMake sure all the values as valid.\nPrice, Weight and Credit have to be positive numbers.",
            "ATTENTION", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addMP3(){
        try{
            if(getBrand().equals("")){
                JOptionPane.showMessageDialog(window, "Please enter a brand.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }else if(getModel().equals("")){
                JOptionPane.showMessageDialog(window, "Please enter a model.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }else if(getPrice() <= 0){
                JOptionPane.showMessageDialog(window, "Please enter positive value for price.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }else if(getWeight() <= 0){
                JOptionPane.showMessageDialog(window, "Please enter positive value for weight.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }else if(getSize().equals("")){
                JOptionPane.showMessageDialog(window, "Please enter a size.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }else if(getMemory() <= 0){
                JOptionPane.showMessageDialog(window, "Please enter positive value for memory.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }else{
                MP3 mp3 = new MP3(getBrand(), getModel(), getPrice(), getWeight(), getSize(), getMemory());
                gadgets.add(mp3);
                JOptionPane.showMessageDialog(window, "Main.MP3 was added successfully.", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                clearAll();
                
                //display the mp3 gadget details just after adding it.
                resultsArea.append("***** New mp3 device added *****\n\n");
                resultsArea.append("Main.Gadget: " + brand_ + " " + model_ + "\n");
                resultsArea.append("Price: £" + price_ + "\n");
                resultsArea.append("The gadget weights: " + weight_ + " grams\n");
                resultsArea.append("The gadget measures: " + size_ + "\n");
                resultsArea.append("Initial memory: " + memory_ + "Mb\n");
                resultsArea.append("***************\n\n");
                resultsFrame.setVisible(true);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(window,
            "Please fill in all the required boxes.\nMake sure all the values as valid.\nPrice, Weight and Memory have to be positive numbers.",
            "ATTENTION", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getBrand(){
        brand_ = brandField.getText();
        return brand_;
    }

    public String getModel(){
        model_ = modelField.getText();
        return model_;
    }

    public String getSize(){
        size_ = sizeField.getText();
        return size_;
    }

    /*public double getPrice(){
        double price_ = 0.0;
        try{
            price_ = Double.parseDouble(priceField.getText());
            if(priceField.getText().equals("")){
                JOptionPane.showMessageDialog(window, "Enter a valid value in price.");
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(window, "Please enter a valid value for the price. Has to be a number.");
        }
        return price_;
    }*/
    
    public double getPrice(){
        price_ = Double.parseDouble(priceField.getText());
        return price_;
    }

    public int getWeight(){
        weight_ = Integer.parseInt(weightField.getText());
        return weight_;
    }

    public int getCredit(){
        credit_ = Integer.parseInt(creditField.getText());
        return credit_;
    }

    public double getMemory(){
        memory_ = Double.parseDouble(memoryField.getText());
        return memory_;
    }

    public int displayDevice(){
        int displayNumber = -1;
        try{
            if(displayNumberField.getText().equals("")){
                JOptionPane.showMessageDialog(window, "Enter a device number.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }else if(Integer.parseInt(displayNumberField.getText()) <= 0){
                JOptionPane.showMessageDialog(window, "Enter a positive device number.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }else if(Integer.parseInt(displayNumberField.getText()) > gadgets.size()){
                JOptionPane.showMessageDialog(window,
                "You do not have that many devices.\nPlease check how many you have by clicking on '# of Devices' or 'Display All'.",
                "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }else{
                displayNumber = Integer.parseInt(displayNumberField.getText());
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(window, "Please enter a device number not a string.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
        }
        return displayNumber;
    }

    public void getList(){
        int devicenumber = 0;
        if(gadgets.size() == 0){
            JOptionPane.showMessageDialog(window, "You have no devices in your shop.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
        }else{
            for(Gadget gadget:gadgets){
                //System.out.println("***** Device *****");
                //gadget.getDetails();
                //System.out.println();
                devicenumber = devicenumber + 1;
                resultsArea.append("Device number: " + String.valueOf(devicenumber)+"\n\n");
                resultsArea.append(gadget.getDetails());
                resultsArea.append("**********\n\n");
                resultsFrame.setVisible(true);
            }
        }
    }

    public void getNumOfDevices(){
        listSize_ = gadgets.size();
        if(listSize_ == 1){ 
            JOptionPane.showMessageDialog(window, "You have " + listSize_ + " device in your shop.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(window, "You have " + listSize_ + " devices in your shop.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void makePhoneCall(){
        if(displayDevice() != -1){
            Gadget gadget = gadgets.get(Integer.parseInt(displayNumberField.getText())-1);
            if(gadget instanceof Mobile){
                try{
                    if(durationField.getText().equals("") || phoneNumberField.getText().equals("")){
                        JOptionPane.showMessageDialog(window, "Please make sure to add a phone number and a call duration.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
                    }else{
                        Mobile mobile = (Mobile) gadget;
                        mobile.makeCall(phoneNumberField.getText(), Integer.parseInt(durationField.getText()));
                        //JOptionPane.showMessageDialog(window, "Your phone call was successfull.", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        clearAll();
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(window, "Please make sure you insert the proper values in each box.", "ATTENTION", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(window, "The device selected is not a mobile.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(window, "The selected device does not exist.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void download(){
        if(displayDevice() != -1){
            Gadget gadget = gadgets.get(Integer.parseInt(displayNumberField.getText())-1);
            if(gadget instanceof MP3){
                try{
                    if(downloadField.getText().equals("") || songNameField.getText().equals("")){
                        JOptionPane.showMessageDialog(window, "Please add a music size and a name.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
                    }else{
                        MP3 mp3 = (MP3) gadget;
                        mp3.addSong(Double.parseDouble(downloadField.getText()), songNameField.getText());
                        //JOptionPane.showMessageDialog(window, "Your song was downloaded with success.", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        clearAll();
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(window, "Please make sure you insert the proper values in each box.", "ATTENTION", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(window, "The device selected is not a mp3.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(window, "The device selected does not exist.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void getHistory(){
        try{
            if(Integer.parseInt(displayNumberField.getText()) > gadgets.size()){
                JOptionPane.showMessageDialog(window, "You do not have that many devices.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }else{
                Gadget gadget = gadgets.get(Integer.parseInt(displayNumberField.getText())-1);
                if(gadget instanceof Mobile){
                    Mobile mobile = (Mobile) gadget;
                    //mobile.callHistory();
                    clearAll();
                    resultsArea.append("Calling history:\n\n");
                    resultsArea.append(mobile.callHistory());
                    resultsArea.append("**********\n\n");
                }else{
                    JOptionPane.showMessageDialog(window, "The selected device is not a mobile.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(window, "That device number is invalid.\nThe device either does not exist or you did not input an integer.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void getSongsList(){
        try{
            if(Integer.parseInt(displayNumberField.getText()) > gadgets.size()){
                JOptionPane.showMessageDialog(window, "You do not have that many devices.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }else{
                Gadget gadget = gadgets.get(Integer.parseInt(displayNumberField.getText())-1);
                if(gadget instanceof MP3){
                    MP3 mp3 = (MP3) gadget;
                    //mp3.getSongs();
                    clearAll();
                    resultsArea.append("Songs list:\n\n");
                    resultsArea.append(mp3.getSongs());
                    resultsArea.append("**********\n\n");
                }else{
                    JOptionPane.showMessageDialog(window, "The selected device is not an mp3.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(window, "That device number is invalid.\nThe device either does not exist or you did not input an integer.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void addCredit(){
        try{
            String credit = JOptionPane.showInputDialog(window, "How much credit do you want to add?", "", JOptionPane.QUESTION_MESSAGE);
            Gadget gadget = gadgets.get(Integer.parseInt(displayNumberField.getText())-1);
            if(gadget instanceof Mobile){
                if(Integer.parseInt(credit) <= 0){
                    JOptionPane.showMessageDialog(window, "Please add a positive value for the credit.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
                }else{
                    Mobile mobile = (Mobile) gadget;
                    mobile.addCredit(Integer.parseInt(credit));
                }
            }else{
                JOptionPane.showMessageDialog(window, "The selected device is not a mobile.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(window, "That device number is invalid.\nThe device either does not exist or you did not input an integer.", "ATTENTION", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void clearAll(){
        JOptionPane.showMessageDialog(window, "Clearing all text fields...", "ATTENTION", JOptionPane.PLAIN_MESSAGE);
        brandField.setText("");
        modelField.setText("");
        priceField.setText("");
        sizeField.setText("");
        weightField.setText("");
        creditField.setText("only for mobile");
        memoryField.setText("only for mp3");
        displayNumberField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadField.setText("");
        songNameField.setText("");
    }
    
    public void testTerminal(){
        JOptionPane.showMessageDialog(window, "A message will be printed on the terminal.", "ATTENTION", JOptionPane.PLAIN_MESSAGE);
        System.out.println("***************");
        System.out.println("Coursework 2 - Building a GUI");
        System.out.println("Made by: Ricardo Rocha - 18016482 ");
        System.out.println("***************");
    }
    
    public void resetDetails(){
        resultsArea.setText("");
    }

    public void quit(){
        JOptionPane.showMessageDialog(window, "This program was created by: Ricardo Rocha\nThanks for using it. :-)",
        "THANK YOU", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }

}