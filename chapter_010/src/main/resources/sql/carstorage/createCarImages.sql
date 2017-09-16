CREATE TABLE public.images
(
    id SERIAL PRIMARY KEY NOT NULL,
    car_id INT REFERENCES public.cars(id),
    image BYTEA
);