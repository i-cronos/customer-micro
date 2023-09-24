package pe.ibk.cpe.customer.application.rest.info.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.ibk.cpe.customer.application.rest.info.dto.AppInfoMapper;
import pe.ibk.cpe.customer.application.rest.info.dto.AppInfoResponseDto;

@RestController
@RequestMapping("/api/v1/info")
@AllArgsConstructor
public class AppInfoRestController {
    private final AppInfoMapper appInfoMapper;

    @GetMapping
    public ResponseEntity<AppInfoResponseDto> info() {
        return ResponseEntity.ok(appInfoMapper.getInfo());
    }
}
