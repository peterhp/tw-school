'use strict';

function each3Sub1(num) {
    return (num - (num - num % 3) / 3);
}

function createUpdatedCollection(collectionA, objectB) {
    for (var i = 0; i < collectionA.length; ++i) {
        for (var j = 0; j < objectB.value.length; ++j) {
            if (collectionA[i].key === objectB.value[j]) {
                collectionA[i].count = each3Sub1(collectionA[i].count);
                break;
            }
        }
    }

    return collectionA;}

module.exports = {
  createUpdatedCollection: createUpdatedCollection,
    each3Sub1: each3Sub1
};
