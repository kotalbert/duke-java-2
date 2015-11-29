package week4;

/**
 * Implementation of  Vigenere Cipher, modified from course template.
 * 
 * @author Pawel Daniluk
 * @version 2.0
 *
 */

import java.util.*;

public class VigenereCipher {
    CaesarCipher[] ciphers; 
    
    /**
     * Default constructor for VigenereCipher.
     * @param key	array if integers, representing positions of key letters 
     * in alphabet.
     */
    public VigenereCipher(int[] key) {
        ciphers = new CaesarCipher[key.length];
        for (int i = 0; i < key.length; i++) {
            ciphers[i] = new CaesarCipher(key[i]);
        }
    }
    
    public VigenereCipher(String key) {
    	this(keyCode(key));
    }
    
    /**
     * Helper function to create key integer array from string.
     * @param 	input	key string
     * @return	integer array representing key string
     */
    private static int[] keyCode(String input) {
    	
    	final String ABT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
    	String inUC = input.toUpperCase(); 
    	int[] out = new int[input.length()];
    	
    	for (int i=0; i<input.length();i++) 
    		out[i] = ABT.indexOf(inUC.charAt(i));
    		
    	return out;
    }
    
    
    public String encrypt(String input) {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            int cipherIndex = i % ciphers.length;
            CaesarCipher thisCipher = ciphers[cipherIndex];
            answer.append(thisCipher.encryptLetter(c));
            i++;
        }
        return answer.toString();
    }
    
    public String decrypt(String input) {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            int cipherIndex = i % ciphers.length;
            CaesarCipher thisCipher = ciphers[cipherIndex];
            answer.append(thisCipher.decryptLetter(c));
            i++;
        }
        return answer.toString();
    }
    
    public String toString() {
        return Arrays.toString(ciphers);
    }
    
}
