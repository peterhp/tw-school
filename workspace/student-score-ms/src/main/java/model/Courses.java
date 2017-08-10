package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Shli on 09/08/2017.
 */
@Entity
public class Courses implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cid;

    private int mathScore = 0;
    private int chineseScore = 0;
    private int englishScore = 0;
    private int programScore = 0;

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public void setChineseScore(int chineseScore) {
        this.chineseScore = chineseScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public void setProgramScore(int programScore) {
        this.programScore = programScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getChineseScore() {
        return chineseScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public int getProgramScore() {
        return programScore;
    }

    @Override
    public Courses clone() {
        try {
            return (Courses) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Courses();
        }
    }
}
