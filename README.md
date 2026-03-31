# LAB-15 - SQLite-et-Android-Gestion-simple-des-tudiants (Application de Gestion d'Étudiants (Android SQLite))

Cette application Android permet de gérer une base de données d'étudiants (CRUD) en utilisant SQLite. Elle suit une architecture propre séparant le modèle, le service d'accès aux données et l'interface utilisateur.


##  État d'avancement des Tâches

###  Tâche 1 — Couche métier : Modèle Etudiant

-  **Étape 1.1** : Création du projet `app`  (Package : `ma.fst.projet`).
  
-  **Étape 1.2** : Création de la classe `Etudiant` dans `projet.fst.ma.app.classes`.
  
    - Attributs : `id`, `nom`, `prenom`.

###  Tâche 2 — Accès aux données : SQLite & Service

-  **Étape 2.1** : Création de `MySQLiteHelper`  (`projet.fst.ma.app.util`).
  
    - Base de données : `ecole`.
      
    - Table : `etudiant` (id, nom, prenom).
      
-  **Étape 2.2** : Création de `EtudiantService`  (`projet.fst.ma.app.service`).
  
    - Implémentation du CRUD : `create`, `update`, `delete`, `findById`, `findAll`.

###  Tâche 3 — Présentation : Validation Logcat

-   **Étape 3.1** : Test de validation en console.
  
    - Vérification du cycle Insertion -> Recherche -> Suppression via Logcat.

### Tâche 4 — UI CRUD : Layout & Événements

-  **Étape 4.1** : Design de l'interface (`activity_main.xml`).
 
    - Utilisation d'un `LinearLayout` vertical.
      
    - Intégration du style personnalisé `myStyle` pour les labels.
      
    - Champs de saisie (`EditText`) et boutons d'action.
      
-  **Étape 4.2** : Programmation de `MainActivity`.
  
    - **Ajouter** : Récupère les saisies, crée l'étudiant et vide les champs.
      
    - **Chercher** : Recherche par ID et affiche le résultat dans un TextView.
      
    - **Supprimer** : Recherche par ID puis supprime l'entrée de la base.
      
    - **Contrôles** : Gestion des champs vides et des étudiants introuvables via des `Toast`.

## 🎬 Démonstration 







