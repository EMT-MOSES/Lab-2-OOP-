import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class MoviesView extends VBox {

    public MoviesView() {

        TextField txtMovie = new TextField();
        ComboBox<String> cmbGenre = new ComboBox<>(DataStore.genres);
        Button btnAdd = new Button("Add Movie");

        ListView<String> listMovies = new ListView<>();

        btnAdd.setOnAction(e -> {
            String movie = txtMovie.getText();
            String genre = cmbGenre.getValue();

            if (movie != null && genre != null) {
                DataStore.moviesMap.putIfAbsent(genre, new ArrayList<>());
                DataStore.moviesMap.get(genre).add(movie);
                txtMovie.clear();
            }
        });

        cmbGenre.setOnAction(e -> {
            String genre = cmbGenre.getValue();
            List<String> movies = DataStore.moviesMap.getOrDefault(genre, new ArrayList<>());
            listMovies.setItems(FXCollections.observableArrayList(movies));
        });

        this.setSpacing(10);
        this.getChildren().addAll(
                new Label("Movie Name"),
                txtMovie,
                new Label("Select Genre"),
                cmbGenre,
                btnAdd,
                listMovies
        );
    }
}
