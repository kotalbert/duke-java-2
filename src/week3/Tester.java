package week3;

/**
 * Write a description of class Tester here.
 * 
 * @author Pawel Daniluk 
 * @version 1.0
 */

import java.util.*;

public class Tester
{
	LogAnalyzer la;
	
	public Tester(String fname) {
        la = new LogAnalyzer();
        la.readFile(fname);
	}
	
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        la.printAll();
    }
    
    /**
     * This method should create a LogAnalyzer, 
     * read from the file short-test_log, and then 
     * test the method countUniqueIPs.
     */
    public void testUniqueIP() {
    	System.out.println("Unique IPs in file:\t"+la.countUniqueIPs());
    }
    
    public void testPrintAllHigherThanNum() {
    	System.out.println("Testing statuses:");
    	la.printAllHigherThanNum(400);
    	//la.printAllHigherThanNum(300);
    } 
    
    public void testUniqueIPVisitsOnDay() {
    	System.out.println("Ips on: Mar 17");
    	System.out.println(la.uniqueIPVisitsOnDay("Mar 17"));
//    	System.out.println("Ips on: Sep 30");
//    	System.out.println(la.uniqueIPVisitsOnDay("Sep 30"));
    }
    
    public void testCountUniqueIPsInRange() {
    	System.out.println("Testing ips in range 200-299");
    	System.out.println(la.countUniqueIPsInRange(200, 299));
//    	System.out.println("Testing ips in range 300-399");
//    	System.out.println(la.countUniqueIPsInRange(300, 399));
    }
    
    public static void main(String[] args) {
		Tester t = new Tester("weblog1_log");
		//t.testLogAnalyzer();
		//t.testUniqueIP();
		t.testPrintAllHigherThanNum();
		t.testUniqueIPVisitsOnDay();
		t.testCountUniqueIPsInRange();
	}
}
