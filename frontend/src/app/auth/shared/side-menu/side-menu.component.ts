import { Component, OnInit } from '@angular/core';
import { routes } from '../../auth-routing.module';

@Component({
  selector: 'app-side-menu',
  templateUrl: './side-menu.component.html',
  styleUrls: ['./side-menu.component.css'],
})
export class SideMenuComponent implements OnInit {
  public menuItems = routes
    .map((route) => route.children ?? [])
    .flat()
    .filter((route) => route && route.path)
    .filter(
      (route) => !route.path?.includes(':') && !route.path?.includes('**')
    );

  ngOnInit(): void {
    console.log(routes);
  }
}
