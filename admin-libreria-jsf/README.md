### JSF Java Server Faces

Framework MVC que facilita la construcción de Vista y Controlador. Nativo JEE. Implementa IoC. JSF es un  

JSF usa un motor de template llamado **facelets**. Son archivos **xhtml** que no se transforman a servlet como los jsp. Las templates xhtml  

* Front Controller: FacesServlet. Controla los managed benas y las vistas
* Managed Bean (asociado a un único xtml) son POJOs que contituyen los controladores de accion (sustituyen a los servlets) 
* jsp > xhtml
* faces-config.xml configuracion adicional al web.xml: recursos, reglas de navegacion, validadores, conversores

La especificación de JSF fue desarrollada por la Java Community Process como: 

* JSR 127 - 1.0 y 1.1, 
* JSR 252 - JSF 1.2 
* JSR 314 - JSF 2.0
* JSR 314 - JSF 2.0 
* JSR 344 - JSF 2.2  
* JSR 372 - JSF 2.3  


JSF es una Las implementaciones son

* Mojarra: oracle (más básica)
* MyFaces: apache
* RichFaces jboss
* Primefaces las más extendidad 
