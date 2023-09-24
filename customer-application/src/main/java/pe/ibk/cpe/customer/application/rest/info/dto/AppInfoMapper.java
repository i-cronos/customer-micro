package pe.ibk.cpe.customer.application.rest.info.dto;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pe.ibk.cpe.customer.application.rest.common.property.AppInfoProperties;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class AppInfoMapper {
    private final AppInfoProperties appInfoProperties;

    public AppInfoResponseDto getInfo(){
        return AppInfoResponseDto.builder()
                .name(appInfoProperties.getName())
                .environment(appInfoProperties.getEnv())
                .current(LocalDateTime.now())
                .build();
    }
}
