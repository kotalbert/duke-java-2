package week2;

import edu.duke.FileResource;
import edu.duke.DirectoryResource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Program to determine which words occur in the greatest number of files, 
 * and for each word, which files they occur in. 
 * 
 * @author Pawel Daniluk 
 * @version 2015-11-24
 */

public class WordsInFiles{
	
	private HashMap<String, ArrayList<String>> wordMap; 
	
	public WordsInFiles() {
		wordMap = new HashMap<String, ArrayList<String>>();
	}
	
	/**
	 * This method should add all the words from f into the map. 
	 * If a word is not in the map, then you must create a new ArrayList of
	 * type String with this word, and have the word map to this ArrayList. 
	 * If a word is already in the map, then add the current filename to its 
	 * ArrayList, unless the filename is already in the ArrayList.
	 * @param f	file to be processed
	 */
	private void addWordsFromFile(File f){
		
		FileResource fr = new FileResource(f);
		String fname = f.getName();
		
		for (String word : fr.words()) {
			
			if (!wordMap.containsKey(word)) {
				ArrayList<String> al = new ArrayList<String>();
				al.add(fname);
				wordMap.put(word, al);
			}
			else {
				ArrayList<String> al = wordMap.get(word);
				if (!al.contains(fname)) al.add(fname);
				
			}
		}
	}
	
	/**
	 *  This method first clears the map, and then uses a DirectoryResource 
	 *  to select a group of files. 
	 *  For each file, it puts all of its words into the map by calling 
	 *  the method addWordsFromFile. 
	 */
	public void buildWordFileMap() {
		wordMap.clear();
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) addWordsFromFile(f);
	}
	
	/**
	 *  This method returns the maximum number of files any word appears in, 
	 *  considering all words from a group of files. 
	 * @param word
	 * @return
	 */
	public int maxNumber() {
		
		int maxSize = 0;
		
		for (String key : wordMap.keySet()) {
			int aSize = wordMap.get(key).size();
			if (aSize>maxSize) maxSize=aSize;
		}
		return maxSize;
	}
	
	/**
	 * This method returns an ArrayList of words that appear in exactly
	 *  number files.
	 * @param 	number	number of files in which word appears
	 * @return	ArrayList of words that appear in number of files
	 */
	public ArrayList<String> wordsInNumFiles(int number) {
		ArrayList<String> al = new ArrayList<String>();
		for (String key : wordMap.keySet()) {
			if (wordMap.get(key).size()==number) al.add(key);
		}
		
		return al;
	}
	
	/**
	 * his method prints the names of the files this word appears in, 
	 * one filename per line. 
	 * @param word
	 */
	public void printFilesIn(String word) {
		System.out.println("Files containing "+word);
		for (String fname : wordMap.get(word)) System.out.println(fname);
	}
	
	public void printAll() {
		
		for (String key : wordMap.keySet()) {
			
			System.out.print(key+"\t");
			for (String fname : wordMap.get(key)) {
				System.out.print(fname+", ");
			}
			System.out.println();
		}
		
	}
	
	public static void tester() {
		WordsInFiles wif = new WordsInFiles();
		wif.buildWordFileMap();
		
		// number of words that appear in 5 files
		System.out.println("Number of words in 7 files: " 
		+ wif.wordsInNumFiles(7).size());
		// number of words that appear in 4 files
		System.out.println("Number of words in 4 files: " 
		+ wif.wordsInNumFiles(4).size());
		
		// files with "laid"
		wif.printFilesIn("laid");
		
		// files with "tree"
		wif.printFilesIn("tree");
		
		
	}
	
	public static void tester2() {
		WordsInFiles wif = new WordsInFiles();
		wif.buildWordFileMap();
		
		wif.printAll();
		System.out.println("Number of words in 3 files: " 
		+ wif.wordsInNumFiles(3).size());
		
	}
	
	public static void main(String[] args) {
		// 
		tester();

	}
	
}