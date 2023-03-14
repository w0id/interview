import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private int age;
    private String gender;

}
