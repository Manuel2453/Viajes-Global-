import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private apiUrl = 'http://localhost:8080/api/usuarios/crearUsuario'; 

  constructor(private http: HttpClient) {}

  // Método para crear un usuario usando HttpParams
  crearUsuario(params: HttpParams): Observable<any> {
    return this.http.post(this.apiUrl, null, { params });
  }

  login(correo: string, contrasena: string): Observable<any> {
    const loginData = { correoElectronico: correo, contrasena: contrasena };
    return this.http.post('http://localhost:8080/api/usuarios/login', loginData);
  }
  
}
