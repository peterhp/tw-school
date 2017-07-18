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

    return;
}

module.exports = {
    map2Array: map2Array,
    countSameElements: countSameElements
};
