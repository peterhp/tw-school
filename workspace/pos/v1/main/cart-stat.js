/**
 * Created by Shli on 19/07/2017.
 */

function calcOriginalCost(item) {
    var commodity = findCommodity(item.barcode);
    return (commodity.price * item.quantity);
}

function calcSaving(item) {
    var saving = 0;

    var promotion = findPromotion(item.barcode);
    if (promotion && promotion.type === "BUY_TWO_GET_ONE_FREE") {
        saving = savingForBuy2Free1(item);
    }

    return saving;
}

function calcActualCost(item) {
    return calcOriginalCost(item) - calcSaving(item);
}

function calcCartOriginalCost(cart) {
    var cost = 0;
    for (var i = 0; i < cart.length; ++i) {
        cost += calcOriginalCost(cart[i]);
    }
    return cost;
}

function calcCartSaving(cart) {
    var saving = 0;
    for (var i = 0; i < cart.length; ++i) {
        saving += calcSaving(cart[i]);
    }
    return saving;
}
