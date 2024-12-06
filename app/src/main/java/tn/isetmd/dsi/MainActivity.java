package tn.isetmd.dsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText etLogin;
    EditText etPassword;
    Button btnLogin;
    TextView etCCompte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Récupère les objets de l'interface
        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        etCCompte = findViewById(R.id.etCCompte);

        // Listener pour le bouton de connexion
        btnLogin.setOnClickListener(view -> {
            System.out.println("Le bouton est cliqué");
            String login = etLogin.getText().toString();
            String password = etPassword.getText().toString();

            if (login.equals("admin") && password.equals("1234")) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("username", login);
                intent.putExtra("password", password);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Login incorrect!", Toast.LENGTH_LONG).show();
            }
        });

        // Listener pour créer un compte
        etCCompte.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CreateCompteActivity.class);
            startActivity(intent);
        });

        // Affiche les informations de connexion si disponibles
        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");

        if (username != null && password != null) {
            Toast.makeText(getApplicationContext(), username + "/" + password, Toast.LENGTH_LONG).show();
        }
    }
}
