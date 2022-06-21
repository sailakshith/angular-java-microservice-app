import { Validators, FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  register = this.fb.group({
    username: ['', Validators.required],
    password: ['', Validators.required],
    mobileNumber: ['', Validators.required],
    email: ['', Validators.required],
    address: ['', Validators.required],
  });

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {}
}
