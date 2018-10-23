import java.util.Objects;

class Jail implements Cell{
private final int fine = 150;

public void doBusiness(Player player) {
    player.currentMoney -= fine;
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jail jail = (Jail) o;
        return fine == jail.fine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fine);
    }
}
