package com.bwc.dao;

import java.util.List;

import com.bwc.model.BwMapBrandSub;
import com.bwc.mybatis.BwMapBrandExample;

/**
 * 
 * @author Bill Tang
 * 
 * ��ͼ�������ݷ��ʽӿ�
 *
 */
public interface IMapDao {
	
	List<BwMapBrandSub> findMapBrandInfo(BwMapBrandExample example) throws Exception;
}
