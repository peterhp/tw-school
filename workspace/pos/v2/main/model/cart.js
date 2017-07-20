/**
 * Created by Shli on 20/07/2017.
 */

class CartItem {

    constructor(item, quantity = 0) {
        this.commodity = item;
        this.quantity = quantity;
    }

}

class Cart {

    constructor() {
        this.items = [];
    }

    find(barcode) {
        let matched = null;
        for (let cartItem of this.items) {
            if (cartItem.commodity.barcode === barcode) {
                matched = cartItem;
                break;
            }
        }
        return matched;
    }

    add(newItem) {
        let item = this.find(newItem.commodity.barcode);
        if (item) {
            item.quantity += newItem.quantity;
        } else {
            this.items.push(newItem);
        }
    }

}

function parseTag(tag) {
    let barcode = tag;
    let quantity = 1;

    let pos = tag.indexOf("-");
    if (pos > 0) {
        barcode = tag.substr(0, pos);
        quantity = parseFloat(tag.substr(pos + 1));
    }

    return {barcode, quantity};
}

function parseCartItemFromTag(tag) {
    const tagItem = parseTag(tag);
    return new CartItem(Item.getCommodity(tagItem.barcode), tagItem.quantity);
}

function parseCartFromTags(tags) {
    let cart = new Cart();
    for (let tag of tags) {
        let item = parseCartItemFromTag(tag);
        cart.add(item);
    }
    return cart;
}

