
# Autocomplete

Api para entrada de eventos e mecanismo de autocomplete do nome do evento.

A implementação foi realizada em Java com Spring Boot e os dados foram armazenados em ElasticSerch, para que a busca do aucomplete seja rápida.

Para que a api desenvolvida seja escalável, ela pode ser adicionada a um container ou adicionada a um serviço serverless na nuvem, como App Engine da Google Cloud ou Lambda da AWS.

## Api

### GET /api/events
 
Retorna todos os eventos criados

### POST /api/events
 
Cria o evento cujos dados são passados no seu corpo, como por exemplo

{
"event": "buy",
"timestamp": "2016-09-22T13:57:31.2311892-04:00"
}

### GET /api/events/autocomplete?string=[TEXTO]
 
Retorna os nomes de eventos que autocompletam o texto passado como parâmetro. Porém, o texto precisa ter no mínimo 2 caracteres para que seja feita a busca

## Para rodar

### Pré-requisitos

 - Java 8
 - ElasticSerch 6.4

### Rodando

```
mvn clean install spring-boot:run
```

