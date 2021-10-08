package Main; /**
 * Programming Coursework
 * 
 * Ricardo Rocha - 18016482
 **/
 
import javax.swing.*; //i imported java swing in order to be able to add dialog message boxes in the future
 
public class Gadget
{
    private String model;
    private double price;
    private int weight;
    private String size; //this variable is for the size as a whole
    
    private String brand; //custom variable
   
    /**
     * Initialise the fields of the gadget.
     * @param gmodel is the model of the gadget.
     * @param gprice is the price of the gadget in pounds.
     * @param gweight is the weight of the gadget in grams.
     * @param gsize is the size of the gadget represented as "11mm x 11mm x 11mm".
     * @param gbrand is the brand of the gadget. - this is a custom attribute.
     */
    public Gadget(String gbrand, String gmodel, double gprice, int gweight, String gsize){
        //model = "";
        //price = 0;
        //weight = 0;
        //size = "";
        //This was my first call, leaving empty strings. Not correct.*/
        
        brand = gbrand;
        model = gmodel;
        price = gprice;
        weight = gweight;
        size = gsize; //measured in mm x mm x mm
    }
    
    /**
     * This method will get the details of each device added to the gadgetshop
     *
     */
    public String getDetails()
    {
        //System.out.println("Main.Gadget: " + brand + " " + model); //I decided to add a brand variable to make the program more complete
        //System.out.println("Main.Gadget: " + model);
        //System.out.println("Price: £" + price);
        //System.out.println("The gadget weights: " + weight + " grams.");
        //System.out.println("The gadget measures: " + size);
        
        String brandmsg = "Main.Gadget: " + brand + " " + model;
        String pricemsg = "\nPrice: £" + price;
        String weightmsg = "\nThe gadget weights: " + weight + " grams";
        String sizemsg = "\nThe gadget measures: " + size;
        
        return brandmsg + pricemsg + weightmsg + sizemsg;
    }
    
    /*public void getDetails()
    {
        String msg = "Main.Gadget: " + brand + " " + model + "\nPrice: £" + price + "\nThe gadget weights: " + weight + " grams.\nThe gadget measures: " + size;
        JOptionPane.showMessageDialog(null, msg, "Main.Gadget Details", JOptionPane.PLAIN_MESSAGE);
    }*/
}