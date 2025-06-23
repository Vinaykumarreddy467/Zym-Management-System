// src/app/model/Payment.ts
import { Member } from "./Member"; // Assuming User is also correctly defined
import { User } from "./user";

export class Payment {
  paymentId: number;
  amount: number;
  time: string;
  date: string;
  user: User;
  member: Member;

  // --- ADD THIS PROPERTY ---
  memberId: number | null; // This will be used for the dropdown's ngModel
  // -------------------------

  constructor() {
    this.paymentId = 0;
    this.amount = 0.0;
    this.time = '';
    this.date = '';
    this.user = new User();
    this.member = new Member();
    this.memberId = null; // Initialize it
  }
}