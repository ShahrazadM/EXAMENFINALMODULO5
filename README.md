Proyecto termnino Modulo5 
objetivo:Aplicar los conceptos vistos em seciones anteriores.Generando una aplicacion Web.Usando diseño MVC.
Problema : UNa empresa de asesorias necesita contar con unsistema de informacion que le permite administratr los procesos de la empresa.
Solucion:Desarrosallar un solucion tecnologiga que permite gestionar de manera mas eficiente lo requerido por la empreza. Pra ello creamos el siguiente Proyecto: 

PREVENSION DE RIESGOS(PruebaFinal5)
Resumen del Proyecto:

Este proyecto tiene como objetivo desarrollar un sistema de información integral para una empresa de asesorías en prevención de riesgos laborales. La empresa enfrenta desafíos en la administración de la información generada, el control de actividades y la coordinación del personal. Además, carece de un sistema adecuado para gestionar clientes y coordinar visitas a terreno, lo que ha llevado a problemas financieros y de calidad en el servicio.

La solución propuesta consiste en desarrollar una plataforma tecnológica que permita planificar y controlar actividades, gestionar clientes, coordinar visitas a terreno y generar reportes útiles para la toma de decisiones. Para lograr esto, se utilizarán tecnologías como Java Enterprise Edition (JEE), Servlets, JavaServer Pages (JSP), HTML, CSS y JavaScript.

El proyecto se estructurará en torno a varios servlets que manejarán diferentes funcionalidades. Entre ellos se incluyen:

InicioControlador: Gestiona la página de inicio del portal y verifica la conexión a la base de datos.
ContactoServlet: Maneja el formulario de contacto y procesa la información ingresada.
CrearUsuario: Permite la creación de un nuevo usuario en el sistema, utilizando el método HTTP POST.
EditarUsuarioServlet: Maneja la edición de información de usuarios existentes, accediendo desde el listado de usuarios.
LoginServlet: Gestiona el acceso de usuarios al portal mediante un formulario de inicio de sesión.
ListaUsuariosServlet: Muestra un listado de todos los usuarios existentes en la plataforma.
LoginServlet: Verifica las credenciales del usuario utilizando la base de datos y redirige según el tipo de usuario.
Cada servlet interactúa con clases y métodos correspondientes para realizar las operaciones necesarias, utilizando métodos HTTP GET y POST según sea necesario.

Además, se han desarrollado varias páginas de vista para proporcionar una interfaz de usuario amigable:

contacto.jsp: Formulario de contacto que permite a los usuarios enviar mensajes.
crearusuario.jsp: Formulario para crear un nuevo usuario en el sistema.
editarusuario.jsp: Formulario para editar la información de un usuario existente.
home.jsp: Página principal del portal que muestra un mensaje de bienvenida y enlaces a otras secciones.
listarcapacitacion.jsp: Muestra un listado de todas las capacitaciones registradas en el sistema.
listarusuarios.jsp: Muestra un listado de usuarios según el tipo seleccionado.
mimenu.jsp: Fragmento de código que se incluye en varias páginas para mostrar un menú de navegación.
También se han agregado los siguientes archivos de vista:

login.jsp: Formulario de inicio de sesión para que los usuarios ingresen al sistema.
mensajeConfirmacion.jsp: Página que muestra un mensaje de confirmación después de enviar un mensaje de contacto.
crearusuario.jsp: Formulario para crear un nuevo usuario con campos específicos según el tipo seleccionado.
menu.jsp: Fragmento de código que muestra un menú de navegación y permite regresar a la página principal.

Observaciones: El modelo de datos incluye tablas para usuarios,capacitaciones con metodos CRUD,implemtados por DAO.Ademas se aplico el Patron Singleton para aseguarar la consistencia de datos.
Finalmente el codigo sera conpartido en un repositorio publicon en Github.

Integrantes del proyecto:
Nayaret Sepulveda enlace GitHub:
Ruben enlace GitHub:
Sherezade GitHub: ShahrazadM
repostorio en GitHub:https://github.com/ShahrazadM/EXAMENFINALMODULO5.git
Frasiel Camp enlace GitHub: https://github.com/Frasiel


