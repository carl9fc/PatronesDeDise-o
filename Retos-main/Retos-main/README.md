# Taller profesional de patrones de diseño — Java + Maven

## Objetivo
Resolver nueve retos de ingeniería de software usando patrones GoF, con pruebas unitarias JUnit 5. Los escenarios son profesionales: notificaciones empresariales, generación de reportes, configuración compartida, integración de proveedores, cálculo de tarifas, checkout, pagos, alertas y ciclo de vida de solicitudes.



## Requisitos
- JDK 17 o superior
- Apache Maven 3.9 o superior
- IDE opcional: IntelliJ IDEA, Eclipse o VS Code

## Ejecutar
Desde la carpeta de cada proyecto:
```bash
mvn clean test
```
En `Retos`, se espera que algunas pruebas fallen inicialmente.

## Retos por categoría

### Creacionales
1. **Factory Method — Enrutamiento de notificaciones:** crear notificadores Email y SMS según el canal solicitado, sin acoplar al cliente a clases concretas.
2. **Builder — Generación de reporte ejecutivo:** construir reportes con título, periodo y secciones opcionales, validando campos obligatorios.
3. **Singleton — Configuración de plataforma:** mantener una única instancia de configuración de plataforma en la JVM.

### Estructurales
4. **Adapter — Pasarela de pagos externa:** adaptar una API heredada que expresa el importe en centavos a una interfaz interna que recibe pesos.
5. **Decorator — Tarifas de envío:** añadir seguro y entrega prioritaria al costo base sin crear una clase por combinación.
6. **Facade — Proceso de checkout:** coordinar inventario, pago y emisión de confirmación desde una operación de alto nivel.

### Comportamiento
7. **Strategy — Cálculo de tarifa de envío:** intercambiar estrategias de tarifa estándar, exprés y nocturna en tiempo de ejecución.
8. **Observer — Alertas de umbral de inventario:** notificar suscriptores cuando el stock llega al umbral configurado.
9. **State — Ciclo de vida de solicitud:** controlar transiciones válidas entre RECIBIDA, EN_REVISION, APROBADA y RECHAZADA.

## Entregables y criterios sugeridos
No uses `System.out.println` como mecanismo de lógica de negocio. 
Mantén la lógica testeable y lanza excepciones claras ante entradas o transiciones inválidas.
