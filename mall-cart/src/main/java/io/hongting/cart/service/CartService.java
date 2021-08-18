package io.hongting.cart.service;

import io.hongting.cart.vo.CartItemVo;
import io.hongting.cart.vo.CartVo;

import java.util.List;

/**
 * @author hongting
 * @create 2021 08 11 2:00 PM
 */
public interface CartService {
    CartItemVo addCartItem (Long skuId, Integer num);


    CartItemVo getCartItem(Long skuId);

    CartVo getCart();

    void checkCart(Long skuId, Integer isChecked);

    void changeItemCount(Long skuId, Integer num);

    void deleteItem(Long skuId);

    List<CartItemVo> getCheckedItems();
}