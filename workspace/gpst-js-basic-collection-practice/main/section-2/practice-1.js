'use strict';

function map2Array(map) {
    var arr = [];
    for (var key in map) {
        arr.push({key: key, count: map[key]});
    }
    return arr;
}

function countSameElements(collection) {
    var elemMap = new Object();

    for (var i = 0; i < collection.length; ++i) {
        var v = collection[i];
        if (typeof elemMap[v] === "undefined") {
            elemMap[v] = 1;
        } else {
            elemMap[v] += 1;
        }
    }

    return map2Array(elemMap);
}

module.exports = {
    map2Array: map2Array,
    countSameElements: countSameElements
};
