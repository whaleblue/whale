package com.bwc.actions.map;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwc.common.CommonAction;
import com.bwc.model.BwMapBrandSub;

/**
 * 
 * @author Bill Tang
 * 
 * ��ͼ����Action��
 *
 */
@Controller
@RequestMapping(value="/map")
public class MapAction extends CommonAction {

	/**
	 * ��ѯ�û���Ϣ
	 * 
	 * @param userForm
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/json", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<BwMapBrandSub> getMapInfo(
			//@RequestBody UserForm userForm
			) throws Exception {
		return this.getMapService().getMapInfo();
	}
}
