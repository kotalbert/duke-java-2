package week2;

import edu.duke.FileResource;
import edu.duke.URLResource;
import java.util.ArrayList;
import java.util.Random;

/**
 * GladLib modified for the assignment purpose.
 * Changes from original:
 * - Private String source added for storing initialized path.
 * - Added verb and fruit categories
 * - Template changed to madtemplate2.txt 
 * - Check to add only unique words from list is added
 * - makeStory prints the number of words replaced
 * 
 * @author Pawel Daniluk 
 * @version 2015-11-23
 */

public class GladLib {
    
    private ArrayList<String> adjectiveList;
    private ArrayList<String> nounList;
    private ArrayList<String> colorList;
    private ArrayList<String> countryList;
    private ArrayList<String> nameList;
    private ArrayList<String> animalList;
    private ArrayList<String> timeList;
    private ArrayList<String> verbList;
    private ArrayList<String> fruitList;
    
    private int wordCount = 0;
    private ArrayList<String> usedWords;
    
    private Random myRandom;
    
    @SuppressWarnings("unused")
	private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    private String source;
    
    public GladLib(){
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLib(String source){
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        this.source = source;
        adjectiveList   = readIt(source+"/adjective.txt"); 
        nounList        = readIt(source+"/noun.txt");
        colorList       = readIt(source+"/color.txt");
        countryList     = readIt(source+"/country.txt");
        nameList        = readIt(source+"/name.txt");      
        animalList      = readIt(source+"/animal.txt");
        timeList        = readIt(source+"/timeframe.txt");
        verbList        = readIt(source+"/verb.txt");
        fruitList       = readIt(source+"/fruit.txt");
        usedWords       = new ArrayList<String>();
    }
    
    private String randomFrom(ArrayList<String> source){
        
        String randWord;
        
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
    
    private String getSubstitute(String label) {
        if (label.equals("country")) {
            return randomFrom(countryList);
        }
        if (label.equals("color")){
            return randomFrom(colorList);
        }
        if (label.equals("noun")){
            return randomFrom(nounList);
        }
        if (label.equals("name")){
            return randomFrom(nameList);
        }
        if (label.equals("adjective")){
            return randomFrom(adjectiveList);
        }
        if (label.equals("animal")){
            return randomFrom(animalList);
        }
        if (label.equals("timeframe")){
            return randomFrom(timeList);
        }
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        if (label.equals("verb")) {
            return randomFrom(verbList);
        }
        if (label.equals("fruit")){
            return randomFrom(fruitList);
        }
        return "**UNKNOWN**";
    }
    
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
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        
        // before returning story, clear the counters
        usedWords.clear();
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    public void makeStory(){
        System.out.println("\n");
        String story = fromTemplate(source+"/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("\nReplaced words: "+wordCount);
        wordCount = 0;
    }
    


}
