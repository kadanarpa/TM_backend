package co.edu.usco.TM.controller.administration;

import co.edu.usco.TM.dto.request.commerce.ReqMakerDTO;
import co.edu.usco.TM.dto.response.commerce.ResMakerDTO;
import co.edu.usco.TM.persistence.entity.commerce.Maker;
import co.edu.usco.TM.service.noImpl.IMakerService;
import co.edu.usco.TM.service.noImpl.IOwnerService;
import co.edu.usco.TM.service.noImpl.IVetService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/maker")
@RestController
public class AdminRestController {
    
    @Autowired
    private IMakerService makerService;
    
    @Autowired
    private IOwnerService ownerService;
    
    @Autowired
    private IVetService vetService;
    
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        
        Optional<Maker> makerOptional = makerService.findById(id);
        
        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();
            
            ResMakerDTO makerDTO = ResMakerDTO.builder()
                    .id(maker.getId())
                    .username(maker.getUsername())
                    .email(maker.getEmail())
                    .role(maker.getRole().getName())
                    .name(maker.getName())
                    .address(maker.getAddress())
                    .phone(maker.getPhone())
                    .productList(maker.getProductList())
                    .build();
            
            return ResponseEntity.ok(makerDTO);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/find")
    public ResponseEntity<?> findAll() {
        
        List<ResMakerDTO> makers = makerService.findAll()
                .stream().map(maker -> ResMakerDTO.builder()
                .id(maker.getId())
                .username(maker.getUsername())
                .email(maker.getEmail())
                .role(maker.getRole().getName())
                .name(maker.getName())
                .address(maker.getAddress())
                .phone(maker.getPhone())
                .imgURL(maker.getImgURL())
                .build())
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(makers);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ReqMakerDTO makerDTO) {
        
        Optional<Maker> makerOptional = makerService.findById(id);
        
        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();
            maker.setUsername(makerDTO.getUsername());
            maker.setEmail(makerDTO.getEmail());
            maker.setPassword(makerDTO.getPassword());
            maker.setName(makerDTO.getName());
            maker.setAddress(makerDTO.getAddress());
            maker.setPhone(makerDTO.getPhone());
            
            makerService.save(maker);
            
            return ResponseEntity.ok("updated maker");
        }
        
        return ResponseEntity.notFound().build();
        
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        
        Optional<Maker> makerOptional = makerService.findById(id);
        
        if (!makerOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        } else if (id != null) {
            
            makerService.deleteById(id);
            
            return ResponseEntity.ok("deleted maker");
        }
        
        return ResponseEntity.badRequest().build();
    }
}
