package com.hit.algorithms;

import java.util.*;


public class NFUAlgoCacheImpl<K,V> extends AbstractAlgoCache<K,V> implements IAlgoCache<K,V>  {
	
	private List<Node<K>> cache;
	private Map<K, V> mapping;
	
	NFUAlgoCacheImpl(int capacity){
		super(capacity);
		cache = new LinkedList<Node<K>>();
		mapping = new HashMap<K,V>();
	}

	@Override
	public V getElement(K key)
	{
		if(cache.contains(new Node<K>(key)))
		{	
			cache.get(cache.indexOf(new Node<K>(key))).addRank();
			reOrderCacheList();
			
			return mapping.get(key);
		}
		else
		{
			return null;
		}
	}

	@Override
	public V putElement(K key, V value) {
		if(!cache.contains(new Node<K>(key)))
		{
			if(cache.size() == getCapacity())
			{
				mapping.remove(cache.get(0).getKey());
				cache.remove(0);
			}
			mapping.put(key, value);
			cache.add(new Node<K>(key));
		}
		return value;
	}

	@Override
	public void removeElement(K key) {
		mapping.remove(key);
		cache.remove(cache.indexOf(new Node<K>(key)));
	}
	
	public void reOrderCacheList()
	{
		Collections.sort(cache);
	}

}
