package util;

import com.alibaba.fastjson.JSON;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dell_2 on 2016/9/9.
 */
public class MongoDBUtil<T> {
    private static final String HOST = "127.0.0.1";
    private MongoClient mongo;

    private static MongoDatabase db;

    private MongoCollection<Document> collection;

    public MongoDBUtil(String host, String dataBaseName, String collName) {
        try {
            mongo = new MongoClient(host);
            db = mongo.getDatabase(dataBaseName);
            collection = db.getCollection(collName);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public MongoDBUtil(String dataBaseName, String collName) {
        this(HOST, dataBaseName, collName);
    }

    public void add(T bean) {
        String json = JSON.toJSONString(bean);
        collection.insertOne(Document.parse(json));
    }

    public List<T> list(Class<T> cls) {
        long count = collection.count();
        List<T> list = new ArrayList<T>((int) count);
        FindIterable<Document> res = collection.find();
        for (Document document : res) {
            String json = JSON.toJSONString(document);
            list.add(JSON.parseObject(json, cls));
        }
        return list;
    }

    public void update(Map<String, String> params, T entry) {
        Document document = new Document();
        document.append("userName","张三");
        collection.updateMany(Filters.eq("userName", "zhangsan"), new Document("$set",document));
    }

    public void find() {
        BsonString bsonString = new BsonString("张三");
        BsonDocument document = new BsonDocument("userName", bsonString);
        Document document1 = collection.findOneAndUpdate(Filters.eq("userName", "zhangsan"), document);
        System.out.println(JSON.toJSONString(document1));
    }

}
