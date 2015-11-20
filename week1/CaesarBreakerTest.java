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
    
}
