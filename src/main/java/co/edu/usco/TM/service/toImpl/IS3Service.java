
package co.edu.usco.TM.service.toImpl;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface IS3Service {
    
    public String uploadFile(MultipartFile file) throws IOException;
    
}