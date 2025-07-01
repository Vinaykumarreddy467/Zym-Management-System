import { Injectable } from '@angular/core';
import { environment } from './baseUrl';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  private apiUrl = `${environment.apiBaseUrl}/api/payments`
  constructor(private http : HttpClient) { }

  processPayment(payment: any, userId: number) {
  return this.http.post(`${this.apiUrl}/${userId}`, payment);
}

verifyPayment(response: any): Observable<any> {
  return this.http.post(`${this.apiUrl}/verify`, response);
}
  getAllPayments() {
    return this.http.get(`${this.apiUrl}/getall`);
  }
  getPaymentById(paymentId: number) {
    return this.http.get(`${this.apiUrl}/getPaymentById/${paymentId}`);
  }
  updatePayment(paymentId: number, payment: any) {
    return this.http.put(`${this.apiUrl}/${paymentId}`, payment);
  }
  deletePayment(paymentId: number) {
    return this.http.delete(`${this.apiUrl}/${paymentId}`);
  }
}
