package com.greenway.pojo.impl;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.greenway.pojo.inter.IUserGroupStructureDAO;
import com.greenway.util.HibernateUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserGroupStructure entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.greenway.pojo.impl.UserGroupStructure
 * @author MyEclipse Persistence Tools
 */

public class UserGroupStructureDAO extends HibernateDaoSupport implements IUserGroupStructureDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UserGroupStructureDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(UserGroupStructure transientInstance) {
		log.debug("saving UserGroupStructure instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserGroupStructure persistentInstance) {
		log.debug("deleting UserGroupStructure instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserGroupStructure findById(java.lang.Integer id) {
		log.debug("getting UserGroupStructure instance with id: " + id);
		try {
			UserGroupStructure instance = (UserGroupStructure) getHibernateTemplate()
					.get("com.greenway.pojo.impl.UserGroupStructure", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserGroupStructure instance) {
		log.debug("finding UserGroupStructure instance by example");
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
		log.debug("finding UserGroupStructure instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UserGroupStructure as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all UserGroupStructure instances");
		try {
			String queryString = "from UserGroupStructure";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserGroupStructure merge(UserGroupStructure detachedInstance) {
		log.debug("merging UserGroupStructure instance");
		try {
			UserGroupStructure result = (UserGroupStructure) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserGroupStructure instance) {
		log.debug("attaching dirty UserGroupStructure instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserGroupStructure instance) {
		log.debug("attaching clean UserGroupStructure instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserGroupStructureDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UserGroupStructureDAO) ctx.getBean("UserGroupStructureDAO");
	}

	public void addMiddleUserGroupRelation(UserGroupStructure ugs) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		session.beginTransaction();
		
		session.save(ugs);
		
		session.getTransaction().commit();
		HibernateUtil.closeSession();
	}
}