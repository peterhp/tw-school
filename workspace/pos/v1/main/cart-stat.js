/**
 * Created by Shli on 19/07/2017.
 */

function calcOriginalCost(item) {
    var commodity = findCommodity(item.barcode);
    return (commodity.price * item.quantity);
}
