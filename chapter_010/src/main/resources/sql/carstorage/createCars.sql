CREATE TABLE public.cars
(
    id SERIAL PRIMARY KEY NOT NULL,
    user_id INT REFERENCES public.users(id),
    mark VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    release_year INT NOT NULL,
    mileage INT NOT NULL,
    body_type VARCHAR(50) NOT NULL,
    color VARCHAR(50) NOT NULL,
    engine_capacity DOUBLE PRECISION NOT NULL,
    engine_type VARCHAR(50) NOT NULL,
    power INT NOT NULL,
    cost  INT NOT NULL,
    is_sold BOOLEAN DEFAULT FALSE,
    description VARCHAR(1000),
    created_date TIMESTAMP DEFAULT now()
);