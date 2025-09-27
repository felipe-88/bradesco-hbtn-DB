
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;

public class UsuarioOperations {

    private MongoCollection collection;

    public UsuarioOperations(MongoCollection collection) {
        this.collection = collection;
    }

    public void operations() {
        Usuario alice = new Usuario("Alice", 25);
        Usuario bob = new Usuario("Bob", 30);
        Usuario charlie = new Usuario("Charlie", 35);

        InsertOneResult insertOneResult = this.collection.insertOne(alice.toDocument());
        System.out.println(insertOneResult.getInsertedId().toString());
        InsertOneResult insertOneResult1 = this.collection.insertOne(bob.toDocument());
        System.out.println(insertOneResult1.getInsertedId().toString());
        InsertOneResult insertOneResult2 = this.collection.insertOne(charlie.toDocument());
        System.out.println(insertOneResult2.getInsertedId().toString());

        FindIterable findIterable = this.collection.find();
        findIterable.forEach(o -> System.out.println(o.toString()));

        this.collection.updateOne(Filters.eq("nome","Bob"), Updates.set("idade",32));

        FindIterable findIterable1 = this.collection.find();
        findIterable.forEach(o -> System.out.println(o.toString()));

        this.collection.deleteOne(Filters.eq("nome", "Charlie"));

        FindIterable findIterable2 = this.collection.find();
        findIterable.forEach(o -> System.out.println(o.toString()));
    }
}
