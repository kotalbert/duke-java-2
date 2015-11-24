package week1;


/**
 * OO version of CaesarCipher with two key decryption
 * 
 * @author Pawel Daniluk 
 * @version 2015-11-21
 */
public class CaesarCipherTwo {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private CaesarCipherOne cc0;
    private CaesarCipherOne cc1;

    /**
     * Constructor setting the keys for encryption and decryption.
     * @param   key0    shift parameter for 2n elements
     * @param   key1    shift parameter for 2n+1 elements
     */
    public CaesarCipherTwo(int key0, int key1) {
        cc0 = new CaesarCipherOne(key0);
        cc1 = new CaesarCipherOne(key1);
    }
    
    /**
     * Method encrypts input with two key method.
     * key0 is used to encrypt every other character with the 
     * Caesar Cipher algorithm, starting with the first character (index 0), 
     * and key1 is used to encrypt every other character, starting 
     * with the second character (index 1).
     * @param   input   String to be encrypted
     * @return  string encrypted with two keys
     */
    public String encrypt(String input) {
        
        StringBuilder sb = new StringBuilder(input);
        
        for (int i=0; i<sb.length(); i++) {
            char ch = sb.charAt(i);
            int key;
            if (i%2==0) sb.setCharAt(i,cc0.encrypt(ch));
            else sb.setCharAt(i,cc1.encrypt(ch));
            
        }
        
        return sb.toString();
    }
    
    /**
     * Method decrypts encrypted input with instance keys.
     * @param   input string encrypted with instance keys and encrypt method
     * @return  decrypted string
     */
    public String decrypt(String input) {
        String s0 = halfOfString(input, 0);
        String s1 = halfOfString(input, 1);
        
        String de0 = cc0.decrypt(s0);
        String de1 = cc1.decrypt(s1);
        
        return mix(de0, de1);
    }
    
    /**
     * Helper function.
     * This method should return a new String that is every 
     * other character from message starting with the start position.
     * @param input   string to be split in half
     * @param   start   starting point to begin splitting
     * @return  string containing every other letter from input
     */
    private static String halfOfString(String input, int start) {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=start;i<input.length();i+=2) sb.append(input.charAt(i));
        
        return sb.toString();
    
    }
    
    /**
     * Helper function for merging string split with halfOfString
     * @param   s0  substring starting from index 0
     * @param   s1  substring starting from index 1
     * @return  original string split with halfOfString
     */
    private static String mix(String s0, String s1) {
        
        StringBuilder sb = new StringBuilder(s0+s1);
        
        //put s0 to place
        for (int i=0;i<s0.length();i++) {
            sb.setCharAt(2*i, s0.charAt(i));
        }
        //put s1 to place
        for (int i=0;i<s1.length();i++) {
            sb.setCharAt(2*i+1, s1.charAt(i));
        }
        return sb.toString();
    
    }
    
    /**
     * Break two key cipher, print keys and return decrypted input.
     * @param   input   string to be decrypted
     * @return  decrypted input
     */
    public static String breakCipher(String input) {
        String s0 = halfOfString(input, 0);
        String s1 = halfOfString(input, 1);
        
        String d0 = CaesarCipherOne.breakCipher(s0);
        String d1 = CaesarCipherOne.breakCipher(s1);
        
        return mix(d0, d1);
    
    
    }
}
