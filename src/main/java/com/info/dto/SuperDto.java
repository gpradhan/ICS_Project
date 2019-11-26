package com.info.dto;

import com.info.model.SuperEntity;

public abstract class SuperDto {

	public abstract void loadDataFromDB(SuperEntity entity);

	public abstract SuperDto loadDataFromUI(SuperDto dto);

}
