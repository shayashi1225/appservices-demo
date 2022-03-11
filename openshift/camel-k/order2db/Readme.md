## 手順

1. Postgre SQLをデプロイ

- 接続ユーザ：user221
- 接続ユーザパスワード：oDRP8QTVX12YMpjC

2. テーブル作成

```bash
oc rsh <PGSのPOD>
psql sampledb -U user221
```

```SQL
sampledb=> create table ordertable (
  id serial PRIMARY KEY,
  orderid INT, 
  orderItemName varchar(50),
  orderType varchar(5),
  price decimal,
  quantity INT,
  shipmentAddress varchar(50),
  zipCode varchar(10)
);

sampledb=> INSERT INTO ordertable (orderid,orderitemname,ordertype,price,quantity,shipmentaddress,zipcode) VALUES (0,'TEST','A',50.9,100,'5-321,Komenoki-dai,Nisshin-city', '470-0118');
```

>INSERT INTO ordertable (orderid,orderitemname,ordertype,price,quantity,shipmentaddress,zipcode) VALUES (:#orderId,:#orderItemName,:#orderType,:#price,:#quantity,:#shipmentAddress,:#zipCode);
>selecrt * from ordertable where orderId = :#orderid

3. Deploy

```
kamel run ./openshift/camel-k/ordertodb.yaml --resource file:./openshift/camel-k/order-mapping_pgs.adm -n demo-pj
```
