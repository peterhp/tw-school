/**
 * Created by Shli on 20/07/2017.
 */

class ReceiptItem {

    constructor(cartItem, cost = 0.00, saving = 0.00) {
        this.item = cartItem;
        this.cost = cost;
        this.saving = saving;
    }

}

function calcItemOriginalCost(cartItem) {
    return (cartItem.commodity.price * cartItem.quantity);
}

function calcItemSaving(cartItem) {
    const promotion = Promotion.getPromotion(cartItem.commodity.barcode);

    let saving =  0.00;
    if (promotion) {
        saving = promotion.calcSaving(cartItem);
    }

    return saving;
}

function calcItemCost(cartItem) {
    return (calcItemOriginalCost(cartItem) - calcItemSaving(cartItem));
}

function calcItemReceipt(cartItem) {
    return new ReceiptItem(cartItem,
        calcItemCost(cartItem), calcItemSaving(cartItem));
}
