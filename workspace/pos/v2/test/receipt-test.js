/**
 * Created by Shli on 20/07/2017.
 */

describe("Generate receipt for cart.", () => {

    let promItem = new CartItem(
        new Item('ITEM000001', '雪碧', '瓶', 3.00), 5);
    let normItem = new CartItem(
        new Item('ITEM000004', '电池', '个', 2.00), 5);

    it("Should calculate saving for cart item.", () => {
        expect(calcItemSaving(promItem)).toEqual(3.00);
        expect(calcItemSaving(normItem)).toEqual(0.00);
    });

    it("Should get receipt info for cart item.", () => {
        expect(calcItemReceipt(promItem)).toEqual(
            new ReceiptItem(promItem, 12.00, 3.00));
        expect(calcItemReceipt(normItem)).toEqual(
            new ReceiptItem(normItem, 10.00, 0.00));
    });

    it("Should calculate total cost and saving based on item receipts.", () => {
        const itemReceipts = [new ReceiptItem(promItem, 12.00, 3.00),
            new ReceiptItem(normItem, 10.00, 0.00)];

        expect(calcTotalCost(itemReceipts)).toEqual(22.00);
        expect(calcTotalSaving(itemReceipts)).toEqual(3.00);
    });

});
