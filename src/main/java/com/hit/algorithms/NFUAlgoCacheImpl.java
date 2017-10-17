package com.hit.algorithms;

import java.util.*;


public class NFUAlgoCacheImpl<K,V> extends AbstractAlgoCache<K,V> {
	
	private Map<K, V> cache;
	private Map<K, Integer> counters;
	
	public NFUAlgoCacheImpl(int capacity){
		super(capacity);
		cache = new LinkedHashMap<>(capacity);
		counters = new LinkedHashMap<>(capacity);
		initCounters();
	}

	/**
	 *
	 * @see IAlgoCache#getElement(K)
	 */
	@Override
	public V getElement(K key)
	{
		//check if the key is exist in cache and in the counters map. then increment its counter and return it
		if (cache.containsKey(key) && counters.containsKey(key)) {
			int incrementedCounter = counters.get(key).intValue() + 1;
			counters.replace(key, incrementedCounter);
			return cache.get(key);
		}

		return null;
	}

	public int getCacheSize(){
		return cache.size();
	}

	/**
	 *
	 * @see IAlgoCache#putElement(K, V)
	 */
	@Override
	public V putElement(K key, V value) {
		V elementReturn = null;
		if (cache.size() == this.getCapacity()) {
			K lowestKey = findKeyWithLowestCounter();
			elementReturn=this.cache.get(lowestKey);
			this.removeElement(lowestKey);
		}
		cache.put(key, value);
		counters.put(key, 0);
		return elementReturn;
	}

	/**
	 *
	 * @see IAlgoCache#removeElement(K)
	 */
	@Override
	public void removeElement(K key){
		cache.remove(key);
		counters.remove(key);
		//Comment
		
	}

	//initialize the counters to 0 using lambda expression
	private void initCounters() {
		counters.forEach((k, v) -> v = 0);
	}

	private K findKeyWithLowestCounter() {
		Integer minValue=1000;
		K lowestKey=null;

		for (K key : counters.keySet()) {
		    if(counters.get(key)<minValue){
		    	lowestKey=key;	
		    }
		}
		return lowestKey;
	}

}
