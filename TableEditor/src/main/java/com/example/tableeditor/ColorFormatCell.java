package com.example.tableeditor;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColorFormatCell extends TableCell<Athlete, Color> {

    private boolean windowCreated = false;
    private Stage EditorStage;

    @Override
    protected void updateItem(Color item, boolean empty) {
            super.updateItem(item, empty);
             if(!empty){
                 setStyle("-fx-padding: 2px;" + "-fx-background-color: " + getRGB(item));
             }

        addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() > 1) {



                    if(!windowCreated){

                        VBox root = new VBox();
                        root.setPadding(new Insets( 10));
                        root.setPrefWidth(250);
                        root.setPrefHeight(350);
                        ColorPicker colorPicker = new ColorPicker();
                        colorPicker.setValue(item);
                        root.getChildren().add(colorPicker);
                        Scene editorScene = new Scene(root);
                        Stage editorStage = new Stage();
                        editorStage.setScene(editorScene);
                        editorStage.setTitle("Pick a Color");
                        EditorStage = editorStage;


                        colorPicker.setOnAction(new EventHandler() {
                            public void handle(Event t) {
                                updateItem(colorPicker.getValue(), false);
                            }
                        });

                        windowCreated =true;



                    }
                    EditorStage.show();





                }
            }
        });

    }

    public String getRGB(Color c){
        int green = (int) (c.getGreen()*255);
        String greenString = Integer.toHexString(green);

        int red = (int) (c.getRed()*255);
        String redString = Integer.toHexString(red);

        int blue = (int) (c.getBlue()*255);
        String blueString = Integer.toHexString(blue);

        String hexColor = "#"+redString+greenString+blueString;
        return  hexColor;
    }


}
