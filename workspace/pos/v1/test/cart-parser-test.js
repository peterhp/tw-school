/**
 * Created by Shli on 19/07/2017.
 */

describe("cart parser", () => {
    it("should get item for barcode", () => {
        expect(parseItem("ITEM000001")).toEqual({
            barcode: "ITEM000001",
            quantity: 1
        });
    });

    it ("should get item for barcode with quantity", () => {
        expect(parseItem("ITEM000001-2.5")).toEqual({
            barcode: "ITEM000001",
            quantity: 2.5
        });
    });

    const strItemArray = [
        "ITEM000001",
        "ITEM000002-2",
        "ITEM000003-2.5",
        "ITEM000001"
    ];

    it ("should get cart for array of item strings", () => {
        expect(parseCart(strItemArray)).toEqual({
            items: [
                {barcode: "ITEM000001", quantity: 2},
                {barcode: "ITEM000002", quantity: 2},
                {barcode: "ITEM000003", quantity: 2.5}
        ]});
    });
});
