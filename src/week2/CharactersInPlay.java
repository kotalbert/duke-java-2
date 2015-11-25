package week2;

import edu.duke.FileResource;
import java.util.ArrayList;

/**
 *  Program to determine the characters in one of Shakespeare’s plays 
 *  that have the most speaking parts. 
 * 
 * @author Pawel Daniluk 
 * @version 2015-11-22
 */
public class CharactersInPlay {
    
    private ArrayList<String> names;
    private ArrayList<Integer> freqs;
    
    public CharactersInPlay() {
        names = new ArrayList<String>();
        freqs = new ArrayList<Integer>();
    }
    
    /**
     * pens a file, and reads the file line-by-line. 
     * For each line, if there is a period on the line, 
     * extract the possible name of the speaking part, 
     * and call update to count it as an occurrence for this person. 
     */
    public void findAllCharacters() {
        
        FileResource fr = new FileResource();
        names.clear();
        freqs.clear();
        
        
        for (String line : fr.lines()) 
            update(getPerson(line));
            
        
    }
    
    /**
     * This method should update the two ArrayLists, adding the 
     * character’s name if it is not already there, 
     * and counting this line as one speaking part for this person. 
     */
    private void update(String person) {
        
        if (person.length()==0) return;
        int indx = names.indexOf(person);
        if (indx == -1) {
            names.add(person);
            freqs.add(1);
        }
        else {
            int freq = freqs.get(indx);
            freqs.set(indx, freq+1);
        }
    
    }
    
    /**
     * Method for extracting a name from a line.
     * Name is all the words before first period is found. 
     * All characters should be converted to uppercase.
     * @param   line    single line read from a file
     * @return  string made of words before first digit
     */
    private String getPerson(String line) {
        
        String[] splitLine = line.split("\\.");
        return splitLine[0].toUpperCase();
        
    }
    
    /**
     * This method should print out the names of all those 
     * characters that have exactly number speaking parts, 
     * where number is greater than or equal to num1 and 
     * less than or equal to num2.
     */
    public void charactersWithNumParts(int num1, int num2) {
        
        for (int i=0;i<names.size();i++) {
        
            int freq = freqs.get(i);
            if (freq >= num1 && freq <= num2) {
            
                String name = names.get(i);
                System.out.printf("%s\tcount: %d\n", name, freq);
            }
        }
    
    }
    
    /**
     * This method returns an int that is the index location of the largest value in myFreqs. 
     * If there is a tie, then return the first such value.
     */
    private int findIndexOfMax() {
        int indOfMax=0;
        int maxSoFar = freqs.get(indOfMax);
        for (int i=1; i<freqs.size(); i++) {
            int iFreq = freqs.get(i);
            if (iFreq > maxSoFar) {
                indOfMax = i;
                maxSoFar = iFreq;
            }
        
        }
        return indOfMax;
    }
    
    public void tester(int num1, int num2) {
    
        findAllCharacters();
        int indx = findIndexOfMax();
        String name = names.get(indx);
        int count = freqs.get(indx);
        System.out.printf("Character with most speaking parts >%s<\t%d\n", name, count);
        charactersWithNumParts(num1, num2);
       
    }
    
    public static void main(String[] args) {
		CharactersInPlay cip = new CharactersInPlay();
		cip.tester(10, 105);
	}
}
