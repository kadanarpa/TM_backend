package co.edu.usco.TM.controller.user;

import co.edu.usco.TM.dto.response.Page.PageResponse;
import co.edu.usco.TM.dto.response.user.ResUserDTO;
import co.edu.usco.TM.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/find")
    public ResponseEntity<PageResponse<ResUserDTO>> getUsers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<ResUserDTO> usersPage = userService.findAllUsers(name, username, email, null, pageable, null, null );
        PageResponse<ResUserDTO> pageResponse = new PageResponse<>(usersPage);

        return ResponseEntity.ok(pageResponse);
    }

}
