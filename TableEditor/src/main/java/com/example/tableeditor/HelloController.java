package com.example.tableeditor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

public class HelloController {

    @FXML
    private TableColumn colFavoriteColor;

    @FXML
    private TableColumn<?, ?> colFirstName;

    @FXML
    private TableColumn<?, ?> colLastName;

    @FXML
    private TableColumn colSport;

    @FXML
    private TableColumn colVegetarian;

    @FXML
    private TableColumn<?, ?> colYears;

    @FXML
    private TableView<Athlete> tvMain;

    @FXML
    public void initialize(){

        PropertyValueFactory facFirstName = new PropertyValueFactory<Athlete, String>("FirstName");
        colFirstName.setCellValueFactory(facFirstName);

        PropertyValueFactory facLastName = new PropertyValueFactory<Athlete, String>("LastName");
        colLastName.setCellValueFactory(facLastName);

        PropertyValueFactory facFavoriteColor = new PropertyValueFactory<Athlete, Color>("FavColor");
        colFavoriteColor.setCellValueFactory(facFavoriteColor);

        Callback<TableColumn, TableCell> colorCellFactory =
                new Callback<TableColumn, TableCell>() {
                    public TableCell call(TableColumn p) {
                        return new ColorFormatCell();
                    }
                };

        colFavoriteColor.setCellFactory(colorCellFactory);


        PropertyValueFactory facSport = new PropertyValueFactory<Athlete, String>("Sport");
        colSport.setCellValueFactory(facSport);



        colSport.setCellFactory(new Callback<TableColumn, TableCell<Athlete, String>>() {
            @Override
            public TableCell<Athlete, String> call(TableColumn tableColumn) {
                TableCell cell = new TableCell<Athlete, String>(){
                    @Override
                    protected void updateItem(String s, boolean b) {
                        super.updateItem(s, b);

                        Label lbl = new Label(s);
                        lbl.setPrefWidth(200);
                        setGraphic(lbl);


                        String[] Sports = {"Snowboarding","Rowling", "Knitting", "Speed Reading", "Pool", "None of the Above"};
                        ComboBox<String> sportsCombo = new ComboBox(FXCollections
                                .observableArrayList(Sports));
                        sportsCombo.setValue(s);
                        sportsCombo.setOnAction(new EventHandler() {
                            public void handle(Event t) {
                                commitEdit(sportsCombo.getValue());
                                updateItem(sportsCombo.getValue(), false);
                            }
                        });

                        lbl.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                            @Override
                            public void handle(MouseEvent mouseEvent) {
                                if (mouseEvent.getClickCount() > 1) {
                                    System.out.println("awd");
                                    setGraphic(sportsCombo);
                                }
                            }
                        });



                    }

                };
                return cell;

            }
        });

        Callback<TableColumn<TableColumn, Boolean>, TableCell<TableColumn, Boolean>> facVegetarianCell =
                new Callback<TableColumn<TableColumn, Boolean>, TableCell<TableColumn, Boolean>>() {
                    @Override
                    public TableCell call(TableColumn<TableColumn, Boolean> p) {
                        return new VegetarianCell();
                    }
                };
        PropertyValueFactory facVegetarian = new PropertyValueFactory<Athlete, Boolean>("Vegetarian");
        colVegetarian.setCellValueFactory(facVegetarian);


        colVegetarian.setCellFactory(facVegetarianCell);



        PropertyValueFactory facYears = new PropertyValueFactory<Athlete, Integer>("Years");
        colYears.setCellValueFactory(facYears);



    }

    public void Init(ObservableList<Athlete> Data){
        tvMain.setItems(Data);
    }

}
