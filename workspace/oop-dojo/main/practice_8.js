
class Person {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    introduce() {
        return `My name is ${this.name}. I am ${this.age} years old.`;
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
        this.class = _class;
    }

    introduce() {
        return `${super.introduce()} ` +
            `I am a Student. I am at Class ${this.class.number}.`;
    }
}

module.exports = {
    Person,
    Class,
    Student
};
