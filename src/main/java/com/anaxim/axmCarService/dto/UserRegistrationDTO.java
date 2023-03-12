package com.anaxim.axmCarService.dto;

public record UserRegistrationDTO(
        String firstName,
        String lastname,
        String username,
        String email,
        String password,
        String profession
){
}
