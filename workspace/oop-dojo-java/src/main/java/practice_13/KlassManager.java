package practice_13;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shli on 24/07/2017.
 */
public class KlassManager {

    private static KlassManager instance = null;

    public static KlassManager getManager() {
        if (instance == null) {
            instance = new KlassManager();
        }
        return instance;
    }

    private Map<Integer, Klass> klasses = new HashMap<>();

    public void createKlass(int number) {
        if (!this.klasses.containsKey(number)) {
            this.klasses.put(number, new Klass(number));
        }
    }

    public Klass getStudentKlass(Student student) {
        for (Klass klass : this.klasses.values()) {
            if (klass.isIn(student)) {
                return klass;
            }
        }
        return null;
    }

    public Klass getKlass(int number) {
        if (this.klasses.containsKey(number)) {
            return this.klasses.get(number);
        }
        return null;
    }
}
