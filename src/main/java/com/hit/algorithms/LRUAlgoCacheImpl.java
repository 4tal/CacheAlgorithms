package com.hit.algorithms;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;


public class LRUAlgoCacheImpl<K,V> extends AbstractAlgoCache<K,V>{
	private Map<K, V> cache;
	
	
	public LRUAlgoCacheImpl(int capacity) {
		super(capacity);
		cache = new LinkedHashMap<>(capacity);
	}


	/**
	 *
	 * @see IAlgoCache#getElement(K)
	 */
	@Override
	public V getElement(K key)
	{
		if (cache.containsKey(key)) {
			V valueToPut = cache.get(key);
			removeElement(key);
			putElement(key, valueToPut);

			return valueToPut;
		}

		return  null;
	}

	/**
	 *
	 * @see IAlgoCache#putElement(K, V)
	 */
	@Override
	public V putElement(K key, V value){
		Map.Entry<K, V> first = null;
		V wantedValue = null;

		if (this.getCapacity() == cache.size()) {
			first = cache.entrySet().iterator().next();
			removeElement(first.getKey());
			wantedValue = first.getValue();
		}

		cache.put(key, value);

		return wantedValue;
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

	@Override
	public String toString() {
		return cache.toString();
	}
}
