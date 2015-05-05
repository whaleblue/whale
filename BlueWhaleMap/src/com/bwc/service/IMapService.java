package com.bwc.service;

import java.util.List;

import com.bwc.model.BwMapBrandSub;

/**
 * 
 * @author Bill Tang
 * 
 * 地图服务接口
 *
 */
public interface IMapService {

	List<BwMapBrandSub> getMapInfo() throws Exception;
}
