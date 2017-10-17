package com.hit.algorithms;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomAlgoCacheImpl<K, V> extends AbstractAlgoCache<K,V> {

	private Map<K, V> cache;
	
	public RandomAlgoCacheImpl(int capacity) {
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
		V removeValue = null;

		if (cache.size() >= getCapacity()) {
			Random random = new Random();
			List<K> keyList = new ArrayList<>(cache.keySet());
			K randKey = keyList.get(random.nextInt(keyList.size()));
			removeValue = cache.get(randKey);
			removeElement(randKey);
			cache.put(key, value);
		} else {
			cache.put(key, value);
		}

		return removeValue;
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
}
