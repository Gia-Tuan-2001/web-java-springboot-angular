import { Component, OnInit } from '@angular/core';
import { BaseComponent } from '../components/base/base.component';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent extends BaseComponent implements OnInit {

  ngOnInit(): void {
    this.cartInfo = JSON.parse(JSON.parse(JSON.stringify(localStorage.getItem('Cart'))));
    this.cartInfo.forEach((c: any) => {
      this.totalPrice += c.count * c.price;
    })
  }

  removeCartItem = (id: any, total: any) => {
    this.cartInfo = this.cartInfo.filter((x: any) => x.product_id != id);
    this.totalPrice -= total;
    localStorage.setItem('Cart', JSON.stringify(this.cartInfo));
    setTimeout(window.location.reload.bind(window.location), 250);
  }
}
