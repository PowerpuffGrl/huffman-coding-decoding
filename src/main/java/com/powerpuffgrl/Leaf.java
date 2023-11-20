package com.powerpuffgrl;

import lombok.EqualsAndHashCode;
import lombok.Getter;

//A separate Leaf class is needed inorder to store information about 
//the character that leaf node represents  

@Getter
@EqualsAndHashCode(callSuper=true)
public class Leaf extends Node{
	
	private final char character;
	
	public Leaf(char character, int frequency) {
		super(frequency);
		this.character=character;
	}

}
