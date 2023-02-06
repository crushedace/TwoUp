package TwoUp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Random;

public class TwoUpController {

    @FXML
    private Label currentScoreDisplay;

    @FXML
    private Button headsButton;

    @FXML
    private Button quitButton2;

    public int randomNumber() {

        Random num = new Random();
        int upperbound = 3;

        int aNumber = num.nextInt(upperbound);

        return aNumber;
    }

    @FXML
    public void headsButtonOnAction(ActionEvent e) {

        TwoUpController aNumber = new TwoUpController();
        int randomNumber = aNumber.randomNumber();

        currentScoreDisplay.setText(String.valueOf(randomNumber));
    }

    @FXML
    public void tailsButtonOnAction(ActionEvent e) {

        TwoUpController aNumber = new TwoUpController();
        int randomNumber = aNumber.randomNumber();

        currentScoreDisplay.setText(String.valueOf(randomNumber));
    }

    @FXML
    private void quitButton2OnAction(ActionEvent e) {
        Stage stage = (Stage) quitButton2.getScene().getWindow();
        stage.close();
    }
}