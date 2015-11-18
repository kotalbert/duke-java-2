package week1;


/**
 * Write a description of WordPlay here.
 * 
 * @author Pawel Daniluk 
 * @version 2015-11-18
 */
public class WordPlay {

    private final char[] vovels = {'a', 'e', 'i', 'o', 'u'};
    /**
     *  This method returns true if ch is a vowel 
     *  (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) 
     *  and false otherwise.
     *  @param  ch  char to be checked
     */
    public boolean isVowel (char ch) {
        char chLow = Character.toLowerCase(ch);
        for (char c : vovels) {
            if (chLow == c) return true;
        }
        return false;
    }
    
    /**
     * Return a String that is the string phrase with all the vowels 
     * (uppercase or lowercase) replaced by ch.
     * @param   phrase  String to be changed
     * @param   ch      character to replace all vovels
     * @return  new String that is phrase with vovels replaced by ch
     */
    public String replaceVowels (String phrase, char ch) {
    
        StringBuilder sb = new StringBuilder(phrase);
        
        for (int i=0;i<sb.length(); i++) {
            if (isVowel(sb.charAt(i))) sb.setCharAt(i, ch);
        }
        
        return sb.toString();
        
    }
    
    /**
     *  This method should return a String that is the string phrase but with the 
     *  Char ch (upper- or lowercase) replaced by ‘*’ if it is in an odd number location in 
     *  the string (first character has index 0, third character has index 2, etc.), or
     *  ‘+’ if it is in an even number location in the string (second character has index 1, 
     *  fourth character has index 3, etc.).
     *  @param  phrase  String to be processed
     *  @param  ch      character to be replaced in string
     *  @return phrase with char ch replaced with '*' or '+'
     */
    public String emphasize(String phrase, char ch) {
        StringBuilder sb = new StringBuilder(phrase);
        
        char chLC = Character.toLowerCase(ch);
        
        for (int i=0; i< sb.length(); i++) {
            char lc = Character.toLowerCase(sb.charAt(i));
            if (lc == chLC) {
                if (i%2==0) sb.setCharAt(i, '*'); 
                else sb.setCharAt(i, '+');
            }
        
        }
        
        return sb.toString();
        
    
    }
    
    
}
