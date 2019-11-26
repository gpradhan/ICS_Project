package com.info.model;

import java.util.Comparator;

public abstract class SuperEntity implements Comparator<SuperEntity> {
	
	public abstract void loadDataFromDB(SuperEntity entity);
	
	public abstract void loadDataFromUI(SuperEntity entity);

}

