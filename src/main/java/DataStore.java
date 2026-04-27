import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class DataStore {

    public static ObservableList<String> genres = FXCollections.observableArrayList();
    public static ObservableList<String> customers = FXCollections.observableArrayList();

    public static Map<String, List<String>> moviesMap = new HashMap<>();
    public static Map<String, List<String>> borrowedMap = new HashMap<>();
    public static Map<String, List<String>> returnedMap = new HashMap<>();
}
