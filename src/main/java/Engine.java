import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Engine {
    private String fuelType;
    private int cylinderNumber;
}
