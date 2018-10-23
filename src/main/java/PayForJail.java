import java.util.Objects;

class PayForJail extends Business {
    private Player player;

    PayForJail(Player player) {
        super(player);
        this.player = player;
    }

    void doAction() {
        super.doAction();
        player.currentMoney -= 150;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayForJail that = (PayForJail) o;
        return Objects.equals(player, that.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player);
    }
}
