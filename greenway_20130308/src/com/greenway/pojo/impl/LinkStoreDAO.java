package com.greenway.pojo.impl;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.greenway.pojo.inter.ILinkStoreDAO;
import com.greenway.util.HibernateUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * LinkStore entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.greenway.pojo.impl.LinkStore
 * @author MyEclipse Persistence Tools
 */

public class LinkStoreDAO extends HibernateDaoSupport implements ILinkStoreDAO{
	private static final Logger log = LoggerFactory
			.getLogger(LinkStoreDAO.class);
	// property constants
	public static final String LINK = "link";
	public static final String VISITED = "visited";

	protected void initDao() {
		// do nothing
	}

	public void save(LinkStore transientInstance) {
		log.debug("saving LinkStore instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LinkStore persistentInstance) {
		log.debug("deleting LinkStore instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LinkStore findById(java.lang.Integer id) {
		log.debug("getting LinkStore instance with id: " + id);
		try {
			LinkStore instance = (LinkStore) getHibernateTemplate().get(
					"com.greenway.pojo.impl.LinkStore", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(LinkStore instance) {
		log.debug("finding LinkStore instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding LinkStore instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from LinkStore as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLink(Object link) {
		return findByProperty(LINK, link);
	}

	public List findByVisited(Object visited) {
		return findByProperty(VISITED, visited);
	}

	public List findAll() {
		log.debug("finding all LinkStore instances");
		try {
			String queryString = "from LinkStore";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LinkStore merge(LinkStore detachedInstance) {
		log.debug("merging LinkStore instance");
		try {
			LinkStore result = (LinkStore) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LinkStore instance) {
		log.debug("attaching dirty LinkStore instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LinkStore instance) {
		log.debug("attaching clean LinkStore instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LinkStoreDAO getFromApplicationContext(ApplicationContext ctx) {
		return (LinkStoreDAO) ctx.getBean("LinkStoreDAO");
	}
	
	public void saveLink(LinkStore link) {
		// TODO Auto-generated method stub
		Session session =  HibernateUtil.currentSession();
		session.beginTransaction();
		
		session.save(link);
		
		session.getTransaction().commit();
		HibernateUtil.closeSession();
	}
}