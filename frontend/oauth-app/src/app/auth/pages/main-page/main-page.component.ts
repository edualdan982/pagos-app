import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { MatCardModule } from '@angular/material/card';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-main-page',
  standalone: true,
  imports: [CommonModule, RouterModule, MatCardModule],
  templateUrl: './main-page.component.html',
  styleUrl: './main-page.component.css',
})
export default class MainPageComponent {
  constructor(private authService: AuthService, private router: Router) {}

  get data() {
    return this.authService.getProfile() ?? { data: 'no data found' };
  }

  public logout() {
    this.authService.logout();
    this.router.navigate(['/auth/login']);
  }
}
