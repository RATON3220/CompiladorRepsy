package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller extends Application{
private Stage stage;



    public void evt_salir(ActionEvent e){
        System.exit(0);
    }//llave cerrar

    public void evt_abrir(ActionEvent e){
        FileChooser of=new FileChooser();
        of.setTitle("Abrir archivo Repsy");
        FileChooser.ExtensionFilter filtro=new FileChooser.ExtensionFilter("Archivos *.RPY","*.RPY");
        of.getExtensionFilters().add(filtro);
        File file=of.showOpenDialog(stage);
    }//llave abrir

    @Override
    public void start(Stage Stage) throws Exception {
        this.stage=stage;

    }
}
