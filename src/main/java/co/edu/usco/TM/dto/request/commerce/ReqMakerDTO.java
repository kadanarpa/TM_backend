package co.edu.usco.TM.dto.request.commerce;

import co.edu.usco.TM.dto.request.administration.ReqUserDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ReqMakerDTO extends ReqUserDTO{

    private String name;
    private String address;
    private String phone;
}
