'use strict';

module.exports = function collectSameElements(collectionA, objectB) {
    var comm = new Array();

    for (var i = 0; i < collectionA.length; ++i) {
        for (var j = 0; j < objectB.value.length; ++j) {
            if (collectionA[i] === objectB.value[j]) {
                comm.push(collectionA[i]);
                break;
            }
        }
    }

    return comm;
}
