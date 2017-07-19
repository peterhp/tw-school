/**
 * Created by Shli on 19/07/2017.
 */

function parseItem(strItem) {
    var barcode = strItem;
    var quantity = 1;

    var pos = strItem.indexOf("-");
    if (pos > 0) {
        barcode = strItem.substr(0, pos);
        quantity = parseFloat(strItem.substr(pos + 1));
    }

    return {barcode: barcode, quantity: quantity};
}
