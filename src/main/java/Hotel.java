import java.util.Objects;

class Hotel implements Cell{
    Player owner;
    boolean isBooked = false;



    public void doBusiness(Player player){
        if(!isBooked) {
            if (player.currentMoney >= 200) {
                player.currentMoney -= 200;
                owner = player;
                isBooked = true;
            }
        } else {
            player.currentMoney -= 50;
            owner.currentMoney += 50;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return isBooked == hotel.isBooked &&
                Objects.equals(owner, hotel.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, isBooked);
    }
}
