import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class RentalsView extends VBox {

    private ListView<String> borrowedList = new ListView<>();
    private ListView<String> returnedList = new ListView<>();

    public RentalsView() {

        ComboBox<String> cmbCustomer = new ComboBox<>(DataStore.customers);
        ComboBox<String> cmbGenre = new ComboBox<>(DataStore.genres);
        ComboBox<String> cmbMovie = new ComboBox<>();

        Button btnSave = new Button("Save Rental");
        Button btnReturn = new Button("Return Movie");

        cmbGenre.setOnAction(e -> {
            String genre = cmbGenre.getValue();
            List<String> movies = DataStore.moviesMap.getOrDefault(genre, new ArrayList<>());
            cmbMovie.setItems(FXCollections.observableArrayList(movies));
        });

        btnSave.setOnAction(e -> {
            String customer = cmbCustomer.getValue();
            String movie = cmbMovie.getValue();

            if (customer != null && movie != null) {
                DataStore.borrowedMap.putIfAbsent(customer, new ArrayList<>());
                DataStore.borrowedMap.get(customer).add(movie);
                updateLists(customer);
            }
        });

        btnReturn.setOnAction(e -> {
            String customer = cmbCustomer.getValue();
            String movie = borrowedList.getSelectionModel().getSelectedItem();

            if (customer != null && movie != null && DataStore.borrowedMap.get(customer) != null) {
                DataStore.borrowedMap.get(customer).remove(movie);

                DataStore.returnedMap.putIfAbsent(customer, new ArrayList<>());
                DataStore.returnedMap.get(customer).add(movie);

                updateLists(customer);
            }
        });

        cmbCustomer.setOnAction(e -> updateLists(cmbCustomer.getValue()));

        this.setSpacing(10);
        this.getChildren().addAll(
                new Label("Customer"), cmbCustomer,
                new Label("Genre"), cmbGenre,
                new Label("Movie"), cmbMovie,
                btnSave,
                new Label("Borrowed"), borrowedList,
                btnReturn,
                new Label("Returned"), returnedList
        );
    }

    private void updateLists(String customer) {
        borrowedList.setItems(FXCollections.observableArrayList(
                DataStore.borrowedMap.getOrDefault(customer, new ArrayList<>())
        ));

        returnedList.setItems(FXCollections.observableArrayList(
                DataStore.returnedMap.getOrDefault(customer, new ArrayList<>())
        ));
    }
}
