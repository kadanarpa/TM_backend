
package co.edu.usco.TM.dto.response.veterinary;

import co.edu.usco.TM.dto.response.administration.ResUserDTO;
import co.edu.usco.TM.persistence.entity.veterinary.Pet;
import co.edu.usco.TM.persistence.entity.veterinary.appointment.Appointment;
import java.util.List;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ResOwnerDTO extends ResUserDTO{
    
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private List<Pet> petList;
    private List<Appointment> appointmentList;
}
