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

var promotions = loadPromotions();

function findPromotion(barcode) {
    var promotion = null;
    for (var i = 0; i < promotions.length; ++i) {
        for (var j = 0; j < promotions[i].barcodes.length; ++j) {
            if (promotions[i].barcodes[j] === barcode) {
                promotion = promotions[i];
                break;
            }
        }
    }
    return promotion;
}
