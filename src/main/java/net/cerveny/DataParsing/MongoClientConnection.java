package net.cerveny.DataParsing;

import com.mongodb.*;

import java.util.List;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoClientConnection {
    static String mongoUri = "mongodb://localhost:27017/";

    public static void ConnectAndInsertStatements(List<Document> input) throws Exception {
        ConnectionString connectionString = new ConnectionString(mongoUri);
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase("test01");
        database.createCollection("statements");
        MongoCollection<Document> statements = database.getCollection("statements");
        statements.insertMany(input);
        mongoClient.close();
    }

    public static void ConnectAndInsertMovements(List<Document> input) throws Exception {
        ConnectionString connectionString = new ConnectionString(mongoUri);
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase("test01");
        database.createCollection("movements");
        MongoCollection<Document> movements = database.getCollection("movements");
        movements.insertMany(input);
        mongoClient.close();
    }
}
