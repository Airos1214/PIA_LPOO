# Guía: Instalación del JDK (Java Development Kit) 
El JDK es necesario para compilar y ejecutar aplicaciones de Java.

## Paso 1: Elegir y Descargar el JDK de Oracle

- Visita el sitio web de Oracle JDK Downloads:
https://www.oracle.com/java/technologies/downloads/

- Selecciona la Versión: Elige una versión de Soporte a Largo Plazo (LTS), como JDK 21 o JDK 17. Haz clic en ella.

- Busca tu Sistema Operativo: En la página de descargas de esa versión, haz clic en la pestaña Windows.

- Descarga el Instalador: Busca en la lista el archivo que dice "x64 Installer" (será un archivo .exe). Haz clic en el enlace de descarga junto a él.

## Paso 2: Instalar el JDK

- Una vez descargado el archivo .exe:
Ejecuta el instalador (requerirá permisos de administrador).

- Aparecerá el asistente de instalación de Oracle. Es un proceso muy directo.

- Simplemente haz clic en "Siguiente" ("Next") en las pantallas del asistente. La configuración por defecto es suficiente.

- El instalador elegirá una ruta (usualmente C:\Program Files\Java\jdk-21...) y finalizará la instalación.

## Paso 3: Configuración Manual de JAVA_HOME

Aunque el Path esté configurado, es una buena práctica configurar JAVA_HOME manualmente.

- Busca "Editar las variables de entorno del sistema" en el menú de inicio de Windows y ábrelo.

- En la ventana de "Propiedades del sistema", haz clic en el botón "Variables de entorno...".
Configurar JAVA_HOME:

- En la sección "Variables del sistema", haz clic en "Nueva...".
Nombre de la variable: JAVA_HOME
Valor de la variable: (La ruta donde se instaló el JDK, ej: C:\Program Files\Java\jdk-21)

- Haz clic en "Aceptar".

- Añadir JAVA_HOME al Path (Opcional, pero recomendado):

- En la misma sección, busca la variable Path, selecciónala y haz clic en "Editar...".

- Haz clic en "Nuevo".
Escribe: %JAVA_HOME%\bin

- Haz clic en "Aceptar" en todas las ventanas para guardar los cambios.

## Paso 4: Verificar la Instalación

Para confirmar que el JDK se instaló correctamente:

#### - Cierra todas las ventanas de Símbolo del sistema (CMD) o PowerShell que tuvieras abiertas.

- Abre una NUEVA ventana de CMD.

- Escribe el siguiente comando y presiona Enter:
   #### java -version
#### - Se deberia ver la versión del JDK que acabas de instalar (ej. java version "21.0.3"...).

- Escribe también:
   #### javac -version
#### - Deberías ver la versión del compilador (ej. javac 21.0.3).

### Si ambos comandos funcionan, ya tienes tu JDK instalado.
