'use strict';

//TODO: 请在该文件中实现练习要求并删除此注释

function printReceipt(tags) {
    const cart = parseCartFromTags(tags);
    const receipt = genReceipt(cart);
    console.log(receipt.toString());
}
