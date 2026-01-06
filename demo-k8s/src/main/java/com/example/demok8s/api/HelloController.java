package com.example.demok8s.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Contrôleur REST pour gérer les requêtes de salutation
 * @author Ilyas MICHICH
 * @version 1.0
 */
@RestController
public class HelloController {

    /** Message de l'application configurable via variable d'environnement */
    @Value("${APP_MESSAGE:Hello from Spring Boot on Kubernetes}")
    private String appMessage;

    /**
     * Endpoint pour retourner un message de bienvenue
     * @return une Map contenant le message et le statut de l'application
     */
    @GetMapping("/api/hello")
    public Map<String, String> hello() {
        return Map.of(
                "message", appMessage,
                "status", "OK"
        );
    }
}
