import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class CustomersView extends VBox {

    public CustomersView() {

        TextField txtName = new TextField();
        Button btnAdd = new Button("Add Customer");

        ListView<String> list = new ListView<>(DataStore.customers);

        btnAdd.setOnAction(e -> {
            String name = txtName.getText();
            if (!name.isEmpty()) {
                DataStore.customers.add(name);
                txtName.clear();
            }
        });

        this.setSpacing(10);
        this.getChildren().addAll(
                new Label("Customer Name"),
                txtName,
                btnAdd,
                list
        );
    }
}
