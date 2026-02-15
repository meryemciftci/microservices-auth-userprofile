# Auth & User Profile Microservices

Spring Boot ve Spring Cloud ile geliştirilmiş basit bir authentication ve user profile microservices yapısı.

## Services
Auth Service (9090) → Register & Login, PostgreSQL, Register sonrası User Service çağırır (Feign)  
User Profile Service (9091) → Kullanıcı profil verileri, MongoDB + Redis Cache  
Config Server (8888) → Merkezi config yönetimi (Git tabanlı)

## Endpoints
POST /dev/v1/auth/register  
POST /dev/v1/auth/login  
POST /dev/v1/user-profile/create-user  
GET  /dev/v1/user-profile/get-all  

## Tech Stack
Spring Boot • Spring Cloud • OpenFeign • PostgreSQL • MongoDB • Redis • Gradle • Docker • Java 21

## Run
```bash
git clone https://github.com/YOUR_USERNAME/microservices-auth-userprofile.git
cd microservices-auth-userprofile
./gradlew :ConfigServer:bootRun
./gradlew :AuthMicroservice:bootRun
./gradlew :UserMicroservice:bootRun
```

## Swagger
http://localhost:9090/swagger-ui.html  
http://localhost:9091/swagger-ui.html  

## Docker
```bash
docker build -t auth-service ./AuthMicroservice
docker build -t user-service ./UserMicroservice
docker build -t config-server ./ConfigServer
```


