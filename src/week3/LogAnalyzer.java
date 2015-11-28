package week3;


/**
 * Analyze Apache server log file.
 * 
 * @author Pawel Daniluk 
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.HashMap;

import edu.duke.FileResource;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     private String dir; 
     /**
      * Constructor. 
      * Initialize ArrayList to store LogEntry objects.
      * Initialize default path to files.
      */
     public LogAnalyzer() {
    	 records = new ArrayList<LogEntry>();
    	 dir = "C:/Users/pd/Documents/Coursera/duke-java-2/data/logs/";
     }
        
     /**
      * Read file and parse lines as LogEntry objects.
      * Using FileResource to select a file to be processed.
      * @param fname	name of log to be parsed, located in default directory
      */
     public void readFile(String fname) {
         FileResource fr = new FileResource(dir+fname);
         for (String line : fr.lines()) 
        	 records.add(WebLogParser.parseEntry(line));
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     /**
      * This method should return an integer representing the number of unique
      * IP addresses.
      * @return number of unique IPs read from log entry
      */
     public int countUniqueIPs() {
    	 
         ArrayList<String> unique = new ArrayList<String>();
    	 for (LogEntry le : records) {
    		 String ip = le.getIpAddress();
    		 if (!unique.contains(ip)) unique.add(ip);
    	 }
    	 
    	 return unique.size();
     }
     
     /**
      * This method should examine all the web log entries in records and print
      * those LogEntrys that have a status code greater than num. 
      * @param num	minimal status code to be printed
      */
     public void printAllHigherThanNum(int num) {
     	System.out.printf("Status>%d:\n",num);
    	 for (LogEntry le : records) {
    		 int status = le.getStatusCode();
    		 if (status > num) System.out.println(le);
    	 }
    	 
     }
     
     /**
      * This method accesses the web logs in records and returns an ArrayList 
      * of Strings of unique IP addresses that had access on the given day. 
      * @param someday	 in the format “MMM DD” where MMM is the first three 
      * characters of the month name with the first letter capitalized and the
      * others in lowercase, and DD is the day in two digits 
      * (examples are “Dec 05” and “Apr 22”). 
      * @return	list of unique Strings, representing unique IPs matching date 
      * parameter
      */
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
    	 
    	 ArrayList<String> ipsOneDay = new ArrayList<String>();
    	 
    	 for (LogEntry le : records) {
    		 String leTime = le.getAccessTime().toString();
    		 String leIP = le.getIpAddress();
    		 if(leTime.indexOf(someday)!=-1) 
    			 if (!ipsOneDay.contains(leIP)) ipsOneDay.add(leIP);
    	 }
    	 
    	 return ipsOneDay;
    	 
     }
     
     /**
      * This method returns the number of unique IP addresses in records that 
      * have a status code in the range from low to high, inclusive. 
      * @param low	low limit of range (inclusive)
      * @param hi	high limit of range (inclusive)
      * @return number of unique IPs with a status in a range
      */
     public int countUniqueIPsInRange(int low, int hi) {
    	 ArrayList<String> unique = new ArrayList<String>(); 
    	 for (LogEntry le : records) {
    		 String ip = le.getIpAddress();
    		 if (!unique.contains(ip)) {
    			 int stat = le.getStatusCode();
    			 if (stat>=low && stat<=hi) unique.add(ip);
    		 }
    	 }
    	 return unique.size();
    	 
     }
     
     /**
      * Maps an IP address to the number of times that IP address appears in 
      * the web log file.
      * @return map of IP to visit counts
      */
     public HashMap<String, Integer> countVisitsPerIP() {return null;}
     
     /**
      * This method returns an ArrayList of Strings of IP addresses that all 
      * have the maximum number of visits to this website. 
      * @param	map	map of IP to visit counts
      * @return	list of IPs that have maximum number of visits		
      */
     public ArrayList<String> mostNumberVisitsByIP(HashMap<String, Integer> map) {
    	 return null;
    	 
     }
     
     /**
      * This method returns a map that uses 
      * records and maps days from web logs to an ArrayList of IP addresses 
      * that occurred on that day.
      * @return	map of day ("MMM DD" format) to array of IPs visited on that day
      */
     public HashMap<String, ArrayList<String>> iPsForDays() {
    	 return null;
     }
     
     /**
      * This method returns the day that has the most IP address visits. 
      * If there is a tie, then return any such day.
      * @param map	maps days from web logs to an ArrayList of IP addresses 
      * that occurred on that day.
      * @return		day that has the most IP address visits.
      */
     public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map) {
    	 return null;
     }
     
     /**
      *  This method returns an ArrayList of IP addresses that had the 
      *  most accesses on the given day.
      * @param 	map	maps days from web logs to an ArrayList of IP addresses that 
      * occurred on that day
      * @param 	day	a day in the format "MMM DD"
      * @return	list of IP addresses that had the most accesses on the given 
      * day. 
      */
     public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map, String day) {
    	 return null;
     }
     
}
