"use strict";

import {Person, Student, Worker} from "../../main/practice_4"

describe("OO入门", function(){
    it("覆盖父类的方法-2", function(){
        const per = new Person("Tom", 21);
        expect(per.introduce()).toEqual(
            "My name is Tom. I am 21 years old.");

        const stu = new Student("Tom", 21, 2);
        expect(stu.introduce()).toEqual(
            "I am a Student. I am at Class 2.");

        const worker = new Worker("Jim", 22);
        expect(worker.introduce()).toEqual(
            "I am a Worker. I have a job.");
    });
});