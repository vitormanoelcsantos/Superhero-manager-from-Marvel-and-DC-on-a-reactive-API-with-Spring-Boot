package com.one.innovation.digital.heroesapi.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Getter;
import lombok.Setter;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;

@Data
@Getter
@Setter
@NoArgsConstructor
@DynamoDBTable(tableName ="Heroes_Table")
public class Heroes {

    /** @DynamoDBHashKey e @DynamoDBAtrribute indicam ao banco qual será o nome das colunas
     * baseado nos atributos.
     * O HashKey é só para a chave primeirária
     */
    @Id
    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBAttribute(attributeName = "name")
    private String name;

    @DynamoDBAttribute(attributeName = "universe")
    private String universe;

    @DynamoDBAttribute(attributeName = "films")
    private int films;

    public Heroes(String id, String name, String universe, int films) {
        this.id = id;
        this.name = name;
        this.universe = universe;
        this.films = films;
    }
}