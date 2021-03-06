'use strict';

function map2Array(map) {
    var arr = new Array();
    for (var key in map) {
        var item = new Object();
        item.name = key;
        item.summary = map[key];
        arr.push(item);
    }
    return arr;
}

function getElemCount(str) {
  if (str.length == 1) {
    return 1;
  }

  var len = str.length - 2;
  if (str[1] == "[") {
    len = str.length - 3;
  }

  return parseInt(str.substr(2, len), 10);
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
    getElemCount: getElemCount,
    map2Array: map2Array
};
