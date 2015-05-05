package com.bwc.model;

import java.util.LinkedList;

public class BwMapBrandSub extends BwMapBrand {

	private LinkedList<BwMapBrandEntity> entityList;

	public LinkedList<BwMapBrandEntity> getEntityList() {
		return entityList;
	}

	public void setEntityList(LinkedList<BwMapBrandEntity> entityList) {
		this.entityList = entityList;
	}
}
