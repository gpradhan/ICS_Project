package com.info.model;

import java.util.Comparator;

public abstract class SuperEntity<T> implements Comparator<T> {
	
	public abstract void loadDataFromDB(T entity);
	
	public abstract void loadDataFromUI(T entity);

	abstract public int compare(T o1, T o2);

	
}

