# Proyecto Final – Problema de Transporte  
**Investigación de Operaciones 1**

## 1. Planteamiento del Problema y Contexto
Este proyecto desarrolla un sistema interactivo para resolver el **problema clásico de transporte**, cuyo objetivo es minimizar el costo total de distribuir productos desde varias fábricas hacia diferentes destinos.  

La aplicación fue implementada en **Java**, utilizando **Swing** para la interfaz gráfica. Forma parte del curso de Investigación de Operaciones 1 y permite ingresar datos como número de fábricas, destinos, costos, oferta y demanda.  

Actualmente, el sistema implementa completamente el **Método de Aproximación de Vogel**, mientras que el método de **Esquina Noroeste** aparece en la interfaz como opción, pero no está desarrollado.

---

## 2. Formulación Matemática del Modelo

Sea:  
- \(x_{ij}\): cantidad enviada de la fábrica *i* al destino *j*  
- \(c_{ij}\): costo unitario  
- \(a_i\): oferta en fábrica *i*  
- \(b_j\): demanda en destino *j*

### **Función Objetivo**
\[
\min Z = \sum_{i=1}^{m} \sum_{j=1}^{n} c_{ij} x_{ij}
\]

### **Restricciones**
- **Oferta por fábrica**  
\[
\sum_j x_{ij} = a_i
\]
- **Demanda por destino**  
\[
\sum_i x_{ij} = b_j
\]
- **No negatividad**  
\[
x_{ij} \ge 0
\]

El sistema usa dos heurísticas iniciales:
- **Método de la Esquina Noroeste** (no implementado)  
- **Método de Vogel**: selecciona asignaciones según penalizaciones por fila y columna.

---

## 3. Desarrollo del Software

### **Arquitectura (MVC)**
- **Modelo:** `Vogel.java`, que implementa el algoritmo de aproximación de Vogel.  
- **Controlador:** `Gestor.java`, coordina las vistas y la ejecución del algoritmo.  
- **Vistas:**  
  - `VistaPrincipal.java`: selección de parámetros y método.  
  - `VistaTabla.java`: ingreso de costos, oferta y demanda, y visualización de resultados.

### **Características del Sistema**
- Interfaz desarrollada en **Swing**.  
- Permite configurar hasta **6 fábricas × 6 destinos**.  
- Construye tablas dinámicas para entrada de datos.  
- Ejecuta el método de Vogel y muestra la matriz de asignación resultante y su costo total.  
- No utiliza librerías externas.

---

## 4. Resultados y Análisis

Ejemplo de ejecución (2 fábricas × 2 destinos):

- **Oferta:** [100, 150]  
- **Demanda:** [120, 130]  
- **Costos:**  [10 20]

El método de Vogel genera una asignación inicial y un costo aproximado de **4750 unidades monetarias**.

### **Limitaciones observadas**
- El método de Esquina Noroeste aún no está implementado.  
- No hay validación avanzada de entrada ni verificación de balance oferta–demanda.  
- Solo se aceptan valores enteros.  
- La aplicación no guarda ni exporta resultados.  

---

## 5. Conclusiones y Recomendaciones

### **Conclusiones**
- La arquitectura **MVC** facilitó la modularidad del proyecto.  
- Swing permitió crear una interfaz sencilla pero funcional.  
- El método de Vogel está correctamente implementado y produce soluciones iniciales razonables.

### **Recomendaciones**
- Implementar el método de Esquina Noroeste para comparación.  
- Agregar validación de datos y manejo de excepciones.  
- Incluir métodos como **Stepping-Stone** para obtener soluciones óptimas.  
- Modernizar la interfaz con **JavaFX**.  
- Permitir exportación de resultados a archivos CSV o PDF.  
- Añadir pruebas unitarias (JUnit).  
- Documentar el código con **Javadoc**.

---



