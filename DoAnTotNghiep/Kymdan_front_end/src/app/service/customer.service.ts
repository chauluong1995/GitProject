import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  readonly API = 'http://localhost:8080/customer';

  constructor(public http: HttpClient) {
  }

  getInformationCustomer(name: any): Observable<any> {
    return this.http.get(this.API + '/information/' + name);
  }

  editInformation(newInformation): Observable<any> {
    return this.http.post(this.API + '/edit-information', newInformation, {headers: {skip: 'true'}});
  }

  register(account): Observable<any> {
    return this.http.post(this.API + '/register', account, {headers: {skip: 'true'}});
  }

  editPassword(username, oldPassword, newPassword): Observable<any> {
    return this.http.get(this.API + '/edit-password/' + username + '/' + oldPassword + '/' + newPassword);
  }
}
