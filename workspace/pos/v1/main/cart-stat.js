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
    if (!promotion) {
        saving = 0;
    }

    return saving;
}
