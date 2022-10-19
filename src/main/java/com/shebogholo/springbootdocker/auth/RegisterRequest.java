package com.shebogholo.springbootdocker.auth;

public record RegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {}