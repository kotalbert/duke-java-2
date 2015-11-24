package week1;


/**
 * OO version of CaesarCipher
 * 
 * @author Pawel Daniluk
 * @version 2015-11-21
 */
public class CaesarCipherOne {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int key;
    
    /**
     * Constructor setting the key for encryption and decryption.
     * @param   key shift parameter for Caesar Cipher
     */
    public CaesarCipherOne(int key) {this.key=key;}
    
    /**
     * Method encrypts input with Caesar Cipher
     * @param   input   String to be encrypted
     * @return  ciphered input string
     */
    public String encrypt(String input) {
        
        StringBuilder sb = new StringBuilder(input);
        
        for (int i=0; i< sb.length(); i++) {
            char encrypted = encrypt(sb.charAt(i));
            sb.setCharAt(i, encrypted);
        }
        
        return sb.toString();
    }
    
    /**
     * Helper function.
     * Encrypt single char with instance key.
     * Decrypts letters only, returning non letters as is.
     * @param   ch  character to be encrypted
     * @return  uppercase or lowercase encrypted character
     */
    public char encrypt(char ch) {
        
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
     * Decrypt Caesar Cipher with an instance given key.
     * @param   msg String to be decrypted
     * @return  decrypted msg
     */
    public String decrypt(String msg) {
        
        StringBuilder sb = new StringBuilder(msg);
        
        for (int i=0; i< sb.length(); i++) {
            char decrypted = decrypt(sb.charAt(i));
            sb.setCharAt(i, decrypted);
        }
        
        return sb.toString();
    }
    
    /**
     * Helper function for decrypting single character with key. 
     * Decrypts letters only, returning non letters as is.
     * @param   ch  character to be decrypted
     * @return  uppercase or lowercase decrypted character
     */
    private char decrypt(char ch) {
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
     * Find index of max value in array.
     * @param   vals    array of ints to be checked.
     * @return  index of max value in ints array
     */
    private static int maxIndex(int[] vals) {
        
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
     * Count occurancies of letters in string.
     * @param   msg String for which number of letters is to be calculated
     * @return  int array containing frequencie of letters
     */
    private static int[] countLetters (String msg) {
        int[] counts = new int[26];
        for (char c : msg.toCharArray()) {
            char cuc = Character.toUpperCase(c);
            if (Character.isAlphabetic(cuc)) counts[ALPHABET.indexOf(cuc)]++;
        }
           
        return counts;
    }
    /**
     * Method for finding encryption key, based on most common occurences of letter
     * in encrypted msg, assuming that it represents 'e';
     * @param   msg encrypted string for which key is to be found
     * @return  encryption key for msg
     */
    private static int getKey(String encrypted) {
        //count letters in msg
        int[] counts = countLetters(encrypted);
        //find intex of highest count
        int indOfMax = maxIndex(counts);
        //find&return shift
        final int IND_E = 4;
        int key = indOfMax - IND_E;
        if (key<0) return key+26;
        else return key;
        
    }
    
    /**
     * Method for breaking Caesar Cipher with one key, based on 'e' occurances.
     * @param   input   string to be decrypted
     * @return  decrypted input string
     */
    public static String breakCipher(String input) {
        int key = getKey(input);
        System.out.println("Found key: "+key);
        CaesarCipherOne cc = new CaesarCipherOne(key);
        return cc.decrypt(input);
        
    }
}
