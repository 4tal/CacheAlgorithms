package com.hit.algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Random<K, V> extends AbstractAlgoCache<K,V> {

	private Map<K, V> cache;
	
	public Random(int capacity) {
		super(capacity);
		cache = new LinkedHashMap<>();
	}

	/**
	 *
	 * @see IAlgoCache#getElement(K)
	 */
	@Override
	public V getElement(K key) {
		V foundValue = null;
		
		if(cache.containsKey(key))
		{
			foundValue = cache.get(key);
		}

		return foundValue;
	}

	/**
	 *
	 * @see IAlgoCache#putElement(K, V)
	 */
	@Override
	public V putElement(K key, V value) {
		V valueReturn = null;

		if(!cache.containsKey(key) && (cache.size() == this.getCapacity())){
			K keyToRemove = getRandomKey();

			if (keyToRemove != null && cache.containsKey(keyToRemove)) {
				valueReturn = cache.remove(keyToRemove);
			}

		}

		cache.put(key, value);

		return value;
	}

	/**
	 * @see IAlgoCache#removeElement(K)
	 */
	@Override
	public void removeElement(K key) {
		if (cache.containsKey(key)) {
			cache.remove(key);
		}
	}

	private K getRandomKey() {
		K keyReturn = null;
		Iterator iterator = cache.entrySet().iterator();
		java.util.Random random = new java.util.Random();
		int i = 0;
		int randNumber = random.nextInt(cache.size()) + 1;

		while (iterator.hasNext() && i < cache.size()) {
			Map.Entry<K, Integer> pair = (Map.Entry) iterator.next();
			keyReturn = pair.getKey();

			++i;
		}

		return keyReturn;
	}

}
