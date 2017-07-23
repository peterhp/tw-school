
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
        this._leader = null;
        this._students = [];
    }

    get number() {
        return this._number;
    }

    isIn(stu) {
        for (let mem of this._students) {
            if (mem.isSameTo(stu)) {
                return true;
            }
        }
        return false;
    }

    appendMember(stu) {
        if (!this.isIn(stu)) {
            this._students.push(stu);
            stu.class = this;
        }
    }

    assignLeader(stu) {
        if (this.isIn(stu)) {
            this._leader = stu;
        } else {
            console.log("It is not one of us.");
        }
    }

    isLeader(stu) {
        return (this._leader && this._leader.isSameTo(stu));
    }
 }

class Student extends Person {
    constructor(_id, _name, _age, _class) {
        super(_id, _name, _age);
        _class.appendMember(this);
    }

    set class(_class) {
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
    constructor(_id, _name, _age, _classes = []) {
        super(_id, _name, _age);
        this._classes = _classes;
    }

    introduce() {
        let self = `${super.introduce()} I am a Teacher. `;
        if (this._classes.length > 0) {
            self += `I teach Class ${this._classes[0].number}`;
            for (let i = 1; i < this._classes.length; ++i) {
                self += `, ${this._classes[i].number}`;
            }
            self += `.`;
        } else {
            self += `I teach No Class.`;
        }
        return self;
    }

    isTeaching(stu) {
        for (let _class of this._classes) {
            if (_class.isIn(stu)) {
                return true;
            }
        }
        return false;
    }
}

module.exports = {
    Person,
    Class,
    Student,
    Teacher
};
