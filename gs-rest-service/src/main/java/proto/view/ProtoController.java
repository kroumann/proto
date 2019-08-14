package proto.view;

import proto.models.*;
import org.springframework.stereotype.Component;

import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.fxml.Initializable;
import com.jfoenix.controls.*;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import java.net.URL;
import java.util.ResourceBundle;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.util.stream.Collectors;

@Component
public class ProtoController implements Initializable {

    @FXML
    private JFXTextField userInfosField;
    @FXML
    private JFXButton logoutBtn;


	@FXML
	private void logoutBtnHdl(ActionEvent event) {

	}


	@Override
    public void initialize(URL url, ResourceBundle rb) {
		//setOnAcion ...
	}

	public void setUserInfos(User user) {
		userInfosField.setText(user.getEmail() + " " + user.getAuthorities());
	}
	/*
    private ObservableList<Category> masterData = FXCollections.observableArrayList();

    public ProtoController() {
        masterData.add(new Category("category 1", "description 1", "image url 1"));
        masterData.add(new Category("category 1", "description 1", "image url 1"));
        masterData.add(new Category("category 1", "description 1", "image url 1"));
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

	*/
}