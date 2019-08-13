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
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;
import proto.ProtoApp;


import org.springframework.stereotype.Component;

@Component
public class LoginController {

    @FXML
    private JFXTextField loginTxtField;

    @FXML
    private JFXPasswordField passwordTxtFld;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private JButton exitBtn;

    private void hdlLoginButton() {
      Stage primStage = (Stage) loginBtn.getScene().getWindow();

      try {
            FXMLLoader loader = new FXMLLoader(ProtoApp.class.getResource("/view/ProtoMain.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Scene scene = new Scene(page);
            //scene.getStylesheets().add("/view/proto.css");
    		primStage.setTitle(PROJECT_TITLE);
    		primStage.setHeight(HEIGHT);
    		primStage.setWidth(WIDTH);
    		primStage.centerOnScreen();
    		primStage.setOnCloseRequest(e -> {
    			Platform.exit();
    			System.exit(0);
    		});
            primStage.setScene(scene);
            primStage.initStyle(StageStyle.TRANSPARENT);
    		primStage.show();
          // stage.close();
      } catch (Exception e){
            System.out.println(e.getMessage());
      }
    }

    @FXML
    public void initialize() {
        //
    }


    public void initManager() {
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
              hdlLoginButton();
              }
            });
    }
}