package com.greenway.pojo.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.greenway.pojo.inter.IPicDAO;

/**
 * A data access object (DAO) providing persistence and search support for Pic
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.greenway.pojo.impl.Pic
 * @author MyEclipse Persistence Tools
 */

public class PicDAO extends HibernateDaoSupport implements IPicDAO {
	private static final Logger log = LoggerFactory.getLogger(PicDAO.class);
	// property constants
	public static final String CAPTION = "caption";
	public static final String IMG = "img";

	protected void initDao() {
		// do nothing
	}

	public void save(Pic transientInstance) {
		log.debug("saving Pic instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Pic persistentInstance) {
		log.debug("deleting Pic instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pic findById(java.lang.Integer id) {
		log.debug("getting Pic instance with id: " + id);
		try {
			Pic instance = (Pic) getHibernateTemplate().get(
					"com.greenway.pojo.impl.Pic", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Pic instance) {
		log.debug("finding Pic instance by example");
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
		log.debug("finding Pic instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Pic as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCaption(Object caption) {
		return findByProperty(CAPTION, caption);
	}

	public List findByImg(Object img) {
		return findByProperty(IMG, img);
	}

	public List findAll() {
		log.debug("finding all Pic instances");
		try {
			String queryString = "from Pic";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Pic merge(Pic detachedInstance) {
		log.debug("merging Pic instance");
		try {
			Pic result = (Pic) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Pic instance) {
		log.debug("attaching dirty Pic instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pic instance) {
		log.debug("attaching clean Pic instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PicDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PicDAO) ctx.getBean("PicDAO");
	}
}