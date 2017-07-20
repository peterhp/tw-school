/**
 * Created by Shli on 20/07/2017.
 */

describe("Generate cart from item tags.", () => {
    const tags = [
        "ITEM000001",
        "ITEM000003-2.5",
        "ITEM000002-2",
        "ITEM000001"
    ];

    it("Should parse tags to get a cart.", () => {
        const cart = parseCartFromTags(tags);

        expect(cart.items.length).toEqual(3);

        expect(cart.items[0].quantity).toEqual(2);
        expect(cart.items[1].quantity).toEqual(2.5);
        expect(cart.items[2].quantity).toEqual(2);

        expect(cart.items[0].commodity).toEqual(
            new Item('ITEM000001', '雪碧', '瓶', 3.00));
    });
});

