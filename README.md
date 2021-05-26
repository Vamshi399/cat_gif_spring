# cat_gif_spring
# How to Run
1) Download the Spring Tools Suite(sts) from the official website and docker desktop.
2) Download the JDK 1.8.0_241 from the official website and set the java environment variables(JAVA_HOME and PATH).
3) Download the h2 browser from official website and login into the Generic H2(Server) from h2 console using credentials username:sa and password:tisadmin
4) Clone this project into the sts and setup buildpath with this jdk library.
5) Run the maven build for this project by goals setting as (clean compile install) by user setting as settings.xml, and also by using embedded maven runtime.
6) To run the application locally we have login to the database and run the application as spring boot application. 
7) There are 3 api's /userById/{userid} , /collectRandomCat/{userid}, /findAllCatsByUserId/{userid} with the baseurl(localhost:8080) and pass the userid by postman we can see the json output.
8) Once the maven build is successful once again run the maven build for this project by goals setting as (docker:build) by user setting as settings.xml, and also by using embedded maven runtime. So the jar file and the DockerFile gets generated under the target/docker folder of the project.
9) Finally we run our application in the docker using the command(docker run -it -p 9999:8080 cat-gif). Here we can connect this application using baseurl(localhost:9999) in the browser/postman. we have to run this command in the folder where the generated jar file from maven build(point 8) is present.
