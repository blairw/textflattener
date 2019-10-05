/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bwtextflattener;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author blair
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private RadioButton rbnSpace;
    private RadioButton rbnDisappear;
    private TextArea txtInput;
    private TextArea txtOutput;
    
    @FXML
    private void userDidClickFlatten(ActionEvent event) {
        String userText = txtInput.getText();
        txtOutput.setText(userText);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
