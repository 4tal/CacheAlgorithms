package com.hit.algorithms;

public abstract class AbstractAlgoCache<K,V> implements IAlgoCache<K,V>  {
	
	private final int capacity;
	
	public AbstractAlgoCache(int capacity)
	{
		this.capacity = capacity;
	}


	public int getCapacity()
	{
		return capacity;
	}
}

