/**
 * Created by Shli on 19/07/2017.
 */

describe("Cart Statistics", () => {

    const promItem = {barcode: "ITEM000001", quantity: 3};
    const normItem = {barcode: "ITEM000004", quantity: 3};

    it("Should return original cost of the item.", () => {
        expect(calcItemOriginalCost(promItem)).toEqual(9);
    });

    it("Should get no saving for item not on promotion.", () => {
        expect(calcItemSaving(normItem)).toEqual(0);
    });

    it("Should get saving for item on promotion.", () => {
        expect(calcItemSaving(promItem)).toEqual(3.00);
    });

    it("Should return actual cost of item.", () => {
        expect(calcItemActualCost(promItem)).toEqual(6.00);
    });

    const cart = {items:[promItem, normItem]};

    it("Should return original cost of all items in cart.", () => {
        expect(calcCartOriginalCost(cart)).toEqual(15.00);
    });

    it("Should return saving of all items in cart.",  () => {
        expect(calcCartSaving(cart)).toEqual(3.00);
    });

    it("Should return actual cost of all items in cart.", () => {
        expect(calcCartActualCost(cart)).toEqual(12.00);
    });
});
