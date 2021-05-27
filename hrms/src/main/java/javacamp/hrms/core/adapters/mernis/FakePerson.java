package javacamp.hrms.core.adapters.mernis;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FakePerson {
    private String firstName;
    private String lastName;
    private String nationalityId;
    private Date birthYear;
}