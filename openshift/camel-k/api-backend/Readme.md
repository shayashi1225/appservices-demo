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

3. テスト
```
 $ curl http://api-demo-pj.apps.cluster-8gszn.8gszn.sandbox944.opentlc.com/orders?orderid=0
[{id=1, orderid=0, orderitemname=TEST, ordertype=A, price=50.9, quantity=100, shipmentaddress=5-321,Komenoki-dai,Nisshin-city, zipcode=470-0118}]
```