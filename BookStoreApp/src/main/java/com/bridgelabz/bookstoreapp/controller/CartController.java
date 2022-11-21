package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.CartDto;
import com.bridgelabz.bookstoreapp.dto.ResponseDto;
import com.bridgelabz.bookstoreapp.model.Cart;
import com.bridgelabz.bookstoreapp.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ICartService cartService;

    @PostMapping("/addToCart/{userId}")
    public ResponseEntity<ResponseDto> addToCart(@PathVariable int userId, @RequestBody CartDto cartDto){
        Cart cart = cartService.addToCart(userId,cartDto);
        ResponseDto responseDto = new ResponseDto("Cart Added  Successfully!!",cart);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
    // Ability to delete cart details by id
    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity<ResponseDto> deleteById(@PathVariable int cartId) {
        cartService.deleteById(cartId);
        ResponseDto reponseDTO = new ResponseDto("cart Data deleted successfully ", "deleted id " + cartId);
        return new ResponseEntity(reponseDTO, HttpStatus.ACCEPTED);
    }
    //Ability to update  quantity
    @PutMapping("/updatequantity/{userId}/{cartId}")
    public ResponseEntity<ResponseDto> changeBookQuantity(@PathVariable int userId, @PathVariable int cartId, @RequestParam int quantity) {
        String cart = cartService.changeCartQty(userId,cartId,quantity);
        ResponseDto responseDTO = new ResponseDto("quantity of Cart Updated successfully", cart);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    // get all cart data
    @GetMapping("/getAll")
    public ResponseEntity<ResponseDto> findAllDetail() {
        List<Cart> cartList = cartService.findAll();
        ResponseDto responseDTO = new ResponseDto("All CartList Retrieved Successfully", cartList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    //Get Cart Data by UserId
    @GetMapping("/UserCart/{userId}")
    public ResponseEntity<ResponseDto> getCartDataByUserID(@PathVariable int userId){
        List<Cart> userCartDetails = cartService.getCartDetailsByUserId(userId);
        ResponseDto responseDTO = new ResponseDto("Cart Details of Given ID are Retrieved Successfully", userCartDetails);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
