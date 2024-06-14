import { Component } from '@angular/core';

import { MatGridListModule } from '@angular/material/grid-list';
import { SideNavComponent } from '../../shared';
import { RouterOutlet } from '@angular/router';

@Component({
  standalone: true,
  imports: [
    MatGridListModule,
    RouterOutlet,
    SideNavComponent
  ],
  templateUrl: './auth.component.html',
  styles: `
    mat-grid-tile {
      background: lightblue;
    }
  `,
})
export default class AuthComponent {}
