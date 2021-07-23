import {Component, ElementRef, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {LoginService} from '../../service/login.service';
import {CustomerService} from '../../service/customer.service';
import {AppAccount} from '../../model/AppAccount';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatDialog} from '@angular/material/dialog';
import {EditPasswordCustomerComponent} from '../edit-password-customer/edit-password-customer.component';

@Component({
  selector: 'app-information-customer',
  templateUrl: './information-customer.component.html',
  styleUrls: ['./information-customer.component.css']
})
export class InformationCustomerComponent implements OnInit {
  public username;
  public customer = new AppAccount();
  public message;
  public flagEdit = false;
  public editForm: FormGroup;
  public newInformation;

  constructor(
    public formBuilder: FormBuilder,
    public loginService: LoginService,
    public customerService: CustomerService,
    public router: Router,
    public el: ElementRef,
    public dialog: MatDialog
  ) {
  }

  ngOnInit() {
    this.editForm = this.formBuilder.group({
      name: [''],
      email: [''],
      password: [''],
      phone: ['', [Validators.required, Validators.pattern('((09|03|07|08|05)+([0-9]{8})\\b)')]],
      birthday: ['', [Validators.required, this.checkAge]],
      address: ['', [Validators.required]],
      gender: ['', [Validators.required]],
    });
    this.username = this.loginService.currentUserValue.username;
    this.customerService.getInformationCustomer(this.username).subscribe(data => {
      this.customer = data;
      this.editForm.patchValue(data);
    });
  }

  edit() {
    this.flagEdit = true;
    this.ngOnInit();
    this.message = ''
  }

  checkAge(control: AbstractControl) {
    const birthday = new Date(control.value);
    const current = new Date();
    const diffTime = (current.getTime() - birthday.getTime()) / (1000 * 60 * 60 * 24 * 365);
    return (diffTime > 16 && diffTime < 150) ? true : {ageError: true};
  }

  submit() {
    this.newInformation = {
      phone: this.editForm.value.phone,
      fullName: this.editForm.value.name,
      birthday: this.editForm.value.birthday,
      address: this.editForm.value.address,
      gender: this.editForm.value.gender,
      email: this.editForm.value.email
    };

    if (this.editForm.valid) {
      this.customerService.editInformation(this.newInformation)
        .subscribe(data => {
          this.message = data.message;
          this.flagEdit = false;
          this.ngOnInit()
        });
    } else {
      for (const key of Object.keys(this.editForm.controls)) {
        if (this.editForm.controls[key].invalid) {
          const invalidControl = this.el.nativeElement.querySelector('[formControlName="' + key + '"]');
          invalidControl.focus();
          break;
        }
      }
    }
  }

  openDialogEditPassword() {
    this.message = '';
    const dialogRefEdit = this.dialog.open(EditPasswordCustomerComponent, {
      width: '500px',
      height: '319px',
      data: {dataNeed: ''},
      disableClose: true
    });

    dialogRefEdit.afterClosed().subscribe(result => {
      this.message = result;
      this.ngOnInit()
    })
  }
}
