package com.hit.algorithms;



public class KeyAndRank<K> implements Comparable<KeyAndRank<K>> {
	
	private final K m_Key;
	private int m_Rank;
	
	public KeyAndRank(K io_Key)
	{
		m_Key=io_Key;
		m_Rank=0;
	}

	
	public K getKey() {
		return m_Key;
	}

	public int getRank()
	{
		return m_Rank;
	}
	
	public void addRank()
	{
		m_Rank++;
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
