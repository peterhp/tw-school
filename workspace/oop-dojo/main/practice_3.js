
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
        this.class = classNum;
    }

    introduce() {
        return `I am a Student. I am at Class ${this.class}.`;
    }

}

module.exports = {Person, Student};
