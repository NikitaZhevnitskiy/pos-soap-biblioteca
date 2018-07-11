[Original repo](https://github.com/wensttay/pos-soap-biblioteca)

# soap-biblioteca
A simple java soap example on docker made to the POS class

With docker-compose installed, just open the terminal here and write the command:

$ sh up.sh

Or do this:

$ mvn clean install
$ docker-compose up -d 

Wait a minute while all containers starts ... and done!
Now you can use the WSDL to generate the files to call the methods on the docker containers by:

<b>Autor's CRUD Methods</b>
- http://localhost:8081/soap-biblioteca/AutorServiceService?wsdl

<b>Livro's CRUD Methods</b>
- http://localhost:8081/soap-biblioteca/LivroServiceService?wsdl

<b>Some helps:</b>

Shutdown Command:
 - $ sh down.sh
 
Restart Command: 
 - $ sh restart.sh
