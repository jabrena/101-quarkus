# 101 Quarkus

```bash
./mvnw quarkus:dev
curl http://localhost:8080/hello

curl -X POST \
  http://localhost:8080/calculate \
  -H "Content-Type: application/json" \
  -d '{
    "operator1": "10",
    "operator2": "5",
    "operation": "add"
  }'
```