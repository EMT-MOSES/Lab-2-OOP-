import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class GenresView extends VBox {

    public GenresView() {

        Label label = new Label("Add Genre");
        TextField txtGenre = new TextField();
        Button btnSave = new Button("Save");

        ListView<String> list = new ListView<>(DataStore.genres);

        btnSave.setOnAction(e -> {
            String genre = txtGenre.getText();
            if (!genre.isEmpty()) {
                DataStore.genres.add(genre);
                txtGenre.clear();
            }
        });

        this.setSpacing(10);
        this.getChildren().addAll(label, txtGenre, btnSave, list);
    }
}
