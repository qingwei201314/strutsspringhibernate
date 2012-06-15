package com.kevin.bread.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.kevin.dao.BakeBreadDao;
import com.kevin.entity.BakeBread;

public class BreadService {
	@Resource
	private BakeBreadDao bakeBreadDao;

	public Boolean saveBread(BakeBread bakeBread) {
		Boolean result = false;
		BakeBread bakeBreadP = bakeBreadDao.getBakeBread(
				bakeBread.getAccount(), bakeBread.getPassword());
		if (bakeBreadP != null) {
			bakeBreadP.setBreadCount(bakeBread.getBreadCount());
			bakeBreadP.setModifyTime(new Date());
			bakeBreadP.setTimes(bakeBreadP.getTimes() + 1);
			result = true;
		}
		return result;
	}

	public List<BakeBread> getBakeBreadList() {
		List<BakeBread> bakeBreadList = bakeBreadDao.getBakeBreadList();
		return bakeBreadList;
	}

	public BakeBreadVo caculateBaker(List<BakeBread> bakeBreadList) {
		BakeBreadVo bakeBreadVo = new BakeBreadVo();
		if (bakeBreadList != null) {
			Integer totalBread = 0;
			for (int i = 0; i < bakeBreadList.size(); i++) {
				BakeBread bakeBread = bakeBreadList.get(i);
				if (i == 0) {
					BeanUtils.copyProperties(bakeBread, bakeBreadVo);
				}
				totalBread += bakeBread.getBreadCount();
			}
			bakeBreadVo.setTotal(totalBread);
		}
		return bakeBreadVo;
	}
}
