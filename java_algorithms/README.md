# Java Algorithms
Directory for Java Algorithms Exercises

# Setup

- Install Maven and latest LTS version  of the Java JDK for your distribution, for example:
  
    `apt -y install maven openjdk-17-jdk`


- Download and install the books standard library implementation

    `cd </path/to/where/algs4.jar-is>`

    `mvn install:install-file -Dfile=algs4.jar -DgroupId=edu.princeton.cs -DartifactId=algs4 -Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true`


# To run

`mvn test`

# To run a single test
`mvn bla bla`

