package wap.dto;

import lombok.Builder;

@Builder
public class UserDTO {
    private String username;

    private Integer u_id;

    private String password;

    private String email;

    private Role role;

    private String company;


}
