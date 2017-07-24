package practice_8;

/**
 * Created by Shli on 24/07/2017.
 */
public class Klass {
    private final int number;

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public boolean isSameTo(Klass klass) {
        return (this.number == klass.number);
    }
}
