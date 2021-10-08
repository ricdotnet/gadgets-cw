package Main; /**
 * Programming Coursework
 * 
 * Ricardo Rocha - 18016482
 **/
 
/*
 * variables with _ at the end it just to set values
 */
 
import java.util.*;
import javax.swing.*;
 
public class MP3 extends Gadget
{
    private double deviceMemory; //initiate the device memory
    private double totalDeviceMemory; //this is just to save the total memory of the device.
    private double memory_; //has to be double because the value will be in mb (xxxx.00).
    private double songSize; //has to be double because the value will be in mb (xx.00).
    private int songs; //integer because this is the number of songs on the device.
    private double usedMemory; //has to be double because it is the sum of all songs sizes.
    
    //variables for the songs list (adding and removing)
    private String songName;
    private int song;
    private double songsize;
    
    private String songs_;
    private String msg;
    
    //define array lists
    private ArrayList<String> songlist;
    private ArrayList<Double> songsizelist;
    
    public MP3(String brand, String model, double price, int weight, String size, double memory_){
        super(brand, model, price, weight, size);
        deviceMemory = memory_;
        totalDeviceMemory = memory_;
        songs = 0; //this will create the device with 0 songs.
        usedMemory = 0.00; //initialises used memory as a double value.
        
        //create array lists
        songlist = new ArrayList<String>();
        songsizelist = new ArrayList<Double>();
    }
    
    public void addSong(double songSize, String songName){
        if (songSize > deviceMemory){
            //System.out.println();
            //System.out.println("There is not enough memory left on the device.");
            
            String msg = "There is not enough memory memory on this Main.MP3.";
            JOptionPane.showMessageDialog(null, msg, "ATTENTION", JOptionPane.PLAIN_MESSAGE);
        }else{
            //songs = songs + 1; //adds 1 song to the amount of songs on the device.
            
            deviceMemory = deviceMemory - songSize; //takes the size of the song from the memory available.
            usedMemory = usedMemory + songSize; //adds the size of the song to the used memory of the device.
            
            songlist.add(songName);
            songsizelist.add(songSize);
            
            String msg = "Song added to your Main.MP3.\n\nName: " + songName + "\nSize: " + songSize + "Mb";
            JOptionPane.showMessageDialog(null, msg, "ATTENTION", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    public int numberOfSongs(){
        /*
         * this is just to calculate the list size
         */
        return songlist.size();
    }
    
    public String NumberOfSongs(){
        if(numberOfSongs() == 1){
            //System.out.println("You have " + songlist.size() + " song in your list.");
            msg = "You have " + songlist.size() + " song in your list.";
        }else{
            //System.out.println("You have " + songlist.size() + " songs in your list.");
            msg = "You have " + songlist.size() + " songs in your list";
        }
        
        return msg;
    }
    
    public String getSongs(){
        int index = 1;
        String list = "";
        if(numberOfSongs() == 0){
            //System.out.println("No songs on the list.");
            list = "You have no songs on the list.";
        }else{
            for(String songName:songlist){
                //System.out.println(songName);
                list += index + " - " + songName + "\n";
                index = index + 1;
            }
        }
        return list;
    }
    
    public void removeSong(int song){
        if(numberOfSongs() == 0){
            System.out.println("No songs on the list.");
        }else if(song > numberOfSongs()){
            System.out.println("That song is invalid.");
        }else{
            System.out.println("You are removing " + songlist.get(song-1));
            songlist.remove(song-1);
            songsizelist.remove(song-1);
        }
    }
    
    public String getDetails(){
        String getdetails = super.getDetails(); //calling the Main.Gadget getDetails() method for detailed view about the Main.MP3 device.
        
        if(songlist.size() == 1){
            songs_ = " song. ";
        }else{
            songs_ = " songs. ";
        }
        
        String totalmemory = "\nDevice total memory: " + totalDeviceMemory + "Mb\n";
        String usedmemory = "Current used memory: " + usedMemory + "Mb\n";
        String memoryleft = "Current memory left: " + deviceMemory + "Mb\n";
        String songsin = "You have: " + songlist.size() + songs_ + "\n";
        /*System.out.println("***** Songs List *****");
        
        if(numberOfSongs() == 0){
            System.out.println("There are no songs on the list.");
        }else{
            int index = 0;
            for(String songName:songlist){
                songsize = songsizelist.get(index);
                index = index + 1;
                System.out.println(index + ": " + songName + " - " + songsize + "Mb");
            }
        }*/
        
        return getdetails + totalmemory + usedmemory + memoryleft + songsin;
    }

}
