# Worthreadingservice

The Worth Reading Service is a Java-based microservice managing the liking functionality for messages. \
It is a part of a larger application and provides RESTful APIs to handle likes on messages. \
This service utilizes GraalVM to build native images, enabling faster startup times and optimized performance.

### Runs on port 8005 with a MYSQL database on port 3306.

#### Run docker compose with the correct image for your machine to build application and database in container.

## API Endpoints

#### Toggle like: 
- PUT /like/toggleLike/{messageId}
- Header: userId 

#### Bulk check if messages is liked by this user: 
- GET /like/bulkIsLiked
- Header: userId 

#### Check if message is liked by this user: 
- GET /like/isLiked/{messageId}/{userId}
 
#### Get amount of likes on message: 
- GET /like/amount/{messageId}

#### Get users who liked message (Not fully implemented. Requires userservice 2 running on the local machine):
- GET /like/users/{messageId}

## Download docker image
#### Native x86-64 image:
- docker pull ghcr.io/chatgut/worthreadingservice:master

#### Native arm64 image:
- docker pull cchriss123/worthreadingservice:arm64

#### JVM image:
- docker pull cchriss123/worthreadingservice:jvm
