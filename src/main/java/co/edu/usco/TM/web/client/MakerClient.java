package co.edu.usco.TM.web.client;

import co.edu.usco.TM.persistence.entity.commerce.Maker;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestPart;

@FeignClient(name = "makerClient", url = "http://localhost:8080/api/maker")
public interface MakerClient {

    @GetMapping("/find")
    List<Maker> getMakers();

    @PostMapping("/create")
    void createMaker(
            @RequestHeader String requestId,
            @RequestPart("maker") Maker maker);
}
