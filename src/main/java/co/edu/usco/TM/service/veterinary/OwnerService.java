
package co.edu.usco.TM.service.veterinary;

import co.edu.usco.TM.dto.request.veterinary.ReqOwnerDTO;
import co.edu.usco.TM.dto.response.veterinary.ResOwnerDTO;
import co.edu.usco.TM.persistence.entity.veterinary.Owner;
import co.edu.usco.TM.persistence.repository.OwnerRepository;
import co.edu.usco.TM.persistence.repository.RoleRepository;
import co.edu.usco.TM.s3.S3Service;
import co.edu.usco.TM.service.noImpl.IOwnerService;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class OwnerService implements IOwnerService {
    
    @Autowired
    private OwnerRepository ownerRepo;
    
    @Autowired
    private RoleRepository roleRepo;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    S3Service s3Service;

    @Override
    public List<ResOwnerDTO> findAll() {
        return ownerRepo.findAll().stream()
                .map(owner -> modelMapper.map(owner, ResOwnerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Owner> findById(Long id) {
        return ownerRepo.findById(id);
    }

    @Override
    public ResOwnerDTO save(ReqOwnerDTO ownerDTO) {
        
        Owner owner = modelMapper.map(ownerDTO, Owner.class);
        owner.setRole(roleRepo.findByName("OWNER"));
        
        ownerRepo.save(owner);
        
        return modelMapper.map(owner, ResOwnerDTO.class);
    }
    
    @Override
    public ResOwnerDTO uploadWithImage(ReqOwnerDTO ownerDTO, MultipartFile file) throws IOException {
        
        Owner owner = modelMapper.map(ownerDTO, Owner.class);
        owner.setRole(roleRepo.findByName("OWNER"));
        owner.setImgURL(s3Service.uploadFile(file));
        
        ownerRepo.save(owner);
        
        return modelMapper.map(owner, ResOwnerDTO.class);
    }

    @Override
    public void delete(Long id) {
        ownerRepo.deleteById(id);
    }
    
}
