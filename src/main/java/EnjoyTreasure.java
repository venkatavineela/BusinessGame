class EnjoyTreasure extends Business {
    private Player player;

    EnjoyTreasure(Player player) {
        super(player);
        this.player = player;
    }

    void doAction() {
        super.doAction();
        player.currentMoney += 200;
    }
}
