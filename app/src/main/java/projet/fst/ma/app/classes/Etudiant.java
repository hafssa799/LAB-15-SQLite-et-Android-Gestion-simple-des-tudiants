package projet.fst.ma.app.classes;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;

    // Constructeur avec paramètres (utilisé pour la création)
    public Etudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    // Constructeur vide (requis pour SQLite / Firebase / frameworks)
    public Etudiant() {
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Optionnel : méthode toString pour faciliter le débogage
    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}