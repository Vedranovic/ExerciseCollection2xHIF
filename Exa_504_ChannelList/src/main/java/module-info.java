module at.htlkaindorf.exa_504_channellist {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlkaindorf.exa_504_channellist to javafx.fxml;
    exports at.htlkaindorf.exa_504_channellist;
    exports at.htlkaindorf.exa_504_channellist.controller;
    opens at.htlkaindorf.exa_504_channellist.controller to javafx.fxml;
}