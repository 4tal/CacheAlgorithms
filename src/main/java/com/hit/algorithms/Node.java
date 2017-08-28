package com.hit.algorithms;

//Create this class for the the NFU (We need to hold a rank for each pair).

public class Node<K> implements Comparable<Node<K>> {
	
	private int rank;
	private final K key;
	
	public Node(K key)
	{
		setRank(0);
		this.key = key;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRank()
	{
		return rank;
	}
	
	public void addRank()
	{
		rank++;
	}
	
	public K getKey()
	{
		return key;
	}
	
	//For the comparable implementation
	@Override
	public int compareTo(Node<K> node) {
		if(getRank() < node.getRank())
		{
			return -1;
		}
		else if(getKey() == node.getKey()){
			return 0;
		}
		else{
			return 1;
		}
		
	}
	
	//The LinkedList is been sorted by this implementation.
	public boolean equals(Object object){
		if(this.getKey().equals(((Node<K>) object).getKey())){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString()
	{
		return key + ", " + rank;
	}

}





