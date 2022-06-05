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
public class FXMLdersController implements Initializable {
    LinkedList dersler = new LinkedList();

    @FXML
    private Label uyariLabel;

    @FXML
    private TextField kodu;

    @FXML
    private TextField kredisi;

    @FXML
    private TextField adi;

    @FXML
    private TextField silinecekKod;

        @FXML
    private Label adLabel1;

    @FXML
    private Label kodLabel1;

    @FXML
    private Label krediLabel1;

    @FXML
    private Label adLabel2;

    @FXML
    private Label kodLabel2;

    @FXML
    private Label krediLabel2;
    @FXML
    private Label kodLabel3;

    @FXML
    private Label adLabel3;

    @FXML
    private Label krediLabel3;
    @FXML
    private Label no1;

    @FXML
    private Label no2;

    @FXML
    private Label no3;
    @FXML
    private Label bilgiLabel;
    int number=0; 
    @FXML
    private Button ekleB;
    @FXML
    private Button silB;
    @FXML
    private Button listeleB;
    @FXML
    private Button geriB;
    @FXML
    private Button ileriB;
    @FXML
    void ekle(ActionEvent event) {
        try{
        String dersAdi=adi.getText();
        String dersKodu=kodu.getText();
        int kredi=Integer.parseInt(kredisi.getText());
        dersler.add(dersAdi, dersKodu, kredi);
        bilgiLabel.setText("Ekleme tamamlandı.");
        number++;
        }
        catch(NumberFormatException ex){
            bilgiLabel.setText("Lütfen Tam sayı giriniz.");
        }
    }

    @FXML
    void geri(ActionEvent event) throws IOException {
        Parent dersEkrani = FXMLLoader.load(getClass().getResource("BST.fxml"));
        Scene dersScene= new Scene(dersEkrani);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(dersScene);
        window.show();
    }

    @FXML
    void listele(ActionEvent event) {
        LinkedList.Ders temp=dersler.ilk;
        if(number==0){
        bilgiLabel.setText("Listelenecek ders bulunmamakta.");
        }else{
            
            try{
            
            adLabel1.setText(temp.dersAdi);
            kodLabel1.setText(temp.dersKodu);
            krediLabel1.setText(String.valueOf(temp.kredi));
        
            temp=temp.next;
            adLabel2.setText(temp.dersAdi);
            kodLabel2.setText(temp.dersKodu);
            krediLabel2.setText(String.valueOf(temp.kredi));
        
            temp=temp.next;
            adLabel3.setText(temp.dersAdi);
            kodLabel3.setText(temp.dersKodu);
            krediLabel3.setText(String.valueOf(temp.kredi));
            
            }catch(NullPointerException ex){
            
            }
            
        }

    }

    @FXML
    void sil(ActionEvent event) {
        String silinecek= silinecekKod.getText();
        if(dersler.remove(silinecek)){
            if(kodLabel3.getText().equals(silinecek)){
            adLabel3.setText(" ");
            krediLabel3.setText(" ");
            kodLabel3.setText(" ");
            }else if(kodLabel2.getText().equals(silinecek)){
            adLabel2.setText(" ");
            krediLabel2.setText(" ");
            kodLabel2.setText(" ");
            }else if(kodLabel1.getText().equals(silinecek)){
            adLabel1.setText(" ");
            krediLabel1.setText(" ");
            kodLabel1.setText(" ");
            }
            bilgiLabel.setText("Silindi.");
            number--;
        }else{
            bilgiLabel.setText("Girdiğiniz kodlu bir ders bulunamadi.");
        }        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ileri(ActionEvent event) throws IOException {
        Parent dersEkrani = FXMLLoader.load(getClass().getResource("FXMLBitirmeProjesi.fxml"));
        Scene dersScene= new Scene(dersEkrani);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(dersScene);
        window.show();
    }
    
}
