public class Business {
    private Player player;

    public Business(Player player) {
        this.player = player;
    }

    void payForJail() {
        player.currentMoney -= 150;
    }
}
