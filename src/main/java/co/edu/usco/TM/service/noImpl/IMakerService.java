
package co.edu.usco.TM.service.noImpl;

import co.edu.usco.TM.persistence.entity.commerce.Maker;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;

public interface IMakerService {
    
    List<Maker> findAll();
    
    Optional<Maker> findById(Long id);
    
    void save(Maker maker);
    
    public void uploadWithImage(Maker maker, MultipartFile file) throws IOException;
    
    void deleteById(Long id);
}
