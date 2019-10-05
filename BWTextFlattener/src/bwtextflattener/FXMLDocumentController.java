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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author blair
 */
public class FXMLDocumentController implements Initializable {
    private boolean textHasBeenFlattened = false;
    
    @FXML
    private RadioButton rbnSpace;

    @FXML
    private RadioButton rbnDisappear;

    @FXML
    private TextArea txtInput;

    @FXML
    private TextArea txtOutput;

    @FXML
    private Label lblStatusBar;

    @FXML
    private Button btnCopyToClipboard;

    @FXML
    private void userDidClickFlatten(ActionEvent event) {
        String replacementString = "";
        if (rbnSpace.isSelected()) {
            replacementString = " ";
        }

        String userText = txtInput.getText();
        String newText = userText.replaceAll("\\r|\\n", replacementString);
        txtOutput.setText(newText);

        btnCopyToClipboard.setDisable(false);
        this.textHasBeenFlattened = true;
    }

    @FXML
    private void userDidClickCopyToClipboard(ActionEvent event) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(txtOutput.getText());
        clipboard.setContent(content);
        
        lblStatusBar.setText("Copied to clipboard!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblStatusBar.setText("Ready.");
        btnCopyToClipboard.setDisable(true);
    }

    @FXML
    private void userDidPressKey(KeyEvent event) {
        final KeyCombination keyComb1 = new KeyCodeCombination(KeyCode.F,
                KeyCombination.CONTROL_DOWN);
        final KeyCombination keyComb2 = new KeyCodeCombination(KeyCode.C,
                KeyCombination.CONTROL_DOWN);
        
        // search for Ctrl + F
        if (keyComb1.match(event)) {
            System.out.println("Key Pressed: " + keyComb1);
            userDidClickFlatten(null);
        }
        
        // search for Ctrl + C
        if (keyComb2.match(event) && textHasBeenFlattened) {
            System.out.println("Key Pressed: " + keyComb2);
            userDidClickCopyToClipboard(null);
        }
    }
}
