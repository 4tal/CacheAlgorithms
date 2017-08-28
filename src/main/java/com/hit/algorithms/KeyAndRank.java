package com.hit.algorithms;



public class KeyAndRank<K> implements Comparable<KeyAndRank<K>> {
	
	private final K key;
	private int rank;
	
	public KeyAndRank(K key)
	{
		this.key = key;
		setRank(0);
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public K getKey() {
		return key;
	}

	public int getRank()
	{
		return rank;
	}
	
	public void addRank()
	{
		rank++;
	}
	
	
	
	@Override
	public int compareTo(KeyAndRank<K> i_Object) {
		if(this.getRank()<i_Object.getRank())
		{
			return -1;
		}
		else if(this.getRank()==i_Object.getRank())
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
	
	

}
