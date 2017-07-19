'use strict';

function genObject(str) {
  var count = 1;

  if (str.length > 1) {
    count = parseInt(str.substr(2), 10);
  }

  return {key: str[0], count: count};
}

function find(elemArr, key) {
  var obj = null;
  for (var i = 0; i < elemArr.length; ++i) {
    var elem = elemArr[i];
    if (elem.key === key) {
      obj = elem;
    }
  }
  return obj;
}

function each3Sub1(num) {
    return (num - Math.floor(num / 3));
}

function countElem(collection) {
  var elemArr = [];

  for (var i = 0; i < collection.length; ++i) {
    var elem = genObject(collection[i]);

    var obj = find(elemArr, elem.key);
    if (!obj) {
      elemArr.push(elem);
    } else {
      obj.count += elem.count;
    }
  }

  return elemArr;
}

function subCommElem(elemArr, keyArr) {
  for (var i = 0; i < elemArr.length; ++i) {
    var elem = elemArr[i];

    for (var j = 0; j < keyArr.length; ++j) {
      if (elem.key === keyArr[j]) {
        elem.count = each3Sub1(elem.count);
      }
    }
  }
}

module.exports = function createUpdatedCollection(collectionA, objectB) {
  var elemArr = countElem(collectionA);

  subCommElem(elemArr, objectB.value);
  
  return elemArr;
}
