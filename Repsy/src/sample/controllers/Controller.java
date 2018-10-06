package sample.controllers;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.reactfx.Subscription;
import java.io.File;
import java.time.Duration;
import static sample.Constants.Configs.*;


public class Controller extends Application{
private Stage stage;
@FXML public Pane panelSote;

    CodeArea codeArea = new CodeArea();
@FXML protected void initialize(){
    // add line numbers to the left of area
    codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
    Subscription cleanupWhenNoLongerNeedIt = codeArea.multiPlainChanges().
            successionEnds(Duration.ofMillis(10)).
            subscribe(ignore -> codeArea.
            setStyleSpans(0, computeHighlighting(codeArea.getText())));
    codeArea.replaceText(0, 0, sampleCode);
    codeArea.setPrefSize(960,404);
  // panelSote.getChildren().add(codeArea);
}//llave load



    public void evt_salir(ActionEvent e){
        System.exit(0);
    }//llave cerrar

    public void evt_abrir(ActionEvent e){
        FileChooser of=new FileChooser();
        of.setTitle("Abrir archivo Repsy");
        panelSote.getChildren().add(codeArea);
        FileChooser.ExtensionFilter filtro=new FileChooser.ExtensionFilter("Archivos *.RPY","*.RPY");
        of.getExtensionFilters().add(filtro);
        File file=of.showOpenDialog(stage);
    }//llave abrir

    @Override
    public void start(Stage Stage) throws Exception {
        this.stage=stage;

    }


}
