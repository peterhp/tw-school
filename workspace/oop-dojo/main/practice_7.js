
class Person {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    introduce() {
        return `My name is ${this.name}. I am ${this.age} years old.`;
    }
}

class Student extends Person {
    constructor(name, age, classNum) {
        super(name, age);
        this.classNum = classNum;
    }

    introduce() {
        return `${super.introduce()} I am a Student. I am at Class ${this.classNum}.`;
    }
}

class Teacher extends Person {
    constructor(name, age, classNum) {
        super(name, age);
        this.classNum = classNum;
    }

    introduce() {
        let className = `No Class`;
        if (typeof this.classNum != "undefined") {
            className = `Class ${this.classNum}`;
        }
        return `${super.introduce()} I am a Teacher. I teach ${className}.`;
    }
}

module.exports = {
    Person,
    Student,
    Teacher
};
