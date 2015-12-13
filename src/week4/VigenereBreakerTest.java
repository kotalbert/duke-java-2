package week4;

import static org.junit.Assert.*;

import java.util.HashSet;

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
	
	private void assertMostCommonCharIn(String path, char mostCommonChar) {
		HashSet<String> dict = vb.readDictionary(new FileResource(path));
		char mostCommon = vb.mostCommonCharIn(dict);
		assertTrue("Dict not ok.", mostCommon == mostCommonChar);
	}
	
	@Test
	public void testMostCommonCharIn() {

		assertMostCommonCharIn("data/vignere/dictionaries/English", 'e');
		assertMostCommonCharIn("data/vignere/dictionaries/German", 'e');
		assertMostCommonCharIn("data/vignere/dictionaries/Italian", 'a');
		assertMostCommonCharIn("data/vignere/dictionaries/Portuguese", 'a');
		
		
	}
	
}
