# app-direct-isv-bv
App Direct Integration project

## Welcome to my integration project with AppDirect!
Let's dive in!

### About
The app is minimal integration of AppDirect's APIs and includes the following: <br />
Spring-based web application using Spring Boot <br />
OAuth 1.0 signing of outbound requests to AppDirect <br />
OAuth 1.0 one-legged authentication of incoming requests from AppDirect (locally only. See *NOTE below)<br />
Mysql persistant database <br />
The app is live at https://stormy-savannah-85494.herokuapp.com/ <br />

### End Points implemented:
Subscription Create Notification URL <br />
Subscription Cancel Notification URL <br />
Subscription Change Notification URL  <br />
User Assignment Notification URL <br />
User Unassignment Notification URL <br />

To use the live app, I'd have to assign you as a user of the application. 
If you'd like access, email me and I will include you as a user. 

*Note: works only when running the app locally, not when deployed on heroku. Currently it is not enabled in live version. <br />
 To try it locally just rename these 2 files back to java: <br />
 `app-direct-isv-bv\src\main\java\com\bvarba\appdirect\web\InMemoryConsumerDetailsServiceConfig.RENAME_TO_JAVA`<br />
 `app-direct-isv-bv\src\main\java\com\bvarba\appdirect\web\OAuthConfig.jRENAME_TO_JAVA`<br />

Or ofcourse you can run it yourself, see bellow:

### Running Requirements
* Java 8
* A mysql instance running at `localhost:3306` with username `app_direct_user` and password: `<YOUR_PASSWORD>`

configure the `application.properties` with the username and password:
spring.datasource.username=app_direct_user<br />
spring.datasource.password=`<YOUR_PASSWORD>` <br />

### Running the application - Command-line
configure the `application.properties` with you App Direct secret and key:
config.key=<YOUR_KEY>
config.secret=<YOUR_SECRET>

* gradlew startApp

### Detailed Instructions
1. First make sure Mysql is installed. (Windows: https://dev.mysql.com/doc/workbench/en/wb-installing-windows.html)
2. Create user: app_direct_user on the mysql instance
3. Start the mysql instance
4. Run the Database create script /mysql/createDB.sql on the mysql instance. This will create app_direct_isv database and assign rights to app_direct_user
5. To create the database from model, make sure in aplication.properties, 
spring.jpa.hibernate.ddl-auto=create is set to create. Then start the application, from root folder: gradlew startApp. (or set it to update afterwords)
7. Stop the application. Now The database is created.To have persistance: any Subsequent runs change: spring.jpa.hibernate.ddl-auto=none is set to none.
8. Restart the application
9. Test Integration Report from developer website

## Dev setup
To just build: `gradlew build`
Set up Eclipse with Spring Tools plugin.
you can run `gradlew clean` and `gradlew eclipse`

### Changing the default port
configure the application.properties with the username and password:
* By default, it starts on port `7789`.
* To change edit application.properties:
* server.port=<NEW_PORT_NUMBER>

