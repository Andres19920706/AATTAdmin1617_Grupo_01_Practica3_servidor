package aatta.practica03.model;
/**
 * Clases DtoUser, contiene la estructura de un usuario.
 * @author Andres Ruiz Peñuela
 * @author Luis Jesús Montes Pérez
 * @version 3.0.1
 */
public class DtoUser {
	/**
	 * Atributos de la clase
	 */
	String name;
	String dni;
    
    /** 
     * Constructor por defecto, asocia un valor equivalente a null
     * a los atributos del usuario.
	 * @version 3.0.1
     */
    public DtoUser( ){
    	this.name="";
    	this.dni="";
    }
    /**
     * Constructor con parámetros, asocia un valor determinado a los atributos del 
     * usuario.
     * @param dni
     * @param user
     */
    public DtoUser(String dni, String user){
        this.dni=dni;
        this.name=user;
    }
    
    /**
     *  Metodos Get y Set para acceder a los atributos. 
     */

    /* Metodos Get */
    
    /**
     * Metodo para obtener el nombre
     * @return name de tipo String
     */
	public String getName() {
		return name;
	}
	/**
	 * Metodo para obtener el DNI
	 * @return dni de tipo String
	 */
	public String getDni() {
		return dni;
	}
	
	/* Metodos Set */
	
	/**
	 * Metodo para insertar el nombre
	 * @param name de tipo String
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Metodo para 	insertar el dni
	 * @param dni de tipo String
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

}
