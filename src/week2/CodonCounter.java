package week2;

import edu.duke.FileResource;
import java.util.HashMap;

/**
 * Program to find out how many times each codon occurs in a strand of DNA 
 * based on reading frames.
 * 
 * @author Pawel Daniluk 
 * @version 2015-11-24
 */

public class CodonCounter {
	
	private HashMap<String, Integer> codons;
	
	public CodonCounter() {
		codons = new HashMap<String, Integer>();
	}
	
	/**
	 * This method will add codons to map of codons mapped to their counts 
	 * from the string dna with the reading frame with the position 
	 * start (a value of 0, 1, or 2).
	 * @param start	start index to count codons (a value of 0, 1, or 2)
	 * @param dna	dna to be processed
	 */
	private void buildCodonMap(int start, String dna) {
		
		for (int i=start; i<dna.length()-3;i++) {
			String codon = dna.substring(i, i+3);
			if (!codons.containsKey(codon)) codons.put(codon,1);
			else codons.put(codon, codons.get(codon)+1);
		}
		
	}
	
	/**
	 * This method will build a new map of codons mapped to their counts 
	 * from the string dna with the reading frame with the position 
	 * start (a value of 0, 1, or 2).
	 * @param dna	dna to be processed
	 */
	public void buildCodonMap(String dna) {
		codons.clear();
		for (int i=0;i<=3;i++) buildCodonMap(i, dna);
		
	}
	
	public String getMostCommonCodon() {
		int maxCount = 0;
		String mostCodon = new String();
		
		for (String codon : codons.keySet()) {
			int count = codons.get(codon);
			if (maxCount<count) {
				maxCount = count;
				mostCodon = codon;
			}
		}
		
		return "Most comon codon: "+mostCodon+"\t"+maxCount;
		
	}
	
	public void printCodonCounts(int start, int end) {
		
		for (String codon : codons.keySet()) {
			int count = codons.get(codon);
			if (count>=start && count<=end) System.out.println(codon+"\t"+count);
			
		}
		
	}
	
	public static void main(String[] args) {
		CodonCounter cc = new CodonCounter();
//		FileResource fr = new FileResource();
//		String DNA = fr.asString();
		
		String DNA = "CGTTCAAGTTCAA";
		cc.buildCodonMap(DNA);
		System.out.println(cc.getMostCommonCodon());
		cc.printCodonCounts(1, 5);

	}
	
}

