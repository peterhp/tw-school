'use strict';

function calcSavingForBuy3Free1(cartItem) {
    return (cartItem.quantity >= 3 ? cartItem.commodity.price * 1 : 0.00);
}

class Promotion {

    constructor(type, calcSaving, barcodes = []) {
        this.type = type;
        this.barcodes = barcodes;
        this.calcSaving = calcSaving;
    }

    static all() {
        return [
            new Promotion('BUY_TWO_GET_ONE_FREE',
                calcSavingForBuy3Free1, [
                    'ITEM000000',
                    'ITEM000001',
                    'ITEM000005'
                ])
        ];
    }

    static getPromotion(barcode) {
        const promotions = Promotion.all();

        let matched = null;
        for (let promotion of promotions) {
            for (let promBarcode of promotion.barcodes) {
                if (promBarcode === barcode) {
                    matched = promotion;
                    break;
                }
            }
        }

        return matched;
    }
}
