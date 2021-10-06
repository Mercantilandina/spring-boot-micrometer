
# Metricas con Spring Boot y Micrometer

Esta aplicación muestra como crear métricas personalizadas utlizando la librería Micrometer. 

## Ejecutar la aplicación

Para iniciar la aplicación ejecutar el siguiente comando:
```
mvn spring-boot:run
```

## Consultar las métricas

Las métricas se muestran con el formato Prometheus con la siguiente dirección:

[http://localhost:8080/actuator/prometheus](http://localhost:8080/actuator/prometheus)


## Ejemplos
Una prueba con contadores se realiza con el siguiente servicio:

[http://localhost:8080/moneda](http://localhost:8080/moneda)

La medición se realiza con la cantidad de veces que salieron las caras de una moneda. Las métricas se muestran en Prometheus con los siguientes nombres:

```
moneda_cara_total
moneda_cruz_total
```

Una medición de tiempo de ejecución se realiza con el servicio:

[http://localhost:8080/lento](http://localhost:8080/lento)

Las métricas se muestran con los siguientes nombres:

```
mensaje_lento_seconds_max
mensaje_lento_seconds_count
mensaje_lento_seconds_sum
```

Una medición con histograma se realiza con el servicio: 

[http://localhost:8080/archivos](http://localhost:8080/archivos)

Las métricas se muestran como: 

```
archivos_sizes_kilobytes_max 
archivos_sizes_kilobytes_bucket{le="10.0",} 
archivos_sizes_kilobytes_bucket{le="50.0",} 
archivos_sizes_kilobytes_bucket{le="90.0",} 
archivos_sizes_kilobytes_bucket{le="+Inf",} 
archivos_sizes_kilobytes_count 
archivos_sizes_kilobytes_sum 
```

Para probar las mediciones de un timer con anotaciones ejecutar el siguente servicio:

[http://localhost:8080/convertir](http://localhost:8080/convertir)

Las métricas se muestran con los siguientes nombres:

```
imagen_convertir_seconds_count
imagen_convertir_seconds_sum
imagen_convertir_seconds_max
```
