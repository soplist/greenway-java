package com.greenway.pojo.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.greenway.pojo.inter.IArticleDAO;
import com.greenway.util.HibernateUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * Article entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.greenway.pojo.impl.Article
 * @author MyEclipse Persistence Tools
 */

public class ArticleDAO extends HibernateDaoSupport implements IArticleDAO {
	private static final Logger log = LoggerFactory.getLogger(ArticleDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String AUTHOR = "author";
	public static final String CONTENT = "content";
	public static final String STATE = "state";
	public static final String GRO = "gro";
	
	protected void initDao() {
		// do nothing
	}

	public void save(Article transientInstance) {
		log.debug("saving Article instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Article persistentInstance) {
		log.debug("deleting Article instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Article findById(java.lang.Integer id) {
		log.debug("getting Article instance with id: " + id);
		try {
			Article instance = (Article) getHibernateTemplate().get(
					"com.greenway.pojo.impl.Article", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Article instance) {
		log.debug("finding Article instance by example");
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
		log.debug("finding Article instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Article as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByAuthor(Object author) {
		return findByProperty(AUTHOR, author);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all Article instances");
		try {
			String queryString = "from Article";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Article merge(Article detachedInstance) {
		log.debug("merging Article instance");
		try {
			Article result = (Article) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Article instance) {
		log.debug("attaching dirty Article instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Article instance) {
		log.debug("attaching clean Article instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ArticleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ArticleDAO) ctx.getBean("ArticleDAO");
	}

	public List findByGro(Object gro) {
		// TODO Auto-generated method stub
		return findByProperty(GRO, gro);
	}

	public List queryArticlesByGroAndPage(int pageSize, int startRow, Gro gro) {
		// TODO Auto-generated method stub
		 List list = null;
	        Transaction tx = null;
	        try {
	            Session session = HibernateUtil.currentSession();
	            tx = session.beginTransaction();
	            Query q = session.createQuery("from Article a where a.gro.id=:gro")
	            		.setParameter("gro", gro.getId());
	            //where ugs.gro=g.id and ugs.WUser=:user")
	    		//.setParameter("user",user).list();
	            q.setFirstResult(startRow);
	            q.setMaxResults(pageSize);
	            list = q.list();
	            tx.commit();
	        } catch (HibernateException he) {
	           if (tx != null) {
	              tx.rollback();
	           }
	           throw he;
	        } finally {
	           HibernateUtil.closeSession();
	        }
	        return list;
	}

	public long getRows(Gro gro) throws HibernateException {
		// TODO Auto-generated method stub
		long totalRows = 0;
	    Transaction tx = null;
	    try {
	          Session session = HibernateUtil.currentSession();
	          tx = session.beginTransaction();
	          Query q = session.createQuery("select count(*) from Article a where a.gro.id=:gro")
	            		.setParameter("gro", gro.getId());
	          totalRows  = (Long) q.uniqueResult();
	          tx.commit();
	    } catch (HibernateException he) {
	          if (tx != null) {
	              tx.rollback();
	          }
	         throw he;
	    } finally {
	    HibernateUtil.closeSession();
	    }

	    return totalRows;
	}

	public Article getCorrentArticle(Integer id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.currentSession();
		session.beginTransaction();
		
		Article article =  (Article) session.get(Article.class, id);
		session.getTransaction().commit();
		return article;
	}
	
	public List<Article> listArticleByJoinGroupSortByDate(User user){
		Session session = HibernateUtil.currentSession();
		session.beginTransaction();
		List<Article> result = session.createQuery("from Article where gro.id in(select gro.id from UserGroupStructure where user=:user) order by date desc")
				.setParameter("user",user).list();
		session.getTransaction().commit();
		return result;
	}
}