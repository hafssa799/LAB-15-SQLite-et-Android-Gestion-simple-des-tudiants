package projet.fst.ma.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity; // Version AndroidX
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import projet.fst.ma.app.classes.Etudiant;
import projet.fst.ma.app.service.EtudiantService;

public class MainActivity extends AppCompatActivity {

    private EditText nom, prenom, id;
    private Button add, rechercher, supprimer;
    private TextView res;
    private EtudiantService es;

    // Méthode utilitaire pour vider les champs de saisie
    private void viderChamps() {
        nom.setText("");
        prenom.setText("");
        id.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Initialisation du service CRUD
        es = new EtudiantService(this);

        // 2. Liaison des composants XML vers Java
        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        add = findViewById(R.id.bn); // Le bouton "Valider"

        id = findViewById(R.id.id);
        rechercher = findViewById(R.id.load);
        supprimer = findViewById(R.id.delete);
        res = findViewById(R.id.res); // Le TextView pour le résultat

        // --- BOUTON AJOUTER (Valider) ---
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = nom.getText().toString().trim();
                String p = prenom.getText().toString().trim();

                if (n.isEmpty() || p.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Veuillez remplir Nom et Prénom", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Insertion en base
                es.create(new Etudiant(n, p));

                // Log de vérification (visible dans Logcat)
                Log.d("SQLITE_CRUD", "Ajout : " + n + " " + p);

                viderChamps();
                Toast.makeText(MainActivity.this, "Étudiant ajouté avec succès", Toast.LENGTH_SHORT).show();
            }
        });

        // --- BOUTON CHERCHER ---
        rechercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputId = id.getText().toString().trim();

                if (inputId.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Saisissez un ID", Toast.LENGTH_SHORT).show();
                    return;
                }

                Etudiant e = es.findById(Integer.parseInt(inputId));

                if (e != null) {
                    // Affichage dans le TextView 'res'
                    res.setText(e.getNom() + " " + e.getPrenom());
                    Log.d("SQLITE_CRUD", "Trouvé : " + e.getNom());
                } else {
                    res.setText("");
                    Toast.makeText(MainActivity.this, "Étudiant introuvable", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // --- BOUTON SUPPRIMER ---
        supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputId = id.getText().toString().trim();

                if (inputId.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Saisissez un ID", Toast.LENGTH_SHORT).show();
                    return;
                }

                int targetId = Integer.parseInt(inputId);
                Etudiant e = es.findById(targetId);

                if (e != null) {
                    es.delete(e);
                    res.setText("");
                    viderChamps();
                    Toast.makeText(MainActivity.this, "Étudiant ID " + targetId + " supprimé", Toast.LENGTH_SHORT).show();
                    Log.d("SQLITE_CRUD", "Suppression ID : " + targetId);
                } else {
                    Toast.makeText(MainActivity.this, "Aucun étudiant à supprimer avec cet ID", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}