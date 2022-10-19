package com.shebogholo.springbootdocker.auth;

public record LoginRequest(
        String email,
        String password
) {}