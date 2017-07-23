"use strict";

import {Person} from "../../main/practice_10";

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
});