package week1;


import static org.junit.Assert.*;
import org.junit.Test;
import edu.duke.FileResource;

/**
 * Test Caesar Cipher implementation.
 * 
 * @author Pawel Daniluk 
 * @version 2015-11-18
 */
public class CaesarCipherTest {
   
    private CaesarCipher cc = new CaesarCipher();
    
    @Test
    public void testEncrypt() {
        assertEquals("CFOPQ IBDFLK XQQXZH BXPQ CIXKH!", cc.encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
        assertEquals("Wzijk Cvxzfe", cc.encrypt("First Legion", 17));
    }
    
    @Test
    public void testCaesar() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        int key = 11;
        String encrypted = cc.encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }
    
    @Test
    public void testEncryptTwoKeys() {
        assertEquals("Czojq Ivdzle", cc.encryptTwoKeys("First Legion", 23, 17));
        
    }
    
    @Test
    public void quiz1() {
    
        String str = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        System.out.println(cc.encrypt(str, 15));
        System.out.println(cc.encryptTwoKeys(str, 8, 21));
    }
}
