package com.bwc.service;

import java.util.List;

import com.bwc.model.BwMapBrandSub;

/**
 * 
 * @author Bill Tang
 * 
 * ��ͼ����ӿ�
 *
 */
public interface IMapService {

	List<BwMapBrandSub> getMapInfo() throws Exception;
}
