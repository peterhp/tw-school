"use strict";

import {Person, Student, Worker} from "../../main/practice_6";

describe("OO入门", function(){
    it("覆盖同时复用父类被覆盖的方法", function(){
        const per = new Person("Tom", 21);
        expect(per.introduce()).toEqual(
            "My name is Tom. I am 21 years old.");

        const stu = new Student("Tom", 21, 2);
        expect(stu.introduce()).toEqual(
            "My name is Tom. I am 21 years old. " +
            "I am a Student. I am at Class 2.");

        const worker = new Worker("Tom", 21);
        expect(worker.introduce()).toEqual(
            "My name is Tom. I am 21 years old. " +
            "I am a Worker. I have a job.");
    });
});