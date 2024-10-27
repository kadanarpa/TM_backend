
package co.edu.usco.TM.dto.request.administration;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ReqUserDTO {
    
    private Long id;
    private String username;
    private String email;
    private String password;
}
