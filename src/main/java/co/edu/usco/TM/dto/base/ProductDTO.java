
package co.edu.usco.TM.dto.base;

import co.edu.usco.TM.persistence.entity.commerce.Maker;
import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    
    private Long id;
    private String name;
    private BigDecimal price;
    private Maker maker;
}
