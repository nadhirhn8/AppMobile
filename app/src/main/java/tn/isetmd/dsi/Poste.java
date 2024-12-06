package tn.isetmd.dsi;
import java.util.Objects;

public class Poste {
    private String titre;
    private String description;
    private int image;

    public Poste() {
    }

    public Poste(String titre, String description, int image) {
        this.titre = titre;
        this.description = description;
        this.image = image;
    }


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Poste{" +
                "titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Poste poste = (Poste) o;
        return image == poste.image && Objects.equals(titre, poste.titre) && Objects.equals(description, poste.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titre, description, image);
    }
}