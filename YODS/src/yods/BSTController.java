
package yods;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
public class BSTController implements Initializable {

    @FXML
    private Button addBST;
    @FXML
    private TextField textBST;
    @FXML
    private Label AnaBilgi;
    @FXML
    private Button postorder;
    @FXML
    private Button preorder;
    @FXML
    private Button inorder;
    @FXML
    private Label GezinmeLabel;
    @FXML
    private Button Left;
    @FXML
    private Button Right;
    @FXML
    private Button Parent;
    @FXML
    private Button previousPage;
    @FXML
    private Button nextPage;
    @FXML
    private Button deleteBST;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    BinarySearchTree.Node root1 = null;
    BinarySearchTree bst = new BinarySearchTree(root1);
    boolean isfirst=true;
    @FXML
    private void ClickAdd(ActionEvent event) {
        String item=textBST.getText();
        try{
            int number = Integer.parseInt(item);
            if(isfirst){
            root1=bst.insert(root1, number);
            isfirst=false;
            }else
            bst.insert(root1,number);
            AnaBilgi.setText("Sayi Eklendi: "+ number);
        }
        catch (NumberFormatException ex){
            AnaBilgi.setText("Lutfen sayi giriniz!");
        }
    }

    @FXML
    private void ClickPostOrder(ActionEvent event) {
        bst.postOrder(root1);
        AnaBilgi.setText(bst.OrderSonuc);
        bst.OrderSonuc="";
    }

    @FXML
    private void ClickPreOrder(ActionEvent event) {
        bst.preOrder(root1);
        AnaBilgi.setText(bst.OrderSonuc);
        bst.OrderSonuc="";
    }

    @FXML
    private void ClickInOrder(ActionEvent event) {
        bst.InOrder(root1);
        AnaBilgi.setText(bst.OrderSonuc);
        bst.OrderSonuc="";
    }

    BinarySearchTree.Node curr = root1;
    @FXML
    private void ClickLeft(ActionEvent event) {
       if(curr!=null){
           curr = curr.left;
           GezinmeLabel.setText(curr.value+"");  
       }else
            GezinmeLabel.setText("Null");
            
        
    }

    @FXML
    private void ClickRight(ActionEvent event) {
        if(curr!=null){
           curr = curr.right;
           GezinmeLabel.setText(curr.value+"");   
       }else
            GezinmeLabel.setText("Null");
    }

    @FXML
    private void ClickParent(ActionEvent event) {
        curr=root1;
        GezinmeLabel.setText(curr.value+"");
    }

    @FXML
    private void ClickpreviousPage(ActionEvent event) throws IOException {
        Parent ileri = FXMLLoader.load(getClass().getResource("StackFXML.fxml"));
        Scene ileris = new Scene(ileri);
        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        window.setScene(ileris);
        window.show();
    }

    @FXML
    private void ClicknextPage(ActionEvent event) throws IOException {
        Parent ileri = FXMLLoader.load(getClass().getResource("FXMLders.fxml"));
        Scene ileris = new Scene(ileri);
        Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        window.setScene(ileris);
        window.show();
    }

    @FXML
    private void ClickDel(ActionEvent event) {
        try{
        int deger = Integer.parseInt(textBST.getText());
        
        BinarySearchTree.Node sil=new BinarySearchTree.Node(deger);
        if(bst.deleteNode(root1, sil)==null)
            AnaBilgi.setText("Agacta bulunmuyor : "+deger);
        else
        AnaBilgi.setText("Silindi: "+deger);
                }
        catch(NumberFormatException ex){
            AnaBilgi.setText("Lütfen sayi giriniz.");
        }
        
    }
    
}
