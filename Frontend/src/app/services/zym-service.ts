import { Injectable } from '@angular/core';
import { environment } from './baseUrl';
import { HttpClient } from '@angular/common/http';
import { Zym } from '../model/Zym';

@Injectable({
  providedIn: 'root'
})
export class ZymService {

  private apiUrl = `${environment.apiBaseUrl}/api/zym`;

  constructor(private http : HttpClient) { }

  addZym(zym: any) {
    return this.http.post(`${this.apiUrl}/add`, zym);
  }
  getAllZyms() {
    return this.http.get(`${this.apiUrl}/getAll`);
  }
  getZymById(zymId: number): any {
  return this.http.get(`${this.apiUrl}/getById/${zymId}`, { responseType: 'json' });
}
  updateZym(zymId: number, zym: Zym) {
    return this.http.put(`${this.apiUrl}/update`, zym);
  }
  deleteZym(zymId: number) {
    return this.http.delete(`${this.apiUrl}/delete/${zymId}`);
  }
}
