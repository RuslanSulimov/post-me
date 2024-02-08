package ru.postme.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.postme.database.model.User;
import ru.postme.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestParam ("nickname") String nickname,
                                        @RequestParam ("firstname") String firstname,
                                        @RequestParam ("lastname") String lastname,
                                        @RequestParam ("email") String email,
                                        @RequestParam ("password")String password,
                                        @RequestBody User user) {

            user.setNickname(nickname);
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setEmail(email);
            user.setPassword(password);

            return ResponseEntity.ok(userService.createUser(user));
    }

    @PatchMapping ("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable ("id") Long id,
                                        @RequestParam ("nickname") String nickname,
                                        @RequestParam ("firstname") String firstname,
                                        @RequestParam ("lastname") String lastname,
                                        @RequestParam ("email") String email,
                                        @RequestParam ("password")String password,
                                        @RequestBody User user) {

        user = userService.getUserById(id);

        user.setNickname(nickname);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setPassword(password);

        userService.updateUser(user);
        return null;
    }
    @DeleteMapping ("/deleteUser/{id}")
    public void deleteUser(@PathVariable ("id") Long id) { userService.deleteUser(id); }

    @GetMapping("/getUserByNickname/{nickname}")
    public ResponseEntity<?> getUserByNickname(@PathVariable ("nickname") String nickname) {
        return ResponseEntity.ok(userService.getUserByNickname(nickname));
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable ("id") Long id) {return ResponseEntity.ok(userService.getUserById(id));}

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
