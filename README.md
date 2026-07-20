![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# 💻 Evaluación Final Transversal (EFT) – Desarrollo Orientado a Objetos I

---

## 👤 Autor del proyecto
- **Nombre completo:** Jaime Seguel Retamales.
- **Sección:** Desarrollo Orientado a Objetos I, sección 005A.
- **Carrera:** Analista Programador.
- **Sede:** Online.

---

## 📘 Descripción general del sistema
Este proyecto corresponde a la **Evaluación Final Transversal (EFT)** (Semana 9) de la asignatura de *Desarrollo Orientado a Objetos I*. Este trabajo fue diseñado y estructurado como un proyecto independiente a las semanas pasadas.

La aplicación gráfica gestiona las operaciones integrales de la agencia de turismo "Llanquihue Tour". El sistema se divide en tres módulos principales:
1. **Gestión de Personal:** Registro y validación estricta de Proveedores (Transporte, Alojamiento), Guías Turísticos y Clientes, utilizando arquitectura de herencia.
2. **Gestión de Catálogo:** Administración de Servicios Turísticos individuales (Paseos Lacustres, Excursiones Culturales, Rutas Gastronómicas) y Paquetes Turísticos, aplicando uso de interfaces y polimorfismo.
3. **Gestión de Reservas:** Sistema automatizado para vincular clientes con los servicios o paquetes seleccionados, calculando automáticamente el precio final y emitiendo el comprobante detallado.

El programa implementa persistencia de datos almacenando todos los registros mediante archivos locales de texto plano (`.txt`), garantizando que la información se conserve entre las sesiones de uso.

---

## 🧱 Estructura general del proyecto

```plaintext
📁 src/com/llanquihuetour/
app/          # Paquete para la clase principal que inicializa el sistema.
└── Main.java
data/         # Paquete para clases de gestión de listas, persistencia y datos.
├── GestorCatalogo.java
├── GestorPersonas.java
└── GestorReservas.java
model/        # Paquete para clases del dominio, herencia e interfaces.
├── Cliente.java
├── Direccion.java
├── Empleado.java
├── ExcursionCultural.java
├── GuiaTuristico.java
├── PaqueteTuristico.java
├── PaseoLacustre.java
├── Persona.java
├── Proveedor.java
├── ProveedorAlojamiento.java
├── ProveedorTransporte.java
├── Registrable.java
├── Reserva.java
├── RutaGastronomica.java
└── ServicioTuristico.java
ui/           # Paquete para las ventanas visuales de la aplicación.
├── VentanaBienvenida.form
├── VentanaBienvenida.java
├── VentanaEmpresa.form
├── VentanaEmpresa.java
├── VentanaReservas.form
└── VentanaReservas.java
util/         # Paquete para utilidades extras y validaciones.
├── CargadorCombobox.java
├── GestorArchivos.java
├── RutInvalidoException.java
├── ValidadorGeneral.java
└── ValidadorRut.java

📁 src/resources/   # Recursos estáticos del sistema.
files/              # Archivos de texto plano (.txt) para persistencia de datos.
├── Clientes.txt
├── Empleados.txt
├── ExcursionesCulturales.txt
├── GuiasTuristicos.txt
├── PaquetesTuristicos.txt
├── PaseosLacustres.txt
├── ProveedoresAlojamiento.txt
├── ProveedoresTransporte.txt
├── Reservas.txt
└── RutasGastronomicas.txt
images/             # Recursos gráficos de la interfaz.
└── Logo.png
```



## ⚙️ Instrucciones para clonar y ejecutar el proyecto

**1.** **Clona el repositorio desde GitHub:**
[https://github.com/jamesAnimal/LlanquihueTourAppEFT-JS.git](https://github.com/jamesAnimal/LlanquihueTourAppEFT-JS.git)

**2.** **Abre el proyecto en IntelliJ IDEA.**
Asegúrate de configurar la carpeta `src` como Sources Root.

**3.** **Ejecuta el archivo Main.java desde el paquete app.** 
El programa levantará la interfaz gráfica habiendo cargado los datos previamente guardados en la carpeta de recursos.

---

**Repositorio GitHub:** [https://github.com/jamesAnimal/LlanquihueTourAppEFT-JS](https://github.com/jamesAnimal/LlanquihueTourAppEFT-JS)
**Fecha de entrega límite (Semana 9 - EFT):** 19/07/2026.

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Desarrollo Orientado a Objetos I | Evaluación Final Transversal (EFT).
