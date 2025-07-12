package com.cefet.projeto_academia.dto;
public class JwtAuthenticationDTO {

	private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthenticationDTO() {
    }

    public JwtAuthenticationDTO(String accessToken) {
        this.accessToken = accessToken;
    }
    
    public String getAccessToken() {
        return accessToken;
    }
    
    public String getTokenType() {
        return tokenType;
    }
}