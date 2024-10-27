
package co.edu.usco.TM.controller.commerce;

import co.edu.usco.TM.dto.request.commerce.ReqMakerDTO;
import co.edu.usco.TM.persistence.entity.commerce.Maker;
import co.edu.usco.TM.service.noImpl.IMakerService;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/maker")
public class MakerRestController {
    
    @Autowired
    IMakerService makerService;
    
    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestPart("maker") ReqMakerDTO makerDTO,
            @RequestPart("file") MultipartFile file) throws URISyntaxException, IOException {
        
        if (makerDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        
        makerService.uploadWithImage(Maker.builder()
                .username(makerDTO.getUsername())
                .email(makerDTO.getEmail())
                .password(makerDTO.getPassword())
                .name(makerDTO.getName())
                .address(makerDTO.getAddress())
                .phone(makerDTO.getPhone())
                .build(), file);
        
        return ResponseEntity.created(new URI("/api/maker/create")).build();
    }
    
}
