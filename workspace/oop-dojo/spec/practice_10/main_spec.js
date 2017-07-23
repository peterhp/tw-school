"use strict";

import {Person, Class, Student, Teacher} from "../../main/practice_10";

describe("OO入门", function(){
    it("对象之间的交互-4", function(){

    });

    it("Case 1: test Person.", () => {
        const tom = new Person("001", "Tom", 21);
        expect(tom.introduce()).toEqual(
            "My name is Tom. I am 21 years old.");

        expect(tom.isSameTo(new Person("001", "Tom", 22))).toEqual(true);
        expect(tom.isSameTo(new Person("002", "Tom", 20))).toEqual(false);
    });

    it("Case 2: test Student.", () => {
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
        const class1 = new Class(1);
        const jim = new Student("002", "Jim", 21, class1);
        class2.assignLeader(jim);
        expect(console.log).toHaveBeenCalledWith(
            "It is not one of us.");
        expect(jim.introduce()).toEqual(
            "My name is Jim. I am 21 years old. " +
            "I am a Student. I am at Class 1.");
    });

    it("Case 3: test Teacher.", () => {
        const tom = new Teacher("001", "Tom", 21, new Class(2));
        expect(tom.introduce()).toEqual(
            "My name is Tom. I am 21 years old. " +
            "I am a Teacher. I teach Class 2.");

        const jim = new Teacher("002", "Jim", 21);
        expect(jim.introduce()).toEqual(
            "My name is Jim. I am 21 years old. " +
            "I am a Teacher. I teach No Class.");
    });
});