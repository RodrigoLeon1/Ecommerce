package com.rodrigoleon.ecommerce.dtos;

import com.rodrigoleon.ecommerce.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String externalId;
    private String email;
    private String name;

    public static UserDTO from(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setExternalId(user.getExternalId());

        return userDTO;
    }
}
