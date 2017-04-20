package aatta.practica03.gr01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aatta.practica03.model.DaoUser_Interface;
import aatta.practica03.model.DtoUser;

/**
 * Clase HomeController para canalizar todas las peticiones realizas al servidor.
 * @author Andres Ruiz Peñuela
 * @author Luis Jesús Montes Pérez
 * @version 3.0.1
 */
@Controller
public class HomeController {
	/* Constnates */
	private final String vistas[] = {"home","autenticado"}; //JSP
	private final String respuest[] = {"220 Solitud Correcta.","400 Solitud Incorrecta.",
			"401 Autenticacion Requerida.","402 Nombre Incorrecto.","403 Contraseña Incorrecta."};//Codigos de respuesta
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); //Auto-generado
	
	@Autowired
	//Busca en servlet-cont, un bean que implemente un DaoUsuario_Interface,
	//para poder acceder a la base de datos.
	DaoUser_Interface daou;  //Dependenica para establecer una conexion con la BBDD mediante JDBTemplate
	
	/**
	 * Metodo home,  para la solicitud de formulario de autenticarse
	 * Get: http://localhost:8080/gr01/
	 *      http://localhost:8080/gr01/index
	 *      
	 * @param model de tipo Model
	 * @return mostrar de tipo String
	 * @version 3.0.1
	 */
	@RequestMapping(value ={"/", "/index"} , method = RequestMethod.GET)
	public String home(Model model) {
		/* Variables */
		String mostrar; //Para poder movernos sobre los distintos jsp
		String date; //Para la fecha con formato.
    	Date today; // Para la fecha del sistema.
    	SimpleDateFormat DATE_FORMAT;//Para dar formato de la fecha.
    	
    	/* Inizialización de variables */
		mostrar=vistas[0]; //Mostramos la primera vista (home.jsp)
		DATE_FORMAT = new SimpleDateFormat("dd/MM/yy HH:mm:SS");//Defenimos el formato.
		today = new Date(); //Obtenemos la fecha del sistema actual.
		date=null;
		
		/* Obtenemos el momento de la conexión */
    	date = DATE_FORMAT.format(today);//Realizamos el formateo de la fecha.

    	/* Salida */
    	logger.info("Momento de conexion "+date); //Informamos del momento de conexión.
		model.addAttribute("serverTime", date ); //Enviamos la fecha de conexión a la vista.
		
		return mostrar; //Mostramos el jsp selecciondo.
	}
	
	/**
	 * Metodo login, para comprobar si es un usuario ya registrado
	 * Peticion Get, http://localhost:8080/gr01/autentica?usuario=prueba&amp;clave=prueba
	 * 
	 * @param req de tipo HttpServletRequest
	 * @param model de tipo Model
	 * @return mostrar de tipo String
	 */
	@RequestMapping(value = "/autentica", method = {RequestMethod.POST,RequestMethod.GET})
	public String login(HttpServletRequest req,Model model){
		/* Variables */
		String mostrar; //Permite recorrer los distintos jsp.
		Boolean existe; //Para comprobar si esta o no en la BBDD
		String user; //Contiene el nombre introducio por el usuario
		DtoUser usuario; 
		String dni; //Contiene el pass introducido por el usuario
		String msg;
		String respuesta;
		
		/* Inizializacion */
		msg=null;
		mostrar = null;
		existe= false;
		mostrar = vistas[1];
		/* Extremos los datos de la petición */
		user = req.getParameter("usuario");
		dni =req.getParameter("clave");
		
		/* Procesmos los datos*/
		if(user==null || dni==null){
			//Si no se introdujo ningun dato
			msg="No hay usuario o Contraseña";
			respuesta= respuest[2];			
		}else{
			//De lo contrario.
			msg="Comprobando si existe "+user;
			//Nos conectmaos con la base de datos.
			//Creamos una instancia nueva.
			
			//Conectamos con la base de datos.
			usuario = daou.exists(dni);
			
			if(usuario!=null){//Se ecuentra en la base de datos, comprobamos el nombre
				if(usuario.getName().equals(user))
				{//El nombre coincide
					msg="Exito en la utenticacion";
					respuesta = respuest[0];
				}else{//El nombre no coincide.
					msg="Nombre incorrecto";
					respuesta = respuest[3];
				}

			}
			else{//No se encuentra en la base de datos.
				msg="No esta registrado, error en la contraseña";
				respuesta = respuest[4];

			}
			
		}
		
		/* Salida */
    	logger.info(msg+" Respuesta "+respuesta); //Informamos del suceso.
    	model.addAttribute("resultado",respuesta); //Enviamos la respuesta al jsp.
		return mostrar;
	}
}
