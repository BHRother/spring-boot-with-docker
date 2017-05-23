# Spring Boot running in Docker

This example shows how to install and run an application inside a Docker.

## About the project:

This project is a Spring Boot project using Gradle and docker plugin.<br/>
Inside the folder src/main/docker you can find the Dockerfile with all the instructions to push the tag to the Docker machine.

#### Versions:
* Spring Boot 1.5.3.RELEASE
* Spring 4.3.8.RELEASE
* Gradle 3.4.1 Embedded

## Installation

### Docker
First, you need to download and install the Docker:
https://www.docker.com/products/docker-toolbox

This is the easily way to install the Docker in your machine.

Follow the instructions and check the manual for more informations.

After you install, open the **Docker Quickstart terminal**, wait until finish some configurations and you can run the example:

`docker run hello-world `

And see the message of: `Hello from Docker!`

This is the first step to check if your docker is running.

**Hint:**

  You need to specify the environment variables, so add in your ~/.bash_profile:

`eval "$(docker-machine env default)" # Set environment variables`


**Docker Machine:**

You can easily check if the machine is running:

`docker-machine status` or `docker-machine ls`

If it's nto running or you want to recreate the machine, run:

`docker-machine create --driver virtualbox dev`

### Building the Application inside Docker

Run the following command to build and buildDocker:

`./gradlew build buildDocker`

After finish you can check if it's in the docker using:

`docker images`

Example:<br/>
`REPOSITORY____________________ TAG __________ IMAGE ID ___ CREATED ______ SIZE`<br/>
`github/spring-boot-with-docker 0.0.1-SNAPSHOT fc00736dd9ae 44 minutes ago 681MB`

To run this tag now:

`docker run -p 8080:8080 -t github/spring-boot-with-docker:0.0.1-SNAPSHOT`

* `-p <internal_port>:<external_port>` - Map the internal port the application is using to expose to a external port.
* `-t <repository>:<tagname>` - Repository Name + TAG version, if not specified the TAG, *latest* is the default


Now try to access in your browser:

`http://localhost:8080/hello/Docker`


#### Not accessing

If for some reason, your localhost:8080 is not accessible outside the docker, open your VirtualBox or machine that is running.

* Settings -> Network<br/>
  Attached to: NAT<br/><br/>
* Advanced -> Port Forwarding<br/>
  Protocol: TCP, Host Port: 8080, Guest Port: 8080. (leave Host IP and Guest IP empty)

