package week1;


/**
 * Implementation of Caesar Cipher.
 * 
 * @author Pawel Daniluk 
 * @version 2015-11-18
 */
public class CaesarCipher {

    final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";  
    
    /**
     * Method encrypts input with Caesar Cipher
     * @param   input   String to be encrypted
     * @param   key     key to be used in cipher
     * @return  ciphered input string
     */
    public String encrypt(String input, int key) {
    
        StringBuilder sb = new StringBuilder(input);
        
        for (int i=0; i< sb.length(); i++) {
            char encrypted = encrypt(sb.charAt(i), key);
            sb.setCharAt(i, encrypted);
        }
        
        return sb.toString();
    }
    
    /**
     * Helper function.
     * Encrypt single char with given key.
     * Decrypts letters only, returning non letters as is.
     * @param   ch  character to be encrypted
     * @param   key encryption key
     * @return  uppercase or lowercase encrypted character
     */
    private char encrypt(char ch, int key) {
        
        char chUC = Character.toUpperCase(ch);
        int cInd = ALPHABET.indexOf(chUC);
        
        // do not translate non letters
        if (cInd==-1) return ch;
        
        // index of encoded character
        int enInd = (cInd+key)%26;
        // encoded character
        char enCh = ALPHABET.charAt(enInd);
        
        // check the case of character and return appropriate
        if (Character.isUpperCase(ch)) return enCh;
        else return Character.toLowerCase(enCh);
    
    }
    
    /**
     * Parameter key1 is used to encrypt every other character with the 
     * Caesar Cipher algorithm, starting with the first character, 
     * and key2 is used to encrypt every other character, starting 
     * with the second character.
     * @return  string encrypted with two keys
     */
    public String encryptTwoKeys(String input, int key1, int key2) {
        
        StringBuilder sb = new StringBuilder(input);
        
        for (int i=0; i<sb.length(); i++) {
            char ch = sb.charAt(i);
            int key;
            if (i%2==0) key = key1;
            else key = key2;
            
            sb.setCharAt(i, encrypt(ch, key));
        }
        
        return sb.toString();
        
    }
    
}
