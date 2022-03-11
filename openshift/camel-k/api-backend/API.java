// camel-k: language=java dependency=camel-quarkus-openapi-java 

import org.apache.camel.builder.AggregationStrategies;
import org.apache.camel.builder.RouteBuilder;

public class API extends RouteBuilder {
  @Override
  public void configure() throws Exception {

    // All endpoints starting from "direct:..." reference an operationId defined
    // in the "openapi.yaml" file.


    // Get an object from the S3 bucket
    from("direct:get")
//      .setHeader("orderid", simple("${header.orderId}"))
      .setBody(simple("SELECT * FROM ordertable WHERE orderid= '${header.orderId}' "))
      .to("jdbc:camel?useHeadersAsParameters=true")
      .convertBodyTo(String.class);

  }
}
