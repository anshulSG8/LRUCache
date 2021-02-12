package com.lru;

import java.math.BigInteger;
import java.util.HashMap;

public class LRUCache {
	
	private HashMap<Integer, LRUNode> hashmap;
	private LRUNode head;
	private LRUNode tail;
	private int LRU_SIZE;
	
	public LRUCache(int size) {
		hashmap = new HashMap<Integer, LRUNode>();
		LRU_SIZE = size;
	}

	public int getEntry(int key) {
		if (hashmap.containsKey(key))
		{
			LRUNode lruNode = hashmap.get(key);
			removeNode(lruNode);
			addAtTop(lruNode);
			return lruNode.getValue();
		}
		return -1;
	}

	public void putEntry(int key, int value) {
		if (hashmap.containsKey(key)) // Key Already Exist, just update the value and move it to top
		{
			LRUNode lruNode = hashmap.get(key);
			lruNode.setValue(value);
			removeNode(lruNode);
			addAtTop(lruNode);
		} else {
			LRUNode lruNode = new LRUNode();
			lruNode.setPrevious(null);
			lruNode.setNext(null);
			lruNode.setValue(value);
			lruNode.setKey(key);
			if (hashmap.size() > LRU_SIZE) // We have reached maxium size so need to make room for new element.
			{
				hashmap.remove(tail.getKey());
				removeNode(tail);				
				addAtTop(lruNode);

			} else {
				addAtTop(lruNode);
			}

			hashmap.put(key, lruNode);
		}
	}
	public void addAtTop(LRUNode lruNode) {
		lruNode.setNext(head);
		lruNode.setPrevious(null);
		if (head != null)
			head.setPrevious(lruNode);
		head = lruNode;
		if (tail == null)
			tail = head;
	}

	public void removeNode(LRUNode lruNode) {

		if (lruNode.getPrevious() != null) {
			lruNode.getPrevious().setNext(lruNode.getNext()); 
		} else {
			head = lruNode.getNext();
		}

		if (lruNode.getNext() != null) {
			lruNode.getNext().setPrevious(lruNode.getPrevious());
		} else {
			tail = lruNode.getPrevious();
		}
	}
	
	public static void main(String[] args) throws Exception {
		// your code goes here
		LRUCache lrucache = new LRUCache(4);
		lrucache.putEntry(1, 1);
		lrucache.putEntry(10, 15);
		lrucache.putEntry(15, 10);
		lrucache.putEntry(10, 16);
		lrucache.putEntry(12, 15);
		lrucache.putEntry(18, 10);
		lrucache.putEntry(13, 16);

		System.out.println(lrucache.getEntry(1));
		System.out.println(lrucache.getEntry(10));
		System.out.println(lrucache.getEntry(15));
		BigInteger i = new BigInteger("124");
		i.subtract(new BigInteger("234"));
	}
	
}
