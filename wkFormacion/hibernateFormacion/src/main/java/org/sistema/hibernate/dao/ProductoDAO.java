package org.sistema.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.sistema.hibernate.models.Producto;
import org.sistema.hibernate.session.HibernateSessionUtils;

public class ProductoDAO extends GenericDAO<Producto> {

	public ProductoDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Producto> findAll(){
		return super.findAll(Producto.class);
	}

	public List<Producto> findProductoByTipoProductoCodigoProducto(String codigoTipoProducto){
		session = HibernateSessionUtils.getSession();
		
		List<Producto> result = new ArrayList<Producto>();
		
		if(codigoTipoProducto!= null && !"".equals(codigoTipoProducto)){
			//codigoTipo
			Criteria criteria = session.createCriteria(Producto.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			//criteria.createAlias("tipoProducto", "resultadoJoin");
		
			criteria.createCriteria("tipoProducto", "resultadoJoin", JoinType.RIGHT_OUTER_JOIN);
			
			criteria.add(Restrictions.ilike("resultadoJoin.codigoTipo", codigoTipoProducto));
			result = criteria.list();
		}
			
		return result;
	}
	
	public Object[] findAvgPrecioCompraAndAvgPrecioVentaCodigoTipoProductoEqual(String codigoTipoProducto){
		session = HibernateSessionUtils.getSession();
		
		Criteria criteria = session.createCriteria(Producto.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		ProjectionList projList = Projections.projectionList();
		projList.add(Property.forName("precioCompra").avg());
		projList.add(Property.forName("precioVenta").avg());
		
		
		criteria.setProjection(Projections.distinct(projList));

		if(codigoTipoProducto!= null && !"".equals(codigoTipoProducto)){			
			criteria.createCriteria("tipoProducto", "resultadoJoin", JoinType.RIGHT_OUTER_JOIN);	
			criteria.add(Restrictions.ilike("resultadoJoin.codigoTipo", codigoTipoProducto));
		}

		return (Object[]) criteria.uniqueResult();
	}
	
	public List<Producto> findPrecioCompraGTAvgPrecioCompraCodigoTipoProductoEqual(String codigoTipoProducto){
		session = HibernateSessionUtils.getSession();
		
		DetachedCriteria avgPrecioCompra= DetachedCriteria.forClass(Producto.class);
		avgPrecioCompra.setProjection(Property.forName("precioCompra").avg());
		
		
		Criteria criteria = session.createCriteria(Producto.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		criteria.add(Property.forName("precioCompra").gt(avgPrecioCompra));
		
		if(codigoTipoProducto!= null && !"".equals(codigoTipoProducto)){			
			criteria.createCriteria("tipoProducto", "resultadoJoin", JoinType.RIGHT_OUTER_JOIN);
			criteria.add(Restrictions.ilike("resultadoJoin.codigoTipo", codigoTipoProducto));
		}
			
		return criteria.list();
	}

}
