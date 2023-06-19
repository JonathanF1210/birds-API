package my.jonathan.BirdView;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdsRepository extends MongoRepository<Birds, ObjectId> {
    Birds findByName(String name);
}



