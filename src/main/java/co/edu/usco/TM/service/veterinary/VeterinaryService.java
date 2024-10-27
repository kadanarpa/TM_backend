package co.edu.usco.TM.service.veterinary;

import co.edu.usco.TM.persistence.entity.veterinary.Veterinarian;
import co.edu.usco.TM.persistence.repository.VeterinarianRepository;
import co.edu.usco.TM.service.noImpl.IVetService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeterinaryService implements IVetService {

    @Autowired
    VeterinarianRepository vetRepo;

    @Override
    public List<Veterinarian> findAll() {
        return vetRepo.findAll();
    }

    @Override
    public Optional<Veterinarian> findById(Long id) {
        return vetRepo.findById(id);
    }

    @Override
    public void save(Veterinarian vet) {
        vetRepo.save(vet);
    }

    @Override
    public void delete(Long id) {
        vetRepo.deleteById(id);
    }
}
