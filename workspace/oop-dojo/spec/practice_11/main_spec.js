"use strict";

import {Person, Class, Student, Teacher} from "../../main/practice_11";

describe("OO入门", function(){
    it("对象之间的交互-5", function(){

    });

    it("Case 1: Person class.", () => {
        const tom = new Person("001", "Tom", 21);
        expect(tom.introduce()).toEqual(
            "My name is Tom. I am 21 years old.");

        expect(tom.isSameTo(new Person("001", "Tom", 22))).toEqual(true);
        expect(tom.isSameTo(new Person("002", "Jim", 20))).toEqual(false);
    });

    it("Case 2: Student class.", () => {
        const class2 = new Class(2);
        const tom = new Student("001", "Tom", 21, class2);
        expect(tom.introduce()).toEqual(
            "My name is Tom. I am 21 years old. " +
            "I am a Student. I am at Class 2.");

        class2.assignLeader(tom);
        expect(tom.introduce()).toEqual(
            "My name is Tom. I am 21 years old. " +
            "I am a Student. I am Leader of Class 2.");

        spyOn(console, "log");
        const jim = new Student("002", "Jim", 21, new Class(1));
        class2.assignLeader(jim);
        expect(console.log).toHaveBeenCalledWith(
            "It is not one of us.");
        expect(jim.introduce()).toEqual(
            "My name is Jim. I am 21 years old. " +
            "I am a Student. I am at Class 1.");
    });

    it("Case 3: Teacher class.", () => {
        const class1 = new Class(1);
        const class2 = new Class(2);
        const class3 = new Class(3);

        const tom = new Teacher("001", "Tom", 21, [class1, class2]);
        expect(tom.introduce()).toEqual(
            "My name is Tom. I am 21 years old. " +
            "I am a Teacher. I teach Class 1, 2.");

        const jim = new Teacher("002", "Jim", 22);
        expect(jim.introduce()).toEqual(
            "My name is Jim. I am 22 years old. " +
            "I am a Teacher. I teach No Class.");

        const lily = new Student("011", "Lily", 18, class1);
        const jane = new Student("012", "Jane", 19, class3);
        expect(tom.isTeaching(lily)).toEqual(true);
        expect(tom.isTeaching(jane)).toEqual(false);
    });
});