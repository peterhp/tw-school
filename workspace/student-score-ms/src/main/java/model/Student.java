package model;

/**
 * Created by Shli on 27/07/2017.
 */
public class Student implements Cloneable {
    private String sid;
    private String name;

    private String gender;
    private String klass;

    private String personalId;
    private String nativePlace;
    private String phone;
    private String email;

    private int mathScore;
    private int chineseScore;
    private int englishScore;
    private int programScore;

    public Student(String id, String name, int math, int chinese, int english, int program) {
        this.sid = id;
        this.name = name;

        this.mathScore = math;
        this.chineseScore = chinese;
        this.englishScore = english;
        this.programScore = program;
    }

    public Student() {

    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setKlass(String klass) {
        this.klass = klass;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getSid() {
        return sid;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getKlass() {
        return klass;
    }

    public String getPersonalId() {
        return personalId;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
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
    public Student clone() {
        try {
            return (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Student();
        }
    }
}
