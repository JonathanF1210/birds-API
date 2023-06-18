package my.jonathan.BirdView;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="birds-site")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Birds {

    @Id
    @JsonProperty("_id")
    private String _id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("scientificName")
    private String scientificName;
    @JsonProperty("images")
    private String images;
    @JsonProperty("description")
    private String description;
    @JsonProperty("breedingSeason")
    private String breedingSeason;
    @JsonProperty("diet")
    private String diet;
    @JsonProperty("countriesFound")
    private List<String> countriesFound;
    @JsonProperty("distributionImage")
    private String distributionImage;
    @JsonProperty("distribution")
    private String distribution;
    @JsonProperty("timeMostActive")
    private List<String> timeMostActive;
    @JsonProperty("order")
    private String order;
    @JsonProperty("family")
    private String family;
    @JsonProperty("wingspan")
    private String wingspan;
    @JsonProperty("height")
    private String height;
    @JsonProperty("weight")
    private String weight;
    @JsonProperty("conservationStatus")
    private String conservationStatus;

    public static class _id {
        @JsonProperty("$oid")
        private String $oid;

        public String get$oid() {
            return $oid;
        }

        public void set$oid(String $oid) {
            this.$oid = $oid;
        }
    }
}
