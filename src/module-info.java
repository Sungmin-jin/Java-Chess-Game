module module {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires transitive javafx.graphics;
//    requires org.junit.jupiter.api;
//    requires org.junit.platform.runner;
    
    
    opens chess to javafx.fxml;
    exports chess;
}