package tn.isetmd.dsi;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PostDetailsActivity extends AppCompatActivity {
    TextView tvTitre, tvDescription;
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_post_details);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Liaison avec les widgets
        tvTitre = findViewById(R.id.tvTitreDetails);
        tvDescription = findViewById(R.id.tvDescriptionDetails);
        ivImage = findViewById(R.id.ivImageDetails);

        // Récupérer les données passées via Intent
        String titre = getIntent().getStringExtra("titre");
        String description = getIntent().getStringExtra("description");
        int imageRes = getIntent().getIntExtra("image", -1);

        // Affecter les données aux widgets
        if (titre != null) tvTitre.setText(titre);
        if (description != null) tvDescription.setText(description);
        if (imageRes != -1) ivImage.setImageResource(imageRes);
    }
}
