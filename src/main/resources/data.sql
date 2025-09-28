--TIENDAS
INSERT INTO public.tiendas VALUES (1, 'Avila')
ON CONFLICT (codigo) DO NOTHING;
INSERT INTO public.tiendas VALUES (2, 'Valencia')
ON CONFLICT (codigo) DO NOTHING;
INSERT INTO public.tiendas VALUES (3, 'Bilbao')
ON CONFLICT (codigo) DO NOTHING;

--TRABAJADORES
INSERT INTO public.trabajadores VALUES ('70896574S', 'Gomez', 8, 'Irene', 1)
ON CONFLICT (dni) DO NOTHING;
INSERT INTO public.trabajadores VALUES ('70336574S', 'Jimenez Sanchez', 8, 'Diego', 3)
ON CONFLICT (dni) DO NOTHING;
INSERT INTO public.trabajadores VALUES ('70336574T', 'Jimenez Perez', 8, 'Irene Actualizada', 1)
ON CONFLICT (dni) DO NOTHING;

--SECCIONES
INSERT INTO public.secciones VALUES (1, 8, 'Horno', 1)
ON CONFLICT (codigo) DO NOTHING;
INSERT INTO public.secciones VALUES (2, 16, 'Drogueria', 1)
ON CONFLICT (codigo) DO NOTHING;
INSERT INTO public.secciones VALUES (3, 16, 'Cajas', 1)
ON CONFLICT (codigo) DO NOTHING;
INSERT INTO public.secciones VALUES (4, 16, 'Pescaderia', 1)
ON CONFLICT (codigo) DO NOTHING;
INSERT INTO public.secciones VALUES (5, 16, 'Verduras', 1)
ON CONFLICT (codigo) DO NOTHING;

--ASIGNACIONES
INSERT INTO public.asignaciones VALUES (1, 8, 1, '70896574S')
ON CONFLICT (codigo) DO NOTHING;
INSERT INTO public.asignaciones VALUES (2, 8, 2, '70336574T')
ON CONFLICT (codigo) DO NOTHING;
