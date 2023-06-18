package my.jonathan.BirdView;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class BirdsController {

    @Autowired
    private BirdsService birdsService;

    @GetMapping("/api/v1/birds")
    public ResponseEntity<List<Birds>> getAllBirds(){
        return new ResponseEntity<List<Birds>>(birdsService.allBirds(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Birds>> getSingleMovie(@PathVariable ObjectId id) {
        return
                new ResponseEntity<Optional<Birds>>(birdsService.singleBird(id), HttpStatus.OK);
    }

    @PostMapping("/api/v1/newBird")
    public ResponseEntity<String> createBirdFromUserInput(@ModelAttribute Birds bird) {
        // Save the bird object to the database
        birdsService.createBird(bird);

        return new ResponseEntity<>("Bird created successfully", HttpStatus.CREATED);
    }
}

