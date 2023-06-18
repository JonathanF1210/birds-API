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
    public ResponseEntity<String> createBirdFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        Birds bird = new Birds();

        // Prompt the user to input values for each property of the bird object
        System.out.print("Enter images: ");
        bird.setImages(scanner.nextLine());

        System.out.print("Enter breeding season: ");
        bird.setBreedingSeason(scanner.nextLine());

        System.out.print("Enter diet: ");
        bird.setDiet(scanner.nextLine());

        System.out.print("Enter countries found (separated by commas): ");
        String countriesFoundInput = scanner.nextLine();
        List<String> countriesFound = Arrays.asList(countriesFoundInput.split(","));
        bird.setCountriesFound(countriesFound);

        System.out.print("Enter distribution image: ");
        bird.setDistributionImage(scanner.nextLine());

        System.out.print("Enter distribution: ");
        bird.setDistribution(scanner.nextLine());

        System.out.print("Enter time most active (separated by commas): ");
        String timeMostActiveInput = scanner.nextLine();
        List<String> timeMostActive = Arrays.asList(timeMostActiveInput.split(","));
        bird.setTimeMostActive(timeMostActive);

        System.out.print("Enter order: ");
        bird.setOrder(scanner.nextLine());

        System.out.print("Enter family: ");
        bird.setFamily(scanner.nextLine());

        System.out.print("Enter wingspan: ");
        bird.setWingspan(scanner.nextLine());

        System.out.print("Enter height: ");
        bird.setHeight(scanner.nextLine());

        System.out.print("Enter weight: ");
        bird.setWeight(scanner.nextLine());

        System.out.print("Enter conservation status: ");
        bird.setConservationStatus(scanner.nextLine());

        System.out.print("Enter description: ");
        bird.setDescription(scanner.nextLine());

        System.out.print("Enter scientific name: ");
        bird.setScientificName(scanner.nextLine());

        System.out.print("Enter name: ");
        bird.setName(scanner.nextLine());

        // Save the bird object to the database
        birdsService.createBird(bird);

        return new ResponseEntity<>("Bird created successfully", HttpStatus.CREATED);
    }

}

