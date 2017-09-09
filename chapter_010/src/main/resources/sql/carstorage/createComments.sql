CREATE TABLE public.comments
(
    id SERIAL NOT NULL,
    user_id INT NOT NULL REFERENCES public.users(id),
    car_id INT NOT NULL REFERENCES public.cars(id),
    description VARCHAR(100),
    created_date TIMESTAMP DEFAULT now(),
  PRIMARY KEY (id, user_id, car_id)
);