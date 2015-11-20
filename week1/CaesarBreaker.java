package week1;


/**
 * Break the Caesar Cipher using the letter frequencies. 
 * 
 * @author Pawel Daniluk
 * @version 2015-11-20
 */
public class CaesarBreaker {
    
    final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";  
    
    /**
     * Count occurancies of letters in string.
     * @param   msg String for which number of letters is to be calculated
     * @return  int array containing frequencie of letters
     */
    public int[] countLetters (String msg) {
        int[] counts = new int[26];
        for (char c : msg.toCharArray()) {
            char cuc = Character.toUpperCase(c);
            if (Character.isAlphabetic(cuc)) counts[ALPHABET.indexOf(cuc)]++;
        }
           
        return counts;
    }
    
    /**
     * Find index of max value in array.
     * @param   vals    array of ints to be checked.
     * @return  index of max value in ints array
     */
    public int maxIndex(int[] vals) {return -1;}
    /**
     * Decrypt Caesar Cipher with a given key.
     * @param   msg String to be decrypted
     * @param   key key for decrypting.
     * @return  decrypted msg
     */
    public String decrypt(String msg, int key) {
        
        StringBuilder sb = new StringBuilder(msg);
        
        for (int i=0; i< sb.length(); i++) {
            char decrypted = decrypt(sb.charAt(i), key);
            sb.setCharAt(i, decrypted);
        }
        
        return sb.toString();
    }
    
    /**
     * Helper function for decrypting single character with key. 
     * Decrypts letters only, returning non letters as is.
     * @param   ch  character to be decrypted
     * @param   key to be used in decrypting
     * @return  uppercase or lowercase decrypted character
     */
    private char decrypt(char ch, int key) {
        char chUC = Character.toUpperCase(ch);
        int cind = ALPHABET.indexOf(chUC);
        // do not decrypt non letters
        if (cind == -1) return ch;
        
        // index of decrypted character
        int dind = (cind - key) % 26;
        
        // java can return negative from modulo:
        if (dind <0) dind+=26;
        
        // decrypted uppercase character
        char dch = ALPHABET.charAt(dind);
        
        // check original case and return decrypted char
        if (Character.isUpperCase(ch)) return dch;
        else return Character.toLowerCase(dch);
    }
}
