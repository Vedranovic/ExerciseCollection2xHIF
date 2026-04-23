package at.htlkaindorf.exa_702_homedevices.interfaces;

public interface SmartControllable {
    void connectToApp();
    void disconnectedFromApp();
    boolean isConnected();
}
