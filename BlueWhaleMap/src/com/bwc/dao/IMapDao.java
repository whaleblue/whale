package com.bwc.dao;

import java.util.List;

import com.bwc.model.BwMapBrandSub;
import com.bwc.mybatis.BwMapBrandExample;

/**
 * 
 * @author Bill Tang
 * 
 * 地图服务数据访问接口
 *
 */
public interface IMapDao {
	
	List<BwMapBrandSub> findMapBrandInfo(BwMapBrandExample example) throws Exception;
}
