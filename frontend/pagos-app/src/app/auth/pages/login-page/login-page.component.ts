import { Component, inject, Inject } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css'],
})
export class LoginPageComponent {
  private fb = inject(FormBuilder);
  private authService = inject(AuthService);

  public myForm = this.fb.group({
    username: ['edual', [Validators.required]],
    password: ['pelota12', [Validators.required]],
  });

  constructor() {}

  login() {
    console.log(this.myForm.value);
    const { username, password } = this.myForm.value;
    this.authService.infoEstado().subscribe((res) => {
      console.log(res);
    });
  }
}
