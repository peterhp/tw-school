
class Person {
    constructor(_id, _name, _age) {
        this._id = _id;
        this._name = _name;
        this._age = _age;
    }

    introduce() {
        return `My name is ${this._name}. I am ${this._age} years old.`;
    }

    isSameTo(per) {
        return (this._id === per._id);
    }
}

class Class {
    constructor(_number) {
        this._number = _number;
    }

    get number() {
        return this._number;
    }

    assignLeader(stu) {
        this._leader = stu;
    }

    isLeader(stu) {
        return ((typeof this._leader != "undefined") &&
            (stu.isSameTo(this._leader)));
    }
}

class Student extends Person {
    constructor(_id, _name, _age, _class) {
        super(_id, _name, _age);
        this._class = _class;
    }

    introduce() {
        let self = `${super.introduce()} I am a Student. `;
        if (this._class.isLeader(this)) {
            self += `I am Leader of Class ${this._class.number}.`;
        } else {
            self += `I am at Class ${this._class.number}.`;
        }
        return self;
    }
}

class Teacher extends Person {
    constructor(_id, _name, _age, _class = null) {
        super(_id, _name, _age);
        this._class = _class;
    }

    introduce() {
        let self = `${super.introduce()} I am a Teacher. `;
        if (this._class) {
            self += `I teach Class ${this._class.number}.`;
        } else {
            self += `I teach No Class.`;
        }
        return self;
    }
}

module.exports = {
    Person,
    Class,
    Student,
    Teacher
};
