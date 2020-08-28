# cashApplicationa

Para probar la app tenes que descargar el archivo .jar del repositorio.

Una vez descargado hay que abrir CMD buscar la ruta donde esta poniendo 

cd C:\Users\ 

De aca se ´ppuede descargar la base de datos, use postgreSQL https://www.postgresql.org/download/windows/

Y de aca se descarga la version de postgre https://www.enterprisedb.com/downloads/postgres-postgresql-downloads

Una vez instalado se tiene que crear un servidor haciendo clic derecho crear servidor sobre ser e la barra de la izquierda

En la pestaña de general se pone cualquier nombre y en connection se pone localhost en host y 5432.

En el desplegable Database se crea una base de datos con el nombre cash.

luego ejecutar el archivo con el siguiente comando

java -jar cashApplication-0.0.1-SNAPSHOT.jar

Una vez que se este ejecutando desde el Postman https://www.postman.com/downloads/ se puede hacer los siguientes comandos con la app.

POST http://localhost:8080/user/create

{
        "email": "Mail@da.com",
        "firstName": "Pepe",
        "lastName": "Rodri",
        "loans":[]
}

Copiando esta estructura en la pestaña body y seteando el lenguaje a json se puede crear un usuario poniendole los datos que desee.

GET http://localhost:8080/user

Con esta linea se obtienen todos los usuarios guardados.

GET http://localhost:8080/user/{id}

Con esta linea se obtiene un usuario especifico cambiando "{id}" por el numero de id que se busque.

POST http://localhost:8080/loans/create

{
    "total":1000,
    "userId":5
}

Crea Loans nuevos con esta sintaxis, igual que create users

GET http://localhost:8080/loans?page=0&size=10&userId=1

Con esta linea se muestran todos los Loans, se tienen que poner obligatoriamente el tamaño y el numero de pagina, opcionalmente se puede agragar el numero de usuario

DELETE http://localhost:8080/user/delete/{userId}

Con esta linea se elimina un usuario dado su id, reemplazandolo por "{userId}". Este comando elimina el usuario y todos sus loans correspondientes.

Postman correspondiente: https://www.getpostman.com/collections/99de905ceaae5b56110f
