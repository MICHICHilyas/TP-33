package com.example.demok8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale de l'application Spring Boot pour le déploiement sur Kubernetes
 * @author Ilyas MICHICH
 * @version 1.0
 */
@SpringBootApplication
public class DemoK8sApplication {

	/**
	 * Méthode principale pour démarrer l'application Spring Boot
	 * @param args les arguments de la ligne de commande
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoK8sApplication.class, args);
	}

}
