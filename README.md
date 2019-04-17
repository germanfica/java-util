# java-util &middot; [![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/germanfica/java-util/blob/master/LICENSE)
| [:sparkles: Guía de instalación](#guía-de-instalación) | [:rocket: Descargas](#descargas) |
| --------------- | -------- |

## Guía de instalación
Siga las siguientes instrucciones para poder empezar a usar java-util:
1.	Generar un paquete con el nombre: `xyz.germanfica.util`
2.	Descargar código fuente y extraer los archivos
3.	Arrastrarlos al paquete `xyz.germanfica.util` creado
4.	Dar una estrellita al repositorio💖

## Docs
### Ejemplo para leer un archivo
```java
import xyz.germanfica.util.Archivo;

public class Test {
	public static void main(String[] args) {
		String NOMBRE_ARCHIVO = "src/xyz/germanfica/util/ejemplo.txt";
		String ejemplo = Archivo.leer(NOMBRE_ARCHIVO);
		System.out.println(ejemplo);
	}
}
```
| Módulo        | Descripción   |
| ------------- | ------------- |
| guardar(String contenido, String NOMBRE_ARCHIVO) : void  | Guarda una cadena de caracteres en un  archivo de texto.  |

Nota: la documentación no está terminada.

## Descargas
Puede obtener acceso al código fuente utilizando una de las siguientes formas:
+ Descargar código fuente del [.zip](https://github.com/germanfica/java-util/archive/master.zip)
+ Clonar el repositorio localmente:
```bash
git clone https://github.com/germanfica/java-util.git
```

## Créditos
- [German Fica](https://www.instagram.com/germanfica/)

## Licencia
[MIT](https://opensource.org/licenses/MIT)
