package week2;

import edu.duke.FileResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * GladLibMap modified to use HashMaps.
 * 
 * @author Pawel Daniluk 
 * @version 2015-11-24
 */

public class GladLibMap {
    
	private HashMap<String, ArrayList<String>> wordMap;
    
    private int wordCount = 0;
    private ArrayList<String> usedWords;
    private ArrayList<String> usedLabels;
    
    private Random myRandom;
    private String source;
    
    /**
     * Constructor for setting path to the files and initializing data 
     * structures for storing the information.
     * @param source	name of the folder where to look for the files
     */
    public GladLibMap(String source){
    	this.source = source;
    	usedLabels = new ArrayList<String>();
        initializeFromSource();
        myRandom = new Random();
    }
    
    /**
     * Helper function for putting lists to HashMap with filename being key
     * @param fname	name of file to be put to HashMap, data from file to be 
     * converted to list
     */
    private void putList(String fname) {
    	wordMap.put(fname, readIt(source+"/"+fname+".txt"));
    }
    
    /**
     * Initializes all the replacement words from files with putList method.
     * @see putList
     */
    private void initializeFromSource() {
    	wordMap = new HashMap<String, ArrayList<String>>();
        
    	putList("adjective");
    	putList("noun");
    	putList("color");
    	putList("country");
    	putList("name");
    	putList("animal");
    	putList("timeframe");
    	putList("verb");
    	putList("fruit");
    	
    	// put random numbers
    	ArrayList<String> nums = new ArrayList<String>();
    	for (int i=0;i<50;i++) nums.add(Integer.toString(i));
    	wordMap.put("number", nums);
    	
        usedWords = new ArrayList<String>();
    }
    
    /**
     * Return random element from list identified by key.
     * @param key identifying map item from which to get random 
     * replacement word. Keeps track of words already used and replaced words
     * count.
     * @return	random word from source
     */
    private String randomFrom(String key){
        
        String randWord;
        ArrayList<String> source = wordMap.get(key);
        if (!usedLabels.contains(key)) usedLabels.add(key);
        
        while (true) {
            int index = myRandom.nextInt(source.size());
            randWord = source.get(index);
            int usedIndex = usedWords.indexOf(randWord);
            if (usedIndex == -1) break;
            else continue;
        }
        
        usedWords.add(randWord);
        wordCount++;
        return randWord;
    }
    
    /**
     * Return replacement of label in a template.
     * @param label	label to be replaced by random word
     * @return	random, unique word for given label. Return "UNKNOWN" if
     * no such label is found
     */
    private String getSubstitute(String label) {
    	if (wordMap.containsKey(label)) return randomFrom(label);
    	else return "UNKNOWN";
        
    }
    
    /**
     * Read words from template and replace labels with appropriate replacement
     * words
     * @param w	word read from template
     * @return	input word or replacement word
     */
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        return prefix+sub+suffix;
    }
    
    /**
     * Print the String to console with line breaks at specified character
     * @param s
     * @param lineWidth
     */
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    /**
     * Read template and replace labels with random replacement words.
     * @return	template file with all labels replaced with random words
     */
    private String fromTemplate(String source){
        String story = new String();
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
       
        }
        // before returning story, clear the counters
        usedWords.clear();
        return story;
    }
    
    /**
     * Helper function for reading files into lists
     * @param 	source	name of file to be read
     * @return	list of words from file in form of new list
     */
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();

        FileResource resource = new FileResource(source);
        for(String line : resource.lines()){
            list.add(line);
        }
        
        return list;
    }
    
    public void makeStory(){
        System.out.println("\n");
        String story = fromTemplate(source+"/madtemplate3.txt");
        printOut(story, 60);
        System.out.println("\nReplaced words:\t"+wordCount);
        System.out.println("Total words:\t" + totalWordsInMap());
        System.out.println("Total words considered:\t"+totalWordsConsidered());
        wordCount = 0;
    }
    /**
     * This method returns the total number of words in all the ArrayLists 
     * in the HashMap. 
     * @return	total number of words that were possible to pick from
     */
    @SuppressWarnings("unused")
	public int totalWordsInMap(){
    	int cnt = 0;
    	for (String key : wordMap.keySet()) {
    		for (String word : wordMap.get(key)) cnt++;
    	}
    	return cnt;
    	
    }
    
    /**
     * This method returns the total number of words in the ArrayLists of the 
     * categories that were used for a particular GladLib.
     * @return	total number of words in categories that were used in GladLib
     */
    @SuppressWarnings("unused")
	public int totalWordsConsidered() {
    	int cnt = 0;
    	for (String label : usedLabels)
    		for (String word : wordMap.get(label)) cnt++;
    	return cnt;	
    }
    
    public static void main(String[] args) {
    	GladLibMap glm = new GladLibMap("data/GladLibData/datalong");
    	glm.makeStory();
	}


}
