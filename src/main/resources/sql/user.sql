CREATE TABLE users(
	id SERIAL PRIMARY KEY,
	email VARCHAR(100) UNIQUE NOT NULL,
	password VARCHAR(255) NOT NULL,
	name VARCHAR(100) NOT NULL,
	roles VARCHAR(100)
);
