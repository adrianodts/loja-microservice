# loja-microservice

Serviço de compras que interage com o serviço de fornecedor via registro no eureka server.


Exemplo de chamada:

```
curl -X POST \
  http://localhost:8080/compra \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: d43bdb63-3f11-10df-badf-d454959316f4' \
  -d '{
	"item": [
		{
			"id" : 1,
			"quantidade" : 1
		},
		{
			"id" : 2,
			"quantidade" : 2
		}
	],
	"endereco" : {
		"rua" : "TESTE",
		"numero": "123",
		"estado" : "SP"
	}
}'
```

