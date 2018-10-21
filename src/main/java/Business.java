public class Business {
    private Player player;

    public Business(Player player) {
        this.player = player;
    }

    void payForJail() {
        player.currentMoney -= 150;
    }

    void enjoyTreasure() {
        player.currentMoney += 200;
    }

    void buyHotel(Hotel hotel) {
        if(player.currentMoney >= 200) {
            player.currentMoney -= 200;
            hotel.owner = player;
        }
    }

    void rentHotel(Hotel hotel) {
        player.currentMoney -= 50;
        hotel.owner.currentMoney += 50;
    }
}
