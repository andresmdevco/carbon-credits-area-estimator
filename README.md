# 🌿 Estimador de Área para Créditos de Carbono

Aplicación de escritorio en Java desarrollada como caso de estudio académico, enfocada en la problemática de empresas dedicadas a la identificación y comercialización de créditos de carbono en regiones de bosque nativo en Colombia. La herramienta permite estimar áreas de bosque dentro de zonas evaluadas mediante el dibujo y análisis de figuras geométricas sobre imágenes satelitales o aéreas, facilitando así el cálculo y la validación de créditos de carbono.

## 🎬 Demo de la aplicación
https://github.com/user-attachments/assets/f9c17da9-a33a-470e-9c6d-dd7c8f09a182

## 📖 Contexto del Problema

Un **crédito de carbono** es un certificado digital que acredita que un proyecto ambiental evitó la emisión de 1 tonelada de CO₂ en un año determinado. Este software fue desarrollado como caso de estudio académico inspirado en la problemática real de empresas como Cataruben que operan en Colombia.

Para definir la cantidad de créditos de carbono comercializables, es necesario calcular el área de bosque nativo disponible en un terreno. El método actual consiste en enviar personas al área a delimitar físicamente cada zona de bosque nativo con cinta de seguridad, lo cual presenta dos problemas:

- ⏳ **Lento**: evaluar una pequeña área (1 Ha) puede tomar hasta una semana
- ❌ **Propenso a errores**: no existe un método de validación, lo que genera dependencia total del criterio del evaluador

La solución propuesta es utilizar un **dron** para capturar imágenes del área y, mediante este software, permitir que un experto identifique las zonas evaluadas y las áreas de bosque nativo, calculando el porcentaje facturable como créditos de carbono.

## 📋 Descripción de la Aplicación

Esta herramienta permite al evaluador dibujar figuras geométricas sobre imágenes tomadas por dron para delimitar dos tipos de zonas:


- 🔵 **Figuras azules** — Representan el **área evaluada** (la zona total bajo análisis)
- 🔴 **Figuras rojas** — Representan las **zonas de bosque nativo** dentro del área evaluada

La aplicación calcula qué porcentaje del área evaluada corresponde a bosque nativo, entregando un estimado del área facturable como créditos de carbono.

## ✅ Criterios de Aceptación

| Criterio | Estado |
|----------|--------|
| Se puede seleccionar una imagen JPG y se muestra en pantalla definiendo el área real evaluada | ✅ |
| Se puede seleccionar una figura según la región a marcar | ✅ |
| Se puede dibujar la figura seleccionada con el color elegido sobre la imagen | ✅ |
| Las figuras dibujadas se pueden guardar en un archivo en formato legible (JSON) | ✅ |
| Se puede obtener una estimación del área de bosque nativo como porcentaje final | ✅ |
| Los archivos guardados se pueden restaurar, editarse y recalcularse en cualquier momento | ✅ |

## ✨ Funcionalidades

- Cargar imágenes de fondo en formato JPG (fotos tomadas por dron) sobre el lienzo
- Dibujar figuras de forma interactiva: **Círculo, Elipse, Cuadrado, Rectángulo**
- Asignar colores (azul/rojo) a cada figura para definir el tipo de área
- Calcular el porcentaje de bosque nativo dentro del área evaluada
- Visualizar los resultados en una ventana dedicada con leyenda explicativa
- Guardar y cargar dibujos mediante serialización JSON (Jackson)

## 🏗️ Estructura del Proyecto

```
src/main/java/
├── com/mycompany/studycase1/
│   └── StudyCase1.java            # Punto de entrada de la aplicación
├── controllers/
│   ├── MainController.java        # Controlador del ciclo de vida de la app
│   └── FileController.java        # Carga de imágenes
├── DAO/
│   └── DrawablesDao.java          # Almacenamiento en memoria de las figuras
├── Drawable/
│   ├── Drawable.java              # Interfaz para figuras dibujables
│   ├── DrawableCircle.java        # Círculo dibujable
│   ├── DrawableEllipse.java       # Elipse dibujable
│   ├── DrawableRectangle.java     # Rectángulo dibujable
│   └── DrawableSquare.java        # Cuadrado dibujable
├── models/
│   ├── Shape.java                 # Modelo base de figura
│   ├── Circle.java                # Modelo círculo
│   ├── Square.java                # Modelo cuadrado
│   ├── Ellipse.java               # Modelo elipse
│   ├── Rectangle.java             # Modelo rectángulo
│   ├── ShapeArea.java             # Lógica de cálculo de áreas
│   ├── NativeForestArea.java      # Calculador de porcentaje de bosque nativo
│   ├── PointShape.java            # Detección de punto dentro de figura
│   ├── ShapeSerializer.java       # Serialización JSON (Jackson)
│   └── ShapeDeserializer.java     # Deserialización JSON (Jackson)
└── views/
    ├── MainWindow.java            # Ventana principal de la aplicación
    ├── MainPanel.java             # Lienzo interactivo de dibujo
    └── ResultWindow.java          # Ventana de visualización de resultados
```

## 📐 Cómo Funciona el Cálculo de Área

La lógica principal en `NativeForestArea.java` opera de la siguiente manera:

1. Itera sobre todas las figuras dibujadas en el lienzo
2. Identifica las **figuras azules** como el área evaluada y suma sus áreas
3. Por cada figura azul, identifica las **figuras rojas** que se encuentran **dentro** de ella y suma sus áreas
4. Retorna el porcentaje: `(área roja dentro del azul / área azul total) × 100`

Fórmulas de área utilizadas en `ShapeArea.java`:

| Figura      | Fórmula                     |
|-------------|-----------------------------|
| Círculo     | π × r²                      |
| Cuadrado    | π × (w/2)²                  |
| Elipse      | π × (w/2) × (h/2)           |
| Rectángulo  | ancho × alto                |

## ⚙️ Requisitos

- Java 22 o superior
- Apache NetBeans 12 o superior (recomendado)
- Maven 3.x (incluido en NetBeans)

## 🚀 Cómo Ejecutar el proyecto


### Opción 1: Apache NetBeans (recomendado)

1. Abrir Apache NetBeans
2. Ir a **File → Open Project** y seleccionar la carpeta del repositorio
3. NetBeans detectará automáticamente el proyecto Maven
4. Hacer clic en el botón **Run Project** (▶) o presionar `F6`

### Opción 2: Línea de comandos con Maven

**1. Clonar el repositorio**
```bash
git clone https://github.com/andresmdevco/carbon-credits-area-estimator.git
cd carbon-credits-area-estimator
```

**2. Compilar el proyecto**
```bash
mvn clean package
```

**3. Ejecutar la aplicación**
```bash
mvn exec:java
```



## 🔧 Dependencias

| Librería             | Versión | Uso                              |
|----------------------|---------|----------------------------------|
| jackson-core         | 2.17.1  | Procesamiento JSON               |
| jackson-databind     | 2.13.4  | Serialización de figuras         |

Las dependencias se descargan automáticamente mediante Maven al abrir o compilar el proyecto.

