package com.kevin.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kevin.entity.BakeBread;

public class BakeBreadDao extends CommonDao<BakeBread> {
	public BakeBread getBakeBread(String account, String password) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(BakeBread.class);
		criteria.add(Restrictions.eq("account", account));
		criteria.add(Restrictions.eq("password", password));
		BakeBread bakeBread = (BakeBread) criteria.uniqueResult();
		return bakeBread;
	}

	@SuppressWarnings("unchecked")
	public List<BakeBread> getBakeBreadList() {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(BakeBread.class);
		criteria.add(Restrictions.eq("deleteFlag", 0));
		criteria.add(Restrictions.between("modifyTime", getBeginTime(),
				getEndTime()));
		criteria.addOrder(Order.asc("times"));
		List<BakeBread> bakeBreadList = criteria.list();
		return bakeBreadList;
	}

	public Date getBeginTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public Date getEndTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
}
