# Worthreadingservice

### Runs on port 8005 with with a MYSQL database on port 3306.

* Native arm64 native image:\
docker pull cchriss123/worthreadingservice:1.0.0

* Regular JVM version image\
docker pull ghcr.io/chatgut/worthreadingservice:latest\

Running with Docker Compose\
docker-compose up



You can also use Docker Compose to run the application along with its MySQL database dependency.
This will start the service on port 8005 and the MySQL database on port 3306.

# API Endpoints

Toggle Like: PUT /like/toggleLike/{messageId}
Bulk Check: GET /like/bulkIsLiked
Is Liked: GET /like/isLiked/{messageId}/{userId}
Get Likes: GET /like/amount/{messageId}
Users who Liked: GET /like/users/{messageId}

























The Worth Reading Service is a Java-based microservice managing the liking functionality for messages. \
It is a part of a larger application and provides RESTful APIs to handle likes on messages.

# Features

Toggle likes for a specific message by a user\
Bulk check if a list of messages is liked by a user\
Check if a specific message is liked by a user\
Get the total number of likes for a specific message\
Get a list of users who liked a specific message
