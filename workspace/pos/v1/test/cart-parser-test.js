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
});

