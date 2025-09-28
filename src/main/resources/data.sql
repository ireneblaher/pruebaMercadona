--TIENDAS
INSERT INTO public.tiendas VALUES (1, 'Avila');
INSERT INTO public.tiendas VALUES (2, 'Valencia');
INSERT INTO public.tiendas VALUES (3, 'Bilbao');

--TRABAJADORES
INSERT INTO public.trabajadores VALUES ('70896574S', 'Gomez', 8, 'Irene', 1);
INSERT INTO public.trabajadores VALUES ('70336574S', 'Jimenez Sanchez', 8, 'Diego', 3);
INSERT INTO public.trabajadores VALUES ('70336574T', 'Jimenez Perez', 8, 'Irene Actualizada', 1);

--SECCIONES
INSERT INTO public.secciones VALUES (1, 8, 'Horno', 1);
INSERT INTO public.secciones VALUES (2, 16, 'Drogueria', 1);
INSERT INTO public.secciones VALUES (3, 16, 'Cajas', 1);
INSERT INTO public.secciones VALUES (4, 16, 'Pescaderia', 1);
INSERT INTO public.secciones VALUES (5, 16, 'Verduras', 1);

--ASIGNACIONES
INSERT INTO public.asignaciones VALUES (1, 8, 1, '70896574S');
INSERT INTO public.asignaciones VALUES (2, 8, 2, '70336574T');
