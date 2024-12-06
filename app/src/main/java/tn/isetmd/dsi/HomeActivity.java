package tn.isetmd.dsi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeActivity extends AppCompatActivity {
    ListView listViewPosts;

    //String[] postsArray = {"Post 1", "Post 2", "Post 3", "Post 4"};

    Poste[] posts={
            new Poste("post 1" , "description post 1" , R.drawable.image1),
            new Poste("post 2" , "description post 2" , R.drawable.image2),
            new Poste("post 3" , "description post 3" , R.drawable.image3),
            new Poste("post 4" , "description post 4" , R.drawable.image4),
            new Poste("post 5" , "description post 5" , R.drawable.image5),
    };

    final ArrayList<Poste> posteList = new ArrayList<Poste>(Arrays.asList(posts));
    private Activity homeActivity =this;
    PostsAdapter posteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Adjust system bars padding if needed
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize listViewPosts

        listViewPosts = findViewById(R.id.ListViewPosts);

       /* ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                postsArray
        );*/

        //listViewPosts.setAdapter(adapter);

        posteAdapter = new PostsAdapter(
                this , R.layout.item_post,
                posteList
        );
        listViewPosts.setAdapter(posteAdapter);
        listViewPosts.setOnItemClickListener((new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Poste clickedPost = posts[position];
                String titreClickedItem = clickedPost.getTitre();

                /*Toast.makeText(
                        HomeActivity.this,
                        "titre de l'item = " + titreClickedItem ,
                        Toast.LENGTH_SHORT
                ).show();*/

                Intent intent = new Intent(HomeActivity.this, PostDetailsActivity.class);
                intent.putExtra("titre", clickedPost.getTitre());
                intent.putExtra("description", clickedPost.getDescription());
                intent.putExtra("image", clickedPost.getImage());
                startActivity(intent);

            }
        }));
    }
}
