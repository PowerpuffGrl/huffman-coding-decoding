package com.powerpuffgrl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Node implements Comparable<Node>{

	private final int frequency;

	private Node leftNode;

	private Node rightNode;

	public Node(Node leftNode, Node rightNode) {
		this.frequency = leftNode.getFrequency() + rightNode.getFrequency();
		this.leftNode = leftNode;
		this.rightNode = rightNode;

	}
	
	//Need to add compareTo method so that nodes can be sorted in ascending order 
	//of frequency in priority queue
	@Override
	public int compareTo(Node node) {
		return Integer.compare(frequency, node.getFrequency());
	}
}
