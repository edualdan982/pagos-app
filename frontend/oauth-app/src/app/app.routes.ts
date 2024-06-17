import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'auth',

    loadComponent: () => import('./auth/pages/auth.component'),

    children: [
      {
        path: 'login',
        title: 'Iniciar Sesión',
        loadComponent: () =>
          import('./auth/pages/login-page/login-page.component'),
      },
      {
        path: 'main',
        title: 'Página principal',
        loadComponent: () => import('./auth/pages/main-page/main-page.component'),
      }
    ],
  },
  {
    path: '',
    redirectTo: '/auth',
    pathMatch: 'full',
  },
];
