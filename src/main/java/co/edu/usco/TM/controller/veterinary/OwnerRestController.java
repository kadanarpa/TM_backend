package co.edu.usco.TM.controller.veterinary;

import co.edu.usco.TM.dto.request.veterinary.ReqOwnerDTO;
import co.edu.usco.TM.dto.response.veterinary.ResOwnerDTO;
import co.edu.usco.TM.service.noImpl.IOwnerService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/owner")
@Tag(name = "Owners", description = "API for Owner Management")
public class OwnerRestController {

    @Autowired
    IOwnerService ownerService;

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    private ResponseEntity<?> save(
            @Parameter(description = "Basic information to create an Owner")
            @RequestPart(value = "owner") ReqOwnerDTO ownerDTO,
            @Parameter(description = "Image for the Owner Profile Icon")
            @RequestPart(name = "image", value = "image", required = false) MultipartFile file) throws IOException {
        ResOwnerDTO response;
        if (file != null && !file.isEmpty()) {
            response = ownerService.uploadWithImage(ownerDTO, file);
        } else {
            response = ownerService.save(ownerDTO);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @GetMapping("/find")
    private ResponseEntity<List<ResOwnerDTO>> findAll() {
        
        return ResponseEntity.ok(ownerService.findAll());
    }

}
