'use strict';
const countSameElements = require('../../main/section-2/practice-2').countSameElements;
const getElemCount = require('../../main/section-2/practice-2').getElemCount;


describe('practice-2-2', () => {

  const collection = [
    'a', 'a', 'a',
    'e', 'e', 'e', 'e', 'e', 'e', 'e',
    'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h', 'h',
    't', 't', 't', 't', 't', 't', 't', 't', 't', 't', 't', 't', 't', 't', 't', 't', 't', 't', 't', 't',
    'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f',
    'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c',
    'g', 'g', 'g', 'g', 'g', 'g', 'g',
    'b', 'b', 'b', 'b', 'b', 'b',
    'd-5'
  ];

  it('把A集合中相同的元素统计出数量', () => {

    const result = countSameElements(collection);

    expect(result).toEqual([
      {key: 'a', count: 3},
      {key: 'e', count: 7},
      {key: 'h', count: 11},
      {key: 't', count: 20},
      {key: 'f', count: 9},
      {key: 'c', count: 8},
      {key: 'g', count: 7},
      {key: 'b', count: 6},
      {key: 'd', count: 5}
    ]);
  });
});

describe("practice-2-2-getElemCount", () => {
  it("Count of single letter should be 1.", () => {
    expect(getElemCount("a")).toEqual(1);
  });

  it("Count of letter with 5 should be 5.", () => {
    expect(getElemCount("b-5")).toEqual(5);
  });
});
