
package co.edu.usco.TM.persistence.entity.commerce;

import co.edu.usco.TM.persistence.entity.administration.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "makers")
public class Maker extends UserEntity {
    
    @Column(name = "mak_business_name")
    private String name;
    
    @Column(name = "mak_business_address")
    private String address;
    
    @Column(name = "mak_phone")
    private String phone;
    
    @OneToMany(mappedBy = "maker", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonIgnore
    private List<Product> productList = new ArrayList<>();
    
}
