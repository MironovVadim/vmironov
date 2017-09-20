CREATE TABLE public.comments
(
    id SERIAL NOT NULL PRIMARY KEY,
    user_id INT NOT NULL REFERENCES public.users(id),
    car_id INT NOT NULL REFERENCES public.cars(id),
    description VARCHAR(1000),
    created_date TIMESTAMP DEFAULT now()
);