
package co.edu.usco.TM.dto.response.administration;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ResUserDTO {
    
    private Long id;
    private String username;
    private String email;
    private String role;
    private String imgURL;
}