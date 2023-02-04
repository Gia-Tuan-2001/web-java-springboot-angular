import { Component, OnInit } from '@angular/core';
import { BaseComponent } from '../components/base/base.component';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent extends BaseComponent implements OnInit {

  orderByAccount: any;
  account_id: any;
  listOrderItem: any;

  ngOnInit(): void {
    this.account_id = JSON.parse(JSON.parse(JSON.stringify(localStorage.getItem('UserInfo')))).account_id;
    this.getListOrderByAccount();
  }

  getListOrderByAccount() {
    this.orderService.getList().subscribe(
      (res) => {
        this.orderByAccount = res.filter((x: any) => x.account_id == this.account_id);
      }
    )
  }

  closeResult: any;
  open(Data: any) {
    this.selected_ID = Data.order_id;
    this.submitted = false;
    this.titleModal = 'Chi tiết đơn hàng';
    this.listOrderItem = JSON.parse(JSON.parse(JSON.stringify(Data.order_item)));
  }
}
