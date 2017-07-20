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

});
