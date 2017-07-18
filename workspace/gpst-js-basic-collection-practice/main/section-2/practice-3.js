'use strict';

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
  return '实现练习要求，并改写该行代码。';
}

module.exports = {
  countSameElements: countSameElements,
    getElemCount: getElemCount
};
