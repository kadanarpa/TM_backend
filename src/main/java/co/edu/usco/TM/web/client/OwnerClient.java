
package co.edu.usco.TM.web.client;

import co.edu.usco.TM.dto.request.veterinary.ReqOwnerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestPart;

@FeignClient(name = "ownerClient", url = "http://localhost:8080/api/owner")
public interface OwnerClient {
    
    @PostMapping("/create")
    void CreateMaker(@RequestHeader String reqID, @RequestPart("owner") ReqOwnerDTO ownerDTO);
    
}
