package com.desafio.lanchonete.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("api")
public class ApiProperty {

    private String originPermitida = "http://localhost:4200";

    public String getOriginPermitida() {
        return originPermitida;
    }

    public void setOriginPermitida(String originPermitida) {
        this.originPermitida = originPermitida;
    }
}
