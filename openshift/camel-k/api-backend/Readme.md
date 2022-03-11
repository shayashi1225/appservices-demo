## 手順

1. PostgreSQL接続用Secretを作成しておく
```
$ oc create secret generic my-datasource --from-file=datasouce.properties
```

2. Deploy
```
$ kamel run API.java --open-api openapi.yaml \
--build-property quarkus.datasource.camel.db-kind=postgresql \
--config secret:my-datasource \
-d mvn:io.quarkus:quarkus-jdbc-postgresql
```