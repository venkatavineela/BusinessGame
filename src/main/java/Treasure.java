import java.util.Objects;

public class Treasure implements Cell {
    private final int amount = 200;

    public void doBusiness(Player player) {
        player.currentMoney += amount;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treasure treasure = (Treasure) o;
        return amount == treasure.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
