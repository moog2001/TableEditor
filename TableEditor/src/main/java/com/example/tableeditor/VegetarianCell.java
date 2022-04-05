package com.example.tableeditor;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;

public class VegetarianCell extends TableCell<Athlete, Boolean> {
    private CheckBox checkBox;

    public VegetarianCell() {
        checkBox = new CheckBox();
        checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                commitEdit(newValue == null ? false : newValue);

            }
        });
    }

    @Override
    public void updateItem(Boolean item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty && item != null) {
            System.out.println(item);
            checkBox.setSelected(item);
            this.setGraphic(checkBox);
        }
    }
}