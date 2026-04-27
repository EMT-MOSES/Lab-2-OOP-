import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        Button btnGenres = new Button("Genres");
        Button btnMovies = new Button("Movies");
        Button btnCustomers = new Button("Customers");
        Button btnRentals = new Button("Rentals");

        btnGenres.setOnAction(e -> stage.setScene(new Scene(new GenresView(), 500, 400)));
        btnMovies.setOnAction(e -> stage.setScene(new Scene(new MoviesView(), 500, 400)));
        btnCustomers.setOnAction(e -> stage.setScene(new Scene(new CustomersView(), 500, 400)));
        btnRentals.setOnAction(e -> stage.setScene(new Scene(new RentalsView(), 600, 500)));

        VBox root = new VBox(10, btnGenres, btnMovies, btnCustomers, btnRentals);

        stage.setTitle("Video Library System");
        stage.setScene(new Scene(root, 300, 200));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
