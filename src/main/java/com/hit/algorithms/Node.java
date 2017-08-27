package com.hit.algorithms;

//Create this class for the the NFU (We need to hold a rank for each pair).

public class Node<K> implements Comparable<Node<K>> {
	
	int m_Rank;
	final K k_Key;
	
	public Node(K io_Key)
	{
		m_Rank=0;
		k_Key=io_Key;
	}
	
	public int getRank()
	{
		return m_Rank;
	}
	
	public void addRank()
	{
		m_Rank++;
	}
	
	public K getKey()
	{
		return k_Key;
	}
	
	//For the comparable implementation
	@Override
	public int compareTo(Node<K> i_Object) {
		if(getRank()<i_Object.getRank())
		{
			return -1;
		}
		else if(getKey()==i_Object.getKey()){
			return 0;
		}
		else{
			return 1;
		}
		
	}
	
	//The LinkedList is been sorted by this implementation.
	public boolean equals(Object i_Object){
		if(this.getKey().equals(((Node<K>) i_Object).getKey())){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString()
	{
		return k_Key+","+m_Rank;
	}

}





