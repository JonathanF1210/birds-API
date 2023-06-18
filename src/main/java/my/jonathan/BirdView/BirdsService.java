package my.jonathan.BirdView;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BirdsService {

    @Autowired
    private BirdsRepository birdsRepository;

    public List<Birds> allBirds(){

        return birdsRepository.findAll();
    }

    public Optional<Birds> singleBird(ObjectId id){
        return birdsRepository.findById(id);
    }

    public void createBird(Birds bird){
        birdsRepository.save(bird);
    }

}
