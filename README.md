# TP-33 : Déploiement Spring Boot sur Kubernetes

## 📋 Description

Ce projet démontre le **déploiement** d'une application **Spring Boot** sur un cluster **Kubernetes**.

## 📁 Structure du Projet

```
TP-33-Ilyas/
├── k8s/
│   ├── deployment.yaml     # Deployment de l'application
│   ├── service.yaml        # Service Kubernetes
│   └── configmap.yaml      # Configuration externalisée
├── Dockerfile
├── pom.xml
└── src/
```

## 📝 deployment.yaml

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: spring-app
spec:
  replicas: 3
  selector:
    matchLabels:
      app: spring-app
  template:
    metadata:
      labels:
        app: spring-app
    spec:
      containers:
      - name: spring-app
        image: myregistry/spring-app:latest
        ports:
        - containerPort: 8080
        livenessProbe:
          httpGet:
            path: /actuator/health/liveness
            port: 8080
        readinessProbe:
          httpGet:
            path: /actuator/health/readiness
            port: 8080
```

## 🚀 Déploiement

```bash
# Appliquer tous les manifestes
kubectl apply -f k8s/

# Vérifier le déploiement
kubectl get deployments
kubectl get pods
kubectl get services

# Scaler l'application
kubectl scale deployment spring-app --replicas=5
```

### Avec Minikube

```bash
minikube start
minikube addons enable ingress
kubectl apply -f k8s/
minikube service spring-app-service
```

## 📊 Commandes Utiles

| Commande | Description |
|----------|-------------|
| `kubectl get all` | Voir toutes les ressources |
| `kubectl describe pod <name>` | Détails d'un pod |
| `kubectl logs <pod>` | Voir les logs |
| `kubectl exec -it <pod> -- bash` | Shell dans un pod |

## ✨ Fonctionnalités

- ✅ Deployment avec replicas
- ✅ Service LoadBalancer
- ✅ ConfigMap pour configuration
- ✅ Health probes (liveness/readiness)
- ✅ Rolling updates

## 👨‍💻 Auteur

**Ilyas MICHICH**

---
*Travail Pratique - Déploiement Kubernetes*
