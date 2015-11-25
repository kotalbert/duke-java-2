package week2;

import edu.duke.FileResource;
import java.util.ArrayList;

/**
 * Find the number of unique words frequency in a text file.
 * 
 * @author Pawel Daniluk 
 * @version 2015-11-22
 */
public class WordFrequencies {

    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies() {
    
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
        
    }
    
    /**
     * Iterates over every word in a file and counting number of unique words in a file.
     */
    private void findUnique() {
    
        myWords.clear();
        myFreqs.clear();
        
        FileResource fr = new FileResource();
        
        for (String word : fr.words()) {
        
            word = word.toLowerCase();
            int index = myWords.indexOf(word);
            if (index==-1) {
                myWords.add(word);
                myFreqs.add(1);
            }
            else {
                int freq = myFreqs.get(index);
                myFreqs.set(index, freq+1);
            }
        }
        
    }
    
    /**
     * This method returns an int that is the index location of the largest value in myFreqs. 
     * If there is a tie, then return the first such value.
     */
    private int findIndexOfMax() {
        int indOfMax=0;
        int maxSoFar = myFreqs.get(indOfMax);
        for (int i=1; i<myFreqs.size(); i++) {
            int iFreq = myFreqs.get(i);
            if (iFreq > maxSoFar) {
                indOfMax = i;
                maxSoFar = iFreq;
            }
        
        }
        return indOfMax;
    }
    
    public void tester(){
        findUnique();
        for (int i=0;i<myWords.size();i++) {
        
            String word = myWords.get(i);
            int freq = myFreqs.get(i);
            System.out.printf("%s\tcount:\t%d\n", word, freq);
        }
        
        int ind = findIndexOfMax();
        String word = myWords.get(ind);
        int freq = myFreqs.get(ind);
        System.out.printf("Number of unique words: %d\n", myWords.size());
        System.out.printf("The word that occurs most often: >%s<: %d\n", word, freq);
    
    }
    
    public static void main(String[] args) {
    	WordFrequencies wf = new WordFrequencies();
    	wf.tester();
	}
    
}
