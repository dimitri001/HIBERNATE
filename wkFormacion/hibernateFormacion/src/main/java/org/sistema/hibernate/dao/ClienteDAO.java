package org.sistema.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;
import org.sistema.hibernate.models.Cliente;
import org.sistema.hibernate.models.Factura;
import org.sistema.hibernate.models.Persona;
import org.sistema.hibernate.models.Producto;
import org.sistema.hibernate.session.HibernateSessionUtils;

public class ClienteDAO extends GenericDAO<Cliente> {

	public ClienteDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Cliente> findAll(){
		return super.findAll(Cliente.class);
	}

	public List<Cliente> findWhere(String nombre, String apellidos, String dni) throws HibernateException{
		session = HibernateSessionUtils.getSession();
		Criteria criteria = session.createCriteria(Cliente.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		//criteria.createAlias("proveedor", "aliasProveedor");// innerJoin por defecto
		//criteria.createCriteria("cliente.proveedor", "aliasProveedor", JoinType.LEFT_OUTER_JOIN);
//		criteria.setProjection(Property.forName("edad").avg());
//		criteria.setProjection(Projections.avg("edad"));		
	
		if(nombre != null){
			criteria.add(Restrictions.ilike("persona.nombre",nombre+"%"));
		}
		
		if(apellidos != null){
			criteria.add(Restrictions.ilike("persona.apellidos",apellidos));
		}
			
		if(dni != null){
			criteria.add(Restrictions.ilike("persona.dni",dni));
		}
/*		
		int bloquePagina = 50; // es el numero de elementos que quiero que se muestren por página
		criteria.setFirstResult(bloquePagina);
		*/
		//criteria.add(Restrictions.ilike("aliasProveedor.nombre", nombre));
		criteria.addOrder(Order.asc("persona.nombre"));
		criteria.setMaxResults(50);
		
		return criteria.list();
	}
	
	public List<Cliente> findByExampleWhere(String nombre, String apellidos, Integer edad, String dni) throws HibernateException{
		session = HibernateSessionUtils.getSession();
		Criteria criteria = session.createCriteria(Cliente.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		Cliente cliente = new Cliente();
		Persona persona = new Persona( nombre,  apellidos, dni, edad,  "");
		cliente.setPersona(persona);
		
		criteria.add(Example.create(cliente).enableLike());
		
		return (List<Cliente>) criteria.list();
		
	}
	
	public List<Cliente> findClientesEdadGTEdadAvg(){
		session = HibernateSessionUtils.getSession();
		
		DetachedCriteria avgEdad= DetachedCriteria.forClass(Cliente.class);
		avgEdad.setProjection(Property.forName("persona.edad").avg());
		
		
		Criteria criteria = session.createCriteria(Cliente.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		criteria.add(Property.forName("persona.edad").gt(avgEdad));
			
		return (List<Cliente>) criteria.list();
	}
	
	//Devuelve los clientes que hayan comprado varias veces el mismo producto
	public Double findEdadAVGCompranProducto(String codigoProducto){
		session = HibernateSessionUtils.getSession();
		
//		DetachedCriteria facturaCriteria= DetachedCriteria.forClass(Factura.class);
		Criteria facturaCriteria= session.createCriteria(Factura.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		facturaCriteria.createCriteria("listaProductos", "resultadoJoinProducto", JoinType.LEFT_OUTER_JOIN);
		facturaCriteria.add(Restrictions.ilike("resultadoJoinProducto.codigo", codigoProducto));		
		facturaCriteria.createCriteria("cliente", "resultadoJoinCliente", JoinType.RIGHT_OUTER_JOIN);
		facturaCriteria.setProjection(Property.forName("resultadoJoinCliente.persona.edad").avg());
			
		return (Double) facturaCriteria.uniqueResult();
	}
	
	//Devuelve los clientes que hayan comprado varias veces el mismo producto
	public Double findEdadAVGCompranProductoNoRepetidos(String codigoProducto){
		session = HibernateSessionUtils.getSession();
		
		DetachedCriteria facturaCriteria= DetachedCriteria.forClass(Factura.class);
		//Criteria facturaCriteria= session.createCriteria(Factura.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		facturaCriteria.createCriteria("listaProductos", "resultadoJoinProducto", JoinType.LEFT_OUTER_JOIN);
		facturaCriteria.add(Restrictions.ilike("resultadoJoinProducto.codigo", codigoProducto));		
		facturaCriteria.createCriteria("cliente", "resultadoJoinCliente", JoinType.RIGHT_OUTER_JOIN);
		facturaCriteria.setProjection(Projections.property("resultadoJoinCliente.persona.dni"));
		
		Criteria clienteCriteria= session.createCriteria(Cliente.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		clienteCriteria.add(Property.forName("persona.dni").in(facturaCriteria));
		clienteCriteria.setProjection(Property.forName("persona.edad").avg());
		
		return (Double) clienteCriteria.uniqueResult();
	}
	public Double mediaEdadPorProducto(String codigoProducto){
		session = HibernateSessionUtils.getSession();
		Criteria criteria = session.createCriteria(Factura.class, "factura");//.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		criteria.createCriteria("factura.cliente", "cliente");
		criteria.createCriteria("factura.listaProductos", "producto", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.like("producto.codigo", codigoProducto));
		criteria.setProjection(Projections.avg("cliente.persona.edad"));		
		return (Double) criteria.uniqueResult();	
	}
	
	public Double mediaEdadPorProductoUnico(String codigoProducto){
		session = HibernateSessionUtils.getSession();
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Factura.class, "factura");
		detachedCriteria.createCriteria("factura.listaProductos", "producto", JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.like("producto.codigo", codigoProducto));
		detachedCriteria.createCriteria("factura.cliente", "cliente");
		detachedCriteria.setProjection(Projections.property("cliente.persona.dni"));
		
		Criteria criteria = session.createCriteria(Cliente.class, "cliente");
		criteria.add(Property.forName("cliente.persona.dni").in(detachedCriteria));
		criteria.setProjection(Projections.avg("cliente.persona.edad"));
				
		return (Double) criteria.uniqueResult();	
	}
	
	
	public Integer findMes() throws HibernateException{
		session = HibernateSessionUtils.getSession();
		Criteria criteria = session.createCriteria(Factura.class, "factura");
		
		criteria.setProjection(Projections.projectionList().add(Projections.count("fecha").as("fecha"))
		.add(Projections.sqlGroupProjection("month(this_.fecha) as value", "month(this_.fecha)",
				new String[]{"value"} , new Type[] {new IntegerType()})) );
		
		criteria.addOrder(Order.desc("fecha"));
		
		return (Integer) ((Object[]) criteria.list().get(0))[1];
	}
	
	
	public Integer findMesSql() throws HibernateException{
		session = HibernateSessionUtils.getSession();
		
		session.createSQLQuery("Select ");
		
		return 1;
	}
	
	
	public List<Cliente> findWhereHQL(String nombre, String apellidos, String dni) throws HibernateException{
		session = HibernateSessionUtils.getSession();
		
		
		String strConsulta= " From Cliente where 1=1 ";
		StringBuffer queryString = new StringBuffer();
		queryString.append(strConsulta);

		
		String condNombre="";
		if(nombre != null){
			condNombre =" and nombre like :nombre ";
			queryString.append(condNombre);
		}
		
		String condApellidos="";
		if(apellidos != null){
			condApellidos=" and apellidos like :apellidos";
			queryString.append(condApellidos);
		}
			
		String condDni="";
		if(dni != null){
			condDni=" and dni =:dni";
			queryString.append(condDni);
		}

		Query consulta = session.createQuery(queryString.toString());
		if(nombre != null){
			consulta.setString("nombre", nombre+"%");
		}
		
		
		if(apellidos != null){
			consulta.setString("apellidos", apellidos+"%");
		}
		
		
		if(dni != null){
			consulta.setString("dni", dni);
		}
		
		return (List<Cliente>) consulta.list();
	}
	
}
