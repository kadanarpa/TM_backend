
package co.edu.usco.TM.service.commerce;

import co.edu.usco.TM.persistence.entity.commerce.Maker;
import co.edu.usco.TM.service.noImpl.IMakerService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.usco.TM.persistence.repository.MakerRepository;
import co.edu.usco.TM.persistence.repository.RoleRepository;
import co.edu.usco.TM.s3.S3Service;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MakerService implements IMakerService{
    
    @Autowired
    MakerRepository makerRepo;
    
    @Autowired
    RoleRepository roleRepo;
    
    @Autowired
    S3Service s3Service;
    
    @Override
    public List<Maker> findAll() {
        return makerRepo.findAll();
    }
    
    @Override
    public Optional<Maker> findById(Long id) {
        return makerRepo.findById(id);
    }
    
    @Override
    public void save(Maker maker) {
        
        maker.setRole(roleRepo.findByName("MAKER"));
        makerRepo.save(maker);
    }
    
    @Override
    public void uploadWithImage(Maker maker, MultipartFile file) throws IOException {
        
        maker.setImgURL(s3Service.uploadFile(file));
        maker.setRole(roleRepo.findByName("MAKER"));
        makerRepo.save(maker);
    }
    
    @Override
    public void deleteById(Long id) {
        makerRepo.deleteById(id);
    }
    
}
