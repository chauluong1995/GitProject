import {Component, ElementRef, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ErrorStateMatcher} from '@angular/material/core';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public registerForm: FormGroup;
  public user;
  public account;
  public message;

  public matcher = new ErrorStateMatcher();

  constructor(
    public formBuilder: FormBuilder,
    public customerService: CustomerService,
    public router: Router,
    public el: ElementRef
  ) {
  }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50),
        // tslint:disable-next-line:max-line-length
        Validators.pattern('^([aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]+(\\s[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]+)*)$')]],
      email: ['', [Validators.required, Validators.pattern('^[a-z][a-z0-9_\\.]{2,30}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$')]],
      password: ['', [Validators.required]],
      confirmPassword: ['', [Validators.required]],
      phone: ['', [Validators.required, Validators.pattern('((09|03|07|08|05)+([0-9]{8})\\b)')]],
      birthday: ['', [Validators.required, this.checkAge]],
      address: ['', [Validators.required]],
      gender: ['', [Validators.required]],
    }, {validator: this.ConfirmedValidator('password', 'confirmPassword')});
  }

  onSubmit() {
    this.user = {
      phone: this.registerForm.value.phone,
      fullName: this.registerForm.value.name,
      birthday: this.registerForm.value.birthday,
      address: this.registerForm.value.address,
      gender: this.registerForm.value.gender,
      email: this.registerForm.value.email
    };
    this.account = {
      username: this.registerForm.value.name,
      password: this.registerForm.value.password,
      appUser: this.user
    };

    if (this.registerForm.valid) {
      this.customerService.register(this.account)
        .subscribe(data => {
          this.message = data.message;
          if (this.message === 'Đăng ký tài khoản thành công !') {
            this.router.navigate(['login', {message: this.message}]).then(r => {
            });
          }
        });
    } else {
      for (const key of Object.keys(this.registerForm.controls)) {
        if (this.registerForm.controls[key].invalid) {
          const invalidControl = this.el.nativeElement.querySelector('[formControlName="' + key + '"]');
          invalidControl.focus();
          break;
        }
      }
    }
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

  checkAge(control: AbstractControl) {
    const birthday = new Date(control.value);
    const current = new Date();
    const diffTime = (current.getTime() - birthday.getTime()) / (1000 * 60 * 60 * 24 * 365);
    return (diffTime > 16 && diffTime < 150) ? true : {ageError: true};
  }
}
