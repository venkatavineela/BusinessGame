class BuyHotel extends Business {

    private final Player player;
    private Hotel hotel;

    BuyHotel(Hotel hotel,Player player) {
        super(player);
        this.player = player;
        this.hotel = hotel;
    }

    void doAction() {
        super.doAction();
        if(player.currentMoney >= 200) {
            player.currentMoney -= 200;
            hotel.owner = player;
        }
    }
}
