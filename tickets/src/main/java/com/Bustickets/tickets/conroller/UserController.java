package com.Bustickets.tickets.conroller;


import com.Bustickets.tickets.payload.UserDTO;
import com.Bustickets.tickets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    //http://localhost:8080/api/users/create
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam(value = "profileImage", required = false)
            MultipartFile profileImage) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userDTO.setPhoneNumber(phoneNumber);
        userDTO.setProfileImage(profileImage);
        UserDTO createdUser = userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Page<UserDTO>> getUsers(@PageableDefault(size =
            10,sort = "id")Pageable pageable){
        Page<UserDTO> users = userService.getUsers(pageable);
        return new ResponseEntity<>(users,HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("Delete Sucessfully",HttpStatus.OK);
    }
    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> downloadUsersAsExcel() {
        try {
            InputStreamResource stream = userService.getUserAsExcel();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=users.xlsx");
                    headers.add("Content-Type", "application/vnd.openxmlformatsofficedocument.spreadsheetml.sheet");
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(stream);
        } catch (Exception e) {
            return
                    ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        @GetMapping(value = "/users/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
        public ResponseEntity<InputStreamResource> getUserAsPdf() {
            try {
                InputStreamResource pdf = userService.getUserAsPdf();
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Disposition", "attachment; filename=users.pdf");
                return ResponseEntity
                        .ok()
                        .headers(headers)
                        .contentType(MediaType.APPLICATION_PDF)
                        .body(pdf);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

}



