'use strict';

//TODO: 请在该文件中实现练习要求并删除此注释

var commodities = loadAllItems();

function findCommodity(barcode) {
    var commodity = null;
    for (var i = 0; i < commodities.length; ++i) {
        if (commodities[i].barcode === barcode) {
            commodity = commodities[i];
            break;
        }
    }
    return commodity;
}
