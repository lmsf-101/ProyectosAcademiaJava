package code;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


// Simple Customer Entity


// Use of Lombok to quickly create the
// constructors, getters and setters of the class:
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Customer {

    
    private int id;
    
    private String firstName;
    
    private String lastName;
    
    private String email;
    
    private String gender;
    
    private String contactNo;
    
    private String country;
    
    private String dob;
    
    


}
