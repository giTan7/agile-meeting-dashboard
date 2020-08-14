import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import {AuthServiceService} from '../auth-service.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formGroup: FormGroup;
  constructor(private authService: AuthServiceService,
    private router: Router) { }

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.formGroup = new FormGroup({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required])
    })
  }

  loginProcess() {
    if(this.formGroup.valid) {
      this.authService.login(this.formGroup.value).subscribe(res => {
        if(res.access_token) {
          this.router.navigate(["/admin/usersList"]);
        } else {
          alert("Unauthorized");
        }

      }, err=> {
        alert("Login Failed");
      })
    }
  }
}
