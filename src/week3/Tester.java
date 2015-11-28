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
    	System.out.println("Ips on: Sep 27");
    	System.out.println(la.uniqueIPVisitsOnDay("Sep 27").size());
//    	System.out.println("Ips on: Sep 30");
//    	System.out.println(la.uniqueIPVisitsOnDay("Sep 30"));
    }
    
    public void testCountUniqueIPsInRange() {
    	System.out.println("Testing ips in range 200-299");
    	System.out.println(la.countUniqueIPsInRange(200, 299));
//    	System.out.println("Testing ips in range 300-399");
//    	System.out.println(la.countUniqueIPsInRange(300, 399));
    }
    
    public void testCountVisitsPerIP() {
    	HashMap<String, Integer> map = la.countVisitsPerIP();
    	System.out.println(map);
    }
    
    public void testMostNumberVisitsByIP() {
    	int max = la.mostNumberVisitsByIP(la.countVisitsPerIP());
    	System.out.println("Max number of visits from ip: "+max);
    }
    
    public void testIPsForDays() {
    	HashMap<String, ArrayList<String>> map = la.iPsForDays();
    	System.out.println("Mapping day-visit");
    	System.out.println(map);
    }
    
    public void testDayWithMostIPVisits() {
    	HashMap<String, ArrayList<String>> map = la.iPsForDays();
    	System.out.println("Day with most visits:");
    	System.out.println(la.dayWithMostIPVisits(map));
    }
    
    public void testIPsWithMostVisitsOnDay() {
    	ArrayList<String> list = la.iPsWithMostVisitsOnDay("Sep 29");
    	System.out.println("IPs with most visits on Sep 29:");
    	System.out.println(list);
    }
    
    public static void main(String[] args) {
		Tester t = new Tester("weblog2_log");
//		t.testLogAnalyzer();
		t.testUniqueIP();
		t.testPrintAllHigherThanNum();
		t.testUniqueIPVisitsOnDay();
		t.testCountUniqueIPsInRange();
		t.testCountVisitsPerIP();
		t.testMostNumberVisitsByIP();
		t.testIPsForDays();
		t.testDayWithMostIPVisits();
		t.testIPsWithMostVisitsOnDay();
	}
}
