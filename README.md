# Solution:

* Application is expecting to get input from command line argument while executing it
    * Application expects to recieve 3 arguments for the three triangle side
    * Each arugment should be an Inetger greater than 0 
* Application consists of 2 main modules:
    * InputReader: `Application` class
        * It reads `Triangle` sides from argument 
        * Create object from `Triangle` class using builder pattern -- I'm using object here in case we need to add more info.
        * Pass the Object to get the correct Type
    * Type dedector: `TriangleType` enum:
        * It has three types for the traingle types.
        * Each Type is defining it's own rules for based on the `Triangle` object
        * Determine which type this `Triangle` object is based on it's data.
* Applicaiton Exception Types:
    * `NoSuchTriangleTypeException`: it refelect that Application is not able to find the correct `TriangleType`
    * `RunTimeException`: it refeclts mainly invalid input.

# How to use the application 

Build and Deploy
----------------------

Make sure you have all necessary tools installed
    
    Java 8
    
Build the application:

    mvn clean install
     
Run locally
----------------------

        java -jar target/triangle-challenge.jar 1 1 1