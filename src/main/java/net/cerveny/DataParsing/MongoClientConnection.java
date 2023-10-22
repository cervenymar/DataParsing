package net.cerveny.DataParsing;

import com.mongodb.*;

import java.util.List;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoClientConnection {
    String mongoUri;
    ConnectionString connectionString;
    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> movements;
    MongoCollection<Document> statements;

    public MongoClientConnection() {
        this.mongoUri = "mongodb://localhost:27017/";
        this.connectionString = new ConnectionString(this.mongoUri);
        this.mongoClient = MongoClients.create(this.connectionString);
        this.database = mongoClient.getDatabase("test01");
        this.movements = database.getCollection("movements");
        this.statements = database.getCollection("statements");
    }

    public void AddToDB(List<Document> movementInput, List<Document> statementInput) throws Exception {        
        this.movements.insertMany(movementInput);
        this.statements.insertMany(statementInput);
        this.mongoClient.close();
    }

}
