package aatta.practica03.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import aatta.practica03.model.DtoUser;
/**
 * Clase UserMapper, para acceder a los datos de la tabla de la BBDD fijada en servlet-context.xml
 * @author Andres Ruiz Peñuela
 * @author Luis Jesús Montes Pérez
 * @version 3.0.1
 */
public class UserMapper implements RowMapper<DtoUser>{
	/**
	 * Metodo para mappear la base de datos.
	 * @param rs de tipo ResultSet
	 * @param rowNum de tipo integger
	 * @exception SQLException
	 * @return u de tipo DtoUser
	 */
	public DtoUser mapRow(ResultSet rs, int rowNum) throws SQLException{
		/* Variables */
		DtoUser u;
		
		/* Iniciazlición */
		u= new DtoUser();
		
		/* Mapeo */
		u.setName(rs.getString("usuario"));
		u.setDni(rs.getString("dni"));

		/* Salida */
		return u;
	}
}
