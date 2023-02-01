package TwoUp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controller {

    private Stage stage;

    private Scene scene;

    private Parent root;

    @FXML

    private Button loginButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    public void loginButtonOnAction(ActionEvent e) {

        if (usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false) {
            //loginMessageLabel.setText("Please Enter Valid Username or Password");
            validateLogin();

        } else {
            loginMessageLabel.setText("Please Enter Username or Password");
        }

    }
    @FXML
    private Button quitButton;

    @FXML
    private void sceneTrigger() throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("TestPage.fxml"));
        stage = (Stage)loginMessageLabel.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void quitButtonOnAction(ActionEvent e) {
        Stage    stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "select count(1) FROM two_up_users WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordPasswordField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    loginMessageLabel.setText("Welcome");
                    sceneTrigger();
                } else{
                    loginMessageLabel.setText("Invalid Login Please Try Again");
                }
            }

        } catch (Exception e){
                e.printStackTrace();
        }
    }
}