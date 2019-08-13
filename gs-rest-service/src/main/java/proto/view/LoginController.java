package proto.view;

import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author danml
 */
public class LoginController implements Initializable {
    
    @FXML
    private Label label;

    @FXML
    private Button closeButton;
    
    @FXML
    public void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    public void handleCloseButton(ActionEvent e) {
     // Stage stage = (Stage) closeButton.getScene().getWindow();
      // stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}