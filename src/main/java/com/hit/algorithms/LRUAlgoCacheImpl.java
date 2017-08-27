package com.hit.algorithms;

import java.util.HashMap;
import java.util.LinkedList;




public class LRUAlgoCacheImpl<K,V> extends AbstractAlgoCache<K,V> implements IAlgoCache<K,V>{	
	LinkedList<K> m_Cache;
	HashMap<K,V> m_Mapping;
	
	
	public LRUAlgoCacheImpl(int io_Capacity) {
		super(io_Capacity);
		m_Cache=new LinkedList<K>();
		m_Mapping=new HashMap<K,V>();
		
		// TODO Auto-generated constructor stub
	}
	
	private void bringToTheFront(K i_Key)
	{
		m_Cache.remove(i_Key);
		m_Cache.addFirst(i_Key);
	}

	@Override
	public V getElement(K i_Key) 
	{
		if(m_Cache.contains(i_Key))
		{
			bringToTheFront(i_Key);
			return m_Mapping.get(i_Key);
		}	
		return null;
		
	}

	@Override
	public V putElement(K io_Key, V io_Value){
		if(!m_Cache.contains(io_Key)){
			if(m_Cache.size()==m_Capacity)
			{
				m_Mapping.remove(m_Cache.getLast());
				m_Cache.removeLast();
				
			}
			
			m_Mapping.put(io_Key, io_Value);
			m_Cache.addFirst(io_Key);
		}
		return io_Value;		
	}

	@Override
	public void removeElement(K io_key) {
		m_Mapping.remove(io_key);
		m_Cache.remove(io_key);	
	}
}
