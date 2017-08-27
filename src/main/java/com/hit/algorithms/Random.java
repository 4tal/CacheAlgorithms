package com.hit.algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

//Add public/private to members.

public class Random<K, V> extends AbstractAlgoCache<K,V> implements IAlgoCache<K,V> {
	LinkedList<K> m_Cache;
	HashMap<K,V> m_Mapping;
	
	public Random(int i_Capacity) 
	{
		super(i_Capacity);
		m_Cache=new LinkedList<K>();
		m_Mapping=new HashMap<K,V>();
	}

	@Override
	public V getElement(K io_Key) {
		
		if(m_Cache.contains(io_Key))
		{
			return m_Mapping.get(io_Key);
		}	
		return null;
	}

	@Override
	public V putElement(K io_Key, V io_Value) {
		Integer tempRandomIndexToRemove;
		K tempKey;
		if(!m_Cache.contains(io_Key)){
			if(m_Cache.size()==m_Capacity)
			{
				tempRandomIndexToRemove=ThreadLocalRandom.current().nextInt(0,m_Capacity);
				tempKey=m_Cache.get(tempRandomIndexToRemove);
				m_Mapping.remove(tempKey);
				m_Cache.remove(tempKey);
			}
			
			m_Mapping.put(io_Key, io_Value);
			m_Cache.add(io_Key);
		}
		return io_Value;
	}

	@Override
	public void removeElement(K io_Key) {
		m_Mapping.remove(io_Key);
		m_Cache.remove(io_Key);	
	}

}
