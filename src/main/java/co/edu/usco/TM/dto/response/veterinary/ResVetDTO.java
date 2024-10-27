
package co.edu.usco.TM.dto.response.veterinary;

import co.edu.usco.TM.dto.response.administration.ResUserDTO;
import co.edu.usco.TM.persistence.entity.veterinary.appointment.Appointment;
import java.util.List;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ResVetDTO extends ResUserDTO{
    
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String specialty;
    private String veterinary;
    private List<Appointment> appointmentList;
}
