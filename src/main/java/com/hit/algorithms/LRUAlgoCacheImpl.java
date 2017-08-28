package com.hit.algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class LRUAlgoCacheImpl<K,V> extends AbstractAlgoCache<K,V> implements IAlgoCache<K,V>{
	private List<K> cache;
	private Map<K, V> mapping;
	
	
	public LRUAlgoCacheImpl(int capacity) {
		super(capacity);
		cache = new LinkedList<K>();
		mapping =new HashMap<K,V>();
		
		// TODO Auto-generated constructor stub
	}
	
	private void bringToTheFront(K key)
	{
		cache.remove(key);
		cache.add(0, key);
	}

	@Override
	public V getElement(K key)
	{
		if(cache.contains(key))
		{
			bringToTheFront(key);
			return mapping.get(key);
		}	
		return null;
	}

	@Override
	public V putElement(K key, V value){
		if(!cache.contains(key)){
			if(cache.size() == getCapacity())
			{
				mapping.remove(cache.get(cache.size() - 1));
				cache.remove(cache.size() - 1);
				
			}
			
			mapping.put(key, value);
			cache.add(0, key);
		}
		return value;
	}

	@Override
	public void removeElement(K key) {
		mapping.remove(key);
		cache.remove(key);
	}
}
