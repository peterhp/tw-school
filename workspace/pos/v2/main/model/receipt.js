/**
 * Created by Shli on 20/07/2017.
 */


function calcItemSaving(cartItem) {
    const promotion = Promotion.getPromotion(cartItem.commodity.barcode);

    let saving =  0.00;
    if (promotion) {
        saving = promotion.calcSaving(cartItem);
    }

    return saving;
}
