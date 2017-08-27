package com.hit.algorithms;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IAlgoCacheTest {
	@Test
	public void testNFUAlgoCacheImpl()
	{
		Integer[] keyList=new Integer[] {1,2,3,4,5};
		String[] valueList=new String[] {"aa","bb","cv","dd","de"};
		int intToCheck=4;
		
		//Create Tester
		NFUAlgoCacheImpl<Integer,String> testerNFU=new NFUAlgoCacheImpl<Integer,String>(intToCheck);
		assertEquals(testerNFU.getCapacity(),intToCheck);
	
		//Check putElement Function.
		testerNFU.putElement(keyList[0], valueList[0]);
		assertEquals(testerNFU.m_Mapping.get(keyList[0]),valueList[0]);
		
		//Fill the map:
		testerNFU.putElement(keyList[1], valueList[1]);
		testerNFU.putElement(keyList[2], valueList[2]);
		testerNFU.putElement(keyList[3], valueList[3]);
		testerNFU.putElement(keyList[4], valueList[4]);
		
		//Check Auto-Remove:
		assertEquals(testerNFU.m_CacheList.size(),intToCheck);
		
		//Check element not in the list
		assertEquals(testerNFU.getElement(keyList[0]),null);
	
		//Check getElement:
		assertEquals(testerNFU.getElement(keyList[2]),"cv");
		
		//Check reOrder (The rank change so it need to move to last.
		assertEquals(testerNFU.m_CacheList.getLast().getRank(),1);
	}

	@Test
	public void testLRUAlgoCacheImpl()
	{
		Integer[] keyList=new Integer[] {1,2,3,4,5};
		String[] valueList=new String[] {"aa","bb","cv","dd","de"};
		int intToCheck=4;
		
		//Create Tester
		LRUAlgoCacheImpl<Integer,String> testerLRU=new LRUAlgoCacheImpl<Integer,String>(intToCheck);
		assertEquals(testerLRU.getCapacity(),intToCheck);
	
		//Check putElement Function.
		testerLRU.putElement(keyList[0], valueList[0]);
		assertEquals(testerLRU.m_Mapping.get(keyList[0]),valueList[0]);
		
		//Fill the map:
		testerLRU.putElement(keyList[1], valueList[1]);
		testerLRU.putElement(keyList[2], valueList[2]);
		testerLRU.putElement(keyList[3], valueList[3]);
		testerLRU.putElement(keyList[4], valueList[4]);
		
		//Check Auto-Remove:
		assertEquals(testerLRU.m_Cache.size(),intToCheck);
			
		//Check element not in the list
		assertEquals(testerLRU.getElement(keyList[0]),null);
	
		//Check getElement:
		assertEquals(testerLRU.getElement(keyList[2]),"cv");
	}
	
	@Test
	public void testRandom()
	{
		Integer[] keyList=new Integer[] {1,2,3,4,5};
		String[] valueList=new String[] {"aa","bb","cv","dd","de"};
		int intToCheck=4;
	
		//Create Tester
		Random<Integer,String> testerRan=new Random<Integer,String>(intToCheck);
		assertEquals(testerRan.getCapacity(),intToCheck);
	
		//Check putElement Function.
		testerRan.putElement(keyList[0], valueList[0]);
		assertEquals(testerRan.m_Mapping.get(keyList[0]),valueList[0]);
		
		//Fill the map:
		testerRan.putElement(keyList[1], valueList[1]);
		testerRan.putElement(keyList[2], valueList[2]);
		testerRan.putElement(keyList[3], valueList[3]);
		testerRan.putElement(keyList[4], valueList[4]);	
	}
}
