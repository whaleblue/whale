package com.bwc.service.impl;

import java.util.List;

import com.bwc.dao.IMapDao;
import com.bwc.model.BwMapBrandSub;
import com.bwc.mybatis.BwMapBrandExample;
import com.bwc.service.IMapService;

/**
 * 
 * @author Bill Tang
 * 
 * ��ͼ����ӿ�ʵ����
 *
 */
public class MapServiceImpl implements IMapService {
	
	private IMapDao mapDao;

	public void setMapDao(IMapDao mapDao) {
		this.mapDao = mapDao;
	}
	
	public List<BwMapBrandSub> getMapInfo() throws Exception {		
		List<BwMapBrandSub> list = this.mapDao.findMapBrandInfo(new BwMapBrandExample());
		return list;
	}
}
