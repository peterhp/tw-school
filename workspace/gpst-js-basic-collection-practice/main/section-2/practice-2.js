'use strict';

const map2Array = require('../../main/section-2/practice-1').map2Array;

function getElemCount(str) {
    return (1 == str.length ? 1 : parseInt(str.substr(2), 10));
}

function countSameElements(collection) {
    var map = new Object();

    for (var i = 0; i < collection.length; ++i) {
        var c = collection[i].charAt(0);
        var count = getElemCount(collection[i]);

        if (typeof map[c] == "undefined") {
            map[c] = count;
        } else {
            map[c] += count;
        }
    }

  return map2Array(map);
}

module.exports = {
  countSameElements: countSameElements,
    getElemCount: getElemCount
};
