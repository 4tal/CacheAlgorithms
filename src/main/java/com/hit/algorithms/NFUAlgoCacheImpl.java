package com.hit.algorithms;

import java.util.*;


public class NFUAlgoCacheImpl<K,V> extends AbstractAlgoCache<K,V> {
	
	private Map<K, V> cache;
	private Map<K, Integer> counters;
	
	NFUAlgoCacheImpl(int capacity){
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

	/**
	 *
	 * @see IAlgoCache#putElement(K, V)
	 */
	@Override
	public V putElement(K key, V value) {
		V elementReturn = null;
		//if cache is full remove the element with the lowest counter then put the new element and return the removed element
		if (cache.size() == this.getCapacity()) {
			K lowestKey = findKeyWithLowestCounter();

			if (lowestKey != null && cache.containsKey(lowestKey) && counters.containsKey(lowestKey)) {
				elementReturn = cache.remove(lowestKey);
				counters.remove(lowestKey);
			}
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
	public void removeElement(K key) {
		if (cache.containsKey(key) && counters.containsKey(key)) {
			cache.remove(key);
			counters.remove(key);
		}
	}

	//initialize the counters to 0 using lambda expression
	private void initCounters() {
		counters.forEach((k, v) -> v = 0);
	}

	private K findKeyWithLowestCounter() {
		Iterator iterator = counters.entrySet().iterator();
		int minCounter = counters.entrySet().iterator().next().getValue();
		K keyLowestCounter = null;

		while (iterator.hasNext()) {
			Map.Entry<K, Integer> pair = (Map.Entry) iterator.next();

			if (minCounter > pair.getValue()) {
				minCounter = pair.getValue();
				keyLowestCounter = pair.getKey();
			}
		}

		return keyLowestCounter;
	}

}
