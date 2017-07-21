"use strict";

import {Person, Student} from "../../main/practice_3"

describe("OO入门", function(){
    it("覆盖父类的方法-1", function(){
        const tom = new Person("Tom", 21);
        expect(tom.introduce()).toEqual(
            "My name is Tom. I am 21 years old.");

        const stu = new Student("Tom", 21, 2);
        expect(stu.introduce()).toEqual(
            "I am a Student. I am at Class 2.");
    });
});