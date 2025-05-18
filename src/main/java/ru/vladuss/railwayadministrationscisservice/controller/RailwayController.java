package ru.vladuss.railwayadministrationscisservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.vladuss.railwayadministrationscisservice.dto.RailwayAdminRequestDto;
import ru.vladuss.railwayadministrationscisservice.dto.RailwayAdminResponseDto;
import ru.vladuss.railwayadministrationscisservice.service.RailwayAdminsService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admins")
public class RailwayController {
    private final RailwayAdminsService service;

    @Autowired
    public RailwayController(RailwayAdminsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RailwayAdminResponseDto> create(@RequestBody @Valid RailwayAdminRequestDto dto) {
        RailwayAdminResponseDto saved = service.create(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{codeJa}")
                .buildAndExpand(saved.getCodeJa())
                .toUri();

        return ResponseEntity.created(location).body(saved);
    }

    @GetMapping("/{codeJa}")
    public ResponseEntity<RailwayAdminResponseDto> get(@PathVariable Long codeJa) {
        return ResponseEntity.ok(service.getById(codeJa));
    }

    @GetMapping
    public ResponseEntity<List<RailwayAdminResponseDto>> list() {
        return ResponseEntity.ok(service.getALl());
    }

    @DeleteMapping("/{codeJa}")
    public ResponseEntity<Void> delete(@PathVariable Long codeJa) {
        service.delete(codeJa);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{codeJa}")
    public ResponseEntity<RailwayAdminResponseDto> update(@PathVariable Long codeJa, @RequestBody @Valid RailwayAdminRequestDto dto) {
        RailwayAdminResponseDto updated = service.update(codeJa, dto);
        return ResponseEntity.ok(updated);
    }

}
