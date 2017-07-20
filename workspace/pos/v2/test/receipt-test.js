/**
 * Created by Shli on 20/07/2017.
 */

describe("Generate receipt for cart.", () => {

    const promItem = new CartItem(
        new Item('ITEM000001', '雪碧', '瓶', 3.00), 5);
    const normItem = new CartItem(
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

    const cart = new Cart();
    cart.add(promItem);
    cart.add(normItem);

    it("Should get receipt for cart.", () => {
        const receipt = genReceipt(cart);

        expect(receipt.items.length).toEqual(2);
        expect(receipt.totalCost).toEqual(22.00);
        expect(receipt.totalSaving).toEqual(3.00);
        expect(receipt.date).toEqual(new Date());
    });

});
