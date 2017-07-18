'use strict';

function map2Array(map) {
    var arr = new Array();
    for (var key in map) {
        var item = new Object();
        item.key = key;
        item.count = map[key];
        arr.push(item);
    }
    return arr;
}

function countSameElements(collection) {
    var elemMap = new Object();

    for (var i = 0; i < collection.length; ++i) {
        var v = collection[i];
        if (typeof elemMap[v] == "undefined") {
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
