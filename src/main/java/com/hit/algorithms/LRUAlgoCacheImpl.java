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
	 * Returns the value to which the specified key is mapped, or null if this cache contains no mapping for the key. In addition performs the relevant cache algorithm
	 * @param key with which the specified value is to be associated
	 * @return the value to which the specified key is mapped, or null if this cache contains no mapping for the key
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
	 * Associates the specified value with the specified key in this cache according to the current algorithm

	 * @param key with which the specified value is to be associated
	 * @param value to be associated with the specified key
	 * @return the value of the element which need to be replaced
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
	 * Removes the mapping for the specified key from this map if present.
	 * @param key whose mapping is to be removed from the cache according to the current algorithm
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
