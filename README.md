# Building OAuth 2 Authentication services with Spring Security and OAuth2 
---------------------------------------------------------------------------

Process to deploy application in server:
==================================================

1. Download/Clone the application in to your machine.
2. Unzip the application in to a directory.
3. Open the IDE - Eclipse/Intellij/RAD/Net Beans and import the project using <b>"Existing Maven Projects".</b> 
4. Resolve all errors by importing jars, setting build path, JRE and Maven dependencies. 
5. Clean the project and deploy on tomcat (web) server. 


The flow of application as follows:
-----------------------------------
<b>1) Refresh_Token:</b><br/>
	User sends a GET request to server with five parameters: <b>grant_type, client_id, client_secret, username, password</b> ; as per configuration in spring-security.xml. Server validates the user credentials with help of spring security, and if the user is authenticated, OAuth generates a refresh token and send sends back to user in following format.<br/>

<i>Input:</i> http://<hostname>:<port>/WebServices/oauth/token?grant_type=password&client_id=myRestClinetId&client_secret=myrestapp&username=ganesh&password=123@java
<br/><i>Output:</i>
{
	"value": "69f0992d-8996-4b61-bac3-990768af9442",		
	"expiration": 1524143144895,
	"tokenType": "bearer",
	"refreshToken": {
		"value": "92efa63d-21f0-4168-af1e-ff56d4e7acf0",	-> <b> Refresh - Token </b>
		"expiration": 1524143384894
	},
	"scope": [
		"read",
		"write",
		"trust"
	],
	"additionalInformation": {},
	"expiresIn": 59,
	"expired": false
}
<br/>
<b>2) Access_Token:</b>
	Server validates the <b>refresh_token</b> with help of spring security (InMemory/Database/Ldap store), and if the "refresh token" is authenticated, OAuth generates a "access token" and send sends back to user in following format.<br/>
	
<i>Input:</i> http://<hostname>:<port>/WebServices/oauth/token?grant_type=refresh_token&client_id=myRestClinetId&refresh_token=92efa63d-21f0-4168-af1e-ff56d4e7acf0
<br/><i>Output:</i>
{
	"value": "4aa9f305-bae6-48c1-843f-427667826970",		-> <b> Access - Token </b>
	"expiration": 1524143169140,
	"tokenType": "bearer",
	"refreshToken": {
		"value": "92efa63d-21f0-4168-af1e-ff56d4e7acf0",
		"expiration": 1524143384894
	},
	"scope": [
		"read",
		"write",
		"trust"
	],
	"additionalInformation": {},
	"expiresIn": 59,
	"expired": false
}
<br/>

<br/>
<b>3) RESULT:</b>
	Server validates the <b>access_token</b> with help of spring security (InMemory/Database/Ldap store), and if the "access token" is authenticated, it will provide access to rest controller, search for URL pattern, executes the logic and send back the result to user as per given format below.<br/>
	
<i>Input:</i> http://<hostname>:<port>/WebServices/user/list?access_token=4aa9f305-bae6-48c1-843f-427667826970
<br/><i>Output:</i><br/>
[
	{
		"username": "ABC",
		"emailId": "abc@gmail.com",
		"mobileNo": "99999999"
	},
	{
		"username": "EFG",
		"emailId": "efg@gmail.com",
		"mobileNo": "88888888"
	},
	{
		"username": "HIJ",
		"emailId": "hij@gmail.com",
		"mobileNo": "77777777"
	},
	{
		"username": "klm",
		"emailId": "KLM@gmail.com",
		"mobileNo": "66666666"
	}
]
