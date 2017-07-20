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

function calcTotalCost(itemReceipts) {
    let cost = 0.00;
    for (let itemReceipt of itemReceipts) {
        cost += itemReceipt.cost;
    }
    return cost;
}

function calcTotalSaving(itemReceipts) {
    let saving = 0.00;
    for (let itemReceipt of itemReceipts) {
        saving += itemReceipt.saving;
    }
    return saving;
}

class Receipt {

    constructor(itemReceipts = [], totalCost = 0.00, totalSaving = 0.00) {
        this.items = itemReceipts;
        this.totalCost = totalCost;
        this.totalSaving = totalSaving;
        this.date = new Date();
    }

    toString() {
        let info = `***<没钱赚商店>收据***\n`;

        info += this._getDateString(this.date) + `\n`;
        info += `----------------------\n`;

        for (let itemReceipt of this.items) {
            info += this._getItemString(itemReceipt) + `\n`;
        }
        info += `----------------------\n`;

        info += `总计：${this.totalCost.toFixed(2)}(元)\n`;
        info += `节省：${this.totalSaving.toFixed(2)}(元)\n`;

        info += `**********************`;

        return info;
    }

    _getDateString(date) {
        const dateDigitToString = num => (num < 10 ? `0${num}` : num);
        const year = dateDigitToString(date.getFullYear()),
            month = dateDigitToString(date.getMonth() + 1),
            day = dateDigitToString(date.getDate()),
            hour = dateDigitToString(date.getHours()),
            minute = dateDigitToString(date.getMinutes()),
            second = dateDigitToString(date.getSeconds()),
            formattedDateString = `${year}年${month}月${day}日 ${hour}:${minute}:${second}`;
        return `打印时间：${formattedDateString}`;
    }

    _getItemString(itemReceipt) {
        const commodity = itemReceipt.item.commodity;
        return `名称：${commodity.name}，数量：${itemReceipt.item.quantity}${commodity.unit}，` +
            `单价：${commodity.price.toFixed(2)}(元)，小计：${itemReceipt.cost.toFixed(2)}(元)`;
    }
}

function genReceipt(cart) {
    let itemReceipts = [];
    for (let cartItem of cart.items) {
        itemReceipts.push(calcItemReceipt(cartItem));
    }

    return new Receipt(itemReceipts,
        calcTotalCost(itemReceipts), calcTotalSaving(itemReceipts));
}
