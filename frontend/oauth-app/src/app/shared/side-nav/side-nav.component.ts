import { Component } from '@angular/core';

import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { routes } from '../../app.routes';

@Component({
  selector: 'app-side-nav',
  standalone: true,
  imports: [MatToolbarModule, MatButtonModule, MatIconModule],
  templateUrl: './side-nav.component.html',
  styles: ``,
})
export class SideNavComponent {
  public menuItems = routes
    .map((route) => route.children ?? [])
    .flat()
    .filter((route) => route && route.path)
    .filter((route) => !route.path?.includes(':'));

  constructor() {}
}
