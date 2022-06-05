/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package yods;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
 * @author dicle
 */
public class FXMLBitirmeProjesiController implements Initializable {

    @FXML
    private Label ogrIsimLabel;

    @FXML
    private TextField ogrIsimField;

    @FXML
    private Button ekleButton;

    @FXML
    private Button cikarButton;

    @FXML
    private Button geri_buton;
    @FXML
    private Label doluMuLabel;
    @FXML
    private Label qu1;

    @FXML
    private Label qu9;

    @FXML
    private Label qu2;

    @FXML
    private Label qu10;

    @FXML
    private Label qu3;

    @FXML
    private Label qu4;

    @FXML
    private Label qu5;

    @FXML
    private Label qu8;

    @FXML
    private Label qu7;

    @FXML
    private Label qu6;

    Queue<Integer> kuyruk = new Queue(10);
    int i = 0;
    int l = 0;
    boolean isFirst = true;
    @FXML
    private Button returnMain;

    @FXML
    void dequeue(ActionEvent event) {  
        if (kuyruk.BosMu()) {
            doluMuLabel.setText("Kuyruk zaten boş");
        } else {
            doluMuLabel.setText("Silme Basarili: " + kuyruk.dequeue());
            l = l%11;
            if (l == 1) {
                qu1.setText(" ");
            } else if (l == 2) {
                qu2.setText(" ");
            } else if (l == 3) {
                qu3.setText(" ");
            } else if (l == 4) {
                qu4.setText(" ");
            } else if (l == 5) {
                qu5.setText(" ");
            } else if (l == 6) {
                qu6.setText(" ");
            } else if (l == 7) {
                qu7.setText(" ");
            } else if (l == 8) {
                qu8.setText(" ");
            } else if (l == 9) {
                qu9.setText(" ");
            } else if (l == 10) {
                qu10.setText(" ");
            }
            l++;
        }
    }

    @FXML
    void enqueue(ActionEvent event) {
        String eklenecek = ogrIsimField.getText();
        if (kuyruk.DoluMu()) {
            doluMuLabel.setText("Kuyruk doldu...");
        } else {
            i=i%11;
            kuyruk.enqueue(eklenecek);
            if(isFirst){
             l++;
            isFirst=false;
            }
            i++;
            if (i == 1) {
                qu1.setText(eklenecek);
            } else if (i == 2) {
                qu2.setText(eklenecek);
            } else if (i == 3) {
                qu3.setText(eklenecek);
            } else if (i == 4) {
                qu4.setText(eklenecek);
            } else if (i == 5) {
                qu5.setText(eklenecek);
            } else if (i == 6) {
                qu6.setText(eklenecek);
            } else if (i == 7) {
                qu7.setText(eklenecek);
            } else if (i == 8) {
                qu8.setText(eklenecek);
            } else if (i == 9) {
                qu9.setText(eklenecek);
            } else if (i == 10) {
                qu10.setText(eklenecek);
            }

        }
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    void geriDon2(ActionEvent event) throws IOException {
        Parent dersEkrani = FXMLLoader.load(getClass().getResource("FXMLDers.fxml"));
        Scene anaScene = new Scene(dersEkrani);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(anaScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ReturnAna(ActionEvent event) throws IOException {
        Parent dersEkrani = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene anaScene = new Scene(dersEkrani);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(anaScene);
        window.show();
    }

}
