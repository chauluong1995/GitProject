import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MaterialModule} from './material.module';
import {HttpClientModule} from '@angular/common/http';
import {NavBarComponent} from './component/nav-bar/nav-bar.component';
import {FooterComponent} from './component/footer/footer.component';
import {HomeComponent} from './component/home/home.component';
import {ProductComponent} from './component/product/product.component';
import {LoginComponent} from './component/login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatDialogModule} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import {RegisterComponent} from './component/register/register.component';
import {InformationCustomerComponent} from './component/information-customer/information-customer.component';
import {EditPasswordCustomerComponent} from './component/edit-password-customer/edit-password-customer.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    FooterComponent,
    HomeComponent,
    ProductComponent,
    LoginComponent,
    RegisterComponent,
    InformationCustomerComponent,
    EditPasswordCustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatButtonModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
