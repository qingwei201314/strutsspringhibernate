package com.kevin.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class CommonDao<T> {
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private SessionFactory sessionFactory;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * 保存记录.
	 * 
	 * @param entity
	 */
	public void save(T entity) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new JDBCException("jdbc exception", new SQLException());
		}
	}

	/**
	 * 更新记录.
	 * 
	 * @param entity
	 */
	public void update(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
	}

	/**
	 * 取出指定ID的对象.
	 * 
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public T get(Class<T> entityClass, Serializable id) {
		return (T) hibernateTemplate.get(entityClass, id);
	}

	/**
	 * 删除一个对象.
	 * 
	 * @param entity
	 */
	public void delete(T entity) {
		hibernateTemplate.delete(entity);
	}

	/**
	 * 根据查询条件查出记录列表.
	 * 
	 * @param criteria
	 * @return
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings({ "unchecked" })
	public List<T> listByCriteria(DetachedCriteria criteria) {
		List<T> list = hibernateTemplate.findByCriteria(criteria);
		return list;
	}
}