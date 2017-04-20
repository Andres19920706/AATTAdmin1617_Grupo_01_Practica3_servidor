package aatta.practica03.model;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import aatta.practica03.model.DaoUser_Interface;
/**
 * Clase DaoUser, contine los metodos para acceder a la base de datos
 * Es una implementacion de DaoUser_Interface
 * @author Andres Ruiz Peñuela
 * @author Luis Jesús Montes Pérez
 * @version 3.0.1
 */
public class DaoUser implements DaoUser_Interface {
	
	private JdbcTemplate jdbcTemplate;//Para trabajar con JDBC que nos proporciona spring
	private DataSource dataSource;//Hace referencia al datasource de la base de datos que sera sostenida en la tabla.
	
	/**
	 * Recibe un dataSource, el cual, es suministrado por inyección, dado que este objeto esta precargado
	 * en el sppring bean configuration.
	 * Este método asigna el valor a la variable privada, y genera una instancia de la template que nos 
	 * proporciona spring pasandole la conexión con la base de datos.
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
	   this.dataSource = dataSource;
	   this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	/**
	 * Método eixst, permite comprobar si el usuario esta almacenado en
	 * la base de datos.
	 * @param dni de tipo String
	 * @return use de tipo DtoUser
	 */
	public DtoUser exists (String dni){
		/* Variables */
		String sql; //Contiene la setencia SQL
		UserMapper mapper; //Mapeo para el acceso a la base de datos
		List<DtoUser> usu; //Quey devuelve una lista o null
		Object[] parametros = {dni}; //Necesaria para query
		
		/* Inicialización de las variables. */
		sql= "select * from miembros where DNI = ? ";
		mapper = new UserMapper();
		
		/* Establecemos la conexion con la base de datos. */
		usu = this.jdbcTemplate.query(sql,parametros, mapper);
		
		/* Comprobramos si existe o no */
		if (usu.isEmpty()){//No existe
			return null;//Devolvemos un null.
		}else{//Existe
			return usu.get(0);//Devolvemos los datos del usuario.
		}
	}
	
}
