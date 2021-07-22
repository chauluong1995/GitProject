import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductTypeService {
  protected readonly API: string = 'http://localhost:8080/productType';

  constructor(
    protected http: HttpClient
  ) {
  }

  getAllProductTypeService(): Observable<any> {
    return this.http.get(this.API + '/list');
  }
}
