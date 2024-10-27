
package co.edu.usco.TM.dto.request.veterinary;

import co.edu.usco.TM.dto.request.administration.ReqUserDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ReqVetDTO extends ReqUserDTO{
    
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String specialty;
    private String veterinary;
}
