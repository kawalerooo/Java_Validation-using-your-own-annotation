module com.example.lab05_zpo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab05_zpo to javafx.fxml;
    exports com.example.lab05_zpo;
}