package org.sistema.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.sistema.hibernate.session.HibernateSessionUtils;

//T indica que es para un tipo genérico
public class GenericDAO<T> {
	protected Session session;

	//método para empezar la transacción
	//usamos protected para cubrir funcinalidades básicas que serán heredadas por otros daos
	protected void startTransaction(){		
		session = HibernateSessionUtils.getSession();
		session.getTransaction().begin();
	}
	
	protected void endTransaction(){
		session.getTransaction().commit();
		session.close();		
	}
	
	protected void handleException(HibernateException he) throws HibernateException{
		session.getTransaction().rollback();
		he.printStackTrace();
		throw he;
	}
	
	public T insert(T entity) throws HibernateException{
		
		try {
			startTransaction();
			session.persist(entity);
			session.flush();
			
		} catch (HibernateException he) {
			handleException(he);
		/*}catch (Exception e) {
			e.printStackTrace();*/
		}finally{
			endTransaction();
		}
		return entity;
		
		
		
	}
	
	public void update(T entity){
		try {
			startTransaction();
			//session.merge(entity);
			session.update(entity);
			session.flush();			
		} catch (HibernateException he) {
			handleException(he);
		}finally{
			endTransaction();
		}
		
	}
	
	public void delete(T entity){
		try {
			startTransaction();
			session.delete(entity);
			session.flush();
		} catch (HibernateException he) {
			handleException(he);
		}finally{
			endTransaction();
		}
		
	}
	
	public T findById(Integer id, Class<T> entityClass){
		T entity = null;
		try {
			session = HibernateSessionUtils.getSession();
			entity = (T) session.get(entityClass, id);
			
			//session.get
		} catch (HibernateException he) {
			handleException(he);
		}finally{
			session.close();
		}
		return entity;
		
	}
	
	public Session getSession() {
		return session;
	}
	
	public List<T> findAll(Class<T> entityClass) throws HibernateException{
		
		List<T> result = new ArrayList<T>();
		
		try {
			session = HibernateSessionUtils.getSession();
			result = session.createCriteria(entityClass).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		}catch (HibernateException he) {
			handleException(he);
		}finally{
			session.close();
		}
		
		return result;
	}
	
	public List<T> findAllHQL(Class<T> entityClass) throws HibernateException{
		
		List<T> result = new ArrayList<T>();
		
		try {
			session = HibernateSessionUtils.getSession();
			Query consulta = session.createQuery(" from "+entityClass.getSimpleName());
			result = consulta.list();
		}catch (HibernateException he) {
			handleException(he);
		}finally{
			session.close();
		}
		
		return result;
	}
		
}
