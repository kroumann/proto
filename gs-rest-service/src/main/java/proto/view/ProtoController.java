package proto.view;

import proto.models.*;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

import java.util.stream.Collectors;

@Component
public class ProtoController {

	public static final int PAGE_ITEMS_COUNT = 10;

    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;
    @FXML
    private Pagination pagination;
    @FXML
    private Label searchLabel;

    private ObservableList<Category> masterData = FXCollections.observableArrayList();

    public ProtoController() {
        masterData.add(new Category("category 1", "description 1", "image url 1"));
        masterData.add(new Category("category 1", "description 1", "image url 1"));
        masterData.add(new Category("category 1", "description 1", "image url 1"));
    }

    @FXML
    private void initialize() {

        // search panel
        searchButton.setText("Search");
        searchButton.setOnAction(event -> loadData());
        searchButton.setStyle("-fx-background-color: #457ecd; -fx-text-fill: #ffffff;");

        searchField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                loadData();
            }
        });

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            searchLabel.setText(newValue);
        });

        pagination.setPageFactory(ProtoController.this::createPage);
    }

    private Node createPage(Integer pageIndex) {

        VBox dataContainer = new VBox();

        TableView<Category> tableView = new TableView<>(masterData);
        TableColumn id = new TableColumn("Name");
        TableColumn name = new TableColumn("Description");
        TableColumn employed = new TableColumn("image URL");

        tableView.getColumns().addAll(id, name, employed);
        dataContainer.getChildren().add(tableView);

        return dataContainer;
    }

    private void loadData() {

        String searchText = searchField.getText();

        Task<ObservableList<Category>> task = new Task<ObservableList<Category>>() {
            @Override
            protected ObservableList<Category> call() throws Exception {
                updateMessage("Loading data");
                return FXCollections.observableArrayList(masterData
                        .stream()
                        .filter(value -> value.getName().toLowerCase().contains(searchText))
                        .collect(Collectors.toList()));
            }
        };

        task.setOnSucceeded(event -> {
            masterData = task.getValue();
            pagination.setVisible(true);
            pagination.setPageCount(masterData.size() / PAGE_ITEMS_COUNT);
        });

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }
}