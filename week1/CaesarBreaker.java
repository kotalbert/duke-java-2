package week1;


/**
 * Break the Caesar Cipher using the letter frequencies. 
 * 
 * @author Pawel Daniluk
 * @version 2015-11-20
 */
public class CaesarBreaker {
    
    final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";  
    // ABCDEFGHIJ   KLMNOPQRST  UVWXYZ
    // 0123456789   0123456789  012345
    
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
    public int maxIndex(int[] vals) {
        
        int indOfMax = 0;
        int maxSoFar = vals[0];
        
        for (int i=1;i<vals.length;i++){
        
            if (vals[i]>maxSoFar) {
                maxSoFar = vals[i];
                indOfMax = i;
            }
        }
        
        return indOfMax;
    }
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
    
        
    /**
     * Method for finding encryption key, based on most common occurences of letter
     * in encrypted msg, assuming that it represents 'e';
     * @param   msg encrypted string for which key is to be found
     * @return  encryption key for msg
     */
    public int findKey(String msg) {
        //count letters in msg
        int[] counts = countLetters(msg);
        //find intex of highest count
        int indOfMax = maxIndex(counts);
        //find&return shift
        final int IND_E = 4;
        int key = indOfMax - IND_E;
        if (key<0) return key+26;
        else return key;
        
    }
    
    /**
     * Method for decrypting meg, encrypted with one key.
     * @param   msg string to be decrypted
     * @return  decrypted msg with key guessed
     */
    public String decryptOneKey(String msg) {
        
        return decrypt(msg, findKey(msg));
        
    }

}
