/**
 * Created by Shli on 19/07/2017.
 */

describe("Cart Statistics", () => {

    const promItem = {barcode: "ITEM000001", quantity: 3};
    const normItem = {barcode: "ITEM000004", quantity: 3};

    it("Should return original cost of the item.", () => {
        expect(calcOriginalCost(promItem)).toEqual(9);
    });

    it("Should get no saving for item not on promotion.", () => {
        expect(calcSaving(normItem)).toEqual(0);
    });
});
