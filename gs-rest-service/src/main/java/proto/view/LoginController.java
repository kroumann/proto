package proto.view;

import proto.*;
import static proto.ProtoConstants.CSS_PATH;
import static proto.ProtoConstants.HEIGHT;
import static proto.ProtoConstants.PROJECT_TITLE;
import static proto.ProtoConstants.WIDTH;

import java.awt.Button;
import java.awt.TextField;
import javax.swing.JPasswordField;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JButton;

import com.jfoenix.controls.*;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;
import proto.ProtoApp;
import proto.models.User;
import proto.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class LoginController implements Initializable {

    @FXML
    private JFXTextField loginTxtField;

    @FXML
    private JFXPasswordField passwordTxtFld;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private JFXButton exitBtn;

    @Autowired
    private UserService userService;

    @FXML
    private void hdlLoginButton(ActionEvent event) {
      Stage primStage = (Stage) loginBtn.getScene().getWindow();

      User user  = this.userService.findByUsername(loginTxtField.getText());
      System.out.println("found user:" + user.getFirstName() + " " + user.getLastName());

      try {
            FXMLLoader loader = new FXMLLoader(ProtoApp.class.getResource("/view/ProtoMain.fxml"));
            //AnchorPane page = (AnchorPane) loader.load();
            Parent page = (Parent) loader.load();
            ProtoController protoController = loader.getController();
            Scene scene = new Scene(page);
    		primStage.setTitle(PROJECT_TITLE);
    		primStage.setHeight(HEIGHT);
    		primStage.setWidth(WIDTH);
    		primStage.centerOnScreen();
    		primStage.setOnCloseRequest(e -> {
    			Platform.exit();
    			System.exit(0);
    		});
            primStage.setScene(scene);
            //primStage.initStyle(StageStyle.TRANSPARENT);
            //ProtoController protoController = loader.getController();
            protoController.setUserInfos(user);
    		primStage.show();
          // stage.close();
      } catch (Exception e){
            System.out.println(e.getMessage());
      }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }


    public void showUserInfo(User user) {


    }
}