# Fitbit Calibrator

This program computes the resulting position(s) of a variable number of trainees on a given soccer field, based on the values supplied inside the input txt file. The first line should always be the upper-right coordinate of the soccer field and we assume that the lower-left is always _(0,0)_. Succeeding lines inside the file will describe the initial position of the trainee(s) and the movements he/she will follow inside the field. 

I have coded the application using the dependency injection design pattern. Doing so removed tightly coupled dependencies between the classes. It also makes it easier to reuse and adjust code for updates and for testing, aside from the fact that it makes the code look cleaner. I have placed the validation of the values derived from the input file and the input file itself inside the **FitbitFileReader** class, to catch erroneous data as early as possible. Any deviation of the values from the requirements and assumptions, and it will terminate the application immediately. 

As requested from the requirements, the program will only accept **.txt** files. Automated tests have been created using **JUnit**. The program has been coded using [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and as such will require this specific version to be installed in your machine to run. To package and test the project, you will also need to have [Maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html) installed. There might be unexpected behaviors in Maven or Windows when cloning into a directory path that has a folder with a space in the name. This might break the automated tests. As such, I recommend to put the cloned repository inside a directory path that has no whitespace in the folder names.

To test the project, go into the project folder and execute the following command.
```sh
mvn test
```

To package the project.
```sh
mvn package
```

To run the program, use the following command in the project folder.
```sh
java -jar target/fitbit-calibrator-1.0-SNAPSHOT.jar sample.txt
```

##### Sample Input and Output
###### Input
```sh
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
4 3 W
MRMRLLMMRLRLRLRLRLRMMMMMRRR 
```
###### Output
```sh
1 3 N
5 1 E
1 5 W
```

##### Assumptions
1. The initial position of the trainee is always inside the soccer field. 
2. Two or more trainees can occupy the same coordinates inside the soccer field.
3. Trainees can't go past the edges of the soccer field. Move commands will be ignored.
4. All alphabets inside the input file must be of uppercase letters.
