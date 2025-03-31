Inditex es un servicio de backend desarrollado utilizando los conceptos de "Arquitectura Hexagonal" o "Puertos y Adaptadores".
Se utiliza "Spring Boot" y "H2" como base de datos. Los datos de entrada de la base de datos se cargan desde el fichero data.sql.
La configuración de la aplicación se encuentra en el archivo application.properties. En este archivo, se configura la conexión a la base de datos H2 y otros parámetros de la aplicación.
El proyecto está estructurado en capas de acuerdo con la arquitectura hexagonal:
Dominio: Contiene la lógica de negocio de la aplicación, implementada usando los principios de DDD. Los componentes de dominio incluyen entidades, objetos de valor y agregados.
Aplicación: Define la API pública del dominio e independiza al dominio de cualquier elemento de infraestructura actual o futuro.
Adaptadores: Manejan la interacción con los puertos de la aplicación, como la base de datos y los servicios externos.
El proyecto utiliza varios bloques de construcción clave de DDD:
Entidades: Son objetos que tienen una identidad continua a lo largo del tiempo, incluso si sus atributos cambian.
Objetos de Valor: Son objetos que no tienen identidad y se describen únicamente por sus atributos. Los objetos de valor son inmutables.
Agregados: Un agregado es un cluster de objetos de dominio (entidades y objetos de valor) que pueden ser tratados como una sola unidad para fines de procesamiento de datos.
El proyecto incluye pruebas unitarias para validar el comportamiento visible de los componentes como si fueran una caja negra. 
Estos tests unitarios validan el contrato del API de los componentes. 
Además, se realizan pruebas de integración para verificar la funcionalidad de los adaptadores, como la base de datos y los servicios externos.
