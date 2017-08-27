package com.hit.algorithms;

public interface IAlgoCache<K,V> {
	V getElement(K io_Key);
	V putElement(K io_Key, V io_Value);
	void removeElement(K io_Key);
}

