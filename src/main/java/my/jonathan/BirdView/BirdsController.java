package my.jonathan.BirdView;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BirdsController {

    @Autowired
    private BirdsService birdsService;

    @GetMapping("/api/v1/birds")
    public ResponseEntity<List<Birds>> getAllBirds(){
        return new ResponseEntity<List<Birds>>(birdsService.allBirds(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Birds>> getSingleMovie(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Birds>>(birdsService.singleBird(id), HttpStatus.OK);
    }

}
