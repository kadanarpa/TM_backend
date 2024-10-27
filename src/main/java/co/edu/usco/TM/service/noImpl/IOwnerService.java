
package co.edu.usco.TM.service.noImpl;

import co.edu.usco.TM.dto.request.veterinary.ReqOwnerDTO;
import co.edu.usco.TM.dto.response.veterinary.ResOwnerDTO;
import co.edu.usco.TM.persistence.entity.veterinary.Owner;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;

public interface IOwnerService {
    
    List<ResOwnerDTO> findAll();
    
    Optional<Owner> findById(Long id);
    
    ResOwnerDTO save(ReqOwnerDTO ownerDTO);
    
    ResOwnerDTO uploadWithImage(ReqOwnerDTO ownerDTO, MultipartFile file) throws IOException;
    
    void delete(Long id);
    
}
