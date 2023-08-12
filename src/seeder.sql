USE coffeedb;

DROP TABLE IF EXISTS users;

# CREATE TABLE users (
#                        id INT AUTO_INCREMENT PRIMARY KEY,
#                        username VARCHAR(50) NOT NULL,
#                        email VARCHAR(100) NOT NULL,
#                        password VARCHAR(255) NOT NULL
# );
INSERT INTO users (id, username, email, password)
VALUES (1, 'jimmy', 'test@test.com', 'password');


