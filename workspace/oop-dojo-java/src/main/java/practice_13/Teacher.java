package practice_13;

import java.util.List;

/**
 * Created by Shli on 24/07/2017.
 */
public class Teacher extends Person {
    public Teacher(String id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String self = String.format("%s I am a Teacher. ", super.introduce());

        List<Klass> klasses =  KlassManager.getManager().getTeachKlasses(this);
        if (klasses.size() > 0) {
            self += String.format("I teach Class %d", klasses.get(0).getNumber());
            for (int i = 1; i < klasses.size(); ++i) {
                self += String.format(", %d", klasses.get(i).getNumber());
            }
            self += ".";
        } else {
            self += "I teach No Class.";
        }

        return self;
    }
}
