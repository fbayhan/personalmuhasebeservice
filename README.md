# personalmuhasebeservice
Kişisel muhasebe app servise


Burası güncellenecek



https://medium.com/@hantsy/protect-rest-apis-with-spring-security-and-jwt-5fbc90305cc5


https://github.com/hantsy/springboot-jwt-sample


git clone https://github.com/fbayhan/personalmuhasebeservice


INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_PM');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');



localhost:8080/api/auth/signup 


{ 
	"name":"adminuser",
	"username":"adminuser",
	"email":"adminuser@a.com",
	"role":["admin"],
	"password":"123456" 

}

{ 
	"name":"pmuser",
	"username":"pmuser",
	"email":"pmuser@a.com",
	"role":["user", "pm"],
	"password":"123456" 

}



{ 
	"name":"user",
	"username":"user",
	"email":"user@a.com",
	"role":["user"],
	"password":"123456" 

}

{ 
	"name":"fatih",
	"username":"fatih",
	"email":"fatih-bayhan@windowslive.com",
	"role":["user"],
	"password":"123456" 

}

localhost:8080/api/auth/signin
{  
	"username":"user",
 	"password":"123456" 

}





{
    "tokenType": "Bearer",
    "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNTU0MzgzMTQ2LCJleHAiOjE1NTQ0Njk1NDZ9.x4Vh7-IUEhJaeeDNIfIVYQNz0nMJ0o_TOisT8ITY1Y9sa2g-PneZAOmB_cJB8LsNP_jxREF59I629_PPovfiyA"
}

localhost:8080/api/test/user

localhost:8080/api/test/pm






localhost:8080/api/everyone/addWageDay

{ 
 "id": "4",
 "dayOfWage": "7"

}















