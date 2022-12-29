module com.csc229labfiles.mavenproject6 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.csc229labfiles.mavenproject6 to javafx.fxml;
    exports com.csc229labfiles.mavenproject6;
}
