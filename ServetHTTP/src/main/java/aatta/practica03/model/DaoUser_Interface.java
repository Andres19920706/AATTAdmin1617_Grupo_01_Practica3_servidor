package aatta.practica03.model;

import java.util.List;
/**
 * Interfaz de DaoUser, para definir los metodos que debe tener la clase DaoUser. 
 * @author Andres Ruiz Pe�uela
 * @author Luis Jes�s Montes P�rez
 * @version 3.0.1
 */
public interface DaoUser_Interface {
	/**
	 * Metodo exists, comprueba si el dni esta en la base de datos.
	 * @param dni
	 * @return obtejo de tipo DtoUser
	 */
	public DtoUser exists (String dni);
}
