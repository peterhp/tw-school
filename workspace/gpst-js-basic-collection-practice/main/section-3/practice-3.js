'use strict';

const countSameElements = require('../../main/section-2/practice-1').countSameElements;

function countElem(collection) {
  var elemMap = {};
  for (var i = 0; i < collection.length; ++i) {
    var c = collection[i];
    if (typeof elemMap[c] === "undefined") {
      elemMap[c] = 1;
    } else {
      elemMap[c] += 1;
    }
  }

  var elemArr = [];
  for (var key in elemMap) {
    elemArr.push({key: key, count: elemMap[key]});
  }

  return elemArr;
}

function each3Sub1(num) {
  return (num - (num - num % 3) / 3);
}

module.exports = function createUpdatedCollection(collectionA, objectB) {
  var elemArr = countElem(collectionA);

  for (var i = 0; i < elemArr.length; ++i) {
    var elem = elemArr[i];
    for (var j = 0; j < objectB.value.length; ++j) {
      if (elem.key === objectB.value[j]) {
        elem.count = each3Sub1(elem.count);
        break;
      }
    }
  }

  return elemArr;
}
