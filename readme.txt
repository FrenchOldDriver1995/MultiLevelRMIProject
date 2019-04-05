#First compile the whole folder
# xxx is the path where the file locate
#every time when you change your code, you shall delete all the .class files and compile
javac xxx/*.java

###First you should register the service 
##open the folder where this file locate
##insert:

rmic Site

###if the terminal say "Warning: generation and use of skeletons and static stubs for JRMP	
##is deprecated. Skeletons are unnecessary, and static stubs have	
##been superseded by dynamically generated stubs. Users are	
##encouraged to migrate away from using rmic to generate skeletons and static	
##stubs. See the documentation for java.rmi.server.UnicastRemoteObject"
##It means all is ok then open a new terminal with the old one opened
##go into the file located path and then insert:

rmiregistry

##open again a new terminal to initial the server, go into the file located path and then #insert:

java -cp . -Djava.security.policy=./security.policy -Djava.rmi.server.codebase=file:/. ServerCentral

##open again a new terminal for the site/client, go into the file located path and then #insert:

java -cp . -Djava.security.policy=./security.policy -Djava.rmi.server.codebase=file:/. SiteClient
