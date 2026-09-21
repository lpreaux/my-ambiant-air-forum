# My Ambiant Air — forum (projet de formation QUALAIR)

> Prototype pédagogique non maintenu, conservé pour documenter le travail réalisé pendant le projet de formation QUALAIR.

API de forum en Java 21 / Spring Boot. Elle modélise des catégories, sujets et commentaires avec Spring Data JPA et expose des ressources HATEOAS.

## État

Le dépôt contient un prototype en un seul commit, sans interface intégrée ni procédure de déploiement. Il ne doit pas être considéré comme un service prêt pour la production.

## Lancement local

Prérequis : Java 21 et PostgreSQL.

```bash
export DATABASE_URL=jdbc:postgresql://localhost:5432/forum
export DATABASE_USER=forum
export DATABASE_PASSWORD=change-me
./mvnw spring-boot:run
```

Les identifiants OAuth expérimentaux ont été retirés de la configuration. Toute valeur anciennement versionnée doit être rotatée et purgée de l'historique avant une nouvelle publication du dépôt.
