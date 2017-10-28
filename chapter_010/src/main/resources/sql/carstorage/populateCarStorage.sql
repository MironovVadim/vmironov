INSERT INTO public.users (nickname, login, password, created_date) VALUES ('root', 'root', 'root', now());
INSERT INTO public.users (nickname, login, password, created_date) VALUES ('user', 'user', 'user', now());
INSERT INTO public.cars (user_id, mark, model, release_year, mileage, body_type, color, engine_capacity,
                         engine_type, power, cost, description, is_sold, created_date) VALUES (
  (SELECT id FROM public.users WHERE login = 'root'), 'Toyota', 'Prius', 2014, 2000, 'Sedan',
                                                      'Red', 1.5, 'Hybrid', 300, 7000,
  'Car in great condition.', FALSE, now());
INSERT INTO public.cars (user_id, mark, model, release_year, mileage, body_type, color, engine_capacity,
                         engine_type, power, cost, description, is_sold, created_date) VALUES (
  (SELECT id FROM public.users WHERE login = 'user'), 'Ford', 'Focus', 2015, 4000, 'Sedan',
                                                      'Red', 1.5, 'Hybrid', 235, 10000,
  'Initial description', FALSE, now());
INSERT INTO public.comments (description, created_date, user_id, car_id) VALUES (
    'First comment', now(), (SELECT id FROM public.users WHERE login = 'user'),
    (SELECT id FROM public.cars WHERE mark = 'Toyota'));
INSERT INTO public.comments (description, created_date, user_id, car_id) VALUES (
  'Second comment', now(), (SELECT id FROM public.users WHERE login = 'root'),
  (SELECT id FROM public.cars WHERE mark = 'Toyota'))