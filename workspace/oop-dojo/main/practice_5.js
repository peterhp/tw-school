
class Person {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    basic_introduce() {
        return `My name is ${this.name}. I am ${this.age} years old.`;
    }

    introduce() {
        return this.basic_introduce();
    }
}

class Student extends Person{
    constructor(name, age, classNum) {
        super(name, age);
        this.classNum = classNum;
    }

    introduce() {
        return this.basic_introduce() +
                ` I am a Student. I am at Class ${this.classNum}.`;
    }
}

class Worker extends Person {
    constructor(name, age) {
        super(name, age);
    }

    introduce() {
        return this.basic_introduce() +
                ` I am a Worker. I have a job.`;
    }
}

module.exports = {
    Person,
    Student,
    Worker
};
