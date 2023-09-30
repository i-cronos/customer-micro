package pe.ibk.cpe.customer.application.rest.controller.info.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class AppInfoResponseDto {
    private String name;
    private String environment;
    private LocalDateTime current;
}
