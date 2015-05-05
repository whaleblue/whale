package com.bwc.common;

import org.springframework.beans.factory.annotation.Autowired;

import com.bwc.service.IMapService;

/**
 * 
 * @author Bill Tang
 * 
 * SpingMVC��ͨ��Action��
 *
 */
public class CommonAction {

	@Autowired
	private IMapService mapService;

	public IMapService getMapService() {
		return mapService;
	}

	public void setMapService(IMapService mapService) {
		this.mapService = mapService;
	}
}
