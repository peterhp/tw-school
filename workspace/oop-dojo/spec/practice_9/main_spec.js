"use strict";

import {Person} from "../../main/practice_9";

describe("OO入门", function(){
    it("对象之间的交互-3", function(){

    });

    it("Case 1: test Person.", () => {
        const tom = new Person("001", "Tom", 21);
        expect(tom.introduce()).toEqual(
            "My name is Tom. I am 21 years old.");

        // Assume that Tom changes his name to Tony at his 23 years old.
        expect(tom.isSameTo(new Person("001", "Tony", 23))).toEqual(true);
    });
});