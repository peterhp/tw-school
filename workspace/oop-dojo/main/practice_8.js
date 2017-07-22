
class Person {
    constructor(name, age) {
        this._name = name;
        this._age = age;
    }

    get name() {
        return this._name;
    }

    introduce() {
        return `My name is ${this._name}. I am ${this._age} years old.`;
    }
}

class Class {
    constructor(classNum) {
        this._number = classNum;
    }

    get number() {
        return this._number;
    }
}

class Student extends Person {
    constructor(name, age, _class) {
        super(name, age);
        this._class = _class;
    }

    introduce() {
        return `${super.introduce()} ` +
            `I am a Student. I am at Class ${this._class.number}.`;
    }

    get class() {
        return this._class;
    }
}

class Teacher extends Person {
    constructor(name, age, _class = null) {
        super(name, age);
        this._class = _class;
    }

    introduce() {
        let classString = `No Class`;
        if (this._class) {
            classString = `Class ${this._class.number}`;
        }
        return `${super.introduce()} I am a Teacher. I teach ${classString}.`;
    }

    introduceWith(stu) {
        let teachString = "";
        if (this._class.number != stu.class.number) {
            teachString = "don't "
        }
        return `${super.introduce()} I am a Teacher. I ${teachString}teach ${stu.name}.`;
    }
}

module.exports = {
    Person,
    Class,
    Student,
    Teacher
};
