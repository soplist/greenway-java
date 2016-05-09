package com.greenway.pojo.impl;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.greenway.pojo.inter.IGentieDAO;
import com.greenway.util.HibernateUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * Gentie entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.greenway.pojo.impl.Gentie
 * @author MyEclipse Persistence Tools
 */

public class GentieDAO extends HibernateDaoSupport implements IGentieDAO {
	private static final Logger log = LoggerFactory.getLogger(GentieDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(Gentie transientInstance) {
		log.debug("saving Gentie instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Gentie persistentInstance) {
		log.debug("deleting Gentie instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Gentie findById(java.lang.Integer id) {
		log.debug("getting Gentie instance with id: " + id);
		try {
			Gentie instance = (Gentie) getHibernateTemplate().get(
					"com.greenway.pojo.impl.Gentie", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Gentie instance) {
		log.debug("finding Gentie instance by example");
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
		log.debug("finding Gentie instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Gentie as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Gentie instances");
		try {
			String queryString = "from Gentie";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Gentie merge(Gentie detachedInstance) {
		log.debug("merging Gentie instance");
		try {
			Gentie result = (Gentie) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Gentie instance) {
		log.debug("attaching dirty Gentie instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Gentie instance) {
		log.debug("attaching clean Gentie instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static GentieDAO getFromApplicationContext(ApplicationContext ctx) {
		return (GentieDAO) ctx.getBean("GentieDAO");
	}
	
	public List<Gentie> listGentieByArticleId(Article article){
		Session session = HibernateUtil.currentSession();
		session.beginTransaction();
		
		List<Gentie> result =   session.createQuery("select g from Gentie g where g.article=:article")
		.setParameter("article",article).list();
		// and ugs.WUser =:uid.setParameter("uid", user.getUid())
		session.getTransaction().commit();
		return result;
	}
}