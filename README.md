# prueba
Prueba técnica de un proyecto Spring Boot que incluye:
- Creación de una base de datos H2
- Creación de un endpoint REST de consulta (GET)
- Test unitarios JUnit

El endpoint apunta a la ruta "/precio?applicationDate={applicationDate}&brandId={brandId}&productId={productId}", cuyos parámetros son:
- applicationDate: fecha de aplicación en formato "YYYY-MM-DDThh:mm:ss"
- brandId: identificador de la cadena
- productId: identificador de producto

La respuesta a una petición GET genera un JSON con los siguientes datos:
- productId: identificador de producto
- brandId: identificador de la cadena
- priceList: identificador de la tarifa de precios aplicable
- startDate: fecha de inicio de aplicación del precio
- endDate: fecha de finalización de aplicación del precio
- price: precio final de venta para las fechas indicadas
