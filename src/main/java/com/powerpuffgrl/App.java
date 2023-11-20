package com.powerpuffgrl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		
		Huffman huffman = new Huffman("aaaaaaaabbbbbbbccccdd");
		String encodedText = huffman.encode();
		System.out.println(encodedText);
		
		String decodedText = huffman.decode(encodedText);
		System.out.println(decodedText);
		
		huffman.printCodes();
	}
	
	

}

