package api.model;

import lombok.Data;

@Data
public class LoginRequestLombokModel {
    private String email, password;
}
