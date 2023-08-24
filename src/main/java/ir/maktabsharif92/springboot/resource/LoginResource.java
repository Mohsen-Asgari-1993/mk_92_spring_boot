package ir.maktabsharif92.springboot.resource;

import ir.maktabsharif92.springboot.service.dto.BasicResponse;
import ir.maktabsharif92.springboot.service.dto.LoginDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
@RequestMapping(LoginResource.PATH)
@RequiredArgsConstructor
public class LoginResource {

    public static final String PATH = "/login";

    private final AuthenticationProvider authenticationProvider;

    @PostMapping
    public ResponseEntity<BasicResponse<String>> login(@RequestBody @Valid LoginDTO dto) {
        Authentication authenticate = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(), dto.getPassword()
                )
        );
        if (authenticate.isAuthenticated()) {
            String token = dto.getUsername().concat(":").concat(dto.getPassword());
            return ResponseEntity.ok(
                    new BasicResponse<>(
                            Base64.getEncoder().encodeToString(token.getBytes())
                    )
            );
        }
        return new ResponseEntity<>(
                new BasicResponse<>(
                        "wrong information"
                ),
                HttpStatus.UNAUTHORIZED
        );
    }
}
