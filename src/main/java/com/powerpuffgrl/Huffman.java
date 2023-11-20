package com.powerpuffgrl;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Huffman {

	private Node root;
	private final String text;
	private Map<Character, Integer> charFrequencies;
	private final Map<Character, String> huffmanCodes;

	public Huffman(String text) {
		this.text = text;
		fillCharFrequenciesMap();

		huffmanCodes = new HashMap<>();

	}

	// construct a hashmap of charactera and their frequency count
	private void fillCharFrequenciesMap() {
		charFrequencies = new HashMap<Character, Integer>();
		for (char character : text.toCharArray()) {
			Integer freq = charFrequencies.get(character);
			charFrequencies.put(character, freq != null ? freq + 1 : 1);

		}
		System.out.println(charFrequencies);

	}

	public String encode() {

		// construct a queue with Leaves in ascending order of their frequency
		Queue<Node> queue = new PriorityQueue<>();
		charFrequencies.forEach((character, frequency) -> queue.add(new Leaf(character, frequency)));

		// Now, read first two leaves add back in the queue as Nodes
		while (queue.size() > 1) {
			queue.add(new Node(queue.poll(), queue.poll()));
		}

		root = queue.poll();
		generateHuffmanCodes(root, "");

		return getEncodedText();
	}

	// read the huffman codes from root to leaves to get code for each character
	private void generateHuffmanCodes(Node node, String code) {
		if (node instanceof Leaf) {
			huffmanCodes.put(((Leaf) node).getCharacter(), code);
			return;
		}

		generateHuffmanCodes(node.getLeftNode(), code.concat("0"));
		generateHuffmanCodes(node.getRightNode(), code.concat("1"));
	}

	private String getEncodedText() {
		StringBuilder sb = new StringBuilder();
		for (char c : text.toCharArray()) {
			sb.append(huffmanCodes.get(c));
		}
		return sb.toString();
	}

	public String decode(String encodedText) {
		StringBuilder sb = new StringBuilder();
		Node current = root;
		for (char character : encodedText.toCharArray()) {
			current = character == '0' ? current.getLeftNode() : current.getRightNode();
			if (current instanceof Leaf) {
				sb.append(((Leaf) current).getCharacter());
				current = root;
			}
		}
		return sb.toString();
	}

	public void printCodes() {
		huffmanCodes.forEach((character,freq)-> System.out.println(character+"->"+freq));
		
	}
}
