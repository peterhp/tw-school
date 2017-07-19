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

function savingForBuy2Free1(item) {
    return (item.quantity >= 2 ? findCommodity(item.barcode).price : 0);
}

function getItemReceipt(item) {
    var commodity = findCommodity(item.barcode);
    return `名称：${commodity.name}，数量：${item.quantity}${commodity.unit}，` +
        `单价：${commodity.price.toFixed(2)}(元)，小计：${item.actualCost.toFixed(2)}(元)`;
}

function getReceipt(cart) {
    var receipt = `***<没钱赚商店>收据***\n`;

    for (var i = 0; i < cart.items.length; ++i) {
        receipt += getItemReceipt(cart.items[i]) + `\n`;
    }
    receipt += `----------------------\n`;

    receipt += `总计：${cart.actualCost.toFixed(2)}(元)\n`;
    receipt += `节省：${cart.saving.toFixed(2)}(元)\n`;
    receipt += `**********************`;

    return receipt;
}

function printReceipt(strItemArray) {
    var cart = parseCart(strItemArray);
    updateCart(cart);
    console.log(getReceipt(cart));
}
