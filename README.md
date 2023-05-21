# Worthreadingservice

The Worth Reading Service is a Java-based microservice managing the liking functionality for messages. \
It is a part of a larger application and provides RESTful APIs to handle likes on messages.

### Runs on port 8005 with a MYSQL database on port 3306.

### Run docker compose with the correct image for your machine to build application and database in container

## API Endpoints

#### Toggle Like: 
- PUT /like/toggleLike/{messageId}

#### Bulk Check: 
- GET /like/bulkIsLiked

#### Is Liked: 
- GET /like/isLiked/{messageId}/{userId}
 
#### Get Likes: 
- GET /like/amount/{messageId}

#### Users who Liked: 
- GET /like/users/{messageId}

## Download docker image
#### Native x86-64 image:
- docker pull ghcr.io/chatgut/worthreadingservice:master

#### Native arm64 image:
- docker pull cchriss123/worthreadingservice:arm64

#### JVM image
- docker pull cchriss123/worthreadingservice:jvm
