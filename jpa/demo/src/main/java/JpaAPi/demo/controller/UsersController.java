package JpaAPi.demo.controller;

import JpaAPi.demo.UsersDto;
import JpaAPi.demo.entity.Users;
import JpaAPi.demo.repostiroy.UsersRepository;
import JpaAPi.demo.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("/users/*")
@RequiredArgsConstructor
@Slf4j
public class UsersController {

    private final UsersService usersService;

    @PostMapping("add")//users/add?credit=10
    public ResponseEntity addCredit( Integer credit, HttpSession session){
        if(session==null|| session.getAttribute("user")==null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("로그인하세요");
        }
        Long userId=(Long)session.getAttribute("user");
        Users updateUser=usersService.updateCredit(userId, credit);
        return ResponseEntity.status(HttpStatus.OK).body(updateUser);
    }

    @PostMapping("login")
    public UsersDto login(String username,  HttpSession session) throws AccessDeniedException {
        Users user= usersService.findUser(username);
        if(user==null){
            log.error("로그인 실패");
            throw new AccessDeniedException("로그인실패");
        }
        session.setAttribute("user",user.getId());
        return user.toDto();
    }
}
