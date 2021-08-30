Created Banking application in java using spring boot and used h2 as a database and check the api's using postman.

How to run the application
Go to the folder of the application .
Right click on it and click on spring boot app .
It will be displayed in console and the port is running in 8080.
Open the google chrome and type localhost:8080/h2-console and type the jdbc url which is available in your console and click the  connect button .Now the database is ready to use.
Open the postman and type the url and select the https methods and check the api's.
Save the account details - Method - Post, Url:localhost:8080/create,parameters:firstname,lastname,username,password
Deposit Method - Post ,Url:localhost:8080/deposit,parameters:accountid,deposit.
Withdraw Method - Post,Url:localhost:8080/withdraw,parameters:accountid,withdraw.
ViewBalance Method- Get,Url:localhost:8080/viewbalance/{accountid}.
