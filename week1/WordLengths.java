package week1;

import edu.duke.FileResource;

/**
 * Figure out the most common word length of words from a file
 * 
 * @author Pawel Daniluk
 * @version 2015-11-19
 */
public class WordLengths {

    /**
     * This method should read in the words from resource and 
     * count the number of words of each length for all the 
     * words in resource, storing these counts in the array counts
     * @param   resource    FileResource to be processed
     * @param   counts      integer array for storing counts of word lenghts
     */
    public void countWordLengths(FileResource resource, int[] counts) {
    
        final int countsLen = counts.length;
        
        for (String word : resource.words()) {
            int wordLen = Math.min(wordLength(word), countsLen);
            counts[wordLen]++;
           
        }
    
    }
    
    /**
     * Helper function for counting word length, ignoring non-letter chars
     * @param   word    string to be counted
     * @return  number of numeric characters in word
     */
    private int wordLength(String word) {
        int len = 0;
        for (char ch : word.toCharArray()) if (Character.isLetter(ch)) len++;
        
        return len;
    }
    
    public void testCountWordLengths() {
    int[] counts = new int[31];
    FileResource fr = new FileResource("data/macbeth.txt");
    
    countWordLengths(fr, counts);
    
    for (int i=1; i<counts.length; i++) {
        System.out.printf("%d:\t%d\n", i, counts[i]);
    }

    }
    
}
