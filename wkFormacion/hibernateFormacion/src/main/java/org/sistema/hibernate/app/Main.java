package org.sistema.hibernate.app;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.sistema.hibernate.dao.ClienteDAO;
import org.sistema.hibernate.dao.EmpleadoDAO;
import org.sistema.hibernate.dao.FacturaDAO;
import org.sistema.hibernate.dao.GenericDAO;
import org.sistema.hibernate.dao.PedidoDAO;
import org.sistema.hibernate.dao.ProductoDAO;
import org.sistema.hibernate.dao.ProveedorDAO;
import org.sistema.hibernate.dao.TipoProductoDAO;
import org.sistema.hibernate.models.Cliente;
import org.sistema.hibernate.models.Empleado;
import org.sistema.hibernate.models.EstadoPedido;
import org.sistema.hibernate.models.Factura;
import org.sistema.hibernate.models.Pedido;
import org.sistema.hibernate.models.Producto;
import org.sistema.hibernate.models.Proveedor;
import org.sistema.hibernate.models.TipoProducto;
import org.sistema.hibernate.models.User;
import org.sistema.hibernate.session.HibernateSessionUtils;

public class Main {

	public static void main(String[] args) {

		
//		method1();
//		method2();

//		method3(100);	

		method4();
	}
	
	public static void method1(){
		Session session = HibernateSessionUtils.getSession();
		session.getTransaction().begin(); // empieza la transacción
		User myUser = new User("Sebas", "1234");
		
		//User myUser2 = new User("Sebas", "1234");
		
		session.persist(myUser);//persistimos el objeto 
		//session.persist(myUser2);//persistimos el objeto 
		session.flush(); //envía los cambios de la transacción
		session.getTransaction().commit();//comiteamos
		
		session.close();
		
		System.out.println("Id generado : "+ myUser.getId());
	}
	
	public static void method2(){
		
		User myUser = new User("Sebas", "1234");		
		GenericDAO<User> myDAO = new GenericDAO<User>();
		myDAO.insert(myUser);		
		System.out.println("insert Id generado : "+ myUser.getId());
		
		myUser.setNombre("nombreCambiado");
		myDAO.update(myUser);
		
		System.out.println("update Id generado : "+ myUser.getId());
		/*
		myDAO.delete(myUser);		
		System.out.println("delete : "+ myUser.getId());
		*/
		User myUserSelect = myDAO.findById(myUser.getId(), User.class);
		
		System.out.println("select Id generado : "+ myUserSelect != null ? myUserSelect.getId() : "objecto null");
	}
	
	public static void method3(Integer limit){
		
		TipoProductoDAO tipoProductoDAO = new TipoProductoDAO();
		
		TipoProducto tipoProducto1 = new TipoProducto("codigoProducto1", "nombre1","descripcion1");
		TipoProducto tipoProducto2 = new TipoProducto("codigoProducto2", "nombre2","descripcion2");
		TipoProducto tipoProducto3 = new TipoProducto("codigoProducto3", "nombre3","descripcion3");
		
		tipoProductoDAO.insert(tipoProducto1);
		tipoProductoDAO.insert(tipoProducto2);
		tipoProductoDAO.insert(tipoProducto3);
		
		ProductoDAO productoDAO = new ProductoDAO();
		List<Producto> myListaProductos = new ArrayList<Producto>();
		for(int i= 0 ; i<100; i++){
			Producto myProducto = new Producto("codigo"+i, new BigDecimal(10+i), new BigDecimal(15+i), i, i > 4? tipoProducto1 : tipoProducto2 , "descripcion"+1);
			myListaProductos.add(myProducto);
			productoDAO.insert(myProducto);
		}

		
		for(int index = 0; index < limit; index++){
			
			Random rn = new Random();
			int edadRandom = rn.nextInt(20);
			
			int miIndex = index+1;
			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente cliente = new Cliente("ciente"+miIndex+"Hola", "Apellidos Cliente"+miIndex, miIndex+"48123R", 15 + edadRandom, "direccion"+miIndex);		
			clienteDAO.insert(cliente);
			
			EmpleadoDAO empleadoDAO = new EmpleadoDAO();
			Empleado empleado = new Empleado(miIndex+"123A", "puesto"+miIndex, "nombre"+miIndex, "apellidos"+miIndex, miIndex+"12346543T", 15 + edadRandom, "direccion"+miIndex);		
			empleadoDAO.insert(empleado);
			
			FacturaDAO facturaDAO = new FacturaDAO();
			Factura factura = new Factura("numeroFactura"+miIndex, cliente, myListaProductos, new Date(), new BigDecimal(10), new BigDecimal(12.5));
			facturaDAO.insert(factura);
			
			ProveedorDAO proveedorDAO = new ProveedorDAO();
			Proveedor proveedor = new Proveedor("proveedor"+miIndex, miIndex+"2345671E","dirección"+miIndex);
			proveedorDAO.insert(proveedor);
			
			PedidoDAO pedidoDAO = new PedidoDAO();
			
			
			int randomIndex = rn.nextInt(myListaProductos.size());
			//randomIndex = randomIndex <= 0 ? 1:randomIndex; 
			Pedido pedido = new Pedido("numeroPedido"+miIndex, myListaProductos.subList(0, randomIndex), new Date(), new BigDecimal(42.5), proveedor, EstadoPedido.PEDIDO);
			pedidoDAO.insert(pedido);

			
		}
		
		method4();
	}
	
	public static void method4(){
		GenericDAO<Producto> myGenericDAO = new GenericDAO<Producto>();
		
		List<Producto> myList = myGenericDAO.findAll(Producto.class); 
		System.out.println("myList =  : ");
		
		System.out.print(myList != null ? myList.size() : "0; objecto null");
		
		ClienteDAO  clienteDAO = new ClienteDAO();		
		List<Cliente> clienteResult = clienteDAO.findWhere("ciente", null, null);
		System.out.println("clienteResult =  : ");		
		System.out.print(clienteResult != null ? clienteResult.size() : "0; objecto null");
		
		//Se usa para cubrir casos simples
		List<Cliente> clienteResult1 = clienteDAO.findByExampleWhere("ciente", null, null, null);
		System.out.println("clienteResult1 =  : ");		
		System.out.print(clienteResult1 != null ? clienteResult1.size() : "0; objecto null");
		
		ProductoDAO productoDAO = new ProductoDAO();
		List<Producto> productoLista = productoDAO.findProductoByTipoProductoCodigoProducto("codigoProducto1");
		System.out.println("productoLista =  : " + productoLista.size());
		
		
		Object[] avgArray = productoDAO.findAvgPrecioCompraAndAvgPrecioVentaCodigoTipoProductoEqual("codigoProducto1");

		if(avgArray.length > 0){
			System.out.println("AvgPrecioCompra =  : " +  avgArray[0] +" AvgPrecioVenta = "+ avgArray[1]);
		}
		
		
		List<Producto> listaProdGTPrecioCompraAVG= productoDAO.findPrecioCompraGTAvgPrecioCompraCodigoTipoProductoEqual("");
		System.out.println("PrecioCompraGTAvgPrecioCompra =  : " + listaProdGTPrecioCompraAVG.size());
		
		
		List<Cliente> listaClientesEdadGTEdadAVG = clienteDAO.findClientesEdadGTEdadAvg();
		System.out.println("listaClientesEdadGTEdadAVG =  : " + listaClientesEdadGTEdadAVG.size());
		
		
		
		Object avgEdadClienteCompraProducto = clienteDAO.findEdadAVGCompranProducto("codigo0");
		
		System.out.println("avgEdadClienteCompraProducto =  : " + avgEdadClienteCompraProducto);
		
		
		
		
		Object avgEdadClienteCompraProducto1 = clienteDAO.findEdadAVGCompranProductoNoRepetidos("codigo0");
		
		System.out.println("avgEdadClienteCompraProductoNoRepetidos =  : " + avgEdadClienteCompraProducto1  );
		
		
		System.out.println(" ***** HQL ***** ");
		
		List<Producto> myList1 = myGenericDAO.findAllHQL(Producto.class);		
		System.out.println("myList1 =  : ");		
		System.out.print(myList1 != null ? myList1.size() : "0; objecto null");
		
		List<Cliente> clienteResultHQL = clienteDAO.findWhereHQL("ciente", "A", null);
		System.out.println("clienteResult1 =  : ");		
		System.out.print(clienteResultHQL != null ? clienteResultHQL.size() : "0; objecto null");
	}

}
