/**
 * Created by Shli on 19/07/2017.
 */

function calcItemOriginalCost(item) {
    var commodity = findCommodity(item.barcode);
    return (commodity.price * item.quantity);
}

function calcItemSaving(item) {
    var saving = 0;

    var promotion = findPromotion(item.barcode);
    if (promotion && promotion.type === "BUY_TWO_GET_ONE_FREE") {
        saving = savingForBuy2Free1(item);
    }

    return saving;
}

function calcItemActualCost(item) {
    return calcItemOriginalCost(item) - calcItemSaving(item);
}

function calcCartOriginalCost(cart) {
    var cost = 0;
    for (var i = 0; i < cart.items.length; ++i) {
        cost += calcItemOriginalCost(cart.items[i]);
    }
    return cost;
}

function calcCartSaving(cart) {
    var saving = 0;
    for (var i = 0; i < cart.items.length; ++i) {
        saving += calcItemSaving(cart.items[i]);
    }
    return saving;
}

function calcCartActualCost(cart) {
    return calcCartOriginalCost(cart) - calcCartSaving(cart);
}

function updateCart(cart) {
    var cost = 0;
    var saving = 0;

    for (var i = 0; i < cart.items.length; ++i) {
        var itemCost = calcItemActualCost(cart.items[i]);
        var itemSaving = calcItemSaving(cart.items[i]);
        cart.items[i].actualCost = itemCost;

        cost += itemCost;
        saving += itemSaving;
    }

    cart.actualCost = cost;
    cart.saving = saving;
}
