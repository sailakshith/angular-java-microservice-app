import { Router } from '@angular/router';
import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  loginForm = this.fb.group({
    username: ['', Validators.required],
    password: ['', Validators.required],
  });

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private http: HttpClient
  ) {}

  login() {
    let loginValues = this.loginForm.value;

    this.http.post('/api/user/login', loginValues).subscribe((data) => {
      if (loginValues.username === loginValues.password) {
        this.router.navigateByUrl(loginValues.username);
      }
    });
  }
}
