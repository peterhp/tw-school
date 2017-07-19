/**
 * Created by Shli on 19/07/2017.
 */

describe("Cart Statistics", () => {

    var item = {barcode: "ITEM000001", quantity: 3};

    it("Should return original cost of the item.", () => {
        expect(calcOriginalCost(item)).toEqual(9);
    });
});
