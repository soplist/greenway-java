package com.greenway.pojo.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.greenway.pojo.inter.IGroDAO;
import com.greenway.util.HibernateUtil;

/**
 * A data access object (DAO) providing persistence and search support for Gro
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.greenway.pojo.impl.Gro
 * @author MyEclipse Persistence Tools
 */

public class GroDAO extends HibernateDaoSupport implements IGroDAO {
	private static final Logger log = LoggerFactory.getLogger(GroDAO.class);
	// property constants
	public static final String NAME = "name";

	protected void initDao() {
		// do nothing
	}

	public void save(Gro transientInstance) {
		log.debug("saving Gro instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Gro persistentInstance) {
		log.debug("deleting Gro instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Gro findById(java.lang.Integer id) {
		log.debug("getting Gro instance with id: " + id);
		try {
			Gro instance = (Gro) getHibernateTemplate().get(
					"com.greenway.pojo.impl.Gro", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Gro instance) {
		log.debug("finding Gro instance by example");
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
		log.debug("finding Gro instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Gro as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.debug("finding all Gro instances");
		try {
			String queryString = "from Gro";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Gro merge(Gro detachedInstance) {
		log.debug("merging Gro instance");
		try {
			Gro result = (Gro) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Gro instance) {
		log.debug("attaching dirty Gro instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Gro instance) {
		log.debug("attaching clean Gro instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static GroDAO getFromApplicationContext(ApplicationContext ctx) {
		return (GroDAO) ctx.getBean("GroDAO");
	}

	public List<Gro> listGroupsByUserId(User user) {
		Session session = HibernateUtil.currentSession();
		session.beginTransaction();
		
		List<Gro> result =  session.createQuery("select g from UserGroupStructure ugs,Gro g where ugs.gro=g.id and ugs.user=:user")
		.setParameter("user",user).list();
		// and ugs.WUser =:uid.setParameter("uid", user.getUid())
		session.getTransaction().commit();
		return result;
	}
	public List<Gro> listGroupsBySummarize() {
		Session session = HibernateUtil.currentSession();
		session.beginTransaction();
		
		List<Gro> result =  session.createQuery("select g from Gro g where g.summarize=:summarize")
		.setParameter("summarize","jianjie").list();
		// and ugs.WUser =:uid.setParameter("uid", user.getUid())
		session.getTransaction().commit();
		return result;
	}
}