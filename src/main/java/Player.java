class Player {
    final int initialMoney = 1000;
    int currentMoney;
    int cellPosition;

    Player() {
        currentMoney = initialMoney;
        cellPosition = -1;
    }

    void play(Cell cell) {
        cell.doBusiness(this);
    }
}
