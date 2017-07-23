
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

module.exports = {
    Person
};
