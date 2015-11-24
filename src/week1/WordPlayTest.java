package week1;


import static org.junit.Assert.*;
import org.junit.Test;


/**
 * Testing WordPlay.
 * 
 * @author Pawel Daniluk 
 * @version 2015-11-18
 */
public class WordPlayTest {
    public WordPlay wp = new WordPlay();
    
    @Test
    public void testIsVovel() {
    
        assertEquals(true, wp.isVowel('A'));
        assertEquals(true, wp.isVowel('a'));
        
        assertEquals(false, wp.isVowel('c'));
        assertEquals(false, wp.isVowel('D'));
    }
    
    @Test
    public void TestReplaceVowels() {
            
        assertEquals("H*ll* W*rld", wp.replaceVowels("Hello World", '*'));
        assertEquals("***xxx***", wp.replaceVowels("aiexxxuoa", '*'));
    }
    
    @Test 
    public void TestEmphasize() {
        
        assertEquals("dn* ctg+*+ctg+", wp.emphasize("dna ctgaaactga", 'a'));
        assertEquals("M+ry Bell+ +br*c*d*br+", wp.emphasize("Mary Bella Abracadabra", 'a'));
    }
    
}
