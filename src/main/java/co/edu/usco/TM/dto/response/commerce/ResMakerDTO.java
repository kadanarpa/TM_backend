
package co.edu.usco.TM.dto.response.commerce;

import co.edu.usco.TM.dto.response.administration.ResUserDTO;
import co.edu.usco.TM.persistence.entity.commerce.Product;
import java.util.List;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ResMakerDTO extends ResUserDTO{
    
    private String name;
    private String address;
    private String phone;
    private List<Product> productList;
    
}
