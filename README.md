# app-direct-isv-bv
App Direct Integration project

### Welcome to my integration project with AppDirect!
Let's dive in!

## End Points implemented:
Subscription Create Notification URL
Subscription Cancel Notification URL
Subscription Change Notification URL 
User Assignment Notification URL
User Unassignment Notification URL

The project is currently hosted and running on my machine live and mapped to a dns.
All end points are mapped here:
http://bvarba.hopto.org:7789/api/developer/integration/v1/cancelSubscription?event={eventUrl}

and I can give you access to my dev account on AppDirect to run the Integration test.

## Running Requirements
* Java 8
* A mysql instance running at `localhost:3306` with username `app_direct_user` and password: `<YOUR_PASSWORD>`

configure the `application.properties` with the username and password:
spring.datasource.username=app_direct_user
spring.datasource.password=`<YOUR_PASSWORD>`

## Running the application - Command-line
* gradlew startApp -Pkey="<YOUR_KEY>" -Psecret="<YOUR_SECRET>"
  <YOUR_KEY> is AppDirect developer consumer key and 
  <YOUR_SECRET> is AppDirect developer cosumer secret

## Detailed Instructions

1. First make sure Mysql is installed. (Windows: https://dev.mysql.com/doc/workbench/en/wb-installing-windows.html)
2. Create user: app_direct_user on the mysql instance
3. Start the mysql instance
4. Run the Database create script /mysql/createDB.sql on the mysql instance. This will create app_direct_isv database and assign rights to app_direct_user
5. To start the application, from root folder: gradlew startApp -Pkey="<YOUR_KEY>" -Psecret="<YOUR_SECRET>".
6. Test Integration Report from developer website

### Changing the default port
configure the application.properties with the username and password:
* By default, it starts on port `7789`.
* To change edit pplication.properties:
* server.port=<NEW_PORT_NUMBER>

