package com.example.authserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "Recursos Protegidos", description = "Exige JWT válido")
@SecurityRequirement(name = "bearerAuth")
public class TestProtectedController {

    @Operation(summary = "Acesso para todos usuários autenticados")
    @GetMapping("/hello")
    public String hello() {
        return "Olá! Endpoint protegido acessado.";
    }

    @Operation(summary = "Acesso apenas para ADMIN")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "Bem-vindo Admin!";
    }
}
