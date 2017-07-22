"use strict";

import {Person, Class, Student, Teacher} from "../../main/practice_9";

describe("OO入门", function(){
    it("对象之间的交互-3", function(){

    });

    it("Case 1: test Person.", () => {
        const tom = new Person("001", "Tom", 21);
        expect(tom.introduce()).toEqual(
            "My name is Tom. I am 21 years old.");

        // Assume that Tom changes his name to Tony at his 23 years old.
        expect(tom.isSameTo(new Person("001", "Tony", 23))).toEqual(true);
        expect(tom.isSameTo(new Person("002", "Tom", 25))).toEqual(false);
    });

    it("Case 2: test Student.", () => {
        const class2 = new Class(2);
        const tom = new Student("001", "Tom", 21, class2);
        expect(tom.introduce()).toEqual(
            "My name is Tom. I am 21 years old. " +
            "I am a Student. I am at Class 2.");

        class2.assignLeader(new Student("002", "Tony", 22, class2));
        expect(tom.introduce()).toEqual(
            "My name is Tom. I am 21 years old. " +
            "I am a Student. I am at Class 2.");

        class2.assignLeader(tom);
        expect(tom.introduce()).toEqual(
            "My name is Tom. I am 21 years old. " +
            "I am a Student. I am Leader of Class 2.");
    });

    it("Case 3: test Teacher.", () => {
        let tom = new Teacher("001", "Tom", 21);
        expect(tom.introduce()).toEqual(
            "My name is Tom. I am 21 years old. " +
            "I am a Teacher. I teach No Class.");

        tom = new Teacher("001", "Tom", 21, new Class(2));
        expect(tom.introduce()).toEqual(
            "My name is Tom. I am 21 years old. " +
            "I am a Teacher. I teach Class 2.");
    });
});