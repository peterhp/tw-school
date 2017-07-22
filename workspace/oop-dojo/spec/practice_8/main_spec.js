"use strict";

import {Person} from "../../main/practice_8";

describe("OO入门", function(){
    it("对象之间的交互-2", function(){

    });

    it("Case 1: test person class.", function () {
       const tom = new Person("Tom", 21);
       expect(tom.introduce()).toEqual(
           "My name is Tom. I am 21 years old.");
    });
});