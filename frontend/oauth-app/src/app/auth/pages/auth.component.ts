import { Component } from '@angular/core';

import { MatGridListModule } from '@angular/material/grid-list';
import { SideNavComponent } from '../../shared';

@Component({
  standalone: true,
  imports: [
    MatGridListModule,
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
