package Main; /**
 * Programming Coursework
 * 
 * Ricardo Rocha - 18016482
 **/
 
import java.util.*;
import javax.swing.*;
//the two imports above are to be able to have array lists and show some results as dialog boxes
 
public class Mobile extends Gadget
{
    private int credit;
    
    private String phoneNumber; //has to be string so I can store the first 0
    private int callTime; //call duration in minutes
    
    //defining array lists
    private ArrayList<String> callHistory;
    private ArrayList<Integer> callingTime;
    private ArrayList<Integer> creditsHistory;
    
    public Mobile(String brand, String model, double price, int weight, String size, int _credit){
        super(brand, model, price, weight, size);
        credit = _credit; //xCredit is the input variable for the starting credit amount.
        
        //creating the array lists
        callHistory = new ArrayList<String>();
        callingTime = new ArrayList<Integer>();
        creditsHistory = new ArrayList<Integer>();
    }
    
    /**
     * Method makeCall
     *
     * @param phoneNumber A parameter
     * @param callTime A parameter
     * 
     * this method will record all calls made using a selected mobile device
     * it will add the phone number to a list and record the call time of each call
     * the user will be able to check how many calls were done
     * the user will also be able to check each number called followed by how many minutes in each call
     */
    public void makeCall(String phoneNumber, int callTime){
        if (credit < 0){ //callTime is the input variable for the call length and it has to be integer with no decimal places.
            String msg = "***** Phone Call *****\n\nYour credit is "+ credit +".\nPlease add credit to make your credit balance at least 1.\n";
            JOptionPane.showMessageDialog(null, msg, "ATTENTION", JOptionPane.WARNING_MESSAGE);
        }else if(credit == 0){
            String msg = "***** Phone Call *****\n\nYour credit is 0.\nPlease add at least 1 credit to be able to make this call.\n";
            JOptionPane.showMessageDialog(null, msg, "ATTENTION", JOptionPane.WARNING_MESSAGE);
        }else if(callTime > credit){//this will give a negative credit and show a message to the user.
            //System.out.println("***** Phone Call *****");
            //System.out.println("Your call will cost " + callTime + " credits but you only have " + credit + " credits.");
            //System.out.println("Your credit will be negative after this call.");

            String msg = "***** Phone Call *****\n\nYour call will cost "+ callTime +" credits but you only have " + credit + " credits.\nYour credit will therefore be negative after this call.";
            JOptionPane.showMessageDialog(null, msg, "ATTENTION", JOptionPane.WARNING_MESSAGE);
            
            credit = credit - callTime; //take credits for the call
            
            callHistory.add(phoneNumber);
            callingTime.add(callTime);
        }else{
            credit = credit - callTime; //take credits for the call
            
            callHistory.add(phoneNumber);
            callingTime.add(callTime);
        
            //System.out.println("***** Phone Call *****");
            //System.out.println("Number: " + phoneNumber);
            //System.out.println("Remaining credit: " + credit);
            //System.out.println("**********************");
            
            String msg = "****** Phone Call ******\n\nPhone Number: " + phoneNumber + "\nCost for this call: " + callTime + "\nRemaining credit: " + credit;
            JOptionPane.showMessageDialog(null, msg, "SUCCESS", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    /**
     * Method callHistory
     *
     * this is the method to retrieve the calling history
     * it will select from 2 array lists every phone number called and how many minutes each call lasted
     * it will then show a message dialog with all the records
     */
    public String callHistory(){
        int index = 0;
        int minutes = 0;
        String output = "";
        for(String calls:callHistory){
            minutes = callingTime.get(index);
            output += "Phone number: " + calls + " - " + minutes + " minutes.\n";
            index = index + 1;
        }
        //JOptionPane.showMessageDialog(null, output, "Call History", JOptionPane.PLAIN_MESSAGE);
        
        return output;
    }
    
    public int getCalls(){
        //this method only returns how many calls were logged
        return callHistory.size();
    }
    
    public int getCreditsHistory(){
        //this method only returns how many times the user added credit to their mobile
        return creditsHistory.size();
    }
    
    /**
     * Method addCredit
     *
     * @param addCredit A parameter
     * this method is called when the user adds credit to a mobile device
     * it will also add 1 to a list to keep a log of how many times the user credited the device
     */
    public void addCredit(int addCredit){
        int oldcredit = credit;
        String crdt = "";
        
        //System.out.println("*** Adding " + addCredit + " Credits ***");
        //System.out.println("You had : " + credit + " Credits");
        
        // this line could be anywhere as long as it is inside this method
        credit = credit + addCredit; //add the credit amount chosen by the user
        //System.out.println("You now have: " + credit + " Credits");
        //System.out.println("*************************");
        
        if(addCredit == 1){
            crdt = " Credit";
        }else{
            crdt = " Credits";
        }
        
        String msg = "***** Adding " + addCredit + crdt + " *****\n\nYou had " + oldcredit + " credits.\nYou now have " + credit + " credits.";
        JOptionPane.showMessageDialog(null, msg, "SUCCESS", JOptionPane.PLAIN_MESSAGE);
        
        creditsHistory.add(addCredit);
    }
    
    public String getDetails(){
        String getdetails = super.getDetails(); //calling the Main.Gadget getDetails() method for detailed view about the Main.MP3 device.
        
        //System.out.println("Total credit on this phone: " + credit);
        //System.out.println("Total calls made on this Phone: " + getCalls());
        //System.out.println("Total times you added credit: " + getCreditsHistory());
        
        String totalcredits = "\nTotal credit on this phone: " + credit;
        String totalcalls = "\nTotal calls made on this Phone: " + getCalls();
        String totaladds = "\nTotal times you added credit: " + getCreditsHistory() + "\n";
        
        return getdetails + totalcredits + totalcalls + totaladds;
    }
}