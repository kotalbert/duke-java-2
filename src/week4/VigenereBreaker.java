package week4;

import edu.duke.FileResource;

/**
 * Class for breaking Vigenere Cipher, based on course template.
 * @author Pawel Daniluk
 * @version 1.0
 */
public class VigenereBreaker {
	
    /**
     * This method slices string and returns one slice for further processing.
     * @param 	message		text to be sliced
     * @param 	whichSlice	slice to be returned (starting 0);
     * @param 	totalSlices	total number of slices of the text
     * @return 	string slice for decrypting 
     */
    public String sliceString(String message, int whichSlice, int totalSlices) {
    	StringBuilder sb = new StringBuilder();
    	char[] ca = message.toCharArray();
    	for (int i=whichSlice;i<ca.length;i+=totalSlices) sb.append(ca[i]);
  
    	return sb.toString();
    }
    
    /**
     * Translates integer array key to string representation.
     * @param 	key	key integer array
     * @return	string representation of key
     */
    public String translateKey(int[] key) {
    	final String ABT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i=0;i<key.length;i++) sb.append(ABT.charAt(key[i]));
    	
    	return sb.toString();
    }
    
    /**
     * Method for extracting key from encrypted input.  
     * @param 	encrypted	message encrypted with Vigenere Cipher
     * @param 	klength		length of the key
     * @param 	mostCommon	most common letter in language
     * @return	key integer array
     */
    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker(mostCommon);
        
        for (int i=0; i<klength;i++) {
        	String slice = sliceString(encrypted, i, klength);
        	key[i] = cc.getKey(slice);
        }
        
        return key;
    }

    /**
     * Decrypt and print selected file.
     */
    public void breakVigenere () {
        String input = new FileResource().asString();
        int[] key = tryKeyLength(input, 4, 'e');
        String dec = new VigenereCipher(key).decrypt(input);
        for (int i=0;i<key.length;i++) System.out.println(i+":\t"+key[i]);
        System.out.println();
        
        System.out.println(dec);        
        
    }
    
}
