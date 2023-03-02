package com.sebastian.portfolio.payloads;

import lombok.Data;

@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Integer id;
    private String username;

    public JwtResponse(String token, Integer id, String username) {
        this.token = token;
        this.id = id;
        this.username = username;
    }
}
