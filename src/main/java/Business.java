class Business {
    private Player player;

    Business(Player player) {
        this.player = player;
    }

    void doAction() {
        player.currentMoney = player.initialMoney;
    }
}
