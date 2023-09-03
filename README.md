# Bookmark
Spring Boot + Kubernetes Deployment
Rest API using spring boot
Run app locally using docker-compose
Deploy app on Kubernetes

To Dockerize images, run the following command:``` ./mvnw spring-boot:build-image.```
Instead of Dockerizing and creating Docker images using the Maven plugin, we can utilize multi-level Dockerization through a Dockefile


![Capture](https://github.com/fatemehSalem/Bookmark/assets/42536170/9636d94c-0096-4c6f-9d27-7500dc3b211d)
Then :``` docker run -p 8080:8080 yourimagename:tag```


```xml
<build>
        <plugins>
                <plugin>
                        <groupId>com.google.cloud.tools</groupId>
                        <artifactId>jib-maven-plugin</artifactId>
                        <version>4.2.0</version>
                        <configuration>
                                <from>
                                        adoptopenjdk:17-jre
                                </from>
                                <to>
                                        <image>ftmhslm/bookmarker</image>
                                        <tag>latest</tag>
                                        <tag>0.0.1</tag>
                                </to>
                                <container>
                                        <ports>
                                                8080
                                        </ports>
                                </container>
                        </configuration>
                </plugin>
        </plugins>
</build>
```

                 

for Jib maven Plugin tool to use your docker image , the following pattern is recommended:
1_ add the configs of Jib dependency on your pom.xml :

2_ run this command:``` ./mvnw jib:build```

