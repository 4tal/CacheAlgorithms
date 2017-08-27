package com.hit.algorithms;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;



public class NFUAlgoCacheImpl<K,V> extends AbstractAlgoCache<K,V> implements IAlgoCache<K,V>  {
	
	LinkedList<Node<K>> m_CacheList;
	HashMap<K,V> m_Mapping;
	
	NFUAlgoCacheImpl(int io_Capacity){
		super(io_Capacity);
		m_CacheList=new LinkedList<Node<K>>();
		m_Mapping=new HashMap<K,V>();
	}

	@Override
	public V getElement(K io_Key) 
	{
		if(m_CacheList.contains(new Node<K>(io_Key)))
		{	
			m_CacheList.get(m_CacheList.indexOf(new Node<K>(io_Key))).addRank();
			reOrderCacheList();
			
			return m_Mapping.get(io_Key);
		}
		else
		{
			return null;
		}
	}

	@Override
	public V putElement(K io_Key, V io_Value) {
		if(!m_CacheList.contains(new Node<K>(io_Key)))
		{
			if(m_CacheList.size()==m_Capacity)
			{
				m_Mapping.remove(m_CacheList.getFirst().getKey());
				m_CacheList.removeFirst();
			}
			m_Mapping.put(io_Key, io_Value);
			m_CacheList.add(new Node<K>(io_Key));
		}
		return io_Value;
	}

	@Override
	public void removeElement(K io_Key) {
		m_Mapping.remove(io_Key);
		m_CacheList.remove(m_CacheList.indexOf(new Node<K>(io_Key)));
	}
	
	public void reOrderCacheList()
	{
		Collections.sort(m_CacheList);
	}

}
