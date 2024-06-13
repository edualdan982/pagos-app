import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthCode } from '../interfaces/auth-code';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private URL: string = 'http://127.0.0.1';

  constructor(private http: HttpClient) {}

  pingAuthServer(): Observable<any> {
    const url = `${this.URL}:8091/oauth2/authorization/msvc-client`;
    return this.http.get(url);
  }

  generatedCodeAuth(username: string, password: string): Observable<AuthCode> {
    const url = `${this.URL}:9000/login`;
    const body = { username, password };

    return this.http.post<AuthCode>(url, body);
  }

  infoEstado(): Observable<any> {
    const url = `${this.URL}:9000/info/estado`;
    return this.http.get(url);
  }
}
