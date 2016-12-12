# sentinelle [![Build Status](https://travis-ci.org/orange-cloudfoundry/sentinelle.svg?branch=master)](https://travis-ci.org/orange-cloudfoundry/sentinelle)

Whether it is for troubleshooting or monitoring, you may need to get information about network connectivity from 
your CF Space. Sentinelle provides Ops with an HTTP API to run common network commands, such as :

- ping
- traceroute
- tcpdump


# Sample usage

## ping

```shell
$ curl -u user:changeit http://localhost:8080/ping/127.0.0.1
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   477  100   477    0     0    149      0  0:00:03  0:00:03 --:--:--   149
Envoi d'une requête 'Ping'  127.0.0.1 avec 32 octets de données:
Réponse de 127.0.0.1?: octets=32 temps<1ms TTL=128
Réponse de 127.0.0.1?: octets=32 temps<1ms TTL=128
Réponse de 127.0.0.1?: octets=32 temps<1ms TTL=128
Réponse de 127.0.0.1?: octets=32 temps<1ms TTL=128

Statistiques Ping pour 127.0.0.1:
    Paquets: envoyés = 4, refus = 4, perdus = 0 (perte 0%),
Durée approximative des boucles en millisecondes :
    Minimum = 0ms, Maximum = 0ms, Moyenne = 0ms

 ```
 
# Install

Download the jar file from the latest release and push it to your Cloud Foundry.

```shell
$ cf push -p sentinelle-<latest-version>.jar
```
 
 
# Development
 The project depends on Java 8.  To build from source and install to your local Maven cache, run the following:
 
 ```shell
 $ ./mvnw clean install
 ```
