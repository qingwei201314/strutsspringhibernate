package com.kevin.bread.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.bread.service.BakeBreadVo;
import com.kevin.bread.service.BreadService;
import com.kevin.entity.BakeBread;
import com.opensymphony.xwork2.ActionSupport;

@Service
public class BreadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private BakeBread bakeBread;
	private BakeBreadVo bakeBreadVo = new BakeBreadVo();
	private List<BakeBread> bakeBreadList;

	private BreadService breadService;

	@Action("/bread/bakeBread")
	@Transactional
	public String bakeBread() {
		bakeBreadList = breadService.getBakeBreadList();
		bakeBreadVo = breadService.caculateBaker(bakeBreadList);
		return SUCCESS;
	}

	@Action(value = "/bread/saveBread", results = {@Result(name = "success", location = "/bread/bakeBread.jsp") })
	@Transactional
	public String saveBread() {
		String result = SUCCESS;
		Boolean deal = breadService.saveBread(bakeBread);
		if (!deal) {
			return ERROR;
		}

		bakeBreadList = breadService.getBakeBreadList();
		bakeBreadVo = breadService.caculateBaker(bakeBreadList);

		return result;
	}

	public BakeBread getBakeBread() {
		return bakeBread;
	}

	public void setBakeBread(BakeBread bakeBread) {
		this.bakeBread = bakeBread;
	}

	public BakeBreadVo getBakeBreadVo() {
		return bakeBreadVo;
	}

	public void setBakeBreadVo(BakeBreadVo bakeBreadVo) {
		this.bakeBreadVo = bakeBreadVo;
	}

	public List<BakeBread> getBakeBreadList() {
		return bakeBreadList;
	}

	public void setBakeBreadList(List<BakeBread> bakeBreadList) {
		this.bakeBreadList = bakeBreadList;
	}

	public BreadService getBreadService() {
		return breadService;
	}

	public void setBreadService(BreadService breadService) {
		this.breadService = breadService;
	}

}
