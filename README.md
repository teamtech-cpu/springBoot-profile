# springBoot-profile
CommandLineRunner interface

      - we can execute any task just before spring boot finishes its startup

      - public void run(String...s) { }

 

ApplicationRunner interface

      - we can execute any task just before spring boot finishes its startup

      - public void run(ApplicationArgument a) { }

 

@SpringBootApplication

@Order(value=2)

public class SpringBootProjectApplication implements CommandLineRunner{

             

              protected final static Log logger=LogFactory.getLog(SpringBootProjectApplication.class);

 

              public static void main(String[] args) {

                             SpringApplication.run(SpringBootProjectApplication.class, args);

                             logger.info("Inside main method");

              }

 

              @Override

              public void run(String... args) throws Exception {

                             logger.info("Inside CommandLineRunner method");

              }

 

}

 

 

@Component

@Order(value=3)

public class CommandLineRunner1 implements CommandLineRunner{

 

              protected final static Log logger=LogFactory.getLog(CommandLineRunner1.class);

             

              @Override

              public void run(String... args) throws Exception {

                  logger.info("Inside CommandLineRunner1 method");

              }

 

}

 

 

@Component

@Order(value=1)

public class CommandLineRunner2 implements CommandLineRunner{

 

    protected final static Log logger=LogFactory.getLog(CommandLineRunner2.class);

             

              @Override

              public void run(String... args) throws Exception {

                  logger.info("Inside CommandLineRunner2 method");

              }

 

}

 

Spring Boot Profiling

     - In enterprise appl, we have many env like dev, qa, prod etc and each env requires specific configuration related to that env

 

1. we create env related properties file (ie) application-envname.properties

2. spring.profiles.active=envname, it will invoke particular profile

 

@Value - used to read the info from application.properties

 

@Profile - used to programtically control files

 

message=Welcome default user

spring.profiles.active=prod

 

message=Welcome development User

server.port=8081

 

message=Welcome Production user

server.port=8082

 

@RestController

public class ProfileController {

             

              @Value("${message}")

              private String msg;

 

              @GetMapping("/message")

              public String getMessage() {

                             return msg;

              }

}

 

 

@Configuration

@Profile("prod")

public class AppConfig {

        @PostConstruct

              public void print() {

                             System.out.println("This application will be executed only in production profile");

              }

}

 

 

application.properties

1. It stores data in sequential format in key value pairs

server.port=1000

spring.profiles.active=dev

 

2. This file specifically used in Java lang

 

3. supports only key value pairs only in the form of String

 

4. If we want to handle multiple profiles then we need to create different properties files

 

application.yml

1. It stores data in hierarchial format

server:

   port: 1000

 

spring:

   profiles:

      active: dev

 

2. This file will be used by many lang like Java, Python etc

 

3. supports key value pairs, map, list, scalar type

 

4. All files related to the multiple profiles can be handled in a single yml file

 

@ConfigurationProperties - used to map its resources from the properties files to the java bean object

 

@PropertySource - used to read single custom property

@PropertySources - used to read multiple custom property

 

student.properties

student.name=Ram

student.age=24

student.address=chennai

 

student1.properties

student.email=ram@gmail.com

student.course=IT

 

@Configuration

@ConfigurationProperties(prefix="student")

//@PropertySource("classpath:student.properties")

//@PropertySource("file:\\C:\\Training\\student1.properties")

@PropertySources({

              @PropertySource("classpath:student.properties"),

              @PropertySource(file:\\C:\\Training\\student1.properties)

})

@Getter

@Setter

public class StudentProps {

     private String name;

     private Integer age;

     private String address;

     private String email;

     private String course;

}

 

 

@RestController

public class StudentController {

             

              @Autowired

              StudentProps student;

 

              @GetMapping("/student")

              public String getStudentInformation() {

                             return student.getAddress()+" "+student.getEmail();

              }

}

 

@Value

1. injecting properties one by one

2. Loose binding/loose grammar not supported (ie) attribute name should be matching

3. SpEL is used in @Value

4. Validation is not supported

5. support only scalar datatypes

 

@ConfigurationProperties

1. Bulk injection of properties

2. Loose binding is supported (ie) special characters and cases

3. Dosent support SpEL

4. Validation is supported

5. support all type of datatypes

 

                <dependency>

                                           <groupId>org.hibernate.validator</groupId>

                                           <artifactId>hibernate-validator</artifactId>

                                           <version>6.0.5.Final</version>

                             </dependency>

                             <dependency>

                                           <groupId>javax.validation</groupId>

                                           <artifactId>validation-api</artifactId>

                                           <version>2.0.0.Final</version>

                             </dependency>

 

@Validated - to do validation of property file

@Valid - to do validation for nesting of properties

 

#scalar datatype

mail.to=abc@gmail.com

mail.from=xyz@gmail.com

mail.age=34

 

#complex type

mail.cc=pqr@gmail.com,mno@gmail.com

mail.bcc=efg@gmail.com,klm@gmail.com

 

#nested type

mail.credential.username=ramu

mail.credential.password=abcd1234

 

 

@Configuration

@ConfigurationProperties(prefix="mail")

@PropertySource("classpath:mail.properties")

@Getter

@Setter

@Validated

public class MailProps {

              @NotBlank

              private String to;

              private String from;

              @Min(value=20)

              @Max(value=40)

              private Integer age;

             

              private String[] cc;

              private List<String> bcc;

             

              @Valid

              private Credential credential=new Credential();

             

              class Credential {

                             @NotBlank

                             private String username;

                             @Size(max=8,min=4)

                             private String password;

                             public String getUsername() {

                                           return username;

                             }

                             public void setUsername(String username) {

                                           this.username = username;

                             }

                             public String getPassword() {

                                           return password;

                             }

                             public void setPassword(String password) {

                                           this.password = password;

                             }

              }

 

}

 

 

Spring Boot - Interceptors

    - used to intercept client request and process them

    - similar to filters, but interceptors is only applied to request that are sending to controller

    - Implement HandlerInterceptor - 3methods

     - preHandle() - perform operation before sending request to controller

     - afterCompletion() - perform operation after completing the request and response

     - postHandle() - perform operation before sending repsonse to client
