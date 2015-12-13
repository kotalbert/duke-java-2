package week4;

import java.util.HashSet;

import edu.duke.FileResource;

/**
 * Testing of Caesar and Vigenere Cipher
 * 
 * @author Pawel Daniluk
 * @version 1.0
 */

public class Tester {


	private CaesarCipher cc;
	private CaesarCracker crack;
	private VigenereBreaker vb;
	
	private <T> void print(T t) {
		System.out.println(t);
	}
	
	public Tester(int key) {
		this.cc = new CaesarCipher(key);
		this.crack = new CaesarCracker();
		this.vb = new VigenereBreaker();
	}
	
	public void testCaesarCipher() {
		String text = new FileResource().asString();
		print("Text to encrypt:");
		print(text);
		print("Encrypted text:");
		print(cc.encrypt(text));
		
	}
	
	public void testCaesarCracker() {
		
		String text = new FileResource().asString();
		print("Encrypted text:");
		String encrypted = cc.encrypt(text); 
		print(encrypted);
		
		print("Cracked text:");
		print(crack.decrypt(encrypted));
		print("Key found:");
		print(crack.getKey(encrypted));
		
	}
	
	public void testVigenereCipher(String key) {
		
		VigenereCipher stringvc = new VigenereCipher(key);
		int[] intkey = {17, 14, 12, 4};
		VigenereCipher intvc = new VigenereCipher(intkey);
		String input = new FileResource().asString();
		
		String intsencrypted = intvc.encrypt(input);
		String stringencrypted = stringvc.encrypt(input);
		
		print("Text to encrypt:");
		print(input);
		
		print("Encrypted with ints:");
		print(intsencrypted);
		
		print("Encrypted with string:");
		print(stringencrypted);
	}
	
	
	public void testBreakVigenere() {
		System.out.println("Decrypted:");
		vb.breakVigenere();
	}
	
	public void testTryKeyLength() {
		String enc= new FileResource("data/vignere/VigenereTestData/athens_keyflute.txt").asString();
		int[] key = vb.tryKeyLength(enc, 5, 'e');
		System.out.println("Encrypted");
		System.out.println(enc);
		System.out.println("Key");
		System.out.println(vb.translateKey(key));

	}
	
	public void testReadDictionary() {
		FileResource fr = new FileResource();
		HashSet<String> set = vb.readDictionary(fr);
		
		for (String item :  set) System.out.println(item);
	}
	
	public void testCountWords() {
		
		HashSet<String> dict = vb.readDictionary(new FileResource("data/vignere/dictionaries/English"));
		System.out.println(vb.countWords(new FileResource().asString(), dict));
		
	}
	
	public static void main(String[] args) {

		Tester t = new Tester(19);
//		t.testCaesarCipher();
//		t.testCaesarCracker();
//		t.testVigenereCipher("rome");
//		t.testReadDictionary();
//		t.testCountWords();
		t.testBreakVigenere();
		
	}

}
