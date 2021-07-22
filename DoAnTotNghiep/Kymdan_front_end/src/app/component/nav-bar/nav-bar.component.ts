import {Component, OnInit} from '@angular/core';
import {LoginService} from '../../service/login.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  currentUser;

  constructor(public loginService: LoginService) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  ngOnInit() {
    this.loginService.name.subscribe(val => {
      this.currentUser = val;
    });
  }

  logout() {
    this.loginService.logout();
    this.currentUser = null;
    this.loginService.broadcastLoginChange(this.currentUser);
  }
}
