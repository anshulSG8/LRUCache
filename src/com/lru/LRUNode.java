package com.lru;

public class LRUNode {
	
	private int key;
	private int value;
	
	private LRUNode previous;
	private LRUNode next;
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public LRUNode getPrevious() {
		return previous;
	}
	public void setPrevious(LRUNode previous) {
		this.previous = previous;
	}
	public LRUNode getNext() {
		return next;
	}
	public void setNext(LRUNode next) {
		this.next = next;
	}
	
	
}
