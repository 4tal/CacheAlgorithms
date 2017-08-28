package com.hit.algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

//Add public/private to members.

public class Random<K, V> extends AbstractAlgoCache<K,V> implements IAlgoCache<K,V> {
	private List<K> cache;
	private Map<K, V> mapping;
	
	public Random(int capacity)
	{
		super(capacity);
		cache = new LinkedList<K>();
		mapping = new HashMap<K,V>();
	}

	@Override
	public V getElement(K key) {
		
		if(cache.contains(key))
		{
			return mapping.get(key);
		}	
		return null;
	}

	@Override
	public V putElement(K key, V value) {
		Integer tempRandomIndexToRemove;
		K tempKey;
		if(!cache.contains(key)){
			if(cache.size() == getCapacity())
			{
				tempRandomIndexToRemove=ThreadLocalRandom.current().nextInt(0, getCapacity());
				tempKey= cache.get(tempRandomIndexToRemove);
				mapping.remove(tempKey);
				cache.remove(tempKey);
			}
			
			mapping.put(key, value);
			cache.add(key);
		}
		return value;
	}

	@Override
	public void removeElement(K key) {
		mapping.remove(key);
		cache.remove(key);
	}

}
