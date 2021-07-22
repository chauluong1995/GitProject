import {Component, OnInit} from '@angular/core';
import {ProductTypeService} from '../../service/product-type.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  protected productTypeList;

  constructor(
    protected productTypeService: ProductTypeService,
  ) {
  }

  ngOnInit() {
    this.productTypeService.getAllProductTypeService().subscribe(
      (data) => {
        this.productTypeList = data;
      },
      () => {
        // const NOTICE = 'Không tìm thấy trang ';
        // this.router.navigate(['notice-page', {message: NOTICE}]).then(r => {});
      },
      () => {
      });
  }

}
