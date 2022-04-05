module com.example.tableeditor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tableeditor to javafx.fxml;
    exports com.example.tableeditor;
}