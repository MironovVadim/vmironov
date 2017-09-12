CREATE TABLE public.users
(
    id SERIAL PRIMARY KEY NOT NULL,
    nickname VARCHAR(100) NOT NULL,
    login VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    created_date TIMESTAMP DEFAULT now()
);