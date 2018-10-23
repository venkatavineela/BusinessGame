
class RentHotel extends Business {

    private final Player player;
    private Hotel hotel;

    RentHotel(Hotel hotel, Player player) {
        super(player);
        this.player = player;
        this.hotel = hotel;
    }

    void doAction() {
        super.doAction();
        player.currentMoney -= 50;
        hotel.owner.currentMoney += 50;
    }
}
