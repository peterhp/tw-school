"use strict";

import {Person, Class, Student, Teacher} from "../../main/practice_8";

describe("OO入门", function(){
    it("对象之间的交互-2", function(){

    });

    it("Case 1: test Person class.", function () {
       const tom = new Person("Tom", 21);
       expect(tom.introduce()).toEqual(
           "My name is Tom. I am 21 years old.");
    });

    it ("Case 2: test Student class.", function () {
       const tom = new Student("Tom", 21, new Class(2));
       expect(tom.introduce()).toEqual(
           "My name is Tom. I am 21 years old. " +
           "I am a Student. I am at Class 2.");
    });

    it ("Case 3: test self-introduction for Teacher.", function () {
       let tom = new Teacher("Tom", 21);
       expect(tom.introduce()).toEqual(
           "My name is Tom. I am 21 years old. " +
           "I am a Teacher. I teach No Class.");

       tom = new Teacher("Tom", 21, new Class(2));
       expect(tom.introduce()).toEqual(
           "My name is Tom. I am 21 years old. " +
           "I am a Teacher. I teach Class 2.");
    });
});