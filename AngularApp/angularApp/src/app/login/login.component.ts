import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ServiceService} from "../Service/service.service";
import {valueReferenceToExpression} from "@angular/compiler-cli/src/ngtsc/annotations/src/util";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router,
              private serviceLogin: ServiceService) { }

  username: string = '' ;
  pass: string = '' ;
  control: number = 0 ;

  ngOnInit() {
  }

  onusernama(event: any){
    this.username = event.target.value;
    this.control = 0;
  }

  onpass(event: any){
    this.pass = event.target.value;
    this.control = 0;
  }


  clicklogin() {
    this.serviceLogin.getLogin(this.username, this.pass).subscribe((value: any) => {
      if (value === true) {
        this.router.navigateByUrl('/lista');
      } else {
        this.control = 1;
      }
      return;
    });
  }

}
