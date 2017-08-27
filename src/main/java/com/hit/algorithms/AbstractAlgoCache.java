package com.hit.algorithms;

public abstract class AbstractAlgoCache<K,V> implements IAlgoCache<K,V>  {
	
	protected final int m_Capacity;
	
	public AbstractAlgoCache(int i_Capacity)
	{
		m_Capacity=i_Capacity;
	}	
	
	public int getCapacity()
	{
		return m_Capacity;
	}
}

