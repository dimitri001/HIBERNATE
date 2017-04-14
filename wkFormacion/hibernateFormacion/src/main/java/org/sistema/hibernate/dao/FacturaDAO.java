package org.sistema.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.sistema.hibernate.models.Factura;
import org.sistema.hibernate.session.HibernateSessionUtils;

public class FacturaDAO extends GenericDAO<Factura> {

	public FacturaDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Factura> findAll(){
		return super.findAll(Factura.class);
	}
	
	public List<Factura> findFacturaByProductoCodigo(String codigoProducto){
		session = HibernateSessionUtils.getSession();
		
		List<Factura> result = new ArrayList<Factura>();
		
		if(codigoProducto!= null && !"".equals(codigoProducto)){
			
			Criteria criteria = session.createCriteria(Factura.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			//criteria.createCriteria("factura.proveedor", "aliasProveedor", JoinType.LEFT_OUTER_JOIN);
			
			
		}
			
		return result;
	}

}
