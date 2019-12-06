USE my_transport_assistant;

INSERT INTO users(id, userName, password, firstName, lastName, enabled)
	SELECT 1, 'admin', 'pass','Cesar Francisco', 'Chavez Maldonado', 1
UNION ALL
	SELECT 2, 'visit', 'pass', 'John', 'Doe', 1;

INSERT INTO roles(id, name, description)
	SELECT 1, 'admin', 'Administrador'
UNION ALL
	SELECT 2, 'guest', 'Guest';


INSERT INTO modules(id, idrol, name, description)
	SELECT 1, 1, 'RoadDotCom', 'Ruta del camion'
UNION ALL
	SELECT 2, 1, 'BusArrivalRateDotCom', 'Tiempo de llegada del camion'
UNION ALL
	SELECT 3, 2, 'BusArrivalRateDotCom', 'Tiempo de llegada del camion';
