CREATE TABLE public.service_users (
  user_id SERIAL,
  login VARCHAR(200) NOT NULL,
  password VARCHAR(200) NOT NULL,
  PRIMARY KEY (user_id)
);