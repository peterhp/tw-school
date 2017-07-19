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

function genItemArray(strItemArray) {
    var items = [];
    for (var i = 0; i < strItemArray.length; ++i) {
        items.push(parseItem(strItemArray[i]));
    }
    return items;
}

function findItem(cart, barcode) {
    var obj = null;
    for (var i = 0; i < cart.items.length; ++i) {
        if (cart.items[i].barcode === barcode) {
            obj = cart.items[i];
            break;
        }
    }
    return obj;
}

function addItemIntoCart(cart, newItem) {
    var item = findItem(cart, newItem.barcode);
    if (item) {
        item.quantity += newItem.quantity;
    } else {
        cart.items.push(newItem);
    }
}

function parseCart(strItemArray) {
    var items = genItemArray(strItemArray);

    var cart = {items: []};
    for (var i = 0; i < items.length; ++i) {
        addItemIntoCart(cart, items[i]);
    }

    return cart;
}
