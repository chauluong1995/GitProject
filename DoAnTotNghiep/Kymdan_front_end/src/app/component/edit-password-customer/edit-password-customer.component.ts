import {Component, ElementRef, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatDialogRef} from '@angular/material/dialog';
import {CustomerService} from '../../service/customer.service';
import {ErrorStateMatcher} from '@angular/material/core';
import {Router} from '@angular/router';
import {LoginService} from '../../service/login.service';

@Component({
  selector: 'app-edit-password-customer',
  templateUrl: './edit-password-customer.component.html',
  styleUrls: ['./edit-password-customer.component.css']
})
export class EditPasswordCustomerComponent implements OnInit {
  public username;
  public editForm: FormGroup;

  public matcher = new ErrorStateMatcher();

  constructor(
    public dialogRef: MatDialogRef<EditPasswordCustomerComponent>,
    public formBuilder: FormBuilder,
    public customerService: CustomerService,
    public el: ElementRef,
    public router: Router,
    public loginService: LoginService,
  ) {
  }

  ngOnInit() {
    this.username = this.loginService.currentUserValue.username;
    this.editForm = this.formBuilder.group({
      oldPassword: ['', [Validators.required]],
      newPassword: ['', [Validators.required]],
      confirmPassword: ['', [Validators.required]],
    }, {validator: this.ConfirmedValidator('newPassword', 'confirmPassword')});
  }

  ConfirmedValidator(controlName: string, matchingControlName: string) {
    return (formGroup: FormGroup) => {
      const control = formGroup.controls[controlName];
      const matchingControl = formGroup.controls[matchingControlName];
      if (matchingControl.errors && !matchingControl.errors.confirmedValidator) {
        return;
      }
      if (control.value !== matchingControl.value) {
        matchingControl.setErrors({confirmedValidator: true});
      } else {
        matchingControl.setErrors(null);
      }
    };
  }

  edit() {
    if (this.editForm.valid) {
      this.customerService.editPassword(this.username, this.editForm.value.oldPassword, this.editForm.value.newPassword)
        .subscribe(data => {
          this.dialogRef.close(data.message);
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
}
