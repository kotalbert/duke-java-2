package week4;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.duke.FileResource;

/**
 * Testing VigenereBreaker.
 * 
 * @author Pawel Daniluk
 * @version 1.0
 */
public class VigenereBreakerTest {

	private VigenereBreaker vb = new VigenereBreaker();

	@Test
	public void testSliceString() {
		
		assertEquals(vb.sliceString("abcdefghijklm", 0, 3), "adgjm");
		assertEquals(vb.sliceString("abcdefghijklm", 1, 3), "behk");
		assertEquals(vb.sliceString("abcdefghijklm", 2, 3), "cfil");
		
		assertEquals(vb.sliceString("abcdefghijklm", 0, 4), "aeim");
		assertEquals(vb.sliceString("abcdefghijklm", 1, 4), "bfj");
		assertEquals(vb.sliceString("abcdefghijklm", 2, 4), "cgk");
		assertEquals(vb.sliceString("abcdefghijklm", 3, 4), "dhl");
		
		assertEquals(vb.sliceString("abcdefghijklm", 0, 5), "afk");
		assertEquals(vb.sliceString("abcdefghijklm", 1, 5), "bgl");
		assertEquals(vb.sliceString("abcdefghijklm", 2, 5), "chm");
		assertEquals(vb.sliceString("abcdefghijklm", 3, 5), "di");
		assertEquals(vb.sliceString("abcdefghijklm", 4, 5), "ej");
	}
	
	@Test
	public void testTryKeyLength() {
		String enc= new FileResource("data/vignere/VigenereTestData/athens_keyflute.txt").asString();
		int[] key = vb.tryKeyLength(enc, 5, 'e');
		System.out.println("Encrypted");
		System.out.println(enc);
		System.out.println("Key");
		System.out.println(vb.translateKey(key));

	}
	
	@Test
	public void testBreakVigenere() {
		System.out.println("Decrypted:");
		vb.breakVigenere();
	}
	
	

}
