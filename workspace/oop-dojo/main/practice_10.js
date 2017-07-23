
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

    hasMember(stu) {
        for (let mem of this._students) {
            if (mem.isSameTo(stu)) {
                return true;
            }
        }
        return false;
    }

    appendMember(stu) {
        if (!this.hasMember(stu)) {
            this._students.push(stu);
            stu.class = this;
        }
    }

    assignLeader(stu) {
        if (this.hasMember(stu)) {
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

module.exports = {
    Person,
    Class,
    Student
};
