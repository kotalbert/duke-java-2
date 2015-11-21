package week1;


import static org.junit.Assert.*;
import org.junit.Test;
import week1.CaesarCipher.*;


/**
 * Testing breaker of Caesar Cipher: CaesarBreaker.
 * 
 * @author Pawel Daniluk 
 * @version 2015-11-20
 */
public class CaesarBreakerTest {
    CaesarCipher cc = new CaesarCipher();
    CaesarBreaker cb = new CaesarBreaker();
    
    @Test
    public void testDecrypt(){
    
        int key = 10;
        String msg = "This is a text to be tested.";
        String encrypted = cc.encrypt(msg, key);
        System.out.println("Encrypted:\t"+ encrypted);
        System.out.println("Decrypted:\t" +  cb.decrypt(encrypted, key));
        
    }
    
    @Test
    public void testCountLetters() {
    
    //String txt = "aaAAbbBBcccCCcdefghijklmnoprstquvyz";
    String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    txt+=txt.toLowerCase();
    int[] counts = cb.countLetters(txt);
    for (int i=0;i<counts.length;i++) {
    
        System.out.printf("%d\t%d\n", i, counts[i]);
    }
    
    }
    
    private int mi(String txt) {return cb.maxIndex(cb.countLetters(txt));}
    
    @Test
    public void testMaxIndex() {
    String txt = "aaaabbc";
    assertEquals(0, mi(txt));
    
    txt = "aaAbbBBcC";
    assertEquals(1, mi(txt));
    
    txt = "aaAbbBBcCcccccc";
    assertEquals(2, mi(txt));
    
    }
    
    private String e(String txt, int key) {return cc.encrypt(txt, key);}
    
    @Test
    public void testFindKey() {
    
        String txt = "eeeEEEeeeeeee aaabb ccdd eeeCCCCEEEE";
        int setKey;
        setKey = 17;
        assertEquals(setKey,cb.findKey(e(txt,setKey)));
        setKey = 2;
        assertEquals(setKey,cb.findKey(e(txt,setKey)));
        setKey = 9;
        assertEquals(setKey,cb.findKey(e(txt,setKey)));
        setKey = 25;
        assertEquals(setKey,cb.findKey(e(txt,setKey)));
    }
    
    @Test
    public void testDecryptOneKey() {
    
        String org = "This is message to be decrypted with my methods!@@@ eee!!";
        String enc = cc.encrypt(org, 21);
        String dec = cb.decryptOneKey(enc);
        assertEquals(org,dec);
        
    }
    
    
}
