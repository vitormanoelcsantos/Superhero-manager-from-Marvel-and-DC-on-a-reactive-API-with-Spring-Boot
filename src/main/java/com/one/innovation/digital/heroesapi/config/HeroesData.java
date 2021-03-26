package com.one.innovation.digital.heroesapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;

import static com.one.innovation.digital.heroesapi.constants.HeroesConstant.REGION_DYNAMO;
import static com.one.innovation.digital.heroesapi.constants.HeroesConstant.ENDPOINT_DYNAMO;


public class HeroesData {
    public static void main(String[] args) {
        AmazonDynamoDB amazonDynamoDBClient = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration
                        (new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO)).build();

        DynamoDB dynamoDB = new DynamoDB(amazonDynamoDBClient);

        Table table = dynamoDB.getTable("Heroes_Table");

        Item hero = new Item().withPrimaryKey("id", 2)
                .withString("name", "Mulher Maravilha")
                .withString("universe", "DC Comics")
                .withNumber("films", 3);

        PutItemOutcome outcome = table.putItem(hero);
    }
}
