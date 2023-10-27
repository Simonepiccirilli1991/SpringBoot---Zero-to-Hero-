package com.spring.zerotohero.base.model.shared;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class BaseProperty {

    private String codiceOpera;
    private LocalDateTime dataUltimaInstallazione;
}
