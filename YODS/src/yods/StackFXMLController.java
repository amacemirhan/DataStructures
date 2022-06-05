package yods;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author amacemirhan
 */
public class StackFXMLController implements Initializable {

    @FXML
    private Button nextPage;
    Stack myStack = new Stack();
    @FXML
    private Button popB;
    @FXML
    private Button pushB;
    @FXML
    private Label st0;
    @FXML
    private Label st1;
    @FXML
    private Label st3;
    @FXML
    private Label st2;
    @FXML
    private Label st5;
    @FXML
    private Label st4;
    @FXML
    private Label st7;
    @FXML
    private Label st6;
    @FXML
    private Label st9;
    @FXML
    private Label st8;
    @FXML
    private Label st11;
    @FXML
    private Label st10;
    @FXML
    private TextField textStack;
    @FXML
    private Label warning;
    @FXML
    private TextField textHuffman;
    @FXML
    private Label warninHuff;
    @FXML
    private Button backBut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void ClickHuffman(ActionEvent event) {
        HuffmanCode hfc = new HuffmanCode();
        Results myR = new Results();
        String hf = textHuffman.getText();
        myR = hfc.createHuffmanTree(hf);
        warninHuff.setText(myR.Encoded + "\n" + myR.Codes);

    }

    int i = -1;

    @FXML
    public void ClickPush(javafx.event.ActionEvent event) throws IOException {
        String curr = textStack.getText();
        myStack.add(curr);
        i++;
        if (i == 0) {
            st0.setText(curr);
        } else if (i == 1) {
            st1.setText(curr);
        } else if (i == 2) {
            st2.setText(curr);
        } else if (i == 3) {
            st3.setText(curr);
        } else if (i == 4) {
            st4.setText(curr);
        } else if (i == 5) {
            st5.setText(curr);
        } else if (i == 6) {
            st6.setText(curr);
        } else if (i == 7) {
            st7.setText(curr);
        } else if (i == 8) {
            st8.setText(curr);
        } else if (i == 9) {
            st9.setText(curr);
        } else if (i == 10) {
            st10.setText(curr);
        } else if (i == 11) {
            st11.setText(curr);
        } else if (i > 11) {
            warning.setText("Stack Dolu.");
            i--;
            myStack.pop();
        }

    }

    @FXML
    public void ClickPop(javafx.event.ActionEvent event) throws IOException {
        if (i < 0) {
            warning.setText("Stack Boş.");
        } else {
            warning.setText("Çıkarıldı: " + myStack.pop());
            if (i == 0) {
                st0.setText(" ");
            } else if (i == 1) {
                st1.setText(" ");
            } else if (i == 2) {
                st2.setText(" ");
            } else if (i == 3) {
                st3.setText(" ");
            } else if (i == 4) {
                st4.setText(" ");
            } else if (i == 5) {
                st5.setText(" ");
            } else if (i == 6) {
                st6.setText(" ");
            } else if (i == 7) {
                st7.setText(" ");
            } else if (i == 8) {
                st8.setText(" ");
            } else if (i == 9) {
                st9.setText(" ");
            } else if (i == 10) {
                st10.setText(" ");
            } else if (i == 11) {
                st11.setText(" ");
            }
            i--;
        }
    }

    @FXML
    public void ClickBack(javafx.event.ActionEvent event) throws IOException {
        Parent geri = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene geris = new Scene(geri);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(geris);
        window.show();
    }

    @FXML
    void ClickNextPage(ActionEvent event) throws IOException {
        Parent StackToBst = FXMLLoader.load(getClass().getResource("BST.fxml"));
        
        Scene sceneSTB = new Scene(StackToBst);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(sceneSTB);
        window.show();
    }

}
