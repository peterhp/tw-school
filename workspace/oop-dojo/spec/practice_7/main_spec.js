"use strict";

import {Person, Student, Teacher} from "../../main/practice_7"

describe("OO入门", function(){
    it("对象之间的交互-1", function(){
        const per = new Person("Tom", 21);
        expect(per.introduce()).toEqual(
            "My name is Tom. I am 21 years old.");

        const stu = new Student("Tom", 21, 2);
        expect(stu.introduce()).toEqual(
            "My name is Tom. I am 21 years old. " +
            "I am a Student. I am at Class 2.");

        const teacher1 = new Teacher("Tom", 21, 2);
        expect(teacher1.introduce()).toEqual(
            "My name is Tom. I am 21 years old. " +
            "I am a Teacher. I teach Class 2.");

        const teacher2 = new Teacher("Tom", 21);
        expect(teacher2.introduce()).toEqual(
            "My name is Tom. I am 21 years old. " +
            "I am a Teacher. I teach No Class.");
    });
});