'use strict';

function getElemCount(str) {
    return (1 == str.length ? 1 : parseInt(str.substr(2), 10));
}

function countSameElements(collection) {
  return '实现练习要求，并改写该行代码。';
}

module.exports = {
  countSameElements: countSameElements,
    getElemCount: getElemCount
};
