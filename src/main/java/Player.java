class Player {
    final int initialMoney = 1000;
    int currentMoney;
    int cellPosition;

    Player() {
        currentMoney = initialMoney;
        cellPosition = 0;
    }

    void play(Business business) {
        business.doAction();
    }
}
